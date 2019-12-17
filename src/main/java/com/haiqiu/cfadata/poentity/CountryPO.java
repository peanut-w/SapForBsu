package com.haiqiu.cfadata.poentity;

public class CountryPO {
    private String id;

    private String name;

    private String code;

    private String iso;

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
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso == null ? null : iso.trim();
    }
}
