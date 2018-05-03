package com.huat.searchengine.entity;

import java.util.ArrayList;
import java.util.List;

public class TblColumnCategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblColumnCategoryExample() {
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

        public Criteria andCategoryNameIsNull() {
            addCriterion("category_name is null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNotNull() {
            addCriterion("category_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameEqualTo(String value) {
            addCriterion("category_name =", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotEqualTo(String value) {
            addCriterion("category_name <>", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThan(String value) {
            addCriterion("category_name >", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("category_name >=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThan(String value) {
            addCriterion("category_name <", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("category_name <=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLike(String value) {
            addCriterion("category_name like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotLike(String value) {
            addCriterion("category_name not like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIn(List<String> values) {
            addCriterion("category_name in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotIn(List<String> values) {
            addCriterion("category_name not in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameBetween(String value1, String value2) {
            addCriterion("category_name between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotBetween(String value1, String value2) {
            addCriterion("category_name not between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryAddressIsNull() {
            addCriterion("category_address is null");
            return (Criteria) this;
        }

        public Criteria andCategoryAddressIsNotNull() {
            addCriterion("category_address is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryAddressEqualTo(String value) {
            addCriterion("category_address =", value, "categoryAddress");
            return (Criteria) this;
        }

        public Criteria andCategoryAddressNotEqualTo(String value) {
            addCriterion("category_address <>", value, "categoryAddress");
            return (Criteria) this;
        }

        public Criteria andCategoryAddressGreaterThan(String value) {
            addCriterion("category_address >", value, "categoryAddress");
            return (Criteria) this;
        }

        public Criteria andCategoryAddressGreaterThanOrEqualTo(String value) {
            addCriterion("category_address >=", value, "categoryAddress");
            return (Criteria) this;
        }

        public Criteria andCategoryAddressLessThan(String value) {
            addCriterion("category_address <", value, "categoryAddress");
            return (Criteria) this;
        }

        public Criteria andCategoryAddressLessThanOrEqualTo(String value) {
            addCriterion("category_address <=", value, "categoryAddress");
            return (Criteria) this;
        }

        public Criteria andCategoryAddressLike(String value) {
            addCriterion("category_address like", value, "categoryAddress");
            return (Criteria) this;
        }

        public Criteria andCategoryAddressNotLike(String value) {
            addCriterion("category_address not like", value, "categoryAddress");
            return (Criteria) this;
        }

        public Criteria andCategoryAddressIn(List<String> values) {
            addCriterion("category_address in", values, "categoryAddress");
            return (Criteria) this;
        }

        public Criteria andCategoryAddressNotIn(List<String> values) {
            addCriterion("category_address not in", values, "categoryAddress");
            return (Criteria) this;
        }

        public Criteria andCategoryAddressBetween(String value1, String value2) {
            addCriterion("category_address between", value1, value2, "categoryAddress");
            return (Criteria) this;
        }

        public Criteria andCategoryAddressNotBetween(String value1, String value2) {
            addCriterion("category_address not between", value1, value2, "categoryAddress");
            return (Criteria) this;
        }

        public Criteria andColumnQuantityIsNull() {
            addCriterion("column_quantity is null");
            return (Criteria) this;
        }

        public Criteria andColumnQuantityIsNotNull() {
            addCriterion("column_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andColumnQuantityEqualTo(Integer value) {
            addCriterion("column_quantity =", value, "columnQuantity");
            return (Criteria) this;
        }

        public Criteria andColumnQuantityNotEqualTo(Integer value) {
            addCriterion("column_quantity <>", value, "columnQuantity");
            return (Criteria) this;
        }

        public Criteria andColumnQuantityGreaterThan(Integer value) {
            addCriterion("column_quantity >", value, "columnQuantity");
            return (Criteria) this;
        }

        public Criteria andColumnQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("column_quantity >=", value, "columnQuantity");
            return (Criteria) this;
        }

        public Criteria andColumnQuantityLessThan(Integer value) {
            addCriterion("column_quantity <", value, "columnQuantity");
            return (Criteria) this;
        }

        public Criteria andColumnQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("column_quantity <=", value, "columnQuantity");
            return (Criteria) this;
        }

        public Criteria andColumnQuantityIn(List<Integer> values) {
            addCriterion("column_quantity in", values, "columnQuantity");
            return (Criteria) this;
        }

        public Criteria andColumnQuantityNotIn(List<Integer> values) {
            addCriterion("column_quantity not in", values, "columnQuantity");
            return (Criteria) this;
        }

        public Criteria andColumnQuantityBetween(Integer value1, Integer value2) {
            addCriterion("column_quantity between", value1, value2, "columnQuantity");
            return (Criteria) this;
        }

        public Criteria andColumnQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("column_quantity not between", value1, value2, "columnQuantity");
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