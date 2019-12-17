package com.haiqiu.cfadata.poentity;

import java.util.Date;

public class SeasonPO {
    private Integer id;

    private String name;

    private String hasTables;

    private Date start;

    private Date end;

    private Integer competitionId;

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

    public String getHasTables() {
        return hasTables;
    }

    public void setHasTables(String hasTables) {
        this.hasTables = hasTables == null ? null : hasTables.trim();
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Integer competitionId) {
        this.competitionId = competitionId;
    }

    @Override
    public String toString() {
        return "SeasonPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hasTables='" + hasTables + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", competitionId=" + competitionId +
                '}';
    }
}
