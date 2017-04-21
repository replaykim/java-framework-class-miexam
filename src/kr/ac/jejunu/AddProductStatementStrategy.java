package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by replay on 2017. 4. 21..
 */
public class AddProductStatementStrategy implements StatementStrategy {
    Product product;

    public AddProductStatementStrategy(Product product) {
        this.product = product;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("INSERT INTO product VALUES (?,?,?)");
        preparedStatement.setLong(1, product.getId());
        preparedStatement.setString(2, product.getTitle());
        preparedStatement.setInt(3, product.getPrice());

        return preparedStatement;
    }
}
