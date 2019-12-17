package com.haiqiu.cfadata.doentity;


import com.haiqiu.cfadata.poentity.RolePO;

import java.util.List;

/**
 * Created by peanut on 2019/5/13 下午4:50
 */
public class TeamSquardFromToDO {


    private TeamBean team;
    private List<SeasonDO> season;

    public TeamBean getTeam() {
        return team;
    }

    public void setTeam(TeamBean team) {
        this.team = team;
    }

    public List<SeasonDO> getSeason() {
        return season;
    }

    public void setSeason(List<SeasonDO> season) {
        this.season = season;
    }

    public static class TeamBean {


        private String id;
        private String name;
        private String shortname;
        private String microname;
        private String type;
        private String gender;
//        private String show_team;
        private List<SquadBean> squad;

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

//        public String getShow_team() {
//            return show_team;
//        }
//
//        public void setShow_team(String show_team) {
//            this.show_team = show_team;
//        }

        public List<SquadBean> getSquad() {
            return squad;
        }

        public void setSquad(List<SquadBean> squad) {
            this.squad = squad;
        }

        public static class SquadBean {
            /**
             * id : 8656216
             * season_id :
             * shirtnumber : 25
             * start : 01.01.2019
             * end : 30.06.2019
             * role : {"id":"1","name":"Torwart"}
             * person : {"id":"590742","name":"Ahmet Daş","firstname":"Ahmet","surname":"Daş","fullname":"Ahmet Daş","gender":"male","birthday":"05.04.2000","height":"0","weight":"0","person_detail":{"id":"506790","position_1":"1","position_2":"0","shoesize":"0","preferred_side":"unknown","birth_place":"Tavşanlı","birth_country":[{"id":"219","name":"Türkei","code":"TUR","iso":"TR"}],"died":"no"},"country":[{"id":"219","name":"Türkei","code":"TUR","iso":"TR"}]}
             */

            private String id;
//            private String season_id;
            private String shirtnumber;
            private String start;
            private String end;
            private RolePO role;
            private PersonBean person;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
//
//            public String getSeason_id() {
//                return season_id;
//            }
//
//            public void setSeason_id(String season_id) {
//                this.season_id = season_id;
//            }

            public String getShirtnumber() {
                return shirtnumber;
            }

            public void setShirtnumber(String shirtnumber) {
                this.shirtnumber = shirtnumber;
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

            public RolePO getRole() {
                return role;
            }

            public void setRole(RolePO role) {
                this.role = role;
            }

            public PersonBean getPerson() {
                return person;
            }

            public void setPerson(PersonBean person) {
                this.person = person;
            }

            public static class RoleBean {
                /**
                 * id : 1
                 * name : Torwart
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

            public static class PersonBean {


                private String id;
                private String name;
                private String firstname;
                private String surname;
                private String fullname;
                private String gender;
                private String birthday;
                private String height;
                private String weight;
//                private PersonDetailDO person_detail;

//                private List<CountryPO> country;

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

//                public PersonDetailDO getPerson_detail() {
//                    return person_detail;
//                }
//
//                public void setPerson_detail(PersonDetailDO person_detail) {
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
    }


}
