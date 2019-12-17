package com.haiqiu.cfadata.doentity;

import com.haiqiu.cfadata.poentity.CountryPO;

import java.util.List;

/**
 * Created by peanut on 2019/7/30 上午10:17
 */
public class PersonDetailDO {

    private String id;
    private String position_1;
    private String position_2;
    private String preferred_side;
    private String birth_place;
    private String died;
    private List<CountryPO> birth_country;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosition_1() {
        return position_1;
    }

    public void setPosition_1(String position_1) {
        this.position_1 = position_1;
    }

    public String getPosition_2() {
        return position_2;
    }

    public void setPosition_2(String position_2) {
        this.position_2 = position_2;
    }

    public String getPreferred_side() {
        return preferred_side;
    }

    public void setPreferred_side(String preferred_side) {
        this.preferred_side = preferred_side;
    }

    public String getBirth_place() {
        return birth_place;
    }

    public void setBirth_place(String birth_place) {
        this.birth_place = birth_place;
    }

    public String getDied() {
        return died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    public List<CountryPO> getBirth_country() {
        return birth_country;
    }

    public void setBirth_country(List<CountryPO> birth_country) {
        this.birth_country = birth_country;
    }
}
