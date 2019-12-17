package com.haiqiu.cfadata.doentity;

/**
 * Created by peanut on 2019/7/30 下午1:53
 */
public class SeasonDO {
    private String id;
    private CompetitionDO competition;
    private String name;
    private String current_round_id;
    private String current_group_matchday;
    private String start;
    private String end;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CompetitionDO getCompetition() {
        return competition;
    }

    public void setCompetition(CompetitionDO competition) {
        this.competition = competition;
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

    public String getCurrent_group_matchday() {
        return current_group_matchday;
    }

    public void setCurrent_group_matchday(String current_group_matchday) {
        this.current_group_matchday = current_group_matchday;
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
