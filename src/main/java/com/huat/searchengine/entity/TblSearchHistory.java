package com.huat.searchengine.entity;

public class TblSearchHistory {
    private String searchId;

    private Long searchTime;

    private String searchContent;

    private Boolean searchType;

    private String userId;

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId == null ? null : searchId.trim();
    }

    public Long getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(Long searchTime) {
        this.searchTime = searchTime;
    }

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent == null ? null : searchContent.trim();
    }

    public Boolean getSearchType() {
        return searchType;
    }

    public void setSearchType(Boolean searchType) {
        this.searchType = searchType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}