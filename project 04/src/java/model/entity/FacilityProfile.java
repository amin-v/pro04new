package model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "loanType")
@Table
public class FacilityProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loanTypeId;

    @Column(columnDefinition = "varchar2(50)", nullable = false)
    private String loanName;

    @Column(columnDefinition = "varchar2(20)", nullable = false)
    private String interestRate;

    @OneToMany(mappedBy = "facilityProfile", cascade = CascadeType.PERSIST)
    private List<GrantCondition> grantConditions = new ArrayList<GrantCondition>();


//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinColumn(name = "FK")


    public FacilityProfile() {

    }

    public FacilityProfile(String loanName, String interestRate, List<GrantCondition> grantConditions) {
        this.loanName = loanName;
        this.interestRate = interestRate;
        this.grantConditions = grantConditions;
    }

    public FacilityProfile(String loanName, String interestRate) {
        this.loanName = loanName;
        this.interestRate = interestRate;
    }

    public FacilityProfile(Long loanTypeId) {
        this.loanTypeId = loanTypeId;

    }

    public Long getLoanTypeId() {
        return loanTypeId;
    }

    public FacilityProfile setLoanTypeId(Long loanTypeId) {
        this.loanTypeId = loanTypeId;
        return this;
    }

    public String getLoanName() {
        return loanName;
    }

    public FacilityProfile setLoanName(String loanName) {
        this.loanName = loanName;
        return this;
    }


    public String getInterestRate() {
        return interestRate;
    }

    public FacilityProfile setInterestRate(String interestRate) {
        this.interestRate = interestRate;
        return this;
    }

    public List<GrantCondition> getGrantConditions() {
        return grantConditions;
    }

    public FacilityProfile setGrantConditions(List<GrantCondition> grantConditions) {
        this.grantConditions = grantConditions;
        return this;
    }
}
