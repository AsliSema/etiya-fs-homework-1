package com.etiya.oopWithNLayeredApp.business;

import com.etiya.oopWithNLayeredApp.core.logging.Logger;
import com.etiya.oopWithNLayeredApp.dataAccess.HibernateProductDao;
import com.etiya.oopWithNLayeredApp.dataAccess.JdbcProductDao;
import com.etiya.oopWithNLayeredApp.dataAccess.ProductDao;
import com.etiya.oopWithNLayeredApp.entities.Product;

import java.util.List;

public class ProductManager {

    private ProductDao productDao;
    private Logger[] loggers;

    public ProductManager(ProductDao productDao, Logger[] loggers) {
        this.productDao = productDao;
        this.loggers = loggers;
    }

    public void add(Product product) throws Exception {
      if(product.getUnitPrice() < 10){
          throw new Exception("Ürün fiyatı 10 dan küçük olamaz!");
      }

//      JdbcProductDao productDao = new JdbcProductDao();
//      productDao.add(product);

//      HibernateProductDao productDao2 = new HibernateProductDao();
//      productDao2.add(product);


//      Bir katman başka bir katmanın class ını kullanırken sadece interface inden erişim kullanır (Dependency Injection).
//      Aşağıdaki kodlar buna ters. Bunun için 10-14 satırları eklendi.
//        ProductDao productDao = new JdbcProductDao();
//        productDao.add(product);

        productDao.add(product);

      for (Logger logger: loggers){
          logger.log(product.getName());
      }

    }
}
