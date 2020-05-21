package com.praveen.springbootsecurity.bootstrap;

import com.praveen.springbootsecurity.model.Product;
import com.praveen.springbootsecurity.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;

@Configurable
public class SpringJpaBootstrap2 {

    private Logger log = LogManager.getLogger(SpringJpaBootstrap.class);

    public CommandLineRunner initDatabase(ProductRepository productRepository){
        return args -> {
            //loadProducts(productRepository);
            //loadProducts1(productRepository);
        };
    }

    private void loadProducts(ProductRepository productRepository){
        Product shirt = new Product();
        shirt.setDescription("Spring Framework Guru Shirt_New1");
        shirt.setPrice(new BigDecimal("322.98"));
        shirt.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
        shirt.setProductId("235268845711068608");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

    }

    private void loadProducts1(ProductRepository productRepository){
        Product mug = new Product();
        mug.setDescription("Spring Framework Guru Mug_New_New1");
        mug.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
        mug.setProductId("168639393495335647");
        mug.setPrice(new BigDecimal("86.45"));
        productRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());

    }
}
