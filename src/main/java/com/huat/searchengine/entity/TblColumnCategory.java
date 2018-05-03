package com.huat.searchengine.entity;

public class TblColumnCategory {
    private String categoryId;

    private String categoryName;

    private String categoryAddress;

    private Integer columnQuantity;

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

    public Integer getColumnQuantity() {
        return columnQuantity;
    }

    public void setColumnQuantity(Integer columnQuantity) {
        this.columnQuantity = columnQuantity;
    }
}