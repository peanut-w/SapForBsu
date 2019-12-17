package com.haiqiu.cfadata.doentity;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by peanut on 2019/5/13 下午4:50
 */
public class MatchDO {

    private MatchBean match;
    private List<MatchResultAtBean> match_result_at;

    public MatchBean getMatch() {
        return match;
    }

    public void setMatch(MatchBean match) {
        this.match = match;
    }

    public List<MatchResultAtBean> getMatch_result_at() {
        return match_result_at;
    }

    public void setMatch_result_at(List<MatchResultAtBean> match_result_at) {
        this.match_result_at = match_result_at;
    }

    public static class MatchBean {

        private String id;
        private String round_id;
        private String matchday;
        private String group_matchday;
        private String match_date;
        private String match_time;
        private String finished;
        private String live_status;
        private String current_period;
//        private String current_period_start;
        private String current_minute;
//        private String attendance;

        private String winner_team_id;
        private RoundBean round;
        private TeamDO home;
        private TeamDO away;

        private List<MatchResultBean> match_result;
        private List<MatchEventBean> match_event;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRound_id() {
            return round_id;
        }

        public void setRound_id(String round_id) {
            this.round_id = round_id;
        }

        public RoundBean getRound() {
            return round;
        }

        public void setRound(RoundBean round) {
            this.round = round;
        }

        public String getMatchday() {
            return matchday;
        }

        public void setMatchday(String matchday) {
            this.matchday = matchday;
        }

        public String getGroup_matchday() {
            return group_matchday;
        }

        public void setGroup_matchday(String group_matchday) {
            this.group_matchday = group_matchday;
        }

        public String getMatch_date() {
            return match_date;
        }

        public void setMatch_date(String match_date) {
            this.match_date = match_date;
        }

        public String getMatch_time() {
            return match_time;
        }

        public void setMatch_time(String match_time) {
            this.match_time = match_time;
        }

        public String getFinished() {
            return finished;
        }

        public void setFinished(String finished) {
            this.finished = finished;
        }

        public String getLive_status() {
            return live_status;
        }

        public void setLive_status(String live_status) {
            this.live_status = live_status;
        }

        public String getCurrent_period() {
            return current_period;
        }

        public void setCurrent_period(String current_period) {
            this.current_period = current_period;
        }

//        public String getCurrent_period_start() {
//            return current_period_start;
//        }
//
//        public void setCurrent_period_start(String current_period_start) {
//            this.current_period_start = current_period_start;
//        }

        public String getCurrent_minute() {
            return current_minute;
        }

        public void setCurrent_minute(String current_minute) {
            this.current_minute = current_minute;
        }

//        public String getAttendance() {
//            return attendance;
//        }
//
//        public void setAttendance(String attendance) {
//            this.attendance = attendance;
//        }

        public String getWinner_team_id() {
            return winner_team_id;
        }

        public void setWinner_team_id(String winner_team_id) {
            this.winner_team_id = winner_team_id;
        }

        public TeamDO getHome() {
            return home;
        }

        public void setHome(TeamDO home) {
            this.home = home;
        }

        public TeamDO getAway() {
            return away;
        }

        public void setAway(TeamDO away) {
            this.away = away;
        }

        public List<MatchResultBean> getMatch_result() {
            return match_result;
        }

        public void setMatch_result(List<MatchResultBean> match_result) {
            this.match_result = match_result;
        }

        public List<MatchEventBean> getMatch_event() {
            return match_event;
        }

        public void setMatch_event(List<MatchEventBean> match_event) {
            this.match_event = match_event;
        }

        public static class RoundBean {
            /**
             * id : 1
             * season : {"id":"113","competition":{"id":"115","name":"Super League","type":"club","gender":"male"},"name":"2003 Relegation"}
             * name : Round
             */

            private String id;
            private SeasonBean season;
            private String name;
            // TODO: 2019/5/14


            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public SeasonBean getSeason() {
                return season;
            }

