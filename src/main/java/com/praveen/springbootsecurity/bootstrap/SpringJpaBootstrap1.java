package com.praveen.springbootsecurity.bootstrap;

import com.praveen.springbootsecurity.model.Product;
import com.praveen.springbootsecurity.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SpringJpaBootstrap1 {

    private ProductRepository productRepository;

    private Logger log = LogManager.getLogger(SpringJpaBootstrap.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventListener
    public  void onEventWithArgs(ContextRefreshedEvent contextRefreshedEvent){
        //loadProducts();
    }

    @EventListener(ContextRefreshedEvent.class)
    public  void onEventWithOutArgs(){
        //loadProducts1();
    }

    private void loadProducts(){
        Product shirt = new Product();
        shirt.setDescription("Spring Framework Guru Shirt_New");
        shirt.setPrice(new BigDecimal("45.95"));
        shirt.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
        shirt.setProductId("235268845711068408");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Spring Framework Guru Mug_New");
        mug.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
        mug.setProductId("168639393495335847");
        mug.setPrice(new BigDecimal("65.95"));
        productRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());

    }

    private void loadProducts1(){
        Product shirt = new Product();
        shirt.setDescription("Spring Framework Guru Shirt_New_New");
        shirt.setPrice(new BigDecimal("78.86"));
        shirt.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
        shirt.setProductId("235268845711068508");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Spring Framework Guru Mug_New_New");
        mug.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
        mug.setProductId("168639393495335747");
        mug.setPrice(new BigDecimal("63.26"));
        productRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());

    }
}
