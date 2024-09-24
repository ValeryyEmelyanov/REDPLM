package com.pak.redplm.service;

import com.pak.redplm.entity.PurchasedProduct;
import com.pak.redplm.entity.SWAssembly;
import com.pak.redplm.entity.SWPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



@Service
public class AssemblyService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AssemblyService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveAssemblies(List<SWAssembly> assemblyList) {
        String query = "INSERT INTO Assembly (name, level, quantity_in_stock, decimal_number, estimated_time, specification, status) VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                SWAssembly assembly = assemblyList.get(i); // Инициализация переменной здесь
                ps.setString(1, assembly.getName());
                ps.setInt(2, assembly.getLevel());
                ps.setInt(3, assembly.getQuantityInStock());
                ps.setString(4, assembly.getDecimalNumber());
                ps.setString(5, assembly.getEstimatedTime().toString());
                ps.setString(6, assembly.getSpecification());
                ps.setString(7, assembly.getStatus().name());
            }

            @Override
            public int getBatchSize() {
                return assemblyList.size();
            }
        });

        // Сохранение связей
        saveComponents(assemblyList);
        savePurchasedParts(assemblyList);
        saveInstructions(assemblyList);
        saveDrawings(assemblyList);
    }

    private void saveComponents(List<SWAssembly> assemblyList) {
        String query = "INSERT INTO assembly_components (assembly_id, part_id) VALUES (?, ?)";

        jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                SWAssembly assembly = new SWAssembly(); // Calculate assembly index
                assembly = assemblyList.get(i / assembly.getComponents().size());
                SWPart part = assembly.getComponents().get(i % assembly.getComponents().size()); // Calculate part index
                ps.setLong(1, assembly.getId());
                ps.setLong(2, part.getId());
            }

            @Override
            public int getBatchSize() {
                return assemblyList.stream().mapToInt(assembly -> assembly.getComponents().size()).sum();
            }
        });
    }

    private void savePurchasedParts(List<SWAssembly> assemblyList) {
        String query = "INSERT INTO assembly_purchased_components (assembly_id, purchased_id) VALUES (?, ?)";

        // Создаем список аргументов для пакетного обновления
        List<Object[]> batchArgs = new ArrayList<>();

        for (SWAssembly assembly : assemblyList) {
            List<PurchasedProduct> purchasedParts = assembly.getPurchasedParts();
            // Проверяем, что список purchasedParts не null и не пустой
            if (purchasedParts != null && !purchasedParts.isEmpty()) {
                for (PurchasedProduct purchasedProduct : purchasedParts) {
                    // Добавляем аргументы для текущей пары assembly_id и purchased_id
                    batchArgs.add(new Object[]{assembly.getId(), purchasedProduct.getId()});
                }
            }
        }

        // Выполняем пакетное обновление
        jdbcTemplate.batchUpdate(query, batchArgs);
    }

    private void saveInstructions(List<SWAssembly> assemblyList) {
        String query = "UPDATE Assembly SET instruction_id = ? WHERE id = ?";

        jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                SWAssembly assembly = assemblyList.get(i);
                ps.setLong(1, assembly.getInstruction().getId());
                ps.setLong(2, assembly.getId());
            }

            @Override
            public int getBatchSize() {
                return assemblyList.size();
            }
        });
    }

    private void saveDrawings(List<SWAssembly> assemblyList) {
        String query = "UPDATE Assembly SET drawing_id = ? WHERE id = ?";

        jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                SWAssembly assembly = assemblyList.get(i);
                ps.setLong(1, assembly.getSwDrawing().getId());
                ps.setLong(2, assembly.getId());
            }

            @Override
            public int getBatchSize() {
                return assemblyList.size();
            }
        });
    }
}







