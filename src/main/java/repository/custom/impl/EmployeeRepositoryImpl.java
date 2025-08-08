package repository.custom.impl;

import model.entity.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.custom.EmployeeDAO;
import util.HibernateUtil;

import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeDAO {

    @Override
    public boolean add(EmployeeEntity entity) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean save(EmployeeEntity entity) {
        return false;
    }

    @Override
    public boolean update(EmployeeEntity entity) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean deleteById(Integer id) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        EmployeeEntity employee = session.get(EmployeeEntity.class, id);
        if (employee != null) {
            session.delete(employee);
            transaction.commit();
            session.close();
            return true;
        }
        transaction.rollback();
        session.close();
        return false;
    }

    @Override
    public EmployeeEntity searchById(Integer id) {
        Session session = HibernateUtil.getSession();
        EmployeeEntity employee = session.get(EmployeeEntity.class, id);
        session.close();
        return employee;
    }

    @Override
    public List<EmployeeEntity> getAll() {
        Session session = HibernateUtil.getSession();
        Query<EmployeeEntity> query = session.createQuery("FROM EmployeeEntity", EmployeeEntity.class);
        List<EmployeeEntity> list = query.list();
        session.close();
        return list;
    }
}
