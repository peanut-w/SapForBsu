package com.haiqiu.cfadata.poentity;

public class PolicyPO {
    private String id;

    private String policyOrder;

    private String policyMeta;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPolicyOrder() {
        return policyOrder;
    }

    public void setPolicyOrder(String policyOrder) {
        this.policyOrder = policyOrder;
    }

    public String getPolicyMeta() {
        return policyMeta;
    }

    public void setPolicyMeta(String policyMeta) {
        this.policyMeta = policyMeta == null ? null : policyMeta.trim();
    }
}
