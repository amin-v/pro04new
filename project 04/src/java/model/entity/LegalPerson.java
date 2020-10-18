package model.entity;

import model.VO.LegalPersonVO;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Table
@Entity(name = "legalPerson")
public class LegalPerson implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long legalPersonId;
    @Column(columnDefinition = "varchar2(30)", nullable = false)
    private String company;
    @Column(columnDefinition = "date" , nullable = false)
    private LocalDate RegisterDate;
    @Column(columnDefinition = "varchar2(30)",unique = true , nullable = false)
    private String economicCode;

    public LegalPerson(String company, LocalDate registerDate, String economicCode) {
        this.company = company;
        RegisterDate = registerDate;
        this.economicCode = economicCode;
    }

    public LegalPerson(long legalPersonId, String company, LocalDate registerDate, String economicCode) {
        this.legalPersonId = legalPersonId;
        this.company = company;
        RegisterDate = registerDate;
        this.economicCode = economicCode;
    }

    public LegalPerson() {
    }

    public Long getLegalPersonId() {
        return legalPersonId;
    }

    public LegalPerson setLegalPersonId(Long id) {
        this.legalPersonId = id;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public LegalPerson setCompany(String company) {
        this.company = company;
        return this;
    }

    public LocalDate getRegisterDate() {
        return RegisterDate;
    }

    public LegalPerson setRegisterDate(LocalDate registerDate) {
        RegisterDate = registerDate;
        return this;
    }

    public String getEconomicCode() {
        return economicCode;
    }

    public LegalPerson setEconomicCode(String economicCode) {
        this.economicCode = economicCode;
        return this;
    }

    public LegalPerson parseLegalPerson(LegalPersonVO legalPersonVO){
        LegalPerson legalPerson=new LegalPerson();
       legalPerson.setLegalPersonId(legalPersonVO.getId());
       legalPerson.setCompany(legalPersonVO.getCompany());
        legalPerson.setRegisterDate(legalPersonVO.getRegisterDate());
       legalPerson.setEconomicCode(legalPersonVO.getEconomicCode());
        return legalPerson;
    }
}
