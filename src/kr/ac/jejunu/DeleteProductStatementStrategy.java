package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by replay on 2017. 4. 21..
 */
public class DeleteProductStatementStrategy implements StatementStrategy {
    Long id;

    public DeleteProductStatementStrategy(Long id) {
        this.id = id;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("DELETE FROM product WHERE id = ?");
        preparedStatement.setLong(1, id);

        return preparedStatement;
    }
}
