package com.technology.management;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController{

    @GetMapping("/manager/all-products")
    public ResponseEntity<String> addCategory() {
        return ResponseEntity.ok("A new category was successfully added");
    }

    @PostMapping("/manager/add-product")
    public ResponseEntity<String> addProduct() {
        return ResponseEntity.ok("The product was successfully added");
    }

    @PostMapping("/manager/delete-product")
    public ResponseEntity<String> deleteProduct() {
        return ResponseEntity.ok("The product was successfully deleted");
    }
}
