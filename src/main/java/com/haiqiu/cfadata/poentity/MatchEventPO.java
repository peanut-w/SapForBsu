package com.haiqiu.cfadata.poentity;

import java.util.Date;

public class MatchEventPO {
    private Long id;

    private Integer matchId;

    private Integer teamId;

    private Integer personId;

    private Integer teamPersonId;

    private Integer additionalPersonId;

    private String action;

    private String kind;

    private String content;

    private Integer minute;

    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getTeamPersonId() {
        return teamPersonId;
    }

    public void setTeamPersonId(Integer teamPersonId) {
        this.teamPersonId = teamPersonId;
    }

    public Integer getAdditionalPersonId() {
        return additionalPersonId;
    }

    public void setAdditionalPersonId(Integer additionalPersonId) {
        this.additionalPersonId = additionalPersonId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
