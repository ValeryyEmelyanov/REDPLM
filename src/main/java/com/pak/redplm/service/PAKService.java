package com.pak.redplm.service;

import com.pak.redplm.entity.PAK;
import com.pak.redplm.repository.PAKRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class  PAKService {

    private final PAKRepository pakRepository;

    public PAKService(PAKRepository pakRepository) {
        this.pakRepository = pakRepository;
    }

    // Create
    public PAK createPAK(PAK pak) {
        return pakRepository.save(pak);
    }

    public void savePak(PAK pak) {
        pakRepository.save(pak);
    }

    // Read
    public List<PAK> getAllPAK(){
        return pakRepository.findAll();
    }
    public Optional<PAK> getPAKById(long id){
        return pakRepository.findById(id);
    }

    public Optional<PAK> getPAKByName(String name){
        return pakRepository.findByName(name);
    }
    public List<PAK> getPAKByIdRange(Long startId, Long endId){
        return pakRepository.findByIdBetween(startId,endId);
    }

    // Update
    public PAK updatePAK (PAK pak){
        return pakRepository.save(pak);
    }

    // Delete
    public void deleteSPAKById(Long id) {
        pakRepository.deleteById(id);
    }
    public void deletePAK(String name) {
        pakRepository.deleteByName(name);
    }
    // Other
    // Получение количества деталей
    public long getCount(){
        return pakRepository.count();
    }
}
