package model.service;

import commons.exceptions.BusinessException;
import configController.HibernateUtil;
import model.entity.FacilityProfile;
import model.entity.GrantCondition;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.apache.log4j.Logger;
import java.util.List;

import static commons.ExceptionMessages.*;

public class FacilityProfileCRUD {
    public static FacilityProfileCRUD facilityProfileCRUD = new FacilityProfileCRUD();

    private FacilityProfileCRUD() {
    }

    public static FacilityProfileCRUD getInstance() {
        return facilityProfileCRUD;
    }

    private static Logger logger =  Logger.getLogger(GrantCondition.class);
    private static Logger logger1 =  Logger.getLogger(FacilityProfile.class);

    public static void persist(FacilityProfile facilityProfile) throws HibernateException, BusinessException {
        Session session = null;
        try {
            logger.debug("start creating facilityProfile");
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(facilityProfile);
            transaction.commit();
            logger.info("Loan Type created.");
        } catch (HibernateException e) {
            logger.error("Loan Type dose not created.");
            throw new BusinessException(Facility_Profile_NotFound);
        } finally {
            session.close();
        }
    }

    public static List<FacilityProfile> findAll() throws HibernateException, BusinessException {
        Session session = null;
        List<FacilityProfile> facilityProfileList;
        try {
            logger1.debug("start finding all loanType");
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            facilityProfileList = session.createQuery("select person from loanType person").getResultList();
            transaction.commit();
            logger1.info("all loan type find.");
        } catch (HibernateException e) {
            logger1.error("Loan Type dose not created.");
            throw new BusinessException(Facility_Profile_NotFound);
        } finally {
            session.close();
        }
        return facilityProfileList;
    }

    public static List<FacilityProfile> findById(long loanTypeId) throws HibernateException, BusinessException {
        Session session = null;
        List<FacilityProfile> facilityProfileList;
        try {
            logger1.debug("start finding loanType id ");
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            facilityProfileList = session.createQuery("select  person from loanType person where person.loanTypeId=:LoanType_ID ").setParameter("LoanType_ID", loanTypeId).getResultList();
            transaction.commit();
            logger1.info("loan type find.");
        } catch (HibernateException e) {
           logger1.error("Loan Type dose not created.");
            throw new BusinessException(FacilityProfile_entity_exist);
        } finally {
            session.close();
        }
        return facilityProfileList;
    }

//check.........................

    public static FacilityProfile validate(String loanName, String interestRate) throws BusinessException {
        if (loanName.equals("") || interestRate.equals("")) {
            throw new BusinessException(FacilityProfile_isNot_compeleted);
        } else {
            FacilityProfile facilityProfile = new FacilityProfile(loanName, interestRate);
            return facilityProfile;
        }
    }

}