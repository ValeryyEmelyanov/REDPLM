package com.pak.redplm.service;

import com.pak.redplm.entity.PurchasedProduct;
import com.pak.redplm.entity.SWAssembly;
import com.pak.redplm.entity.SWPart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AssemblyService {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public void saveAssemblies(List<SWAssembly> assemblyList) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO Assembly (name, level, quantity_in_stock, decimal_number, estimated_time, specification, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                for (SWAssembly assembly : assemblyList) {
                    preparedStatement.setString(1, assembly.getName());
                    preparedStatement.setInt(2, assembly.getLevel());
                    preparedStatement.setInt(3, assembly.getQuantityInStock());
                    preparedStatement.setString(4, assembly.getDecimalNumber());
                    preparedStatement.setString(5, assembly.getEstimatedTime().toString());
                    preparedStatement.setString(6, assembly.getSpecification());
                    preparedStatement.setString(7, assembly.getStatus().name());
                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();
            }

            // Сохранение связей
            saveComponents(connection, assemblyList);
            saveAssemblies(connection, assemblyList);
            savePurchasedParts(connection, assemblyList);
            saveInstructions(connection, assemblyList);
            saveDrawings(connection, assemblyList);
        }
    }

    private void saveComponents(Connection connection, List<SWAssembly> assemblyList) throws SQLException {
        String query = "INSERT INTO assembly_components (assembly_id, part_id) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (SWAssembly assembly : assemblyList) {
                for (SWPart part : assembly.getComponents()) {
                    preparedStatement.setLong(1, assembly.getId());
                    preparedStatement.setLong(2, part.getId());
                    preparedStatement.addBatch();
                }
            }
            preparedStatement.executeBatch();
        }
    }

    private void saveAssemblies(Connection connection, List<SWAssembly> assemblyList) throws SQLException {
        String query = "INSERT INTO assembly_subassemblies (assembly_id, subassembly_id) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (SWAssembly assembly : assemblyList) {
                for (SWAssembly subassembly : assembly.getAssemblies()) {
                    preparedStatement.setLong(1, assembly.getId());
                    preparedStatement.setLong(2, subassembly.getId());
                    preparedStatement.addBatch();
                }
            }
            preparedStatement.executeBatch();
        }
    }

    private void savePurchasedParts(Connection connection, List<SWAssembly> assemblyList) throws SQLException {
        String query = "INSERT INTO assembly_purchased_components (assembly_id, purchased_id) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (SWAssembly assembly : assemblyList) {
                for (PurchasedProduct purchasedProduct : assembly.getPurchasedParts()) {
                    preparedStatement.setLong(1, assembly.getId());
                    preparedStatement.setLong(2, purchasedProduct.getId());
                    preparedStatement.addBatch();
                }
            }
            preparedStatement.executeBatch();
        }
    }

    private void saveInstructions(Connection connection, List<SWAssembly> assemblyList) throws SQLException {
        String query = "UPDATE Assembly SET instruction_id = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (SWAssembly assembly : assemblyList) {
                preparedStatement.setLong(1, assembly.getInstruction().getId());
                preparedStatement.setLong(2, assembly.getId());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }
    }

    private void saveDrawings(Connection connection, List<SWAssembly> assemblyList) throws SQLException {
        String query = "UPDATE Assembly SET drawing_id = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (SWAssembly assembly : assemblyList) {
                preparedStatement.setLong(1, assembly.getSwDrawing().getId());
                preparedStatement.setLong(2, assembly.getId());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }
    }
}

