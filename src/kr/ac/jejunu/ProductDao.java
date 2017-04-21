package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.*;

public class ProductDao {
    JdbcContext jdbcContext;

    public Product get(Long id) throws ClassNotFoundException, SQLException {
        String sql = "select * from product where id = ?";
        Object[] params = new Object[]{id};

        return jdbcContext.queryForObject(sql, params);
    }

    public void add(Product product) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO product VALUES (?,?,?)";
        Object[] params = new Object[]{product.getId(), product.getTitle(), product.getPrice()};

        jdbcContext.update(sql, params);

    }

    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM product WHERE id = ?";
        Object[] params = new Object[]{id};
        jdbcContext.update(sql, params);
    }

    public void update(Product product) throws SQLException {
        String sql = "update product set title = ?, price = ? where id = ?";
        Object[] params = new Object[]{product.getTitle(), product.getPrice(), product.getId()};

        jdbcContext.update(sql, params);
    }

    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }


}
