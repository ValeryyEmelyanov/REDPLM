package com.pak.redplm.service;

import com.pak.redplm.entity.StorageContainer;
import com.pak.redplm.repository.StorageContainerRepository;

import java.util.List;
import java.util.Optional;

public class StorageContainerService {

    private final StorageContainerRepository storageContainerRepository;

    public StorageContainerService(StorageContainerRepository storageContainerRepository) {
        this.storageContainerRepository = storageContainerRepository;
    }

    // Create
    public StorageContainer createStorageContainer (StorageContainer storageContainer) {
        return storageContainerRepository.save(storageContainer);
    }

    // Read
    public List<StorageContainer> getAllStorageContainer(){
        return storageContainerRepository.findAll();
    }
    public Optional<StorageContainer> getStorageContainerById(long id){
        return storageContainerRepository.findById(id);
    }

    // Update
    public StorageContainer updateInstructionManual (StorageContainer storageContainer){
        return storageContainerRepository.save(storageContainer);
    }

    // Delete
    public void deleteStorageContainerById(Long id) {
        storageContainerRepository.deleteById(id);
    }
    public void deleteStorageContainerByName(String name) {
        storageContainerRepository.deleteByName(name);
    }

    // Other
    // Получение количества деталей
    public long getCount(){
        return storageContainerRepository.count();
    }

}
