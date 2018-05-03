package com.huat.searchengine.entity;

public class TblArticle {
    private String articleId;

    private String articleTitle;

    private String articleAddress;

    private Integer commentQuantity;

    private Integer browseQuantity;

    private Long publishDate;

    private String articleDesc;

    private Byte articleType;

    private Boolean hot;

    private Boolean sticky;

    private String categoryId;

    private String columnId;

    private String expertId;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public String getArticleAddress() {
        return articleAddress;
    }

    public void setArticleAddress(String articleAddress) {
        this.articleAddress = articleAddress == null ? null : articleAddress.trim();
    }

    public Integer getCommentQuantity() {
        return commentQuantity;
    }

    public void setCommentQuantity(Integer commentQuantity) {
        this.commentQuantity = commentQuantity;
    }

    public Integer getBrowseQuantity() {
        return browseQuantity;
    }

    public void setBrowseQuantity(Integer browseQuantity) {
        this.browseQuantity = browseQuantity;
    }

    public Long getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Long publishDate) {
        this.publishDate = publishDate;
    }

    public String getArticleDesc() {
        return articleDesc;
    }

    public void setArticleDesc(String articleDesc) {
        this.articleDesc = articleDesc == null ? null : articleDesc.trim();
    }

    public Byte getArticleType() {
        return articleType;
    }

    public void setArticleType(Byte articleType) {
        this.articleType = articleType;
    }

    public Boolean getHot() {
        return hot;
    }

    public void setHot(Boolean hot) {
        this.hot = hot;
    }

    public Boolean getSticky() {
        return sticky;
    }

    public void setSticky(Boolean sticky) {
        this.sticky = sticky;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId == null ? null : columnId.trim();
    }

    public String getExpertId() {
        return expertId;
    }

    public void setExpertId(String expertId) {
        this.expertId = expertId == null ? null : expertId.trim();
    }
}