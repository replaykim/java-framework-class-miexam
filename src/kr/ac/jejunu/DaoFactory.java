package kr.ac.jejunu;


/**
 * Created by replay on 2017. 4. 21..
 */

public class DaoFactory {
    public ProductDao getProductDao() {
        return new ProductDao(getConnectionMaker());
    }


    public JejuConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }
}
