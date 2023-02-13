package com.daniellanza.clpbackend.service;

import com.daniellanza.clpbackend.repository.ProductRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@RequiredArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
}
