package com.haiqiu.cfadata.doentity;

public class GfxDO {
    private String id;

    private String uri;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

}
