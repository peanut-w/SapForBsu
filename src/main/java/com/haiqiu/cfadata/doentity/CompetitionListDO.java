package com.haiqiu.cfadata.doentity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.haiqiu.cfadata.poentity.AgePO;
import com.haiqiu.cfadata.poentity.CountryPO;
import com.haiqiu.cfadata.poentity.FederationPO;
import com.haiqiu.cfadata.poentity.SportPO;

/**
 * Created by peanut on 2019/5/13 下午4:48
 */
public class CompetitionListDO {


    private String id;
    private String name;
    private String shortname;
    private String microname;
    private String type;
    private String gender;

    /**
     * 数据库表中不存在这三条数据，计划根据当前时间生成
     */

    private String current_season_id;
    private String current_round_id;
//    private String current_matchday;
//
//    private String competition_order;

    private String age_id;
    private SportPO sport;
    //    private PolicyPO policy;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CountryPO country;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private FederationPO federation;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AgePO age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getMicroname() {
        return microname;
    }

    public void setMicroname(String microname) {
        this.microname = microname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCurrent_season_id() {
        return current_season_id;
    }

    public void setCurrent_season_id(String current_season_id) {
        this.current_season_id = current_season_id;
    }

    public String getCurrent_round_id() {
        return current_round_id;
    }

    public void setCurrent_round_id(String current_round_id) {
        this.current_round_id = current_round_id;
    }

//    public String getCurrent_matchday() {
//        return current_matchday;
//    }
//
//    public void setCurrent_matchday(String current_matchday) {
//        this.current_matchday = current_matchday;
//    }
//
//    public String getCompetition_order() {
//        return competition_order;
//    }
//
//    public void setCompetition_order(String competition_order) {
//        this.competition_order = competition_order;
//    }

    public String getAge_id() {
        return age_id;
    }

    public void setAge_id(String age_id) {
        this.age_id = age_id;
    }

    public SportPO getSport() {
        return sport;
    }

    public void setSport(SportPO sport) {
        this.sport = sport;
    }

//    public PolicyPO getPolicy() {
//        return policy;
//    }
//
//    public void setPolicy(PolicyPO policy) {
//        this.policy = policy;
//    }

    public CountryPO getCountry() {
        return country;
    }

    public void setCountry(CountryPO country) {
        this.country = country;
    }

    public FederationPO getFederation() {
        return federation;
    }

    public void setFederation(FederationPO federation) {
        this.federation = federation;
    }

    public AgePO getAge() {
        return age;
    }

    public void setAge(AgePO age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "CompetitionListDO{" +
                "id=" + id +
                ", sport=" + sport +
                ", name='" + name + '\'' +
                ", shortname='" + shortname + '\'' +
                ", microname='" + microname + '\'' +
                ", type='" + type + '\'' +
                ", gender='" + gender + '\'' +
                ", current_season_id='" + current_season_id + '\'' +
                ", current_round_id='" + current_round_id + '\'' +
//                ", current_matchday='" + current_matchday + '\'' +
//                ", competition_order='" + competition_order + '\'' +
                ", age_id='" + age_id + '\'' +
//                ", policy=" + policy +
                ", country=" + country +
                ", federation=" + federation +
                ", age=" + age +
                '}';
    }
}
