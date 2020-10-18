package model.VO;

import model.entity.RealPerson;

import java.time.LocalDate;

public class RealPersonVO {
    private Long id;
    private String name;
    private String family;
    private String fatherName;
    private LocalDate birthDate;
    private String nationalCode;

    public RealPersonVO() {
    }

    public RealPersonVO(String name, String family, String fatherName, LocalDate birthDate, String nationalCode) {
        this.name = name;
        this.family = family;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
        this.nationalCode = nationalCode;
    }

    public RealPersonVO(Long id, String name, String family, String fatherName, LocalDate birthDate, String nationalCode) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
        this.nationalCode = nationalCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public RealPersonVO parseRealPersonVO(RealPerson realPerson) {
        RealPersonVO realPersonVO = new RealPersonVO();
        realPersonVO.setId(realPerson.getRealPersonId());
        realPersonVO.setName(realPerson.getName());
        realPersonVO.setFamily(realPerson.getFamily());
        realPersonVO.setFatherName(realPerson.getFatherName());
        realPersonVO.setNationalCode(realPerson.getNationalCode());
        realPersonVO.setBirthDate(realPerson.getBirthDate());
        return realPersonVO;

    }

}
