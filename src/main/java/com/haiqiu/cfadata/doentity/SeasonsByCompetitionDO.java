package com.haiqiu.cfadata.doentity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.haiqiu.cfadata.poentity.AgePO;
import com.haiqiu.cfadata.poentity.CountryPO;
import com.haiqiu.cfadata.poentity.FederationPO;

import java.util.List;

/**
 * Created by peanut on 2019/5/13 下午4:49
 */
public class SeasonsByCompetitionDO {

    private String id;
    private String sport_id;
    private String name;
    private String shortname;
    private String type;
    private String gender;
    private String current_season_id;
    private String current_round_id;
//    private String current_matchday;
    private String age_id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CountryPO country;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private FederationPO federation;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AgePO age;
    private List<SeasonBean> season;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSport_id() {
        return sport_id;
    }

    public void setSport_id(String sport_id) {
        this.sport_id = sport_id;
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

    public String getAge_id() {
        return age_id;
    }

    public void setAge_id(String age_id) {
        this.age_id = age_id;
    }

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

    public List<SeasonBean> getSeason() {
        return season;
    }

    public void setSeason(List<SeasonBean> season) {
        this.season = season;
    }

    public static class SeasonBean {

        private String id;
        private String name;
        private String current_round_id;
//        private String current_group_matchday;
        private String has_tables;
        private String start;
        private String end;


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

        public String getCurrent_round_id() {
            return current_round_id;
        }

        public void setCurrent_round_id(String current_round_id) {
            this.current_round_id = current_round_id;
        }

//        public String getCurrent_group_matchday() {
//            return current_group_matchday;
//        }
//
//        public void setCurrent_group_matchday(String current_group_matchday) {
//            this.current_group_matchday = current_group_matchday;
//        }

        public String getHas_tables() {
            return has_tables;
        }

        public void setHas_tables(String has_tables) {
            this.has_tables = has_tables;
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

    }

    @Override
    public String toString() {
        return "SeasonsByCompetitionDO{" +
                "id='" + id + '\'' +
                ", sport_id='" + sport_id + '\'' +
                ", name='" + name + '\'' +
                ", shortname='" + shortname + '\'' +
                ", type='" + type + '\'' +
                ", gender='" + gender + '\'' +
                ", current_season_id='" + current_season_id + '\'' +
                ", current_round_id='" + current_round_id + '\'' +
//                ", current_matchday='" + current_matchday + '\'' +
                ", age_id='" + age_id + '\'' +
                ", country=" + country +
                ", federation=" + federation +
                ", age=" + age +
                ", season=" + season +
                '}';
    }
}
