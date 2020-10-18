/*package model.service;

import commons.exceptions.BusinessException;
import model.entity.LegalPerson;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.logging.Logger;

import static commons.ExceptionMessages.*;


public class LegalPersonService {
    private static LegalPersonService legalPersonService = new LegalPersonService();

    private LegalPersonService() {
    }

    public static LegalPersonService getInstance() {
        return legalPersonService;
    }

    public LegalPerson persist(LegalPerson legalPerson) throws Exception {
        try {
            EntityManager entityManager = JPA.getEntitymanager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(legalPerson);
            entityTransaction.commit();
            Logger.getLogger(String.valueOf(LegalPerson.class)).info("legalCustomer created");
            entityManager.close();
        } catch (HibernateException e) {
            Logger.getLogger(String.valueOf(LegalPerson.class)).info("legal customer dose not created.");
            e.printStackTrace();
            throw new BusinessException(REPETETIVE_ECONOMIC_CODE);
        }
        return legalPerson;
    }

    public LegalPerson update(LegalPerson legalPerson) throws Exception {
        try {
            EntityManager entityManager = JPA.getEntitymanager();
            LegalPerson hibernatePerson = entityManager.find(LegalPerson.class, legalPerson.getLegalPersonId());
            hibernatePerson.setCompany(legalPerson.getCompany());
            hibernatePerson.setEconomicCode(legalPerson.getEconomicCode());
            hibernatePerson.setRegisterDate(legalPerson.getRegisterDate());
            entityManager.getTransaction().begin();
            entityManager.persist(legalPerson);
            entityManager.getTransaction().commit();
            entityManager.close();
            Logger.getLogger(String.valueOf(LegalPerson.class)).info("legal customer updated.");
            return hibernatePerson;
        } catch (HibernateException e) {
            Logger.getLogger(String.valueOf(LegalPerson.class)).info("legal customer dose not updated.");
            throw new BusinessException(REPETETIVE_ECONOMIC_CODE);
        }
    }

    public LegalPerson delete(LegalPerson legalPerson) throws Exception {

            EntityManager entityManager = JPA.getEntitymanager();
            entityManager.getTransaction().begin();
            LegalPerson hibernatePerson = entityManager.find(LegalPerson.class, legalPerson.getLegalPersonId());
            entityManager.remove(hibernatePerson);
            entityManager.getTransaction().commit();
            entityManager.close();
            Logger.getLogger(String.valueOf(LegalPerson.class)).info("legal customer deleted.");
            return hibernatePerson;
    }


    public List<LegalPerson> findAll() throws Exception {
        EntityManager entityManager = JPA.getEntitymanager();
        List<LegalPerson> legalPersonList = entityManager.createQuery("select person from legalPerson person").getResultList();
        entityManager.close();
        return legalPersonList;
    }

    public List<LegalPerson> findByCompany(String company) throws Exception {
        EntityManager entityManager = JPA.getEntitymanager();
        List<LegalPerson> legalPersonList = entityManager.createQuery("select person from legalPerson person where person.company=:company").setParameter("company", company).getResultList();
        entityManager.close();
        Logger.getLogger(String.valueOf(LegalPerson.class)).info("legal customer find by company.");
        return legalPersonList;
    }

    public List<LegalPerson> findByEconomicCode(String economicCode) throws Exception {
        try {
        EntityManager entityManager = JPA.getEntitymanager();
        List<LegalPerson> legalPersonList = entityManager.createQuery("select person from legalPerson person where person.economicCode=:economicCode").setParameter("economicCode", economicCode).getResultList();
        entityManager.close();
            Logger.getLogger(String.valueOf(LegalPerson.class)).info("legal customer find by economicCode.");
        return legalPersonList;
        } catch (HibernateException e) {
            Logger.getLogger(String.valueOf(LegalPerson.class)).info("Legal customer dose not find by economicCode.");
            throw new BusinessException(ENTITY_NOT_FOUND);
        }
    }

    public List<LegalPerson> findById(long id) throws Exception {
        try {
            EntityManager entityManager = JPA.getEntitymanager();
           List<LegalPerson> legalPersonList = entityManager.createQuery("select person from legalPerson person where person.id=:id").setParameter("id", id).getResultList();
            entityManager.close();
            Logger.getLogger(String.valueOf(LegalPerson.class)).info("legal customer retrieved.");
            return legalPersonList;
        } catch (HibernateException e) {
            Logger.getLogger(String.valueOf(LegalPerson.class)).info("Legal customer dose not retrieved.");
            throw new BusinessException(Legal_Customer_Number);
        }
    }



}
 */
