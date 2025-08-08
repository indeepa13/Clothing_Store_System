package repository.custom.impl;

import model.entity.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.custom.EmployeeDAO;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeDAO {

    @Override
    public boolean add(EmployeeEntity entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
        }
        return false;
    }

    @Override
    public void save(EmployeeEntity entity) {

    }

    @Override
    public boolean update(EmployeeEntity entity) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
        }
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            EmployeeEntity employee = session.get(EmployeeEntity.class, id);
            if (employee != null) session.delete(employee);
            tx.commit();
        }
        return false;
    }

    @Override
    public EmployeeEntity searchById(String s) throws SQLException {
        return null;
    }

    @Override
    public List<EmployeeEntity> getAll() {
        return List.of();
    }

    @Override
    public List<EmployeeEntity> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<EmployeeEntity> query = session.createQuery("FROM EmployeeEntity", EmployeeEntity.class);
            return query.getResultList();
        }
    }
}