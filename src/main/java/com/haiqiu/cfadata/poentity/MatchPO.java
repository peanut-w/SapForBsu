package com.haiqiu.cfadata.poentity;

import java.util.Date;

public class MatchPO {
    private Integer id;

    private Integer roundId;

    private Integer matchday;

    private Integer groupMatchday;

    private Date matchDate;

//    private String matchTime;

    private String finished;

    private String liveStatus;

    private Integer attendance;

    private Integer homeId;

    private Integer awayId;

    private Integer venueId;

    private Integer refereeId;

    private Integer winnerTeamId;

    private Integer seasonId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoundId() {
        return roundId;
    }

    public void setRoundId(Integer roundId) {
        this.roundId = roundId;
    }

    public Integer getMatchday() {
        return matchday;
    }

    public void setMatchday(Integer matchday) {
        this.matchday = matchday;
    }

    public Integer getGroupMatchday() {
        return groupMatchday;
    }

    public void setGroupMatchday(Integer groupMatchday) {
        this.groupMatchday = groupMatchday;
    }


    public String getFinished() {
        return finished;
    }

    public void setFinished(String finished) {
        this.finished = finished == null ? null : finished.trim();
    }

    public String getLiveStatus() {
        return liveStatus;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

//    public String getMatchTime() {
//        return matchTime;
//    }
//
//    public void setMatchTime(String matchTime) {
//        this.matchTime = matchTime;
//    }

    public void setLiveStatus(String liveStatus) {
        this.liveStatus = liveStatus == null ? null : liveStatus.trim();
    }

    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    public Integer getHomeId() {
        return homeId;
    }

    public void setHomeId(Integer homeId) {
        this.homeId = homeId;
    }

    public Integer getAwayId() {
        return awayId;
    }

    public void setAwayId(Integer awayId) {
        this.awayId = awayId;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public void setVenueId(Integer venueId) {
        this.venueId = venueId;
    }

    public Integer getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(Integer refereeId) {
        this.refereeId = refereeId;
    }

    public Integer getWinnerTeamId() {
        return winnerTeamId;
    }

    public Integer getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    public void setWinnerTeamId(Integer winnerTeamId) {
        this.winnerTeamId = winnerTeamId;

    }

    @Override
    public String toString() {
        return "MatchPO{" +
                "id=" + id +
                ", roundId=" + roundId +
                ", matchday=" + matchday +
                ", groupMatchday=" + groupMatchday +
                ", matchDate=" + matchDate +
                ", finished='" + finished + '\'' +
                ", liveStatus='" + liveStatus + '\'' +
                ", attendance=" + attendance +
                ", homeId=" + homeId +
                ", awayId=" + awayId +
                ", venueId=" + venueId +
                ", refereeId=" + refereeId +
                ", winnerTeamId=" + winnerTeamId +
                ", seasonId=" + seasonId +
                '}';
    }
}
