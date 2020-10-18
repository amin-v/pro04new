package commons;

public interface ExceptionMessages {

    String ENTITY_NOT_FOUND= "error 100 :there is no legal customer with this economic code";
    String REPETETIVE_ECONOMIC_CODE= "error 101 :the economic code that you entered is already exist";
    String COMPANY_NOT_FOUND="error 102 : there is no legal customer with this company";
    String Legal_Customer_Number="error 103: there is no legal customer with this CustomerNumber";
    String REPETETIVE_NATIONAL_CODE="error 104 :the national code that you entered is already exist";
    String NAME_NOT_FOUND="error 105 : there is no real customer with this name";
    String FAMILY_NOT_FOUND="error 106 : there is no real customer with this Family";
    String RealCustomer_Entity_NOT_FOUND="error 107 : there is no Real customer with this National code";
    String REALCUSTOMER_NOT_FOUND="error 108 : there is no Real Customer whith this properties";
    String Facility_Profile_NotFound ="error 109:Loan type is not created";
    String FacilityProfile_entity_exist ="error 110: loanType_id not exist";
    String customerNumer_RealPerson="error 111: real person customer id is not exist";
    String GrandCondition_NotFound="error112: loanName is not exist";
    String THE_CONDITIONS_IS_NOT_TRUE="your coditiones is not true";
    String FacilityProfile_isNot_compeleted ="error114:plz compeleted file";
    String table_lesstime="حداقل زمان باید کمتر از حداکثر باشد.";
    String table_overTime="حداقل مبلغ باید کمتر از حداکثر باشد.";
    String repetetive_Condition="نام شرط اعطا ذکر شده تکراری است.";
    String time_and_durtion="در وارد کردن مدت و مبلغ قرار داد دقت فرمایید...";
}
