package model.service;

import commons.exceptions.BusinessException;
import configController.HibernateUtil;
import model.entity.FacilityAccount;
import model.entity.GrantCondition;
import model.entity.FacilityProfile;
import model.entity.RealPerson;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.List;

import static commons.ExceptionMessages.customerNumer_RealPerson;
import static commons.ExceptionMessages.time_and_durtion;

public class FacilityAccountCRUD {
    private static FacilityAccountCRUD facilityAccountCRUD = new FacilityAccountCRUD();

    private FacilityAccountCRUD() {
    }

    public static FacilityAccountCRUD getInstance() {
        return facilityAccountCRUD;
    }

    private static Logger logger = Logger.getLogger(FacilityAccount.class);

    public static void persist(FacilityProfile facilityProfile, RealPerson realPerson, FacilityAccount facilityAccount) throws HibernateException, BusinessException {
       logger.debug("start creating facilityProfile");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            validate(facilityAccount.getAmount(), facilityAccount.getDuration(), facilityAccount.getFacilityProfile().getLoanTypeId());
            facilityAccount.setFacilityProfile(facilityProfile);
            facilityAccount.setRealPerson(realPerson);
            session.persist(facilityAccount);
            transaction.commit();
           logger.info("loan file created.");
        } catch (HibernateException e) {
           logger.error("loan file dose not created.");
            throw new BusinessException(customerNumer_RealPerson);
        } finally {
            session.close();
        }
    }

    public static List<FacilityAccount> findById(long realPersonId) throws BusinessException {
        logger.debug("start finding by loanId");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<FacilityAccount> facilityAccountList;
        try {
            facilityAccountList = session.createQuery("select loanFile from LoanFile loanFile LEFT join fetch loanFile.realPerson loan where loanFile.realPerson.realPersonId=: realPersonId").setParameter("realPersonId", realPersonId).getResultList();
            transaction.commit();
           logger.info("Loan File  find.");
            return facilityAccountList;
        } catch (HibernateException e) {
            logger.error("FacilityAccount dose not find.");
            e.printStackTrace();
            throw new BusinessException(customerNumer_RealPerson);
        } finally {
            session.close();
        }
    }


    //check..................................................
    public static FacilityProfile validate(String amount, String duration, long loanTypeId) throws BusinessException {
        List<GrantCondition> grantConditionList = GrantConditionalCRUD.findByLoanId(loanTypeId);
        for (GrantCondition grantCondition : grantConditionList) {
            if ((Long.parseLong(duration) < grantCondition.getMaxDuration()) && (Long.parseLong(duration) > grantCondition.getMinDuration())) {
                if ((new BigDecimal(amount).compareTo(grantCondition.getMaxAmount())) <= 0 && (new BigDecimal(amount).compareTo(grantCondition.getMinAmount()) >= 0)) {
                    return grantCondition.getFacilityProfile().setLoanTypeId(loanTypeId);
                }
            }
        }
        throw new BusinessException(time_and_durtion);
    }
}