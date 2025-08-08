package repository.custom.impl;

import model.entity.EmployeeDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.custom.EmployeeDAO;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeDAO {

    @Override
    public boolean save(EmployeeDTO entity) {
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
    public boolean update(EmployeeDTO entity) {
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
    public boolean deleteById(Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            EmployeeDTO employee = session.get(EmployeeDTO.class, id);
            if (employee != null) session.delete(employee);
            tx.commit();
        }
        return false;
    }

    @Override
    public EmployeeDTO searchById(Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(EmployeeDTO.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public EmployeeDTO searchByUsername(String username) {
        try (Session session = HibernateUtil.getSession()) {
            String hql = "FROM EmployeeDTO e WHERE e.email = :username";
            Query<EmployeeDTO> query = session.createQuery(hql, EmployeeDTO.class);
            query.setParameter("username", username);
            return query.uniqueResult(); // returns one result or null
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<EmployeeDTO> getAll() {
        try (Session session = HibernateUtil.getSession()) {
            Query<EmployeeDTO> query =
                    session.createQuery("FROM EmployeeDTO", EmployeeDTO.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


}