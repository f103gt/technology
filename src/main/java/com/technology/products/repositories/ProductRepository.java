package com.technology.products.repositories;

import com.technology.products.models.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ProductRepository extends JpaRepository<Product, BigInteger> {
}
