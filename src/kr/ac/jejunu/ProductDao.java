package kr.ac.jejunu;

import java.sql.*;

public abstract class ProductDao {
    public Product get(Long id) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Product product = new Product();
        product.setId(resultSet.getLong("id"));
        product.setTitle(resultSet.getString("title"));
        product.setPrice(resultSet.getInt("price"));
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return product;
    }

    public void add(Product product) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO product VALUES (?,?,?)");
        preparedStatement.setLong(1, product.getId());
        preparedStatement.setString(2,product.getTitle());
        preparedStatement.setInt(3, product.getPrice());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    abstract Connection getConnection() throws ClassNotFoundException, SQLException;
}
