package com.haiqiu.cfadata.doentity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.haiqiu.cfadata.poentity.CountryPO;
import com.haiqiu.cfadata.poentity.RolePO;

import java.util.List;

/**
 * Created by peanut on 2019/5/13 下午4:50
 */

public class PersonDO {

    private String id;
    private String name;
    private String firstname;
    private String surname;
    private String fullname;
    private String gender;
    private String birthday;
    private String height;
    private String weight;
    //    private String last_modified;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PersonDetailDO person_detail;
    private List<GfxDO> gfx;
    private List<CountryPO> country;
    private List<TeamPersonBean> team_person;

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

//    public String getLast_modified() {
//        return last_modified;
//    }
//
//    public void setLast_modified(String last_modified) {
//        this.last_modified = last_modified;
//    }

    public PersonDetailDO getPerson_detail() {
        return person_detail;
    }

    public void setPerson_detail(PersonDetailDO person_detail) {
        this.person_detail = person_detail;
    }

    public List<GfxDO> getGfx() {
        return gfx;
    }

    public void setGfx(List<GfxDO> gfx) {
        this.gfx = gfx;
    }

    public List<CountryPO> getCountry() {
        return country;
    }

    public void setCountry(List<CountryPO> country) {
        this.country = country;
    }

    public List<TeamPersonBean> getTeam_person() {
        return team_person;
    }

    public void setTeam_person(List<TeamPersonBean> team_person) {
        this.team_person = team_person;
    }


    public static class TeamPersonBean {
        /**
         * id : 448106
         * shirtnumber : 28
         * start : 01.07.1999
         * end : 30.06.2000
         * role : {"id":"2","name":"Abwehr","group":"Athletes","order":"2"}
         * team : {"id":"720","name":"FC Wacker Innsbruck","shortname":"W. Innsbruck","gender":"male","country":{"id":"158","name":"Österreich","code":"AUT","iso":"AT"},"age":{"id":"1","name":""},"club":{"id":"188","name":"FC Wacker Innsbruck"}}
         */

        private String id;
        private String shirtnumber;
        private String start;
        private String end;
        private RolePO role;
        private TeamBean team;

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

        public TeamBean getTeam() {
            return team;
        }

        public void setTeam(TeamBean team) {
            this.team = team;
        }

        public static class TeamBean {
            private String id;
            private String name;
            private String shortname;
            private String gender;
//            private CountryPO country;
//            private AgePO age;
//            private ClubBean club;

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

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

//            public CountryPO getCountry() {
//                return country;
//            }
//
//            public void setCountry(CountryPO country) {
//                this.country = country;
//            }
//
//            public AgePO getAge() {
//                return age;
//            }

//            public void setAge(AgePO age) {
//                this.age = age;
//            }
//
//            public ClubBean getClub() {
//                return club;
//            }
//
//            public void setClub(ClubBean club) {
//                this.club = club;
//            }


            public static class ClubBean {

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
}
