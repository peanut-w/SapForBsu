package com.haiqiu.cfadata.doentity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.haiqiu.cfadata.poentity.AgePO;
import com.haiqiu.cfadata.poentity.SportPO;

import java.util.List;

/**
 * Created by peanut on 2019/6/5 下午4:31
 */
public class TeamsByClubDO {


    private String id;
    private String name;
    private List<TeamBean> team;

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

    public List<TeamBean> getTeam() {
        return team;
    }

    public void setTeam(List<TeamBean> team) {
        this.team = team;
    }

    public static class TeamBean {

        private String id;
        private String name;
        private String shortname;
        private String microname;
        private String type;
        private String gender;
        private String show_team;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private SportPO sport;
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

        public String getShow_team() {
            return show_team;
        }

        public void setShow_team(String show_team) {
            this.show_team = show_team;
        }

        public SportPO getSport() {
            return sport;
        }

        public void setSport(SportPO sport) {
            this.sport = sport;
        }


        public AgePO getAge() {
            return age;
        }

        public void setAge(AgePO age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "TeamBean{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", shortname='" + shortname + '\'' +
                    ", microname='" + microname + '\'' +
                    ", type='" + type + '\'' +
                    ", gender='" + gender + '\'' +
                    ", show_team='" + show_team + '\'' +
                    ", sport=" + sport +
                    ", age=" + age +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TeamsByClubDO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", team=" + team +
                '}';
    }
}
