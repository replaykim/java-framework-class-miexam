package kr.ac.jejunu;

import org.junit.Test;

import java.sql.SQLException;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductDaoTest {


    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

        ProductDao productDao = new ProductDao(new JejuConnectionMaker());
        Product product = productDao.get(id);
        assertThat(id, is(product.getId()));
        assertThat(title, is(product.getTitle()));
        assertThat(price, is(product.getPrice()));
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        Long id  =   Long.valueOf(new Random().nextInt(3000)) ;
        String title  = "김재현";
        Integer price = 123456;

        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);

        ProductDao productDao = new ProductDao(new JejuConnectionMaker());
        productDao.add(product);

        Product resultProduct = productDao.get(id);

        assertThat(id, is(resultProduct.getId()));
        assertThat(title, is(resultProduct.getTitle()));
        assertThat(price, is(resultProduct.getPrice()));
    }

    @Test
    public void hallaGet() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

        ProductDao productDao = new ProductDao(new HallaConnectionMaker());
        Product product = productDao.get(id);
        assertThat(id, is(product.getId()));
        assertThat(title, is(product.getTitle()));
        assertThat(price, is(product.getPrice()));
    }

    @Test
    public void hallaAdd() throws SQLException, ClassNotFoundException {
        Long id  =   Long.valueOf(new Random().nextInt(3000)) ;
        String title  = "김재현";
        Integer price = 123456;

        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);

        ProductDao productDao = new ProductDao(new HallaConnectionMaker());
        productDao.add(product);

        Product resultProduct = productDao.get(id);

        assertThat(id, is(resultProduct.getId()));
        assertThat(title, is(resultProduct.getTitle()));
        assertThat(price, is(resultProduct.getPrice()));
    }
}
