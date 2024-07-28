package com.pak.redplm.controller;

import com.pak.redplm.entity.PurchasedProduct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/purchasedItem")
public class PurchasedProductController {

    @GetMapping("/form")
    public String getPurchasedItemAddForm(Model model) {
        model.addAttribute("purchasedItem", new PurchasedProduct());
        return "formForAddPurchasedItem";
    }

    @PostMapping("/add")
    public String addPurchasedItem(PurchasedProduct purchasedItem) {
        // Логика для сохранения изделия
        return "redirect:/purchasedItem/list";
    }

    @GetMapping("/list")
    public String listPurchasedItems(Model model) {
        // Логика для получения всех покупных изделий
        model.addAttribute("purchasedItems", new ArrayList<PurchasedProduct>());
        return "listAllPurchasedItems";
    }
}