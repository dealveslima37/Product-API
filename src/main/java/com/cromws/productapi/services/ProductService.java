package com.cromws.productapi.services;

import java.util.List;
import java.util.Optional;

import com.cromws.productapi.dto.ProductDTO;
import com.cromws.productapi.models.Product;
import com.cromws.productapi.repositories.ProductRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductService {

    private ProductRepository repository;

    public ProductDTO create(ProductDTO dto) {
        Product product = new Product(dto.getName(), dto.getCategory(), dto.getPrice(), dto.getQuantity());
        product = repository.save(product);

        return new ProductDTO(product);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> product = repository.findById(id);

        return product.orElse(null);
    }

    public ProductDTO update(ProductDTO dto, Long id) {
        Product product = new Product();
        product.setId(id);
        product.setName(dto.getName());
        product.setCategory(dto.getCategory());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        product = repository.save(product);

        return new ProductDTO(product);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
