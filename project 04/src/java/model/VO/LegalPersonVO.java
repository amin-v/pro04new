package model.VO;

import model.entity.LegalPerson;

import java.time.LocalDate;

public class LegalPersonVO {
    private Long id;
    private String company;
    private LocalDate RegisterDate;
    private String economicCode;


    public LegalPersonVO() {
    }

    public LegalPersonVO(String company, LocalDate registerDate, String economicCode) {
        this.company = company;
        RegisterDate = registerDate;
        this.economicCode = economicCode;
    }

    public LegalPersonVO(long id, String company, LocalDate registerDate, String economicCode) {
        this.id = id;
        this.company = company;
        RegisterDate = registerDate;
        this.economicCode = economicCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDate getRegisterDate() {
        return RegisterDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        RegisterDate = registerDate;
    }

    public String getEconomicCode() {
        return economicCode;
    }

    public void setEconomicCode(String economicCode) {
        this.economicCode = economicCode;
    }

    public static LegalPersonVO parseLegalPersonVO(LegalPerson legalPerson) {
        LegalPersonVO legalPersonVo = new LegalPersonVO();
        legalPersonVo.setId(legalPerson.getLegalPersonId());
        legalPersonVo.setCompany(legalPerson.getCompany());
        legalPersonVo.setRegisterDate(legalPerson.getRegisterDate());
        legalPersonVo.setEconomicCode(legalPerson.getEconomicCode());
        return legalPersonVo;
    }
}
