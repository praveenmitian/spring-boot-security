package com.praveen.springbootsecurity.loaddatabase;

import com.praveen.springbootsecurity.model.Product;
import com.praveen.springbootsecurity.model.Student;
import com.praveen.springbootsecurity.repository.ProductRepository;
import com.praveen.springbootsecurity.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class LoadDataBaseByCommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public CommandLineRunner loadDataBase(StudentRepository studentRepository, ProductRepository productRepository){
        return args -> {logger.info(studentRepository.save(new Student(1, "Praveen")).toString());
        logger.info(productRepository.save(loadProduct()).toString());
        };
    }

    public Product loadProduct(){
        Product shirt = new Product();
        shirt.setDescription("Spring Framework Guru Shirt");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
        shirt.setProductId("235268845711068308");
        return shirt;
    }
}
