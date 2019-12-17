package com.haiqiu.cfadata.doentity;


import java.util.List;

/**
 * Created by peanut on 2019/5/13 下午4:50
 */
public class MatchesBySeasonsDO {
    private String id;
    private String competition_id;
    private String name;
//    private String current_round_id;
//    private String current_group_matchday;
    private String has_tables;
    private String start;
    private String end;
    private List<RoundBean> round;

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

//    public String getCurrent_round_id() {
//        return current_round_id;
//    }
//
//    public void setCurrent_round_id(String current_round_id) {
//        this.current_round_id = current_round_id;
//    }
//
//    public String getCurrent_group_matchday() {
//        return current_group_matchday;
//    }
//
//    public void setCurrent_group_matchday(String current_group_matchday) {
//        this.current_group_matchday = current_group_matchday;
//    }

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

    public List<RoundBean> getRound() {
        return round;
    }

    public void setRound(List<RoundBean> round) {
        this.round = round;
    }

    public static class RoundBean {
        private String id;
        private String season_id;
        private String name;
        private String current_matchday;
//        private String round_order;
        private List<MatchBean> match;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSeason_id() {
            return season_id;
        }

        public void setSeason_id(String season_id) {
            this.season_id = season_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCurrent_matchday() {
            return current_matchday;
        }

        public void setCurrent_matchday(String current_matchday) {
            this.current_matchday = current_matchday;
        }

//        public String getRound_order() {
//            return round_order;
//        }
//
//        public void setRound_order(String round_order) {
//            this.round_order = round_order;
//        }

        public List<MatchBean> getMatch() {
            return match;
        }

        public void setMatch(List<MatchBean> match) {
            this.match = match;
        }

        public static class MatchBean {
            private String id;
//            private String matchday;
//            private String group_matchday;
            private String match_date;
            private String match_time;
            private String finished;
//            private String live_status;
//            private String attendance;
//            private String winner_team_id;
            private TeamDOForSeason home;
            private TeamDOForSeason away;
//            private List<MatchResultBean> match_result;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

//            public String getMatchday() {
//                return matchday;
//            }
//
//            public void setMatchday(String matchday) {
//                this.matchday = matchday;
//            }
//
//            public String getGroup_matchday() {
//                return group_matchday;
//            }
//
//            public void setGroup_matchday(String group_matchday) {
//                this.group_matchday = group_matchday;
//            }

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

//            public String getLive_status() {
//                return live_status;
//            }
//
//            public void setLive_status(String live_status) {
//                this.live_status = live_status;
//            }
//
//            public String getAttendance() {
//                return attendance;
//            }
//
//            public void setAttendance(String attendance) {
//                this.attendance = attendance;
//            }

//            public String getWinner_team_id() {
//                return winner_team_id;
//            }
//
//            public void setWinner_team_id(String winner_team_id) {
//                this.winner_team_id = winner_team_id;
//            }

            public TeamDOForSeason getHome() {
                return home;
            }

            public void setHome(TeamDOForSeason home) {
                this.home = home;
            }

            public TeamDOForSeason getAway() {
                return away;
            }

            public void setAway(TeamDOForSeason away) {
                this.away = away;
            }

//            public List<MatchResultBean> getMatch_result() {
//                return match_result;
//            }
//
//            public void setMatch_result(List<MatchResultBean> match_result) {
//                this.match_result = match_result;
//            }


            public static class MatchResultBean {

                private String match_result;
                private String match_result_at;
                private String place;
                private String rounds;
                private String points;
                private String rank;
                private String comment;
                private String team_id;
                private String person_id;

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

                public String getRounds() {
                    return rounds;
                }

                public void setRounds(String rounds) {
                    this.rounds = rounds;
                }

                public String getPoints() {
                    return points;
                }

                public void setPoints(String points) {
                    this.points = points;
                }

                public String getRank() {
                    return rank;
                }

                public void setRank(String rank) {
                    this.rank = rank;
                }

                public String getComment() {
                    return comment;
                }

                public void setComment(String comment) {
                    this.comment = comment;
                }

                public String getTeam_id() {
                    return team_id;
                }

                public void setTeam_id(String team_id) {
                    this.team_id = team_id;
                }

                public String getPerson_id() {
                    return person_id;
                }

                public void setPerson_id(String person_id) {
                    this.person_id = person_id;
                }
            }
        }
    }
}
