package com.huat.searchengine.entity;

public class TblColumn {
    private String columnId;

    private String columnTitle;

    private String columnDesc;

    private String columnAddress;

    private String columnAvatar;

    private Integer browseQuantity;

    private Integer focusQuantity;

    private Integer articleQuantity;

    private String expertId;

    private String categoryId;

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId == null ? null : columnId.trim();
    }

    public String getColumnTitle() {
        return columnTitle;
    }

    public void setColumnTitle(String columnTitle) {
        this.columnTitle = columnTitle == null ? null : columnTitle.trim();
    }

    public String getColumnDesc() {
        return columnDesc;
    }

    public void setColumnDesc(String columnDesc) {
        this.columnDesc = columnDesc == null ? null : columnDesc.trim();
    }

    public String getColumnAddress() {
        return columnAddress;
    }

    public void setColumnAddress(String columnAddress) {
        this.columnAddress = columnAddress == null ? null : columnAddress.trim();
    }

    public String getColumnAvatar() {
        return columnAvatar;
    }

    public void setColumnAvatar(String columnAvatar) {
        this.columnAvatar = columnAvatar == null ? null : columnAvatar.trim();
    }

    public Integer getBrowseQuantity() {
        return browseQuantity;
    }

    public void setBrowseQuantity(Integer browseQuantity) {
        this.browseQuantity = browseQuantity;
    }

    public Integer getFocusQuantity() {
        return focusQuantity;
    }

    public void setFocusQuantity(Integer focusQuantity) {
        this.focusQuantity = focusQuantity;
    }

    public Integer getArticleQuantity() {
        return articleQuantity;
    }

    public void setArticleQuantity(Integer articleQuantity) {
        this.articleQuantity = articleQuantity;
    }

    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId == null ? null : expertId.trim();
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }
}