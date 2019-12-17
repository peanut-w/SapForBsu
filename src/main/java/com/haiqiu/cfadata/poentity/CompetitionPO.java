package com.haiqiu.cfadata.poentity;

import java.util.Date;

public class CompetitionPO {
    private Integer id;

    private String name;

    private String shortname;

    private String microname;

    private String type;

    private String gender;

    private Integer sportId;

    private Integer federationId;

    private Integer policyId;

    private Integer countryId;

    private Integer order;

    private Integer ageId;

    private Date starttime;

    private Date lastModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }

    public String getMicroname() {
        return microname;
    }

    public void setMicroname(String microname) {
        this.microname = microname == null ? null : microname.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getSportId() {
        return sportId;
    }

    public void setSportId(Integer sportId) {
        this.sportId = sportId;
    }

    public Integer getFederationId() {
        return federationId;
    }

    public void setFederationId(Integer federationId) {
        this.federationId = federationId;
    }

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getAgeId() {
        return ageId;
    }

    public void setAgeId(Integer ageId) {
        this.ageId = ageId;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "CompetitionPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortname='" + shortname + '\'' +
                ", microname='" + microname + '\'' +
                ", type='" + type + '\'' +
                ", gender='" + gender + '\'' +
                ", sportId=" + sportId +
                ", federationId=" + federationId +
                ", policyId=" + policyId +
                ", countryId=" + countryId +
                ", order=" + order +
                ", ageId=" + ageId +
                ", starttime=" + starttime +
                ", lastModified=" + lastModified +
                '}';
    }
}
