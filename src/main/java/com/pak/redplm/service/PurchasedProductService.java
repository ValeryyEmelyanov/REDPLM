package com.pak.redplm.service;

import com.pak.redplm.entity.PurchasedProduct;
import com.pak.redplm.repository.PurchasedProductRepository;

import java.util.List;
import java.util.Optional;

public class PurchasedProductService {

    private final PurchasedProductRepository purchasedProductRepository;

    public PurchasedProductService(PurchasedProductRepository purchasedProductRepository) {
        this.purchasedProductRepository = purchasedProductRepository;
    }


    // Create
    public PurchasedProduct createPurchasedProduct(PurchasedProduct purchasedProduct) {
        return purchasedProductRepository.save(purchasedProduct);
    }

    // Read
    public List<PurchasedProduct> getAllPurchasedProduct(){
        return purchasedProductRepository.findAll();
    }
    public Optional<PurchasedProduct> getPurchasedProductById(long id){
        return purchasedProductRepository.findById(id);
    }
    public Optional<PurchasedProduct> getPurchasedProductByDecimalName(String decimalName){
        return purchasedProductRepository.findByDecimalNumber(decimalName);
    }
    public Optional<PurchasedProduct> getPurchasedProductByName(String name){
        return purchasedProductRepository.findByName(name);
    }
    public List<PurchasedProduct> getPurchasedProductByIdRange(Long startId, Long endId){
        return purchasedProductRepository.findByIdBetween(startId,endId);
    }

    // Update
    public PurchasedProduct updatePurchasedProduct (PurchasedProduct purchasedProduct){
        return purchasedProductRepository.save(purchasedProduct);
    }

    // Delete
    public void deleteSPurchasedProductById(Long id) {
        purchasedProductRepository.deleteById(id);
    }
    public void deletePurchasedProduct(String name) {
        purchasedProductRepository.deleteByName(name);
    }
    public void deletePurchasedProductByDecimalNumber(String decimalNumber) {
        purchasedProductRepository.deleteByDecimalNumber(decimalNumber);
    }
    // Other
    // Получение количества деталей
    public long getCount(){
        return purchasedProductRepository.count();
    }
}