            public void setSeason(SeasonBean season) {
                this.season = season;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public static class SeasonBean {
                /**
                 * id : 113
                 * competition : {"id":"115","name":"Super League","type":"club","gender":"male"}
                 * name : 2003 Relegation
                 */

                private String id;
                private CompetitionBean competition;
                private String name;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public CompetitionBean getCompetition() {
                    return competition;
                }

                public void setCompetition(CompetitionBean competition) {
                    this.competition = competition;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public static class CompetitionBean {
                    /**
                     * id : 115
                     * name : Super League
                     * type : club
                     * gender : male
                     */

                    private String id;
                    private String name;
                    private String type;
                    private String gender;

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
                }
            }
        }

        public static class MatchResultBean {
            /**
             * match_result : 4
             * match_result_at : 0
             * place : home
             */

            private String match_result;
            private String match_result_at;
            private String place;

            public String getMatch_result() {
                return match_result;
            }

            public void setMatch_result(String match_result) {
                this.match_result = match_result;
            }

            public String getMatch_result_at() {
                return match_result_at;
            }

            public void setMatch_result_at(String match_result_at) {
                this.match_result_at = match_result_at;
            }

            public String getPlace() {
                return place;
            }

            public void setPlace(String place) {
                this.place = place;
            }
        }

        public static class MatchEventBean {
            /**
             * id : 17725942
             * team : {"id":"590","name":"FC Aarau","show_team":"yes"}
             * team_person : {"id":"202421","shirtnumber":"0"}
             * person : {"id":"8945","name":"Ivan Benito","firstname":"Ivan","surname":"Benito","fullname":"Ivan Benito","gender":"male","birthday":"27.08.1976","height":"182","weight":"80","person_detail":{"id":"73882","position_1":"1","position_2":"0","preferred_side":"unknown","birth_place":"Aarau","died":"no"},"country":[{"id":"183","name":"Switzerland","code":"SUI","iso":"CH"}]}
             * action : playing
             * kind : lineup
             * content :
             * minute : 0
             * additional_person_id : 0
             * created : 26.09.2015 12:36:42
             * additional_person : {"id":"10713","name":"Christian Brand","firstname":"Christian","surname":"Brand","fullname":"Christian Brand","gender":"male","birthday":"23.05.1972","height":"174","weight":"67","person_detail":{"id":"131","position_1":"8","position_2":"0","preferred_side":"both","birth_place":"Quakenbrück","died":"no"},"country":[{"id":"47","name":"Germany","code":"GER","iso":"DE"}]}
             */

            private String id;
            @JsonInclude(JsonInclude.Include.NON_NULL)
            private TeamBean team;
            @JsonInclude(JsonInclude.Include.NON_NULL)
            private TeamPersonBean team_person;
            @JsonInclude(JsonInclude.Include.NON_NULL)
            private PersonBean person;
            private String action;
            private String kind;
//            private String content;
            private String minute;
//            private String additional_person_id;
//            private String created;
            @JsonInclude(JsonInclude.Include.NON_NULL)
            private PersonBean additional_person;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public TeamBean getTeam() {
                return team;
            }

            public void setTeam(TeamBean team) {
                this.team = team;
            }

            public TeamPersonBean getTeam_person() {
                return team_person;
            }

            public void setTeam_person(TeamPersonBean team_person) {
                this.team_person = team_person;
            }

            public PersonBean getPerson() {
                return person;
            }

            public void setPerson(PersonBean person) {
                this.person = person;
            }

            public String getAction() {
                return action;
            }

            public void setAction(String action) {
                this.action = action;
            }

            public String getKind() {
                return kind;
            }

            public void setKind(String kind) {
                this.kind = kind;
            }

//            public String getContent() {
//                return content;
//            }
//
//            public void setContent(String content) {
//                this.content = content;
//            }

            public String getMinute() {
                return minute;
            }

            public void setMinute(String minute) {
                this.minute = minute;
            }

//            public String getAdditional_person_id() {
//                return additional_person_id;
//            }
//
//            public void setAdditional_person_id(String additional_person_id) {
//                this.additional_person_id = additional_person_id;
//            }

//            public String getCreated() {
//                return created;
//            }
//
//            public void setCreated(String created) {
//                this.created = created;
//            }

            public PersonBean getAdditional_person() {
                return additional_person;
            }

            public void setAdditional_person(PersonBean additional_person) {
                this.additional_person = additional_person;
            }

            public static class TeamBean {
                /**
                 * id : 590
                 * name : FC Aarau
                 * show_team : yes
                 */

                private String id;
                private String name;
                private String show_team;

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

                public String getShow_team() {
                    return show_team;
                }

                public void setShow_team(String show_team) {
                    this.show_team = show_team;
                }
            }

            public static class TeamPersonBean {
                /**
                 * id : 202421
                 * shirtnumber : 0
                 */

                private String id;
                private String shirtnumber;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getShirtnumber() {
                    return shirtnumber;
                }

                public void setShirtnumber(String shirtnumber) {
                    this.shirtnumber = shirtnumber;
                }
            }

            public static class PersonBean {
                /**
                 * id : 8945
                 * name : Ivan Benito
                 * firstname : Ivan
                 * surname : Benito
                 * fullname : Ivan Benito
                 * gender : male
                 * birthday : 27.08.1976
                 * height : 182
                 * weight : 80
                 * person_detail : {"id":"73882","position_1":"1","position_2":"0","preferred_side":"unknown","birth_place":"Aarau","died":"no"}
                 * country : [{"id":"183","name":"Switzerland","code":"SUI","iso":"CH"}]
                 */

                private String id;
                private String name;
                private String firstname;
                private String surname;
                private String fullname;
                private String gender;
                private String birthday;
                private String height;
                private String weight;
//                private PersonDetailForMatchDO person_detail;


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

                public String getFirstname() {
                    return firstname;
                }

                public void setFirstname(String firstname) {
                    this.firstname = firstname;
                }

                public String getSurname() {
                    return surname;
                }

                public void setSurname(String surname) {
                    this.surname = surname;
                }

                public String getFullname() {
                    return fullname;
                }

                public void setFullname(String fullname) {
                    this.fullname = fullname;
                }

                public String getGender() {
                    return gender;
                }

                public void setGender(String gender) {
                    this.gender = gender;
                }

                public String getBirthday() {
                    return birthday;
                }

                public void setBirthday(String birthday) {
                    this.birthday = birthday;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getWeight() {
                    return weight;
                }

                public void setWeight(String weight) {
                    this.weight = weight;
                }

//                public PersonDetailForMatchDO getPerson_detail() {
//                    return person_detail;
//                }
//
//                public void setPerson_detail(PersonDetailForMatchDO person_detail) {
//                    this.person_detail = person_detail;
//                }

//                public List<CountryPO> getCountry() {
//                    return country;
//                }
//
//                public void setCountry(List<CountryPO> country) {
//                    this.country = country;
//                }

            }

        }

        @Override
        public String toString() {
            return "MatchBean{" +
                    "id='" + id + '\'' +
                    ", round_id='" + round_id + '\'' +
                    ", round=" + round +
                    ", matchday='" + matchday + '\'' +
                    ", group_matchday='" + group_matchday + '\'' +
                    ", match_date='" + match_date + '\'' +
                    ", match_time='" + match_time + '\'' +
                    ", finished='" + finished + '\'' +
                    ", live_status='" + live_status + '\'' +
                    ", current_period='" + current_period + '\'' +
//                    ", current_period_start='" + current_period_start + '\'' +
                    ", current_minute='" + current_minute + '\'' +
//                    ", attendance='" + attendance + '\'' +
                    ", winner_team_id='" + winner_team_id + '\'' +
                    ", home=" + home +
                    ", away=" + away +
                    ", match_result=" + match_result +
                    ", match_event=" + match_event +
                    '}';
        }
    }

    public static class MatchResultAtBean {
        /**
         * id : 0
         * name : Endergebnis
         * shortname : Ergebnis
         */

        private String id;
        private String name;
//        private String shortname;

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

//        public String getShortname() {
//            return shortname;
//        }
//
//        public void setShortname(String shortname) {
//            this.shortname = shortname;
//        }

        @Override
        public String toString() {
            return "MatchResultAtBean{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
//                    ", shortname='" + shortname + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MatchDO{" +
                "match=" + match +
                ", match_result_at=" + match_result_at +
                '}';
    }
}
