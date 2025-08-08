package repository.custom.impl;

import model.entity.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.custom.EmployeeDAO;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeDAO {

    @Override
    public boolean save(EmployeeEntity entity) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }




    @Override
    public boolean update(EmployeeEntity entity) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean deleteById(String id) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            EmployeeEntity employee = session.get(EmployeeEntity.class, id);
            if (employee != null) session.delete(employee);
            tx.commit();
        }
        return false;
    }

    @Override
    public EmployeeEntity searchById(Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(EmployeeEntity.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public EmployeeEntity searchByUsername(String username) {
        try (Session session = HibernateUtil.getSession()) {
            String hql = "FROM EmployeeEntity e WHERE e.email = :username";
            Query<EmployeeEntity> query = session.createQuery(hql, EmployeeEntity.class);
            query.setParameter("username", username);
            return query.uniqueResult(); // returns one result or null
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<EmployeeEntity> getAll() {
        try (Session session = HibernateUtil.getSession()) {
            Query<EmployeeEntity> query =
                    session.createQuery("FROM EmployeeEntity", EmployeeEntity.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


}