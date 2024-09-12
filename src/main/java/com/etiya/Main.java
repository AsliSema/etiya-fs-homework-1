package com.etiya;

import com.etiya.oopWithNLayeredApp.business.ProductManager;
import com.etiya.oopWithNLayeredApp.core.logging.DatabaseLogger;
import com.etiya.oopWithNLayeredApp.core.logging.Logger;
import com.etiya.oopWithNLayeredApp.core.logging.MailLogger;
import com.etiya.oopWithNLayeredApp.dataAccess.HibernateProductDao;
import com.etiya.oopWithNLayeredApp.dataAccess.JdbcProductDao;
import com.etiya.oopWithNLayeredApp.entities.Product;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        Product product1 = new Product(1, "Iphone Xr", 10000);

        Logger[] loggers = {new DatabaseLogger(), new MailLogger()};

        ProductManager productManager = new ProductManager(new HibernateProductDao(), loggers);
        productManager.add(product1);
    }
}