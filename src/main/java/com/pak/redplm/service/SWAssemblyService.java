package com.pak.redplm.service;

import com.pak.redplm.entity.SWAssembly;
import com.pak.redplm.repository.SWAssemblyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

        // Добавить обновление сборки, выгрузку входящих

@Service
public class SWAssemblyService {

    private SWAssemblyRepository swAssemblyRepository;


    // Create
    public SWAssembly createSWAssembly(SWAssembly swAssembly) {
        return swAssemblyRepository.save(swAssembly);
    }

    // Read
    public List<SWAssembly> getAllSWPart(){
        return swAssemblyRepository.findAll();
    }
    public Optional<SWAssembly> getSWPartById(long id){
        return swAssemblyRepository.findById(id);
    }
    public Optional<SWAssembly> getSWPartByDecimalName(String decimalName){
        return swAssemblyRepository.findByDecimalNumber(decimalName);
    }
    public Optional<SWAssembly> getSWPartByName(String name){
        return swAssemblyRepository.findByName(name);
    }
    public List<SWAssembly> getSWPartsByIdRange(Long startId, Long endId){
        return swAssemblyRepository.findByIdBetween(startId,endId);
    }

    // Update
    public SWAssembly updateSWPart (SWAssembly swAssembly){
        return swAssemblyRepository.save(swAssembly);
    }

    // Delete
    public void deleteSWPartById(Long id) {
        swAssemblyRepository.deleteById(id);
    }
    public void deleteSWPartByName(String name) {
        swAssemblyRepository.deleteByName(name);
    }
    public void deleteSWPartByDecimalNumber(String decimalNumber) {
        swAssemblyRepository.deleteByDecimalNumber(decimalNumber);
    }
    // Other
    // Получение количества деталей
    public long getCount(){
        return swAssemblyRepository.count();
    }

}
