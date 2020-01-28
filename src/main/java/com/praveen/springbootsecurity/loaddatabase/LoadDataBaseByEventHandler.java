package com.praveen.springbootsecurity.loaddatabase;

import com.praveen.springbootsecurity.model.Product;
import com.praveen.springbootsecurity.model.Student;
import com.praveen.springbootsecurity.repository.ProductRepository;
import com.praveen.springbootsecurity.repository.StudentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LoadDataBaseByEventHandler {

    private Logger log = LogManager.getLogger(LoadDataBaseByEventHandler.class);

    private StudentRepository studentRepository;
    private ProductRepository productRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventListener
    public void loadDBWithArg(ContextRefreshedEvent contextRefreshedEvent){
        loadProducts();
    }
    @EventListener(ContextRefreshedEvent.class)
    public void loadDBWithoutArg(){
        loadStudent();
    }

    private void loadProducts() {
        Product shirt = new Product();
        shirt.setDescription("Spring Framework Guru Shirt_New");
        shirt.setPrice(new BigDecimal("187.95"));
        shirt.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_513.jpg");
        shirt.setProductId("235268845711068309");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Spring Framework Guru Mug");
        mug.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
        mug.setProductId("168639393495335947");
        mug.setPrice(new BigDecimal("11.95"));
        productRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());
    }

    private void loadStudent(){
        Student saran = new Student();
        saran.setStudentName("Sarankarthi");
        log.info(studentRepository.save(saran).toString());

        Student narain = new Student();
        narain.setStudentName("Narainkarthi");
        log.info(studentRepository.save(narain).toString());

    }
}
