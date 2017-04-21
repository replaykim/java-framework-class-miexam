package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by replay on 2017. 4. 21..
 */
public class UpdateProductStatementStrategy implements StatementStrategy {
    @Override
    public PreparedStatement makeStatement(Connection connection, Object object) throws SQLException {
        Product product = (Product) object;
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("update product set title = ?, price = ? where id = ?");
        preparedStatement.setString(1, product.getTitle());
        preparedStatement.setInt(2, product.getPrice());
        preparedStatement.setLong(3, product.getId());

        return preparedStatement;
    }
}
