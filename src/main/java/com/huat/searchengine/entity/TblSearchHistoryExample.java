package com.huat.searchengine.entity;

import java.util.ArrayList;
import java.util.List;

public class TblSearchHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblSearchHistoryExample() {
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

        public Criteria andSearchIdIsNull() {
            addCriterion("search_id is null");
            return (Criteria) this;
        }

        public Criteria andSearchIdIsNotNull() {
            addCriterion("search_id is not null");
            return (Criteria) this;
        }

        public Criteria andSearchIdEqualTo(String value) {
            addCriterion("search_id =", value, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdNotEqualTo(String value) {
            addCriterion("search_id <>", value, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdGreaterThan(String value) {
            addCriterion("search_id >", value, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdGreaterThanOrEqualTo(String value) {
            addCriterion("search_id >=", value, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdLessThan(String value) {
            addCriterion("search_id <", value, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdLessThanOrEqualTo(String value) {
            addCriterion("search_id <=", value, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdLike(String value) {
            addCriterion("search_id like", value, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdNotLike(String value) {
            addCriterion("search_id not like", value, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdIn(List<String> values) {
            addCriterion("search_id in", values, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdNotIn(List<String> values) {
            addCriterion("search_id not in", values, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdBetween(String value1, String value2) {
            addCriterion("search_id between", value1, value2, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdNotBetween(String value1, String value2) {
            addCriterion("search_id not between", value1, value2, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchTimeIsNull() {
            addCriterion("search_time is null");
            return (Criteria) this;
        }

        public Criteria andSearchTimeIsNotNull() {
            addCriterion("search_time is not null");
            return (Criteria) this;
        }

        public Criteria andSearchTimeEqualTo(Long value) {
            addCriterion("search_time =", value, "searchTime");
            return (Criteria) this;
        }

        public Criteria andSearchTimeNotEqualTo(Long value) {
            addCriterion("search_time <>", value, "searchTime");
            return (Criteria) this;
        }

        public Criteria andSearchTimeGreaterThan(Long value) {
            addCriterion("search_time >", value, "searchTime");
            return (Criteria) this;
        }

        public Criteria andSearchTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("search_time >=", value, "searchTime");
            return (Criteria) this;
        }

        public Criteria andSearchTimeLessThan(Long value) {
            addCriterion("search_time <", value, "searchTime");
            return (Criteria) this;
        }

        public Criteria andSearchTimeLessThanOrEqualTo(Long value) {
            addCriterion("search_time <=", value, "searchTime");
            return (Criteria) this;
        }

        public Criteria andSearchTimeIn(List<Long> values) {
            addCriterion("search_time in", values, "searchTime");
            return (Criteria) this;
        }

        public Criteria andSearchTimeNotIn(List<Long> values) {
            addCriterion("search_time not in", values, "searchTime");
            return (Criteria) this;
        }

        public Criteria andSearchTimeBetween(Long value1, Long value2) {
            addCriterion("search_time between", value1, value2, "searchTime");
            return (Criteria) this;
        }

        public Criteria andSearchTimeNotBetween(Long value1, Long value2) {
            addCriterion("search_time not between", value1, value2, "searchTime");
            return (Criteria) this;
        }

        public Criteria andSearchContentIsNull() {
            addCriterion("search_content is null");
            return (Criteria) this;
        }

        public Criteria andSearchContentIsNotNull() {
            addCriterion("search_content is not null");
            return (Criteria) this;
        }

        public Criteria andSearchContentEqualTo(String value) {
            addCriterion("search_content =", value, "searchContent");
            return (Criteria) this;
        }

        public Criteria andSearchContentNotEqualTo(String value) {
            addCriterion("search_content <>", value, "searchContent");
            return (Criteria) this;
        }

        public Criteria andSearchContentGreaterThan(String value) {
            addCriterion("search_content >", value, "searchContent");
            return (Criteria) this;
        }

        public Criteria andSearchContentGreaterThanOrEqualTo(String value) {
            addCriterion("search_content >=", value, "searchContent");
            return (Criteria) this;
        }

        public Criteria andSearchContentLessThan(String value) {
            addCriterion("search_content <", value, "searchContent");
            return (Criteria) this;
        }

        public Criteria andSearchContentLessThanOrEqualTo(String value) {
            addCriterion("search_content <=", value, "searchContent");
            return (Criteria) this;
        }

        public Criteria andSearchContentLike(String value) {
            addCriterion("search_content like", value, "searchContent");
            return (Criteria) this;
        }

        public Criteria andSearchContentNotLike(String value) {
            addCriterion("search_content not like", value, "searchContent");
            return (Criteria) this;
        }

        public Criteria andSearchContentIn(List<String> values) {
            addCriterion("search_content in", values, "searchContent");
            return (Criteria) this;
        }

        public Criteria andSearchContentNotIn(List<String> values) {
            addCriterion("search_content not in", values, "searchContent");
            return (Criteria) this;
        }

        public Criteria andSearchContentBetween(String value1, String value2) {
            addCriterion("search_content between", value1, value2, "searchContent");
            return (Criteria) this;
        }

        public Criteria andSearchContentNotBetween(String value1, String value2) {
            addCriterion("search_content not between", value1, value2, "searchContent");
            return (Criteria) this;
        }

        public Criteria andSearchTypeIsNull() {
            addCriterion("search_type is null");
            return (Criteria) this;
        }

        public Criteria andSearchTypeIsNotNull() {
            addCriterion("search_type is not null");
            return (Criteria) this;
        }

        public Criteria andSearchTypeEqualTo(Boolean value) {
            addCriterion("search_type =", value, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeNotEqualTo(Boolean value) {
            addCriterion("search_type <>", value, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeGreaterThan(Boolean value) {
            addCriterion("search_type >", value, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("search_type >=", value, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeLessThan(Boolean value) {
            addCriterion("search_type <", value, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("search_type <=", value, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeIn(List<Boolean> values) {
            addCriterion("search_type in", values, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeNotIn(List<Boolean> values) {
            addCriterion("search_type not in", values, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("search_type between", value1, value2, "searchType");
            return (Criteria) this;
        }

        public Criteria andSearchTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("search_type not between", value1, value2, "searchType");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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