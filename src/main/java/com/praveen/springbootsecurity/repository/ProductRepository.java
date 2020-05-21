package com.praveen.springbootsecurity.repository;

import com.praveen.springbootsecurity.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
