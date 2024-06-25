package com.pak.redplm.service;

import com.pak.redplm.entity.SWAssembly;
import com.pak.redplm.repository.SWAssemblyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

        // Добавить обновление сборки, выгрузку входящих

@Service
public class SWAssemblyService {

    private SWAssemblyRepository swAssemblyRepository;

    // Получение списка всех сборок
    public List<SWAssembly> getAllSWAssemblies() {
        return swAssemblyRepository.findAll();
    }

    // Получение сборки по ID
    // Optional - для получения пустого объекта, а не null
    public Optional<SWAssembly> getSWAssemblyById(Long id) {
        return swAssemblyRepository.findById(id);
    }

    // Создание новой сборки
    public SWAssembly createSWAssembly(SWAssembly swAssembly) {
        return swAssemblyRepository.save(swAssembly);
    }

    // Удаление сборки
    public void deleteSWAssembly(Long id) {
        swAssemblyRepository.deleteById(id);
    }

}
