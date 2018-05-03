package com.huat.searchengine.entity;

import java.util.ArrayList;
import java.util.List;

public class TblExpertExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TblExpertExample() {
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

        public Criteria andExpertNameIsNull() {
            addCriterion("expert_name is null");
            return (Criteria) this;
        }

        public Criteria andExpertNameIsNotNull() {
            addCriterion("expert_name is not null");
            return (Criteria) this;
        }

        public Criteria andExpertNameEqualTo(String value) {
            addCriterion("expert_name =", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameNotEqualTo(String value) {
            addCriterion("expert_name <>", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameGreaterThan(String value) {
            addCriterion("expert_name >", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameGreaterThanOrEqualTo(String value) {
            addCriterion("expert_name >=", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameLessThan(String value) {
            addCriterion("expert_name <", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameLessThanOrEqualTo(String value) {
            addCriterion("expert_name <=", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameLike(String value) {
            addCriterion("expert_name like", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameNotLike(String value) {
            addCriterion("expert_name not like", value, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameIn(List<String> values) {
            addCriterion("expert_name in", values, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameNotIn(List<String> values) {
            addCriterion("expert_name not in", values, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameBetween(String value1, String value2) {
            addCriterion("expert_name between", value1, value2, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertNameNotBetween(String value1, String value2) {
            addCriterion("expert_name not between", value1, value2, "expertName");
            return (Criteria) this;
        }

        public Criteria andExpertAddressIsNull() {
            addCriterion("expert_address is null");
            return (Criteria) this;
        }

        public Criteria andExpertAddressIsNotNull() {
            addCriterion("expert_address is not null");
            return (Criteria) this;
        }

        public Criteria andExpertAddressEqualTo(String value) {
            addCriterion("expert_address =", value, "expertAddress");
            return (Criteria) this;
        }

        public Criteria andExpertAddressNotEqualTo(String value) {
            addCriterion("expert_address <>", value, "expertAddress");
            return (Criteria) this;
        }

        public Criteria andExpertAddressGreaterThan(String value) {
            addCriterion("expert_address >", value, "expertAddress");
            return (Criteria) this;
        }

        public Criteria andExpertAddressGreaterThanOrEqualTo(String value) {
            addCriterion("expert_address >=", value, "expertAddress");
            return (Criteria) this;
        }

        public Criteria andExpertAddressLessThan(String value) {
            addCriterion("expert_address <", value, "expertAddress");
            return (Criteria) this;
        }

        public Criteria andExpertAddressLessThanOrEqualTo(String value) {
            addCriterion("expert_address <=", value, "expertAddress");
            return (Criteria) this;
        }

        public Criteria andExpertAddressLike(String value) {
            addCriterion("expert_address like", value, "expertAddress");
            return (Criteria) this;
        }

        public Criteria andExpertAddressNotLike(String value) {
            addCriterion("expert_address not like", value, "expertAddress");
            return (Criteria) this;
        }

        public Criteria andExpertAddressIn(List<String> values) {
            addCriterion("expert_address in", values, "expertAddress");
            return (Criteria) this;
        }

        public Criteria andExpertAddressNotIn(List<String> values) {
            addCriterion("expert_address not in", values, "expertAddress");
            return (Criteria) this;
        }

        public Criteria andExpertAddressBetween(String value1, String value2) {
            addCriterion("expert_address between", value1, value2, "expertAddress");
            return (Criteria) this;
        }

        public Criteria andExpertAddressNotBetween(String value1, String value2) {
            addCriterion("expert_address not between", value1, value2, "expertAddress");
            return (Criteria) this;
        }

        public Criteria andExpertJobIsNull() {
            addCriterion("expert_job is null");
            return (Criteria) this;
        }

        public Criteria andExpertJobIsNotNull() {
            addCriterion("expert_job is not null");
            return (Criteria) this;
        }

        public Criteria andExpertJobEqualTo(String value) {
            addCriterion("expert_job =", value, "expertJob");
            return (Criteria) this;
        }

        public Criteria andExpertJobNotEqualTo(String value) {
            addCriterion("expert_job <>", value, "expertJob");
            return (Criteria) this;
        }

        public Criteria andExpertJobGreaterThan(String value) {
            addCriterion("expert_job >", value, "expertJob");
            return (Criteria) this;
        }

        public Criteria andExpertJobGreaterThanOrEqualTo(String value) {
            addCriterion("expert_job >=", value, "expertJob");
            return (Criteria) this;
        }

        public Criteria andExpertJobLessThan(String value) {
            addCriterion("expert_job <", value, "expertJob");
            return (Criteria) this;
        }

        public Criteria andExpertJobLessThanOrEqualTo(String value) {
            addCriterion("expert_job <=", value, "expertJob");
            return (Criteria) this;
        }

        public Criteria andExpertJobLike(String value) {
            addCriterion("expert_job like", value, "expertJob");
            return (Criteria) this;
        }

        public Criteria andExpertJobNotLike(String value) {
            addCriterion("expert_job not like", value, "expertJob");
            return (Criteria) this;
        }

        public Criteria andExpertJobIn(List<String> values) {
            addCriterion("expert_job in", values, "expertJob");
            return (Criteria) this;
        }

        public Criteria andExpertJobNotIn(List<String> values) {
            addCriterion("expert_job not in", values, "expertJob");
            return (Criteria) this;
        }

        public Criteria andExpertJobBetween(String value1, String value2) {
            addCriterion("expert_job between", value1, value2, "expertJob");
            return (Criteria) this;
        }

        public Criteria andExpertJobNotBetween(String value1, String value2) {
            addCriterion("expert_job not between", value1, value2, "expertJob");
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

        public Criteria andArticleOriginalIsNull() {
            addCriterion("article_original is null");
            return (Criteria) this;
        }

        public Criteria andArticleOriginalIsNotNull() {
            addCriterion("article_original is not null");
            return (Criteria) this;
        }

        public Criteria andArticleOriginalEqualTo(Integer value) {
            addCriterion("article_original =", value, "articleOriginal");
            return (Criteria) this;
        }

        public Criteria andArticleOriginalNotEqualTo(Integer value) {
            addCriterion("article_original <>", value, "articleOriginal");
            return (Criteria) this;
        }

        public Criteria andArticleOriginalGreaterThan(Integer value) {
            addCriterion("article_original >", value, "articleOriginal");
            return (Criteria) this;
        }

        public Criteria andArticleOriginalGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_original >=", value, "articleOriginal");
            return (Criteria) this;
        }

        public Criteria andArticleOriginalLessThan(Integer value) {
            addCriterion("article_original <", value, "articleOriginal");
            return (Criteria) this;
        }

        public Criteria andArticleOriginalLessThanOrEqualTo(Integer value) {
            addCriterion("article_original <=", value, "articleOriginal");
            return (Criteria) this;
        }

        public Criteria andArticleOriginalIn(List<Integer> values) {
            addCriterion("article_original in", values, "articleOriginal");
            return (Criteria) this;
        }

        public Criteria andArticleOriginalNotIn(List<Integer> values) {
            addCriterion("article_original not in", values, "articleOriginal");
            return (Criteria) this;
        }

        public Criteria andArticleOriginalBetween(Integer value1, Integer value2) {
            addCriterion("article_original between", value1, value2, "articleOriginal");
            return (Criteria) this;
        }

        public Criteria andArticleOriginalNotBetween(Integer value1, Integer value2) {
            addCriterion("article_original not between", value1, value2, "articleOriginal");
            return (Criteria) this;
        }

        public Criteria andReadingQuantityIsNull() {
            addCriterion("reading_quantity is null");
            return (Criteria) this;
        }

        public Criteria andReadingQuantityIsNotNull() {
            addCriterion("reading_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andReadingQuantityEqualTo(Integer value) {
            addCriterion("reading_quantity =", value, "readingQuantity");
            return (Criteria) this;
        }

        public Criteria andReadingQuantityNotEqualTo(Integer value) {
            addCriterion("reading_quantity <>", value, "readingQuantity");
            return (Criteria) this;
        }

        public Criteria andReadingQuantityGreaterThan(Integer value) {
            addCriterion("reading_quantity >", value, "readingQuantity");
            return (Criteria) this;
        }

        public Criteria andReadingQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("reading_quantity >=", value, "readingQuantity");
            return (Criteria) this;
        }

        public Criteria andReadingQuantityLessThan(Integer value) {
            addCriterion("reading_quantity <", value, "readingQuantity");
            return (Criteria) this;
        }

        public Criteria andReadingQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("reading_quantity <=", value, "readingQuantity");
            return (Criteria) this;
        }

        public Criteria andReadingQuantityIn(List<Integer> values) {
            addCriterion("reading_quantity in", values, "readingQuantity");
            return (Criteria) this;
        }

        public Criteria andReadingQuantityNotIn(List<Integer> values) {
            addCriterion("reading_quantity not in", values, "readingQuantity");
            return (Criteria) this;
        }

        public Criteria andReadingQuantityBetween(Integer value1, Integer value2) {
            addCriterion("reading_quantity between", value1, value2, "readingQuantity");
            return (Criteria) this;
        }

        public Criteria andReadingQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("reading_quantity not between", value1, value2, "readingQuantity");
            return (Criteria) this;
        }

        public Criteria andFansQuantityIsNull() {
            addCriterion("fans_quantity is null");
            return (Criteria) this;
        }

        public Criteria andFansQuantityIsNotNull() {
            addCriterion("fans_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andFansQuantityEqualTo(Integer value) {
            addCriterion("fans_quantity =", value, "fansQuantity");
            return (Criteria) this;
        }

        public Criteria andFansQuantityNotEqualTo(Integer value) {
            addCriterion("fans_quantity <>", value, "fansQuantity");
            return (Criteria) this;
        }

        public Criteria andFansQuantityGreaterThan(Integer value) {
            addCriterion("fans_quantity >", value, "fansQuantity");
            return (Criteria) this;
        }

        public Criteria andFansQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("fans_quantity >=", value, "fansQuantity");
            return (Criteria) this;
        }

        public Criteria andFansQuantityLessThan(Integer value) {
            addCriterion("fans_quantity <", value, "fansQuantity");
            return (Criteria) this;
        }

        public Criteria andFansQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("fans_quantity <=", value, "fansQuantity");
            return (Criteria) this;
        }

        public Criteria andFansQuantityIn(List<Integer> values) {
            addCriterion("fans_quantity in", values, "fansQuantity");
            return (Criteria) this;
        }

        public Criteria andFansQuantityNotIn(List<Integer> values) {
            addCriterion("fans_quantity not in", values, "fansQuantity");
            return (Criteria) this;
        }

        public Criteria andFansQuantityBetween(Integer value1, Integer value2) {
            addCriterion("fans_quantity between", value1, value2, "fansQuantity");
            return (Criteria) this;
        }

        public Criteria andFansQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("fans_quantity not between", value1, value2, "fansQuantity");
            return (Criteria) this;
        }

        public Criteria andLikeQunatityIsNull() {
            addCriterion("like_qunatity is null");
            return (Criteria) this;
        }

        public Criteria andLikeQunatityIsNotNull() {
            addCriterion("like_qunatity is not null");
            return (Criteria) this;
        }

        public Criteria andLikeQunatityEqualTo(Integer value) {
            addCriterion("like_qunatity =", value, "likeQunatity");
            return (Criteria) this;
        }

        public Criteria andLikeQunatityNotEqualTo(Integer value) {
            addCriterion("like_qunatity <>", value, "likeQunatity");
            return (Criteria) this;
        }

        public Criteria andLikeQunatityGreaterThan(Integer value) {
            addCriterion("like_qunatity >", value, "likeQunatity");
            return (Criteria) this;
        }

        public Criteria andLikeQunatityGreaterThanOrEqualTo(Integer value) {
            addCriterion("like_qunatity >=", value, "likeQunatity");
            return (Criteria) this;
        }

        public Criteria andLikeQunatityLessThan(Integer value) {
            addCriterion("like_qunatity <", value, "likeQunatity");
            return (Criteria) this;
        }

        public Criteria andLikeQunatityLessThanOrEqualTo(Integer value) {
            addCriterion("like_qunatity <=", value, "likeQunatity");
            return (Criteria) this;
        }

        public Criteria andLikeQunatityIn(List<Integer> values) {
            addCriterion("like_qunatity in", values, "likeQunatity");
            return (Criteria) this;
        }

        public Criteria andLikeQunatityNotIn(List<Integer> values) {
            addCriterion("like_qunatity not in", values, "likeQunatity");
            return (Criteria) this;
        }

        public Criteria andLikeQunatityBetween(Integer value1, Integer value2) {
            addCriterion("like_qunatity between", value1, value2, "likeQunatity");
            return (Criteria) this;
        }

        public Criteria andLikeQunatityNotBetween(Integer value1, Integer value2) {
            addCriterion("like_qunatity not between", value1, value2, "likeQunatity");
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

        public Criteria andBlogAddressIsNull() {
            addCriterion("blog_address is null");
            return (Criteria) this;
        }

        public Criteria andBlogAddressIsNotNull() {
            addCriterion("blog_address is not null");
            return (Criteria) this;
        }

        public Criteria andBlogAddressEqualTo(String value) {
            addCriterion("blog_address =", value, "blogAddress");
            return (Criteria) this;
        }

        public Criteria andBlogAddressNotEqualTo(String value) {
            addCriterion("blog_address <>", value, "blogAddress");
            return (Criteria) this;
        }

        public Criteria andBlogAddressGreaterThan(String value) {
            addCriterion("blog_address >", value, "blogAddress");
            return (Criteria) this;
        }

        public Criteria andBlogAddressGreaterThanOrEqualTo(String value) {
            addCriterion("blog_address >=", value, "blogAddress");
            return (Criteria) this;
        }

        public Criteria andBlogAddressLessThan(String value) {
            addCriterion("blog_address <", value, "blogAddress");
            return (Criteria) this;
        }

        public Criteria andBlogAddressLessThanOrEqualTo(String value) {
            addCriterion("blog_address <=", value, "blogAddress");
            return (Criteria) this;
        }

        public Criteria andBlogAddressLike(String value) {
            addCriterion("blog_address like", value, "blogAddress");
            return (Criteria) this;
        }

        public Criteria andBlogAddressNotLike(String value) {
            addCriterion("blog_address not like", value, "blogAddress");
            return (Criteria) this;
        }

        public Criteria andBlogAddressIn(List<String> values) {
            addCriterion("blog_address in", values, "blogAddress");
            return (Criteria) this;
        }

        public Criteria andBlogAddressNotIn(List<String> values) {
            addCriterion("blog_address not in", values, "blogAddress");
            return (Criteria) this;
        }

        public Criteria andBlogAddressBetween(String value1, String value2) {
            addCriterion("blog_address between", value1, value2, "blogAddress");
            return (Criteria) this;
        }

        public Criteria andBlogAddressNotBetween(String value1, String value2) {
            addCriterion("blog_address not between", value1, value2, "blogAddress");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIsNull() {
            addCriterion("blog_title is null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIsNotNull() {
            addCriterion("blog_title is not null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleEqualTo(String value) {
            addCriterion("blog_title =", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotEqualTo(String value) {
            addCriterion("blog_title <>", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThan(String value) {
            addCriterion("blog_title >", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThanOrEqualTo(String value) {
            addCriterion("blog_title >=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThan(String value) {
            addCriterion("blog_title <", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThanOrEqualTo(String value) {
            addCriterion("blog_title <=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLike(String value) {
            addCriterion("blog_title like", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotLike(String value) {
            addCriterion("blog_title not like", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIn(List<String> values) {
            addCriterion("blog_title in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotIn(List<String> values) {
            addCriterion("blog_title not in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleBetween(String value1, String value2) {
            addCriterion("blog_title between", value1, value2, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotBetween(String value1, String value2) {
            addCriterion("blog_title not between", value1, value2, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andPersonalCenterIsNull() {
            addCriterion("personal_center is null");
            return (Criteria) this;
        }

        public Criteria andPersonalCenterIsNotNull() {
            addCriterion("personal_center is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalCenterEqualTo(String value) {
            addCriterion("personal_center =", value, "personalCenter");
            return (Criteria) this;
        }

        public Criteria andPersonalCenterNotEqualTo(String value) {
            addCriterion("personal_center <>", value, "personalCenter");
            return (Criteria) this;
        }

        public Criteria andPersonalCenterGreaterThan(String value) {
            addCriterion("personal_center >", value, "personalCenter");
            return (Criteria) this;
        }

        public Criteria andPersonalCenterGreaterThanOrEqualTo(String value) {
            addCriterion("personal_center >=", value, "personalCenter");
            return (Criteria) this;
        }

        public Criteria andPersonalCenterLessThan(String value) {
            addCriterion("personal_center <", value, "personalCenter");
            return (Criteria) this;
        }

        public Criteria andPersonalCenterLessThanOrEqualTo(String value) {
            addCriterion("personal_center <=", value, "personalCenter");
            return (Criteria) this;
        }

        public Criteria andPersonalCenterLike(String value) {
            addCriterion("personal_center like", value, "personalCenter");
            return (Criteria) this;
        }

        public Criteria andPersonalCenterNotLike(String value) {
            addCriterion("personal_center not like", value, "personalCenter");
            return (Criteria) this;
        }

        public Criteria andPersonalCenterIn(List<String> values) {
            addCriterion("personal_center in", values, "personalCenter");
            return (Criteria) this;
        }

        public Criteria andPersonalCenterNotIn(List<String> values) {
            addCriterion("personal_center not in", values, "personalCenter");
            return (Criteria) this;
        }

        public Criteria andPersonalCenterBetween(String value1, String value2) {
            addCriterion("personal_center between", value1, value2, "personalCenter");
            return (Criteria) this;
        }

        public Criteria andPersonalCenterNotBetween(String value1, String value2) {
            addCriterion("personal_center not between", value1, value2, "personalCenter");
            return (Criteria) this;
        }

        public Criteria andExpertAvatarIsNull() {
            addCriterion("expert_avatar is null");
            return (Criteria) this;
        }

        public Criteria andExpertAvatarIsNotNull() {
            addCriterion("expert_avatar is not null");
            return (Criteria) this;
        }

        public Criteria andExpertAvatarEqualTo(String value) {
            addCriterion("expert_avatar =", value, "expertAvatar");
            return (Criteria) this;
        }

        public Criteria andExpertAvatarNotEqualTo(String value) {
            addCriterion("expert_avatar <>", value, "expertAvatar");
            return (Criteria) this;
        }

        public Criteria andExpertAvatarGreaterThan(String value) {
            addCriterion("expert_avatar >", value, "expertAvatar");
            return (Criteria) this;
        }

        public Criteria andExpertAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("expert_avatar >=", value, "expertAvatar");
            return (Criteria) this;
        }

        public Criteria andExpertAvatarLessThan(String value) {
            addCriterion("expert_avatar <", value, "expertAvatar");
            return (Criteria) this;
        }

        public Criteria andExpertAvatarLessThanOrEqualTo(String value) {
            addCriterion("expert_avatar <=", value, "expertAvatar");
            return (Criteria) this;
        }

        public Criteria andExpertAvatarLike(String value) {
            addCriterion("expert_avatar like", value, "expertAvatar");
            return (Criteria) this;
        }

        public Criteria andExpertAvatarNotLike(String value) {
            addCriterion("expert_avatar not like", value, "expertAvatar");
            return (Criteria) this;
        }

        public Criteria andExpertAvatarIn(List<String> values) {
            addCriterion("expert_avatar in", values, "expertAvatar");
            return (Criteria) this;
        }

        public Criteria andExpertAvatarNotIn(List<String> values) {
            addCriterion("expert_avatar not in", values, "expertAvatar");
            return (Criteria) this;
        }

        public Criteria andExpertAvatarBetween(String value1, String value2) {
            addCriterion("expert_avatar between", value1, value2, "expertAvatar");
            return (Criteria) this;
        }

        public Criteria andExpertAvatarNotBetween(String value1, String value2) {
            addCriterion("expert_avatar not between", value1, value2, "expertAvatar");
            return (Criteria) this;
        }

        public Criteria andBlogGradeIsNull() {
            addCriterion("blog_grade is null");
            return (Criteria) this;
        }

        public Criteria andBlogGradeIsNotNull() {
            addCriterion("blog_grade is not null");
            return (Criteria) this;
        }

        public Criteria andBlogGradeEqualTo(Integer value) {
            addCriterion("blog_grade =", value, "blogGrade");
            return (Criteria) this;
        }

        public Criteria andBlogGradeNotEqualTo(Integer value) {
            addCriterion("blog_grade <>", value, "blogGrade");
            return (Criteria) this;
        }

        public Criteria andBlogGradeGreaterThan(Integer value) {
            addCriterion("blog_grade >", value, "blogGrade");
            return (Criteria) this;
        }

        public Criteria andBlogGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_grade >=", value, "blogGrade");
            return (Criteria) this;
        }

        public Criteria andBlogGradeLessThan(Integer value) {
            addCriterion("blog_grade <", value, "blogGrade");
            return (Criteria) this;
        }

        public Criteria andBlogGradeLessThanOrEqualTo(Integer value) {
            addCriterion("blog_grade <=", value, "blogGrade");
            return (Criteria) this;
        }

        public Criteria andBlogGradeIn(List<Integer> values) {
            addCriterion("blog_grade in", values, "blogGrade");
            return (Criteria) this;
        }

        public Criteria andBlogGradeNotIn(List<Integer> values) {
            addCriterion("blog_grade not in", values, "blogGrade");
            return (Criteria) this;
        }

        public Criteria andBlogGradeBetween(Integer value1, Integer value2) {
            addCriterion("blog_grade between", value1, value2, "blogGrade");
            return (Criteria) this;
        }

        public Criteria andBlogGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_grade not between", value1, value2, "blogGrade");
            return (Criteria) this;
        }

        public Criteria andBlogScoreIsNull() {
            addCriterion("blog_score is null");
            return (Criteria) this;
        }

        public Criteria andBlogScoreIsNotNull() {
            addCriterion("blog_score is not null");
            return (Criteria) this;
        }

        public Criteria andBlogScoreEqualTo(Integer value) {
            addCriterion("blog_score =", value, "blogScore");
            return (Criteria) this;
        }

        public Criteria andBlogScoreNotEqualTo(Integer value) {
            addCriterion("blog_score <>", value, "blogScore");
            return (Criteria) this;
        }

        public Criteria andBlogScoreGreaterThan(Integer value) {
            addCriterion("blog_score >", value, "blogScore");
            return (Criteria) this;
        }

        public Criteria andBlogScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_score >=", value, "blogScore");
            return (Criteria) this;
        }

        public Criteria andBlogScoreLessThan(Integer value) {
            addCriterion("blog_score <", value, "blogScore");
            return (Criteria) this;
        }

        public Criteria andBlogScoreLessThanOrEqualTo(Integer value) {
            addCriterion("blog_score <=", value, "blogScore");
            return (Criteria) this;
        }

        public Criteria andBlogScoreIn(List<Integer> values) {
            addCriterion("blog_score in", values, "blogScore");
            return (Criteria) this;
        }

        public Criteria andBlogScoreNotIn(List<Integer> values) {
            addCriterion("blog_score not in", values, "blogScore");
            return (Criteria) this;
        }

        public Criteria andBlogScoreBetween(Integer value1, Integer value2) {
            addCriterion("blog_score between", value1, value2, "blogScore");
            return (Criteria) this;
        }

        public Criteria andBlogScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_score not between", value1, value2, "blogScore");
            return (Criteria) this;
        }

        public Criteria andDownloadGradeIsNull() {
            addCriterion("download_grade is null");
            return (Criteria) this;
        }

        public Criteria andDownloadGradeIsNotNull() {
            addCriterion("download_grade is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadGradeEqualTo(Integer value) {
            addCriterion("download_grade =", value, "downloadGrade");
            return (Criteria) this;
        }

        public Criteria andDownloadGradeNotEqualTo(Integer value) {
            addCriterion("download_grade <>", value, "downloadGrade");
            return (Criteria) this;
        }

        public Criteria andDownloadGradeGreaterThan(Integer value) {
            addCriterion("download_grade >", value, "downloadGrade");
            return (Criteria) this;
        }

        public Criteria andDownloadGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("download_grade >=", value, "downloadGrade");
            return (Criteria) this;
        }

        public Criteria andDownloadGradeLessThan(Integer value) {
            addCriterion("download_grade <", value, "downloadGrade");
            return (Criteria) this;
        }

        public Criteria andDownloadGradeLessThanOrEqualTo(Integer value) {
            addCriterion("download_grade <=", value, "downloadGrade");
            return (Criteria) this;
        }

        public Criteria andDownloadGradeIn(List<Integer> values) {
            addCriterion("download_grade in", values, "downloadGrade");
            return (Criteria) this;
        }

        public Criteria andDownloadGradeNotIn(List<Integer> values) {
            addCriterion("download_grade not in", values, "downloadGrade");
            return (Criteria) this;
        }

        public Criteria andDownloadGradeBetween(Integer value1, Integer value2) {
            addCriterion("download_grade between", value1, value2, "downloadGrade");
            return (Criteria) this;
        }

        public Criteria andDownloadGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("download_grade not between", value1, value2, "downloadGrade");
            return (Criteria) this;
        }

        public Criteria andDownloadScoreIsNull() {
            addCriterion("download_score is null");
            return (Criteria) this;
        }

        public Criteria andDownloadScoreIsNotNull() {
            addCriterion("download_score is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadScoreEqualTo(Integer value) {
            addCriterion("download_score =", value, "downloadScore");
            return (Criteria) this;
        }

        public Criteria andDownloadScoreNotEqualTo(Integer value) {
            addCriterion("download_score <>", value, "downloadScore");
            return (Criteria) this;
        }

        public Criteria andDownloadScoreGreaterThan(Integer value) {
            addCriterion("download_score >", value, "downloadScore");
            return (Criteria) this;
        }

        public Criteria andDownloadScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("download_score >=", value, "downloadScore");
            return (Criteria) this;
        }

        public Criteria andDownloadScoreLessThan(Integer value) {
            addCriterion("download_score <", value, "downloadScore");
            return (Criteria) this;
        }

        public Criteria andDownloadScoreLessThanOrEqualTo(Integer value) {
            addCriterion("download_score <=", value, "downloadScore");
            return (Criteria) this;
        }

        public Criteria andDownloadScoreIn(List<Integer> values) {
            addCriterion("download_score in", values, "downloadScore");
            return (Criteria) this;
        }

        public Criteria andDownloadScoreNotIn(List<Integer> values) {
            addCriterion("download_score not in", values, "downloadScore");
            return (Criteria) this;
        }

        public Criteria andDownloadScoreBetween(Integer value1, Integer value2) {
            addCriterion("download_score between", value1, value2, "downloadScore");
            return (Criteria) this;
        }

        public Criteria andDownloadScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("download_score not between", value1, value2, "downloadScore");
            return (Criteria) this;
        }

        public Criteria andBbsGradeIsNull() {
            addCriterion("bbs_grade is null");
            return (Criteria) this;
        }

        public Criteria andBbsGradeIsNotNull() {
            addCriterion("bbs_grade is not null");
            return (Criteria) this;
        }

        public Criteria andBbsGradeEqualTo(Integer value) {
            addCriterion("bbs_grade =", value, "bbsGrade");
            return (Criteria) this;
        }

        public Criteria andBbsGradeNotEqualTo(Integer value) {
            addCriterion("bbs_grade <>", value, "bbsGrade");
            return (Criteria) this;
        }

        public Criteria andBbsGradeGreaterThan(Integer value) {
            addCriterion("bbs_grade >", value, "bbsGrade");
            return (Criteria) this;
        }

        public Criteria andBbsGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("bbs_grade >=", value, "bbsGrade");
            return (Criteria) this;
        }

        public Criteria andBbsGradeLessThan(Integer value) {
            addCriterion("bbs_grade <", value, "bbsGrade");
            return (Criteria) this;
        }

        public Criteria andBbsGradeLessThanOrEqualTo(Integer value) {
            addCriterion("bbs_grade <=", value, "bbsGrade");
            return (Criteria) this;
        }

        public Criteria andBbsGradeIn(List<Integer> values) {
            addCriterion("bbs_grade in", values, "bbsGrade");
            return (Criteria) this;
        }

        public Criteria andBbsGradeNotIn(List<Integer> values) {
            addCriterion("bbs_grade not in", values, "bbsGrade");
            return (Criteria) this;
        }

        public Criteria andBbsGradeBetween(Integer value1, Integer value2) {
            addCriterion("bbs_grade between", value1, value2, "bbsGrade");
            return (Criteria) this;
        }

        public Criteria andBbsGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("bbs_grade not between", value1, value2, "bbsGrade");
            return (Criteria) this;
        }

        public Criteria andBbsScoreIsNull() {
            addCriterion("bbs_score is null");
            return (Criteria) this;
        }

        public Criteria andBbsScoreIsNotNull() {
            addCriterion("bbs_score is not null");
            return (Criteria) this;
        }

        public Criteria andBbsScoreEqualTo(Integer value) {
            addCriterion("bbs_score =", value, "bbsScore");
            return (Criteria) this;
        }

        public Criteria andBbsScoreNotEqualTo(Integer value) {
            addCriterion("bbs_score <>", value, "bbsScore");
            return (Criteria) this;
        }

        public Criteria andBbsScoreGreaterThan(Integer value) {
            addCriterion("bbs_score >", value, "bbsScore");
            return (Criteria) this;
        }

        public Criteria andBbsScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("bbs_score >=", value, "bbsScore");
            return (Criteria) this;
        }

        public Criteria andBbsScoreLessThan(Integer value) {
            addCriterion("bbs_score <", value, "bbsScore");
            return (Criteria) this;
        }

        public Criteria andBbsScoreLessThanOrEqualTo(Integer value) {
            addCriterion("bbs_score <=", value, "bbsScore");
            return (Criteria) this;
        }

        public Criteria andBbsScoreIn(List<Integer> values) {
            addCriterion("bbs_score in", values, "bbsScore");
            return (Criteria) this;
        }

        public Criteria andBbsScoreNotIn(List<Integer> values) {
            addCriterion("bbs_score not in", values, "bbsScore");
            return (Criteria) this;
        }

        public Criteria andBbsScoreBetween(Integer value1, Integer value2) {
            addCriterion("bbs_score between", value1, value2, "bbsScore");
            return (Criteria) this;
        }

        public Criteria andBbsScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("bbs_score not between", value1, value2, "bbsScore");
            return (Criteria) this;
        }

        public Criteria andExpertMedalsIsNull() {
            addCriterion("expert_medals is null");
            return (Criteria) this;
        }

        public Criteria andExpertMedalsIsNotNull() {
            addCriterion("expert_medals is not null");
            return (Criteria) this;
        }

        public Criteria andExpertMedalsEqualTo(String value) {
            addCriterion("expert_medals =", value, "expertMedals");
            return (Criteria) this;
        }

        public Criteria andExpertMedalsNotEqualTo(String value) {
            addCriterion("expert_medals <>", value, "expertMedals");
            return (Criteria) this;
        }

        public Criteria andExpertMedalsGreaterThan(String value) {
            addCriterion("expert_medals >", value, "expertMedals");
            return (Criteria) this;
        }

        public Criteria andExpertMedalsGreaterThanOrEqualTo(String value) {
            addCriterion("expert_medals >=", value, "expertMedals");
            return (Criteria) this;
        }

        public Criteria andExpertMedalsLessThan(String value) {
            addCriterion("expert_medals <", value, "expertMedals");
            return (Criteria) this;
        }

        public Criteria andExpertMedalsLessThanOrEqualTo(String value) {
            addCriterion("expert_medals <=", value, "expertMedals");
            return (Criteria) this;
        }

        public Criteria andExpertMedalsLike(String value) {
            addCriterion("expert_medals like", value, "expertMedals");
            return (Criteria) this;
        }

        public Criteria andExpertMedalsNotLike(String value) {
            addCriterion("expert_medals not like", value, "expertMedals");
            return (Criteria) this;
        }

        public Criteria andExpertMedalsIn(List<String> values) {
            addCriterion("expert_medals in", values, "expertMedals");
            return (Criteria) this;
        }

        public Criteria andExpertMedalsNotIn(List<String> values) {
            addCriterion("expert_medals not in", values, "expertMedals");
            return (Criteria) this;
        }

        public Criteria andExpertMedalsBetween(String value1, String value2) {
            addCriterion("expert_medals between", value1, value2, "expertMedals");
            return (Criteria) this;
        }

        public Criteria andExpertMedalsNotBetween(String value1, String value2) {
            addCriterion("expert_medals not between", value1, value2, "expertMedals");
            return (Criteria) this;
        }

        public Criteria andExpertRankingIsNull() {
            addCriterion("expert_ranking is null");
            return (Criteria) this;
        }

        public Criteria andExpertRankingIsNotNull() {
            addCriterion("expert_ranking is not null");
            return (Criteria) this;
        }

        public Criteria andExpertRankingEqualTo(Integer value) {
            addCriterion("expert_ranking =", value, "expertRanking");
            return (Criteria) this;
        }

        public Criteria andExpertRankingNotEqualTo(Integer value) {
            addCriterion("expert_ranking <>", value, "expertRanking");
            return (Criteria) this;
        }

        public Criteria andExpertRankingGreaterThan(Integer value) {
            addCriterion("expert_ranking >", value, "expertRanking");
            return (Criteria) this;
        }

        public Criteria andExpertRankingGreaterThanOrEqualTo(Integer value) {
            addCriterion("expert_ranking >=", value, "expertRanking");
            return (Criteria) this;
        }

        public Criteria andExpertRankingLessThan(Integer value) {
            addCriterion("expert_ranking <", value, "expertRanking");
            return (Criteria) this;
        }

        public Criteria andExpertRankingLessThanOrEqualTo(Integer value) {
            addCriterion("expert_ranking <=", value, "expertRanking");
            return (Criteria) this;
        }

        public Criteria andExpertRankingIn(List<Integer> values) {
            addCriterion("expert_ranking in", values, "expertRanking");
            return (Criteria) this;
        }

        public Criteria andExpertRankingNotIn(List<Integer> values) {
            addCriterion("expert_ranking not in", values, "expertRanking");
            return (Criteria) this;
        }

        public Criteria andExpertRankingBetween(Integer value1, Integer value2) {
            addCriterion("expert_ranking between", value1, value2, "expertRanking");
            return (Criteria) this;
        }

        public Criteria andExpertRankingNotBetween(Integer value1, Integer value2) {
            addCriterion("expert_ranking not between", value1, value2, "expertRanking");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andExpertSignIsNull() {
            addCriterion("expert_sign is null");
            return (Criteria) this;
        }

        public Criteria andExpertSignIsNotNull() {
            addCriterion("expert_sign is not null");
            return (Criteria) this;
        }

        public Criteria andExpertSignEqualTo(String value) {
            addCriterion("expert_sign =", value, "expertSign");
            return (Criteria) this;
        }

        public Criteria andExpertSignNotEqualTo(String value) {
            addCriterion("expert_sign <>", value, "expertSign");
            return (Criteria) this;
        }

        public Criteria andExpertSignGreaterThan(String value) {
            addCriterion("expert_sign >", value, "expertSign");
            return (Criteria) this;
        }

        public Criteria andExpertSignGreaterThanOrEqualTo(String value) {
            addCriterion("expert_sign >=", value, "expertSign");
            return (Criteria) this;
        }

        public Criteria andExpertSignLessThan(String value) {
            addCriterion("expert_sign <", value, "expertSign");
            return (Criteria) this;
        }

        public Criteria andExpertSignLessThanOrEqualTo(String value) {
            addCriterion("expert_sign <=", value, "expertSign");
            return (Criteria) this;
        }

        public Criteria andExpertSignLike(String value) {
            addCriterion("expert_sign like", value, "expertSign");
            return (Criteria) this;
        }

        public Criteria andExpertSignNotLike(String value) {
            addCriterion("expert_sign not like", value, "expertSign");
            return (Criteria) this;
        }

        public Criteria andExpertSignIn(List<String> values) {
            addCriterion("expert_sign in", values, "expertSign");
            return (Criteria) this;
        }

        public Criteria andExpertSignNotIn(List<String> values) {
            addCriterion("expert_sign not in", values, "expertSign");
            return (Criteria) this;
        }

        public Criteria andExpertSignBetween(String value1, String value2) {
            addCriterion("expert_sign between", value1, value2, "expertSign");
            return (Criteria) this;
        }

        public Criteria andExpertSignNotBetween(String value1, String value2) {
            addCriterion("expert_sign not between", value1, value2, "expertSign");
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