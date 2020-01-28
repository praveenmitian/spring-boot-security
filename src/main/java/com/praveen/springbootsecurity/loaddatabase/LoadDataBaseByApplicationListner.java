package com.praveen.springbootsecurity.loaddatabase;
//Alternate/Easy to this method is by EventListner from 4.2 spring version.

import com.praveen.springbootsecurity.model.Product;
import com.praveen.springbootsecurity.model.Student;
import com.praveen.springbootsecurity.repository.ProductRepository;
import com.praveen.springbootsecurity.repository.StudentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LoadDataBaseByApplicationListner implements ApplicationListener<ContextRefreshedEvent> {
    private Logger log = LogManager.getLogger(LoadDataBaseByApplicationListner.class);

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadProducts();
        loadStudent();
    }

    private void loadProducts() {
        Product shirt = new Product();
        shirt.setDescription("Guru Shirt_New");
        shirt.setPrice(new BigDecimal("87.95"));
        shirt.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_514.jpg");
        shirt.setProductId("235268845711068409");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription(" Guru Mug");
        mug.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_516.jpg");
        mug.setProductId("168639393495335947");
        mug.setPrice(new BigDecimal("15.95"));
        productRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());
    }

    private void loadStudent(){
        Student sandy = new Student();
        sandy.setStudentName("Sandy");
        log.info(studentRepository.save(sandy).toString());

        Student siva = new Student();
        siva.setStudentName("Siva");
        log.info(studentRepository.save(siva).toString());

    }
}
