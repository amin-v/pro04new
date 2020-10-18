package model.entity;

import model.VO.RealPersonVO;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity(name = "realPerson")
public class RealPerson implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long realPersonId;
    @Column(columnDefinition = "varchar2(30)", nullable = false)
    private String name;
    @Column(columnDefinition = "varchar2(30)", nullable = false)
    private String family;
    @Column(columnDefinition = "varchar2(30)", nullable = false)
    private String fatherName;
    @Column(columnDefinition = "date", nullable = false)
    private LocalDate birthDate;
    @Column(columnDefinition = "varchar2(10)", unique = true, nullable = false)
    private String nationalCode;
    @OneToMany(mappedBy = "realPerson",cascade = CascadeType.ALL)
    private List<FacilityAccount> facilityAccountList =new ArrayList<>();

    public RealPerson(String name, String family, String fatherName, LocalDate birthDate, String nationalCode) {
        this.name = name;
        this.family = family;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
        this.nationalCode = nationalCode;
    }

    public RealPerson(Long realPersonId, String name, String family, String fatherName, LocalDate birthDate, String nationalCode) {
        this.realPersonId = realPersonId;
        this.name = name;
        this.family = family;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
        this.nationalCode = nationalCode;
    }

    public RealPerson() {
    }

    public Long getRealPersonId() {
        return realPersonId;
    }

    public RealPerson setRealPersonId(Long id) {
        this.realPersonId = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RealPerson setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public RealPerson setFamily(String family) {
        this.family = family;
        return this;
    }

    public String getFatherName() {
        return fatherName;
    }

    public RealPerson setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public RealPerson setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public RealPerson setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
        return this;
    }

    public RealPerson parseRealPerson(RealPersonVO realPersonVO) {
        RealPerson realPerson = new RealPerson();
        realPersonVO.setId(realPersonVO.getId());
        realPersonVO.setName(realPersonVO.getName());
        realPersonVO.setFamily(realPersonVO.getFamily());
        realPersonVO.setFatherName(realPersonVO.getFatherName());
        realPersonVO.setNationalCode(realPersonVO.getNationalCode());
        realPersonVO.setBirthDate(realPersonVO.getBirthDate());
        return realPerson;

    }
}
