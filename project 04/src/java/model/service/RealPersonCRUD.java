package model.service;

import commons.exceptions.BusinessException;
import configController.HibernateUtil;
import model.entity.RealPerson;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static commons.ExceptionMessages.REPETETIVE_NATIONAL_CODE;
import static commons.ExceptionMessages.RealCustomer_Entity_NOT_FOUND;

public class RealPersonCRUD {
    private static RealPersonCRUD realPersonCRUD = new RealPersonCRUD();

    private RealPersonCRUD() {
    }

    private static Logger logger = Logger.getLogger(RealPerson.class);

    public static RealPersonCRUD getInstance() {
        return realPersonCRUD;
    }

    public static void persist(RealPerson person) throws Exception {
        try {
            logger.debug("start creating RealCustomer");
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(person);
            transaction.commit();
            session.close();
           logger.info("real customer created.");
        } catch (HibernateException e) {
            logger.error("real customer dose not created.");
            throw new BusinessException(REPETETIVE_NATIONAL_CODE);
        }
    }

    public static void update(RealPerson realPerson) throws Exception {
        Session session = null;
        try {
            logger.debug("start updating realCustomer");
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            RealPerson hibernatePerson = session.find(RealPerson.class, realPerson.getRealPersonId());
            hibernatePerson.setBirthDate(realPerson.getBirthDate());
            hibernatePerson.setFamily(realPerson.getFamily());
            hibernatePerson.setFatherName(realPerson.getFatherName());
            hibernatePerson.setNationalCode(realPerson.getNationalCode());
            session.persist(hibernatePerson);
            transaction.commit();
            logger.info("real customer updated.");
        } catch (HibernateException e) {
            logger.error("real customer dose not updated.");
            e.printStackTrace();
            throw new BusinessException(REPETETIVE_NATIONAL_CODE);
        } finally {
            session.close();
        }
    }


    public static void delete(RealPerson realPerson) throws Exception {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        RealPerson hibernatePerson = session.find(RealPerson.class, realPerson.getRealPersonId());
        session.remove(hibernatePerson);
        transaction.commit();
        session.close();
    }

    public List<RealPerson> findAll() throws Exception {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<RealPerson> realPersonList = session.createQuery("select  person  from realPerson person").getResultList();
        transaction.commit();
        session.close();
        return realPersonList;
    }


    public List<RealPerson> findById(Long id) throws Exception {
        Session session = null;
        List<RealPerson> realPersonList;
        try {
            logger.debug("start finding realCustomer by Id ");
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            realPersonList = session.createQuery("select  person from realPerson person where  person.id=:id").setParameter("id", id).getResultList();
           logger.info("real customer retrieved.");
            transaction.commit();
        } catch (HibernateException e) {
           logger.error("real customer dose not retrieved.");
            e.printStackTrace();
            throw new BusinessException(RealCustomer_Entity_NOT_FOUND);
        } finally {
            session.close();
        }
        return realPersonList;
    }


    public static List<RealPerson> findByNationalCode(String nationalCode) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<RealPerson> realPersonList;
        try {
            logger.debug("start findingNationalCode");
            realPersonList = session.createQuery("select  person  from realPerson person where person.nationalCode=:nationalCode").setParameter("nationalCode", nationalCode).getResultList();
            transaction.commit();
            logger.info("real customer retrieved.");

        } catch (HibernateException e) {
           logger.error("real customer dose not retrieved.");
            e.printStackTrace();
            throw new BusinessException(RealCustomer_Entity_NOT_FOUND);
        } finally {
            session.close();
        }
        return realPersonList;
    }

    public List<RealPerson> findByName(String name) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<RealPerson> realPersonList = session.createQuery("select  person  from realPerson person where person.name=:name").setParameter("name", name).getResultList();
        transaction.commit();
        Logger.getLogger(String.valueOf(RealPerson.class)).info("real customer retrieved.");
        session.close();
        return realPersonList;
    }

    public List<RealPerson> findByFamily(String family) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<RealPerson> realPersonList = session.createQuery("select  person  from realPerson person where person.family=:family").setParameter("family", family).getResultList();
        transaction.commit();
        Logger.getLogger(String.valueOf(RealPerson.class)).info("real customer retrieved.");
        session.close();
        return realPersonList;
    }

    public static List<RealPerson> conditionalFind(String where, Map<String, Object> parameterList) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<RealPerson> realPersonList;
        try {
            logger.debug("start conditionalFind");
            Query query = session.createQuery("select person from realPerson person " + where);
            Set<String> keys = parameterList.keySet();
            for (String key : keys) {
                query.setParameter(key, parameterList.get(key));
            }
            realPersonList = query.getResultList();
            transaction.commit();
        } catch (HibernateException e) {
          logger.error("real customer dose not retrieved.");
            e.printStackTrace();
            throw new BusinessException(RealCustomer_Entity_NOT_FOUND);
        } finally {
            session.close();
        }
        return realPersonList;
    }

}
