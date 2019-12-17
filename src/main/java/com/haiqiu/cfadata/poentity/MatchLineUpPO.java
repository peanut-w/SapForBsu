package com.haiqiu.cfadata.poentity;

import java.util.Date;

public class MatchLineUpPO {
    private Integer id;

    private Integer matchId;

    private Integer teamId;

    private Integer playerId;

    private Integer playerNum;

    private Integer playerType;

    private String position;

    private String xposition;

    private String yposition;

    private Date createdttm;

    private String creator;

    private Date updatedttm;

    private String updater;

    private String datasource;

    private Integer lineupName;

    private String positionType;

    private String playerIcon;

    private String playerName;


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

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(Integer playerNum) {
        this.playerNum = playerNum;
    }

    public Integer getPlayerType() {
        return playerType;
    }

    public void setPlayerType(Integer playerType) {
        this.playerType = playerType;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getXposition() {
        return xposition;
    }

    public void setXposition(String xposition) {
        this.xposition = xposition == null ? null : xposition.trim();
    }

    public String getYposition() {
        return yposition;
    }

    public void setYposition(String yposition) {
        this.yposition = yposition == null ? null : yposition.trim();
    }

    public Date getCreatedttm() {
        return createdttm;
    }

    public void setCreatedttm(Date createdttm) {
        this.createdttm = createdttm;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getUpdatedttm() {
        return updatedttm;
    }

    public void setUpdatedttm(Date updatedttm) {
        this.updatedttm = updatedttm;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource == null ? null : datasource.trim();
    }

    public Integer getLineupName() {
        return lineupName;
    }

    public void setLineupName(Integer lineupName) {
        this.lineupName = lineupName;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType == null ? null : positionType.trim();
    }

    public String getPlayerIcon() {
        return playerIcon;
    }

    public void setPlayerIcon(String playerIcon) {
        this.playerIcon = playerIcon == null ? null : playerIcon.trim();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
