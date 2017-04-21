package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.*;

public class ProductDao {
    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    JdbcContext jdbcContext;

    public Product get(Long id) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new GetProductStatementStrategy(id);
        return jdbcContext.jdbcContextWithStatementStrategyForQuery(statementStrategy);
    }

    public void add(Product product) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new AddProductStatementStrategy(product);
        jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);

    }

    public void delete(Long id) throws SQLException {
        StatementStrategy statementStrategy = new DeleteProductStatementStrategy(id);
        jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }

    public void update(Product product) throws SQLException {
        StatementStrategy statementStrategy = new UpdateProductStatementStrategy(product);
        jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }

}
