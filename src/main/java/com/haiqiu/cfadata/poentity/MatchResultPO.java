package com.haiqiu.cfadata.poentity;

public class MatchResultPO {
    private Integer id;

    private Integer matchId;

    private Integer matchResult;

    private Integer matchResultAt;

    private String place;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(Integer matchResult) {
        this.matchResult = matchResult;
    }

    public Integer getMatchResultAt() {
        return matchResultAt;
    }

    public void setMatchResultAt(Integer matchResultAt) {
        this.matchResultAt = matchResultAt;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }
}
