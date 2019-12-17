package com.haiqiu.cfadata.doentity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.haiqiu.cfadata.poentity.AgePO;
import com.haiqiu.cfadata.poentity.CountryPO;

import java.util.List;

/**
 * Created by peanut on 2019/5/13 下午4:49
 */
public class TeamsBySeasonExtendDO {



    private String id;
    private String sport_id;

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

    public List<SeasonBean> getSeason() {
        return season;
    }

    public void setSeason(List<SeasonBean> season) {
        this.season = season;
    }

    public static class SeasonBean {


        private String id;
        private String competition_id;
        private String name;
        private String start;
        private String end;
        private List<TeamBean> team;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCompetition_id() {
            return competition_id;
        }

        public void setCompetition_id(String competition_id) {
            this.competition_id = competition_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

//        public String getCurrent_round_id() {
//            return current_round_id;
//        }
//
//        public void setCurrent_round_id(String current_round_id) {
//            this.current_round_id = current_round_id;
//        }
//
//        public String getCurrent_group_matchday() {
//            return current_group_matchday;
//        }
//
//        public void setCurrent_group_matchday(String current_group_matchday) {
//            this.current_group_matchday = current_group_matchday;
//        }

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

        public List<TeamBean> getTeam() {
            return team;
        }

        public void setTeam(List<TeamBean> team) {
            this.team = team;
        }

        public static class TeamBean {


            private String id;
            private String source_id;
            private String name;
            private String shortname;
//            private String microname;
            private String type;
            private String gender;
            private String show_team;
            @JsonInclude(JsonInclude.Include.NON_NULL)
            private CountryPO country;
            @JsonInclude(JsonInclude.Include.NON_NULL)
            private AgePO age;
            @JsonInclude(JsonInclude.Include.NON_NULL)
            private ClubBean club;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSource_id() {
                return source_id;
            }

            public void setSource_id(String source_id) {
                this.source_id = source_id;
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

            public String getShow_team() {
                return show_team;
            }

            public void setShow_team(String show_team) {
                this.show_team = show_team;
            }


            public CountryPO getCountry() {
                return country;
            }

            public void setCountry(CountryPO country) {
                this.country = country;
            }

            public AgePO getAge() {
                return age;
            }

            public void setAge(AgePO age) {
                this.age = age;
            }


            public ClubBean getClub() {
                return club;
            }

            public void setClub(ClubBean club) {
                this.club = club;
            }

            public static class ClubBean {
                /**
                 * id : 459
                 * name : Botafogo RJ
                 */

                private String id;
                private String name;

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
            }
        }
    }

    @Override
    public String toString() {
        return "TeamsBySeasonExtendDO{" +
                "id='" + id + '\'' +
                ", sport_id='" + sport_id + '\'' +
                ", season=" + season +
                '}';
    }
}
