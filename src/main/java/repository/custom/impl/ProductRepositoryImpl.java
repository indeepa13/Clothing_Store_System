package repository.custom.impl;

import model.entity.ProductEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.custom.ProductDAO;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductDAO {

    @Override
    public boolean save(ProductEntity entity) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(ProductEntity entity) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteById(String s) {
        return false;
    }

    @Override
    public ProductEntity searchById(Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(ProductEntity.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




    @Override
    public List<ProductEntity> getAll() {
        try (Session session = HibernateUtil.getSession()) {
            Query<ProductEntity> query =
                    session.createQuery("FROM ProductEntity", ProductEntity.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


//    @Override
//    public Integer getLastID() {
//        try (Session session = HibernateUtil.getSession()) {
//            String hql = "SELECT max(p.id) FROM ProductEntity p";
//            Integer lastId = session.createQuery(hql, Integer.class).uniqueResult();
//            return lastId != null ? lastId : 0;
//        }
//    }

//    @Override
//    public Boolean updateQty(Integer id, Integer qty) {
//        try (Session session = HibernateUtil.getSession()) {
//            Transaction transaction = session.beginTransaction();
//            String hql = "UPDATE ProductEntity p SET p.qty = :qty WHERE p.id = :id";
//            Query<?> query = session.createQuery(hql);
//            query.setParameter("qty", qty);
//            query.setParameter("id", id);
//            int result = query.executeUpdate();
//            transaction.commit();
//            return result > 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }

    //    @Override
//    public boolean deleteById(Integer id) {
//        try (Session session = HibernateUtil.getSession()) {
//            Transaction transaction = session.beginTransaction();
//            ProductEntity product = session.get(ProductEntity.class, id);
//            if (product != null) {
//                session.delete(product);
//                transaction.commit();
//                return true;
//            }
//            return false;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    @Override
//    public ProductEntity searchById(Integer id) {
//        try (Session session = HibernateUtil.getSession()) {
//            return session.get(ProductEntity.class, id);
//        }
//    }
    }

