package com.pak.redplm.service;

import com.pak.redplm.entity.SWPart;
import com.pak.redplm.repository.SWPartRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class SWPartService {
    private final SWPartRepository swPartRepository;
    public SWPartService(SWPartRepository swPartRepository) {
        this.swPartRepository = swPartRepository;
    }


// Create
    public SWPart createSWAssembly(SWPart swPart) {
        return swPartRepository.save(swPart);
    }

// Read
    public List<SWPart> getAllSWPart(){
        return swPartRepository.findAll();
    }
    public Optional<SWPart> getSWPartById(long id){
        return swPartRepository.findById(id);
    }
    public Optional<SWPart> getSWPartByDecimalName(String decimalName){
        return swPartRepository.findByDecimalNumber(decimalName);
    }
    public Optional<SWPart> getSWPartByName(String name){
        return swPartRepository.findByName(name);
    }
    public List<SWPart> getSWPartsByIdRange(Long startId, Long endId){
        return swPartRepository.findByIdBetween(startId,endId);
    }

// Update
    public SWPart updateSWPart (SWPart swPart){
        return swPartRepository.save(swPart);
    }

// Delete
    public void deleteSWPartById(Long id) {
        swPartRepository.deleteById(id);
    }
    public void deleteSWPartByName(String name) {
        swPartRepository.deleteByName(name);
    }
    public void deleteSWPartByDecimalNumber(String decimalNumber) {
        swPartRepository.deleteByDecimalNumber(decimalNumber);
    }
// Other
    // Получение количества деталей
    public long getCount(){
        return swPartRepository.count();
    }

}
