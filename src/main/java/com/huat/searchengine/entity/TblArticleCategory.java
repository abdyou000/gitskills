package com.huat.searchengine.entity;

public class TblArticleCategory {
    private String categoryId;

    private String categoryName;

    private String categoryAddress;

    private Integer articleQuantity;

    private String expertId;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getCategoryAddress() {
        return categoryAddress;
    }

    public void setCategoryAddress(String categoryAddress) {
        this.categoryAddress = categoryAddress == null ? null : categoryAddress.trim();
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
}