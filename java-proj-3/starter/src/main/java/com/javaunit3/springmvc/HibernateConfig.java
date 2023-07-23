package com.javaunit3.springmvc;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javaunit3.springmvc.model.MovieEntity;
import com.javaunit3.springmvc.model.VoteEntity;

@Configuration
public class HibernateConfig {

  @Autowired
  @Bean
  public SessionFactory sessionFactory() throws HibernateException {
    
    SessionFactory factory;
     factory = new org.hibernate.cfg.Configuration()
          .configure("hibernate.cfg.xml")
          .addAnnotatedClass(MovieEntity.class)
          .addAnnotatedClass(VoteEntity.class)
          .buildSessionFactory(); 
    return factory;
  }
  
}
