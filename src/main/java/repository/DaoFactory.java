package repository;

import repository.custom.impl.EmployeeRepositoryImpl;
import repository.custom.impl.ProductRepositoryImpl;
import repository.custom.impl.UserRepositoryImpl;
import repository.custom.impl.EmployeeRepositoryImpl;
import repository.custom.impl.ProductRepositoryImpl;
import repository.custom.impl.UserRepositoryImpl;


import static org.apache.logging.log4j.Level.CATEGORY;
import static org.apache.poi.ss.formula.functions.AggregateFunction.PRODUCT;
import static util.ServiceType.EMPLOYEE;

public class DaoFactory {
    private static DaoFactory instance;
    private DaoFactory(){}

    public static DaoFactory getInstance(){
        return instance==null?instance=new DaoFactory():instance;
    }
    public <T extends SuperRepository, RepositoryType> T getRepositoryType(RepositoryType type){
        if (type.equals(EMPLOYEE)) {
            return (T) new EmployeeRepositoryImpl();
        } else if (type.equals(PRODUCT)) {
            return (T) new ProductRepositoryImpl();
        } else if (type.equals(CATEGORY)) {
            return (T) new UserRepositoryImpl();
        }
        return null;
    }
}
