package kr.ac.jejunu;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;

public class ProductDao {
    JdbcTemplate jdbcTemplate;

    public Product get(Long id) throws ClassNotFoundException, SQLException {
        String sql = "select * from product where id = ?";
        Object[] params = new Object[]{id};

        Product product1 = null;
        try {
            product1 =  jdbcTemplate.queryForObject(sql, params, (resultSet, i) -> {
                Product product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setTitle(resultSet.getString("title"));
                product.setPrice(resultSet.getInt("price"));

                return product;
            });
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return product1;
    }

    public void add(Product product) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO product VALUES (?,?,?)";
        Object[] params = new Object[]{product.getId(), product.getTitle(), product.getPrice()};

        jdbcTemplate.update(sql, params);

    }

    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM product WHERE id = ?";
        Object[] params = new Object[]{id};

        jdbcTemplate.update(sql, params);
    }

    public void update(Product product) throws SQLException {
        String sql = "update product set title = ?, price = ? where id = ?";
        Object[] params = new Object[]{product.getTitle(), product.getPrice(), product.getId()};

        jdbcTemplate.update(sql, params);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
