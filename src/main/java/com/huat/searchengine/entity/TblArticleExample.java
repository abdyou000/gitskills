package com.huat.searchengine.entity;

import java.util.ArrayList;
import java.util.List;

public class TblArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblArticleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(String value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(String value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(String value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(String value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(String value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(String value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLike(String value) {
            addCriterion("article_id like", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotLike(String value) {
            addCriterion("article_id not like", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<String> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<String> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(String value1, String value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(String value1, String value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNull() {
            addCriterion("article_title is null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIsNotNull() {
            addCriterion("article_title is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTitleEqualTo(String value) {
            addCriterion("article_title =", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotEqualTo(String value) {
            addCriterion("article_title <>", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThan(String value) {
            addCriterion("article_title >", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleGreaterThanOrEqualTo(String value) {
            addCriterion("article_title >=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThan(String value) {
            addCriterion("article_title <", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLessThanOrEqualTo(String value) {
            addCriterion("article_title <=", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleLike(String value) {
            addCriterion("article_title like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotLike(String value) {
            addCriterion("article_title not like", value, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleIn(List<String> values) {
            addCriterion("article_title in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotIn(List<String> values) {
            addCriterion("article_title not in", values, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleBetween(String value1, String value2) {
            addCriterion("article_title between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleTitleNotBetween(String value1, String value2) {
            addCriterion("article_title not between", value1, value2, "articleTitle");
            return (Criteria) this;
        }

        public Criteria andArticleAddressIsNull() {
            addCriterion("article_address is null");
            return (Criteria) this;
        }

        public Criteria andArticleAddressIsNotNull() {
            addCriterion("article_address is not null");
            return (Criteria) this;
        }

        public Criteria andArticleAddressEqualTo(String value) {
            addCriterion("article_address =", value, "articleAddress");
            return (Criteria) this;
        }

        public Criteria andArticleAddressNotEqualTo(String value) {
            addCriterion("article_address <>", value, "articleAddress");
            return (Criteria) this;
        }

        public Criteria andArticleAddressGreaterThan(String value) {
            addCriterion("article_address >", value, "articleAddress");
            return (Criteria) this;
        }

        public Criteria andArticleAddressGreaterThanOrEqualTo(String value) {
            addCriterion("article_address >=", value, "articleAddress");
            return (Criteria) this;
        }

        public Criteria andArticleAddressLessThan(String value) {
            addCriterion("article_address <", value, "articleAddress");
            return (Criteria) this;
        }

        public Criteria andArticleAddressLessThanOrEqualTo(String value) {
            addCriterion("article_address <=", value, "articleAddress");
            return (Criteria) this;
        }

        public Criteria andArticleAddressLike(String value) {
            addCriterion("article_address like", value, "articleAddress");
            return (Criteria) this;
        }

        public Criteria andArticleAddressNotLike(String value) {
            addCriterion("article_address not like", value, "articleAddress");
            return (Criteria) this;
        }

        public Criteria andArticleAddressIn(List<String> values) {
            addCriterion("article_address in", values, "articleAddress");
            return (Criteria) this;
        }

        public Criteria andArticleAddressNotIn(List<String> values) {
            addCriterion("article_address not in", values, "articleAddress");
            return (Criteria) this;
        }

        public Criteria andArticleAddressBetween(String value1, String value2) {
            addCriterion("article_address between", value1, value2, "articleAddress");
            return (Criteria) this;
        }

        public Criteria andArticleAddressNotBetween(String value1, String value2) {
            addCriterion("article_address not between", value1, value2, "articleAddress");
            return (Criteria) this;
        }

        public Criteria andCommentQuantityIsNull() {
            addCriterion("comment_quantity is null");
            return (Criteria) this;
        }

        public Criteria andCommentQuantityIsNotNull() {
            addCriterion("comment_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andCommentQuantityEqualTo(Integer value) {
            addCriterion("comment_quantity =", value, "commentQuantity");
            return (Criteria) this;
        }

        public Criteria andCommentQuantityNotEqualTo(Integer value) {
            addCriterion("comment_quantity <>", value, "commentQuantity");
            return (Criteria) this;
        }

        public Criteria andCommentQuantityGreaterThan(Integer value) {
            addCriterion("comment_quantity >", value, "commentQuantity");
            return (Criteria) this;
        }

        public Criteria andCommentQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_quantity >=", value, "commentQuantity");
            return (Criteria) this;
        }

        public Criteria andCommentQuantityLessThan(Integer value) {
            addCriterion("comment_quantity <", value, "commentQuantity");
            return (Criteria) this;
        }

        public Criteria andCommentQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("comment_quantity <=", value, "commentQuantity");
            return (Criteria) this;
        }

        public Criteria andCommentQuantityIn(List<Integer> values) {
            addCriterion("comment_quantity in", values, "commentQuantity");
            return (Criteria) this;
        }

        public Criteria andCommentQuantityNotIn(List<Integer> values) {
            addCriterion("comment_quantity not in", values, "commentQuantity");
            return (Criteria) this;
        }

        public Criteria andCommentQuantityBetween(Integer value1, Integer value2) {
            addCriterion("comment_quantity between", value1, value2, "commentQuantity");
            return (Criteria) this;
        }

        public Criteria andCommentQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_quantity not between", value1, value2, "commentQuantity");
            return (Criteria) this;
        }

        public Criteria andBrowseQuantityIsNull() {
            addCriterion("browse_quantity is null");
            return (Criteria) this;
        }

        public Criteria andBrowseQuantityIsNotNull() {
            addCriterion("browse_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseQuantityEqualTo(Integer value) {
            addCriterion("browse_quantity =", value, "browseQuantity");
            return (Criteria) this;
        }

        public Criteria andBrowseQuantityNotEqualTo(Integer value) {
            addCriterion("browse_quantity <>", value, "browseQuantity");
            return (Criteria) this;
        }

        public Criteria andBrowseQuantityGreaterThan(Integer value) {
            addCriterion("browse_quantity >", value, "browseQuantity");
            return (Criteria) this;
        }

        public Criteria andBrowseQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("browse_quantity >=", value, "browseQuantity");
            return (Criteria) this;
        }

        public Criteria andBrowseQuantityLessThan(Integer value) {
            addCriterion("browse_quantity <", value, "browseQuantity");
            return (Criteria) this;
        }

        public Criteria andBrowseQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("browse_quantity <=", value, "browseQuantity");
            return (Criteria) this;
        }

        public Criteria andBrowseQuantityIn(List<Integer> values) {
            addCriterion("browse_quantity in", values, "browseQuantity");
            return (Criteria) this;
        }

        public Criteria andBrowseQuantityNotIn(List<Integer> values) {
            addCriterion("browse_quantity not in", values, "browseQuantity");
            return (Criteria) this;
        }

        public Criteria andBrowseQuantityBetween(Integer value1, Integer value2) {
            addCriterion("browse_quantity between", value1, value2, "browseQuantity");
            return (Criteria) this;
        }

        public Criteria andBrowseQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("browse_quantity not between", value1, value2, "browseQuantity");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNull() {
            addCriterion("publish_date is null");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNotNull() {
            addCriterion("publish_date is not null");
            return (Criteria) this;
        }

        public Criteria andPublishDateEqualTo(Long value) {
            addCriterion("publish_date =", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotEqualTo(Long value) {
            addCriterion("publish_date <>", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThan(Long value) {
            addCriterion("publish_date >", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThanOrEqualTo(Long value) {
            addCriterion("publish_date >=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThan(Long value) {
            addCriterion("publish_date <", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThanOrEqualTo(Long value) {
            addCriterion("publish_date <=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateIn(List<Long> values) {
            addCriterion("publish_date in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotIn(List<Long> values) {
            addCriterion("publish_date not in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateBetween(Long value1, Long value2) {
            addCriterion("publish_date between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotBetween(Long value1, Long value2) {
            addCriterion("publish_date not between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andArticleDescIsNull() {
            addCriterion("article_desc is null");
            return (Criteria) this;
        }

        public Criteria andArticleDescIsNotNull() {
            addCriterion("article_desc is not null");
            return (Criteria) this;
        }

        public Criteria andArticleDescEqualTo(String value) {
            addCriterion("article_desc =", value, "articleDesc");
            return (Criteria) this;
        }

        public Criteria andArticleDescNotEqualTo(String value) {
            addCriterion("article_desc <>", value, "articleDesc");
            return (Criteria) this;
        }

        public Criteria andArticleDescGreaterThan(String value) {
            addCriterion("article_desc >", value, "articleDesc");
            return (Criteria) this;
        }

        public Criteria andArticleDescGreaterThanOrEqualTo(String value) {
            addCriterion("article_desc >=", value, "articleDesc");
            return (Criteria) this;
        }

        public Criteria andArticleDescLessThan(String value) {
            addCriterion("article_desc <", value, "articleDesc");
            return (Criteria) this;
        }

        public Criteria andArticleDescLessThanOrEqualTo(String value) {
            addCriterion("article_desc <=", value, "articleDesc");
            return (Criteria) this;
        }

        public Criteria andArticleDescLike(String value) {
            addCriterion("article_desc like", value, "articleDesc");
            return (Criteria) this;
        }

        public Criteria andArticleDescNotLike(String value) {
            addCriterion("article_desc not like", value, "articleDesc");
            return (Criteria) this;
        }

        public Criteria andArticleDescIn(List<String> values) {
            addCriterion("article_desc in", values, "articleDesc");
            return (Criteria) this;
        }

        public Criteria andArticleDescNotIn(List<String> values) {
            addCriterion("article_desc not in", values, "articleDesc");
            return (Criteria) this;
        }

        public Criteria andArticleDescBetween(String value1, String value2) {
            addCriterion("article_desc between", value1, value2, "articleDesc");
            return (Criteria) this;
        }

        public Criteria andArticleDescNotBetween(String value1, String value2) {
            addCriterion("article_desc not between", value1, value2, "articleDesc");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIsNull() {
            addCriterion("article_type is null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIsNotNull() {
            addCriterion("article_type is not null");
            return (Criteria) this;
        }

        public Criteria andArticleTypeEqualTo(Byte value) {
            addCriterion("article_type =", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNotEqualTo(Byte value) {
            addCriterion("article_type <>", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeGreaterThan(Byte value) {
            addCriterion("article_type >", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("article_type >=", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeLessThan(Byte value) {
            addCriterion("article_type <", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeLessThanOrEqualTo(Byte value) {
            addCriterion("article_type <=", value, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeIn(List<Byte> values) {
            addCriterion("article_type in", values, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNotIn(List<Byte> values) {
            addCriterion("article_type not in", values, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeBetween(Byte value1, Byte value2) {
            addCriterion("article_type between", value1, value2, "articleType");
            return (Criteria) this;
        }

        public Criteria andArticleTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("article_type not between", value1, value2, "articleType");
            return (Criteria) this;
        }

        public Criteria andHotIsNull() {
            addCriterion("hot is null");
            return (Criteria) this;
        }

        public Criteria andHotIsNotNull() {
            addCriterion("hot is not null");
            return (Criteria) this;
        }

        public Criteria andHotEqualTo(Boolean value) {
            addCriterion("hot =", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotEqualTo(Boolean value) {
            addCriterion("hot <>", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotGreaterThan(Boolean value) {
            addCriterion("hot >", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotGreaterThanOrEqualTo(Boolean value) {
            addCriterion("hot >=", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLessThan(Boolean value) {
            addCriterion("hot <", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotLessThanOrEqualTo(Boolean value) {
            addCriterion("hot <=", value, "hot");
            return (Criteria) this;
        }

        public Criteria andHotIn(List<Boolean> values) {
            addCriterion("hot in", values, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotIn(List<Boolean> values) {
            addCriterion("hot not in", values, "hot");
            return (Criteria) this;
        }

        public Criteria andHotBetween(Boolean value1, Boolean value2) {
            addCriterion("hot between", value1, value2, "hot");
            return (Criteria) this;
        }

        public Criteria andHotNotBetween(Boolean value1, Boolean value2) {
            addCriterion("hot not between", value1, value2, "hot");
            return (Criteria) this;
        }

        public Criteria andStickyIsNull() {
            addCriterion("sticky is null");
            return (Criteria) this;
        }

        public Criteria andStickyIsNotNull() {
            addCriterion("sticky is not null");
            return (Criteria) this;
        }

        public Criteria andStickyEqualTo(Boolean value) {
            addCriterion("sticky =", value, "sticky");
            return (Criteria) this;
        }

        public Criteria andStickyNotEqualTo(Boolean value) {
            addCriterion("sticky <>", value, "sticky");
            return (Criteria) this;
        }

        public Criteria andStickyGreaterThan(Boolean value) {
            addCriterion("sticky >", value, "sticky");
            return (Criteria) this;
        }

        public Criteria andStickyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("sticky >=", value, "sticky");
            return (Criteria) this;
        }

        public Criteria andStickyLessThan(Boolean value) {
            addCriterion("sticky <", value, "sticky");
            return (Criteria) this;
        }

        public Criteria andStickyLessThanOrEqualTo(Boolean value) {
            addCriterion("sticky <=", value, "sticky");
            return (Criteria) this;
        }

        public Criteria andStickyIn(List<Boolean> values) {
            addCriterion("sticky in", values, "sticky");
            return (Criteria) this;
        }

        public Criteria andStickyNotIn(List<Boolean> values) {
            addCriterion("sticky not in", values, "sticky");
            return (Criteria) this;
        }

        public Criteria andStickyBetween(Boolean value1, Boolean value2) {
            addCriterion("sticky between", value1, value2, "sticky");
            return (Criteria) this;
        }

        public Criteria andStickyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("sticky not between", value1, value2, "sticky");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(String value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(String value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(String value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(String value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(String value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLike(String value) {
            addCriterion("category_id like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotLike(String value) {
            addCriterion("category_id not like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<String> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<String> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(String value1, String value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(String value1, String value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andColumnIdIsNull() {
            addCriterion("column_id is null");
            return (Criteria) this;
        }

        public Criteria andColumnIdIsNotNull() {
            addCriterion("column_id is not null");
            return (Criteria) this;
        }

        public Criteria andColumnIdEqualTo(String value) {
            addCriterion("column_id =", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdNotEqualTo(String value) {
            addCriterion("column_id <>", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdGreaterThan(String value) {
            addCriterion("column_id >", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdGreaterThanOrEqualTo(String value) {
            addCriterion("column_id >=", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdLessThan(String value) {
            addCriterion("column_id <", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdLessThanOrEqualTo(String value) {
            addCriterion("column_id <=", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdLike(String value) {
            addCriterion("column_id like", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdNotLike(String value) {
            addCriterion("column_id not like", value, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdIn(List<String> values) {
            addCriterion("column_id in", values, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdNotIn(List<String> values) {
            addCriterion("column_id not in", values, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdBetween(String value1, String value2) {
            addCriterion("column_id between", value1, value2, "columnId");
            return (Criteria) this;
        }

        public Criteria andColumnIdNotBetween(String value1, String value2) {
            addCriterion("column_id not between", value1, value2, "columnId");
            return (Criteria) this;
        }

        public Criteria andExpertIdIsNull() {
            addCriterion("expert_id is null");
            return (Criteria) this;
        }

        public Criteria andExpertIdIsNotNull() {
            addCriterion("expert_id is not null");
            return (Criteria) this;
        }

        public Criteria andExpertIdEqualTo(String value) {
            addCriterion("expert_id =", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdNotEqualTo(String value) {
            addCriterion("expert_id <>", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdGreaterThan(String value) {
            addCriterion("expert_id >", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdGreaterThanOrEqualTo(String value) {
            addCriterion("expert_id >=", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdLessThan(String value) {
            addCriterion("expert_id <", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdLessThanOrEqualTo(String value) {
            addCriterion("expert_id <=", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdLike(String value) {
            addCriterion("expert_id like", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdNotLike(String value) {
            addCriterion("expert_id not like", value, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdIn(List<String> values) {
            addCriterion("expert_id in", values, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdNotIn(List<String> values) {
            addCriterion("expert_id not in", values, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdBetween(String value1, String value2) {
            addCriterion("expert_id between", value1, value2, "expertId");
            return (Criteria) this;
        }

        public Criteria andExpertIdNotBetween(String value1, String value2) {
            addCriterion("expert_id not between", value1, value2, "expertId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}