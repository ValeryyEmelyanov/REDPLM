package com.pak.redplm.service;

import com.pak.redplm.entity.SWAssembly;
import com.pak.redplm.entity.SWPart;
import com.pak.redplm.repository.SWPartRepository;

import java.util.List;
import java.util.Optional;

public class SWPartService {

    private final SWPartRepository swPartRepository;

    public SWPartService(SWPartRepository swPartRepository) {
        this.swPartRepository = swPartRepository;
    }

    //Получение списка всех деталей
    public List<SWPart> getAllSWPart(){
        return swPartRepository.findAll();
    }

    //Получение деталей по
    public Optional<SWPart> getSWPartById(long id){
        return swPartRepository.findById(id);
    }

    public Optional<SWPart> getSWPartByDecimalNumber(String decimalNumber){
        return swPartRepository.findByDecimalNumber(decimalNumber);
    }


}
