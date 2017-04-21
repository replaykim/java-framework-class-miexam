package kr.ac.jejunu;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;
import java.util.Random;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ProductDaoTest {

    ProductDao productDao;
    @Before
    public void setup(){
        ApplicationContext applicationContext = new GenericXmlApplicationContext("DaoFactory.xml");
        productDao = applicationContext.getBean("productDao", ProductDao.class);
    }
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

        Product product = productDao.get(id);
        assertThat(id, is(product.getId()));
        assertThat(title, is(product.getTitle()));
        assertThat(price, is(product.getPrice()));
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        Long id  =   Long.valueOf(new Random().nextInt(30000)) ;
        String title  = "김재현";
        Integer price = 123456;

        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);

        productDao.add(product);

        Product resultProduct = productDao.get(id);

        assertThat(id, is(resultProduct.getId()));
        assertThat(title, is(resultProduct.getTitle()));
        assertThat(price, is(resultProduct.getPrice()));
    }

    @Test
    public void delete() throws SQLException, ClassNotFoundException {
        Long id  =   Long.valueOf(new Random().nextInt(30000)) ;
        String title  = "삭제용";
        Integer price = 123456;

        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);

        productDao.add(product);
        productDao.delete(id);

        Product resultProduct = productDao.get(id);

        assertThat(resultProduct, nullValue());
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException {
        Long id  =   Long.valueOf(new Random().nextInt(30000)) ;
        String title  = "수정용";
        Integer price = 123456;

        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);

        productDao.add(product);

        String changedTitle = "수정후";
        Integer changedPrice = 500000;

        product.setTitle(changedTitle);
        product.setPrice(changedPrice);
        productDao.update(product);

        Product resultProduct = productDao.get(id);

        assertThat(id, is(resultProduct.getId()));
        assertThat(changedTitle, is(resultProduct.getTitle()));
        assertThat(changedPrice, is(resultProduct.getPrice()));
    }
}
