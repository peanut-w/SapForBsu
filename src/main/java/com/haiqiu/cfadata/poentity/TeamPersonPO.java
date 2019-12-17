package com.haiqiu.cfadata.poentity;

import java.util.Date;

public class TeamPersonPO {
    private Integer id;

    private Integer teamId;

    private Integer personId;

    private Integer roleId;

    private String shirtnumber;

    private Date start;

    private Date end;

    private String state;

    private Integer fee;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getShirtnumber() {
        return shirtnumber;
    }

    public void setShirtnumber(String shirtnumber) {
        this.shirtnumber = shirtnumber == null ? null : shirtnumber.trim();
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "TeamPersonPO{" +
                "id=" + id +
                ", teamId=" + teamId +
                ", personId=" + personId +
                ", roleId=" + roleId +
                ", shirtnumber='" + shirtnumber + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", state='" + state + '\'' +
                ", fee=" + fee +
                '}';
    }
}
