package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by replay on 2017. 4. 21..
 */
public class GetProductStatementStrategy implements StatementStrategy {
    Long id;

    public GetProductStatementStrategy(Long id) {
        this.id = id;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("select * from product where id = ?");
        preparedStatement.setLong(1, id);

        return preparedStatement;
    }
}
