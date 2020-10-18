package model.service;

import commons.exceptions.BusinessException;
import configController.HibernateUtil;
import model.entity.GrantCondition;
import model.entity.FacilityProfile;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.apache.log4j.Logger;

import java.util.List;

import static commons.ExceptionMessages.*;

public class GrantConditionalCRUD {
    private static GrantConditionalCRUD grantConditionalCRUD = new GrantConditionalCRUD();

    private GrantConditionalCRUD() {
    }

    public static GrantConditionalCRUD getInstance() {
        return grantConditionalCRUD;
    }

    private static Logger logger = Logger.getLogger(GrantCondition.class);

    public static void persist(FacilityProfile facilityProfile, GrantCondition grantCondition) throws BusinessException {
        Session session = null;
        try {
            logger.debug("start creating facilityProfile");
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
//            FacilityProfileCRUD.getInstance().persist(facilityProfile);
//            for (GrantCondition grantCondition: grantConditions){
//                grantCondition.getFacilityProfile().setLoanTypeId(facilityProfile.getLoanTypeId());
//            }
            //FacilityProfileCRUD.persist(facilityProfile);
            grantCondition.setFacilityProfile(facilityProfile);
            session.persist(grantCondition);
            transaction.commit();
            logger.info("Grant Conditions created.");
        } catch (HibernateException e) {
            logger.error("Grant Conditions dose not created.");
            throw new BusinessException(THE_CONDITIONS_IS_NOT_TRUE);
        } finally {
            session.close();
        }
    }

    public static List<GrantCondition> finByName(String name) throws BusinessException {
        Session session = null;
        List<GrantCondition> grantConditionList;
        try {
            logger.debug("start finding loanType by name ");
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            grantConditionList = session.createQuery("select grantCondition from GrantCondition grantCondition left join fetch grantCondition.facilityProfile loan where grantCondition.name=:name").setParameter("name", name).getResultList();
            transaction.commit();
            logger.info("Grant Conditions find.");
        } catch (HibernateException e) {
            logger.error("Grant Conditions dose not find.");
            e.printStackTrace();
            throw new BusinessException(GrandCondition_NotFound);
        } finally {
            session.close();
        }
        return grantConditionList;
    }

    public static List<GrantCondition> findByLoanId(long loanTypeId) throws BusinessException {
        List<GrantCondition> grantConditionList;
        logger.debug("starting finding loanTypeId ");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            grantConditionList = session.createQuery("select grantCondition from GrantCondition grantCondition left join fetch grantCondition.facilityProfile loan where grantCondition.facilityProfile.loanTypeId=:LoanType_ID").setParameter("LoanType_ID", loanTypeId).getResultList();
            transaction.commit();
            logger.info("Grant Conditions  find.");
            return grantConditionList;
        } catch (HibernateException e) {
            logger.error("Grant Conditions dose not find.");
            e.printStackTrace();
            throw new BusinessException(GrandCondition_NotFound);
        } finally {
            session.close();
        }
    }

    public List<GrantCondition> findAll() throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<GrantCondition> grantConditionList = session.createQuery("select  grantCondition  from GrantCondition grantCondition").getResultList();
        transaction.commit();
        session.close();
        return grantConditionList;
    }

    //check........................................
//    public static void create(List<GrantCondition> grantConditionList, String loanTypeName, String interestRate) throws BusinessException {
//        FacilityProfile loanType = new FacilityProfile(loanTypeName, interestRate, grantConditionList);
//        GrantConditionalCRUD.getInstance().persist(loanType, grantConditionList);
//    }

    public static boolean validate(GrantCondition grantCondition) throws BusinessException {
        if (grantCondition.getMinDuration() >= grantCondition.getMaxDuration()) {
            throw new BusinessException(table_lesstime);
        }
        if (grantCondition.getMinAmount().compareTo(grantCondition.getMaxAmount()) > 0) {
            throw new BusinessException(table_overTime);
        }

        List<GrantCondition> findGrantConditional = GrantConditionalCRUD.finByName(grantCondition.getName());
        if (findGrantConditional == null) {
            throw new BusinessException(repetetive_Condition);
        }

        return true;
    }
}


