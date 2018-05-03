package com.huat.searchengine.entity;

import java.util.ArrayList;
import java.util.List;

public class TblColumnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblColumnExample() {
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

        public Criteria andColumnTitleIsNull() {
            addCriterion("column_title is null");
            return (Criteria) this;
        }

        public Criteria andColumnTitleIsNotNull() {
            addCriterion("column_title is not null");
            return (Criteria) this;
        }

        public Criteria andColumnTitleEqualTo(String value) {
            addCriterion("column_title =", value, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleNotEqualTo(String value) {
            addCriterion("column_title <>", value, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleGreaterThan(String value) {
            addCriterion("column_title >", value, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleGreaterThanOrEqualTo(String value) {
            addCriterion("column_title >=", value, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleLessThan(String value) {
            addCriterion("column_title <", value, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleLessThanOrEqualTo(String value) {
            addCriterion("column_title <=", value, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleLike(String value) {
            addCriterion("column_title like", value, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleNotLike(String value) {
            addCriterion("column_title not like", value, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleIn(List<String> values) {
            addCriterion("column_title in", values, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleNotIn(List<String> values) {
            addCriterion("column_title not in", values, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleBetween(String value1, String value2) {
            addCriterion("column_title between", value1, value2, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnTitleNotBetween(String value1, String value2) {
            addCriterion("column_title not between", value1, value2, "columnTitle");
            return (Criteria) this;
        }

        public Criteria andColumnDescIsNull() {
            addCriterion("column_desc is null");
            return (Criteria) this;
        }

        public Criteria andColumnDescIsNotNull() {
            addCriterion("column_desc is not null");
            return (Criteria) this;
        }

        public Criteria andColumnDescEqualTo(String value) {
            addCriterion("column_desc =", value, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescNotEqualTo(String value) {
            addCriterion("column_desc <>", value, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescGreaterThan(String value) {
            addCriterion("column_desc >", value, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescGreaterThanOrEqualTo(String value) {
            addCriterion("column_desc >=", value, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescLessThan(String value) {
            addCriterion("column_desc <", value, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescLessThanOrEqualTo(String value) {
            addCriterion("column_desc <=", value, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescLike(String value) {
            addCriterion("column_desc like", value, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescNotLike(String value) {
            addCriterion("column_desc not like", value, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescIn(List<String> values) {
            addCriterion("column_desc in", values, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescNotIn(List<String> values) {
            addCriterion("column_desc not in", values, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescBetween(String value1, String value2) {
            addCriterion("column_desc between", value1, value2, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnDescNotBetween(String value1, String value2) {
            addCriterion("column_desc not between", value1, value2, "columnDesc");
            return (Criteria) this;
        }

        public Criteria andColumnAddressIsNull() {
            addCriterion("column_address is null");
            return (Criteria) this;
        }

        public Criteria andColumnAddressIsNotNull() {
            addCriterion("column_address is not null");
            return (Criteria) this;
        }

        public Criteria andColumnAddressEqualTo(String value) {
            addCriterion("column_address =", value, "columnAddress");
            return (Criteria) this;
        }

        public Criteria andColumnAddressNotEqualTo(String value) {
            addCriterion("column_address <>", value, "columnAddress");
            return (Criteria) this;
        }

        public Criteria andColumnAddressGreaterThan(String value) {
            addCriterion("column_address >", value, "columnAddress");
            return (Criteria) this;
        }

        public Criteria andColumnAddressGreaterThanOrEqualTo(String value) {
            addCriterion("column_address >=", value, "columnAddress");
            return (Criteria) this;
        }

        public Criteria andColumnAddressLessThan(String value) {
            addCriterion("column_address <", value, "columnAddress");
            return (Criteria) this;
        }

        public Criteria andColumnAddressLessThanOrEqualTo(String value) {
            addCriterion("column_address <=", value, "columnAddress");
            return (Criteria) this;
        }

        public Criteria andColumnAddressLike(String value) {
            addCriterion("column_address like", value, "columnAddress");
            return (Criteria) this;
        }

        public Criteria andColumnAddressNotLike(String value) {
            addCriterion("column_address not like", value, "columnAddress");
            return (Criteria) this;
        }

        public Criteria andColumnAddressIn(List<String> values) {
            addCriterion("column_address in", values, "columnAddress");
            return (Criteria) this;
        }

        public Criteria andColumnAddressNotIn(List<String> values) {
            addCriterion("column_address not in", values, "columnAddress");
            return (Criteria) this;
        }

        public Criteria andColumnAddressBetween(String value1, String value2) {
            addCriterion("column_address between", value1, value2, "columnAddress");
            return (Criteria) this;
        }

        public Criteria andColumnAddressNotBetween(String value1, String value2) {
            addCriterion("column_address not between", value1, value2, "columnAddress");
            return (Criteria) this;
        }

        public Criteria andColumnAvatarIsNull() {
            addCriterion("column_avatar is null");
            return (Criteria) this;
        }

        public Criteria andColumnAvatarIsNotNull() {
            addCriterion("column_avatar is not null");
            return (Criteria) this;
        }

        public Criteria andColumnAvatarEqualTo(String value) {
            addCriterion("column_avatar =", value, "columnAvatar");
            return (Criteria) this;
        }

        public Criteria andColumnAvatarNotEqualTo(String value) {
            addCriterion("column_avatar <>", value, "columnAvatar");
            return (Criteria) this;
        }

        public Criteria andColumnAvatarGreaterThan(String value) {
            addCriterion("column_avatar >", value, "columnAvatar");
            return (Criteria) this;
        }

        public Criteria andColumnAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("column_avatar >=", value, "columnAvatar");
            return (Criteria) this;
        }

        public Criteria andColumnAvatarLessThan(String value) {
            addCriterion("column_avatar <", value, "columnAvatar");
            return (Criteria) this;
        }

        public Criteria andColumnAvatarLessThanOrEqualTo(String value) {
            addCriterion("column_avatar <=", value, "columnAvatar");
            return (Criteria) this;
        }

        public Criteria andColumnAvatarLike(String value) {
            addCriterion("column_avatar like", value, "columnAvatar");
            return (Criteria) this;
        }

        public Criteria andColumnAvatarNotLike(String value) {
            addCriterion("column_avatar not like", value, "columnAvatar");
            return (Criteria) this;
        }

        public Criteria andColumnAvatarIn(List<String> values) {
            addCriterion("column_avatar in", values, "columnAvatar");
            return (Criteria) this;
        }

        public Criteria andColumnAvatarNotIn(List<String> values) {
            addCriterion("column_avatar not in", values, "columnAvatar");
            return (Criteria) this;
        }

        public Criteria andColumnAvatarBetween(String value1, String value2) {
            addCriterion("column_avatar between", value1, value2, "columnAvatar");
            return (Criteria) this;
        }

        public Criteria andColumnAvatarNotBetween(String value1, String value2) {
            addCriterion("column_avatar not between", value1, value2, "columnAvatar");
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

        public Criteria andFocusQuantityIsNull() {
            addCriterion("focus_quantity is null");
            return (Criteria) this;
        }

        public Criteria andFocusQuantityIsNotNull() {
            addCriterion("focus_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andFocusQuantityEqualTo(Integer value) {
            addCriterion("focus_quantity =", value, "focusQuantity");
            return (Criteria) this;
        }

        public Criteria andFocusQuantityNotEqualTo(Integer value) {
            addCriterion("focus_quantity <>", value, "focusQuantity");
            return (Criteria) this;
        }

        public Criteria andFocusQuantityGreaterThan(Integer value) {
            addCriterion("focus_quantity >", value, "focusQuantity");
            return (Criteria) this;
        }

        public Criteria andFocusQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("focus_quantity >=", value, "focusQuantity");
            return (Criteria) this;
        }

        public Criteria andFocusQuantityLessThan(Integer value) {
            addCriterion("focus_quantity <", value, "focusQuantity");
            return (Criteria) this;
        }

        public Criteria andFocusQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("focus_quantity <=", value, "focusQuantity");
            return (Criteria) this;
        }

        public Criteria andFocusQuantityIn(List<Integer> values) {
            addCriterion("focus_quantity in", values, "focusQuantity");
            return (Criteria) this;
        }

        public Criteria andFocusQuantityNotIn(List<Integer> values) {
            addCriterion("focus_quantity not in", values, "focusQuantity");
            return (Criteria) this;
        }

        public Criteria andFocusQuantityBetween(Integer value1, Integer value2) {
            addCriterion("focus_quantity between", value1, value2, "focusQuantity");
            return (Criteria) this;
        }

        public Criteria andFocusQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("focus_quantity not between", value1, value2, "focusQuantity");
            return (Criteria) this;
        }

        public Criteria andArticleQuantityIsNull() {
            addCriterion("article_quantity is null");
            return (Criteria) this;
        }

        public Criteria andArticleQuantityIsNotNull() {
            addCriterion("article_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andArticleQuantityEqualTo(Integer value) {
            addCriterion("article_quantity =", value, "articleQuantity");
            return (Criteria) this;
        }

        public Criteria andArticleQuantityNotEqualTo(Integer value) {
            addCriterion("article_quantity <>", value, "articleQuantity");
            return (Criteria) this;
        }

        public Criteria andArticleQuantityGreaterThan(Integer value) {
            addCriterion("article_quantity >", value, "articleQuantity");
            return (Criteria) this;
        }

        public Criteria andArticleQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_quantity >=", value, "articleQuantity");
            return (Criteria) this;
        }

        public Criteria andArticleQuantityLessThan(Integer value) {
            addCriterion("article_quantity <", value, "articleQuantity");
            return (Criteria) this;
        }

        public Criteria andArticleQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("article_quantity <=", value, "articleQuantity");
            return (Criteria) this;
        }

        public Criteria andArticleQuantityIn(List<Integer> values) {
            addCriterion("article_quantity in", values, "articleQuantity");
            return (Criteria) this;
        }

        public Criteria andArticleQuantityNotIn(List<Integer> values) {
            addCriterion("article_quantity not in", values, "articleQuantity");
            return (Criteria) this;
        }

        public Criteria andArticleQuantityBetween(Integer value1, Integer value2) {
            addCriterion("article_quantity between", value1, value2, "articleQuantity");
            return (Criteria) this;
        }

        public Criteria andArticleQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("article_quantity not between", value1, value2, "articleQuantity");
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