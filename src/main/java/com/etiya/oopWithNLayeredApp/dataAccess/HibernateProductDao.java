package com.etiya.oopWithNLayeredApp.dataAccess;

import com.etiya.oopWithNLayeredApp.entities.Product;

public class HibernateProductDao implements ProductDao{
    public void add(Product product){
        System.out.println("Hibernate ile veritabanına eklendi");
    }
}
