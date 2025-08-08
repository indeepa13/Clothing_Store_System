package repository;

import repository.custom.impl.EmployeeRepositoryImpl;
import repository.custom.impl.ProductRepositoryImpl;
import repository.custom.impl.UserRepositoryImpl;
import util.RepositoryType;

public class DaoFactory {
    private static DaoFactory instance;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    public <T extends SuperRepository> T getRepositoryType(RepositoryType type) {
        switch (type) {
            case EMPLOYEE:
                return (T) new EmployeeRepositoryImpl();
            case PRODUCT:
                return (T) new ProductRepositoryImpl();
            case CATEGORY:
            case USER:
                return (T) new UserRepositoryImpl();
            default:
                return null;
        }
    }

}