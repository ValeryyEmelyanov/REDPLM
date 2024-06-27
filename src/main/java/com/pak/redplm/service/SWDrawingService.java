package com.pak.redplm.service;

import com.pak.redplm.entity.SWAssembly;
import com.pak.redplm.entity.SWDrawing;
import com.pak.redplm.repository.SWDrawingRepository;

import java.util.List;
import java.util.Optional;

public class SWDrawingService {

    private final SWDrawingRepository swDrawingRepository;

    public SWDrawingService(SWDrawingRepository swDrawingRepository) {
        this.swDrawingRepository = swDrawingRepository;
    }

    // Create
    public SWDrawing createSWDrawing(SWDrawing swDrawing) {
        return swDrawingRepository.save(swDrawing);
    }

    // Read
    public List<SWDrawing> getAllSWDrawing(){
        return swDrawingRepository.findAll();
    }
    public Optional<SWDrawing> getSWDrawingById(long id){
        return swDrawingRepository.findById(id);
    }
    public Optional<SWDrawing> getSWDrawingByDecimalName(String decimalName){
        return swDrawingRepository.findByDecimalNumber(decimalName);
    }
    public Optional<SWDrawing> getSWDrawingByName(String name){
        return swDrawingRepository.findByName(name);
    }
    public List<SWDrawing> getSWDrawingsByIdRange(Long startId, Long endId){
        return swDrawingRepository.findByIdBetween(startId,endId);
    }

    // Update
    public SWDrawing updateSWDrawing (SWDrawing swDrawing){
        return swDrawingRepository.save(swDrawing);
    }

    // Delete
    public void deleteSWDrawingById(Long id) {
        swDrawingRepository.deleteById(id);
    }
    public void deleteSWDrawingByName(String name) {
        swDrawingRepository.deleteByName(name);
    }
    public void deleteSWDrawingByDecimalNumber(String decimalNumber) {
        swDrawingRepository.deleteByDecimalNumber(decimalNumber);
    }
    // Other
    // Получение количества деталей
    public long getCount(){
        return swDrawingRepository.count();
    }

}
