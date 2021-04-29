package com.example.withfront.model;

public class TablesForTest {
    Integer id;
    String username;
    String domain;
    int serverId;
    boolean registrated;

    public boolean isRegistrated() {
        return registrated;
    }

    public void setRegistrated(boolean registrated) {
        this.registrated = registrated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }
}
