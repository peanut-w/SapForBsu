package com.haiqiu.cfadata.doentity;

/**
 * Created by peanut on 2019/7/30 上午9:54
 */
public class TeamDOForSeason {
    /**
     * id : 590
     * name : FC Aarau
     * show_team : yes
     */

    private String id;
    private String name;
    private String show_team;
    private String type;
    private String gender;

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

    public String getShow_team() {
        return show_team;
    }

    public void setShow_team(String show_team) {
        this.show_team = show_team;
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
}
