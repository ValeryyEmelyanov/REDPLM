package com.pak.redplm.service;

import com.pak.redplm.entity.InstructionManual;
import com.pak.redplm.repository.InstructionManualRepository;

import java.util.List;
import java.util.Optional;

public class InstructionManualService {

    private final InstructionManualRepository instructionManualRepository;

    public InstructionManualService(InstructionManualRepository instructionManualRepository) {
        this.instructionManualRepository = instructionManualRepository;
    }

    // Create
    public InstructionManual createInstructionManual (InstructionManual instructionManual) {
        return instructionManualRepository.save(instructionManual);
    }

    // Read
    public List<InstructionManual> getAllInstructionManual(){
        return instructionManualRepository.findAll();
    }
    public Optional<InstructionManual> getInstructionManualById(long id){
        return instructionManualRepository.findById(id);
    }
    public Optional<InstructionManual> getInstructionManualByDecimalName(String decimalName){
        return instructionManualRepository.findByDecimalNumber(decimalName);
    }
    public Optional<InstructionManual> getInstructionManualByName(String name){
        return instructionManualRepository.findByName(name);
    }
    public List<InstructionManual> getInstructionManualsByIdRange(Long startId, Long endId){
        return instructionManualRepository.findByIdBetween(startId,endId);
    }

    // Update
    public InstructionManual updateInstructionManual (InstructionManual instructionManual){
        return instructionManualRepository.save(instructionManual);
    }

    // Delete
    public void deleteInstructionManualById(Long id) {
        instructionManualRepository.deleteById(id);
    }
    public void deleteInstructionManualByName(String name) {
        instructionManualRepository.deleteByName(name);
    }
    public void deleteInstructionManualByDecimalNumber(String decimalNumber) {
        instructionManualRepository.deleteByDecimalNumber(decimalNumber);
    }
    // Other
    // Получение количества деталей
    public long getCount(){
        return instructionManualRepository.count();
    }

}
