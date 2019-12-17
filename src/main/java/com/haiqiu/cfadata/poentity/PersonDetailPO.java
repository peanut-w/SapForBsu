package com.haiqiu.cfadata.poentity;

public class PersonDetailPO {
    private String id;

    private String shoesize;

    private String preferred_side;

    private String birth_place;

    private String birthCountryId;

    private String position_1;

    private String position_2;

    private String died;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShoesize() {
        return shoesize;
    }

    public void setShoesize(String shoesize) {
        this.shoesize = shoesize;
    }

    public String getPreferred_side() {
        return preferred_side;
    }

    public void setPreferred_side(String preferred_side) {
        this.preferred_side = preferred_side == null ? null : preferred_side.trim();
    }

    public String getBirth_place() {
        return birth_place;
    }

    public void setBirth_place(String birth_place) {
        this.birth_place = birth_place == null ? null : birth_place.trim();
    }

    public String getBirthCountryId() {
        return birthCountryId;
    }

    public void setBirthCountryId(String birthCountryId) {
        this.birthCountryId = birthCountryId;
    }

    public String getPosition1() {
        return position_1;
    }

    public void setPosition1(String position_1) {
        this.position_1 = position_1 == null ? null : position_1.trim();
    }

    public String getPosition_2() {
        return position_2;
    }

    public void setPosition_2(String position_2) {
        this.position_2 = position_2 == null ? null : position_2.trim();
    }

    public String getDied() {
        return died;
    }

    public void setDied(String died) {
        this.died = died == null ? null : died.trim();
    }
}
