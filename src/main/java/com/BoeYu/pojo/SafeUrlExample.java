package com.BoeYu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SafeUrlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SafeUrlExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSafeTypeIsNull() {
            addCriterion("safe_type is null");
            return (Criteria) this;
        }

        public Criteria andSafeTypeIsNotNull() {
            addCriterion("safe_type is not null");
            return (Criteria) this;
        }

        public Criteria andSafeTypeEqualTo(String value) {
            addCriterion("safe_type =", value, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeNotEqualTo(String value) {
            addCriterion("safe_type <>", value, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeGreaterThan(String value) {
            addCriterion("safe_type >", value, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("safe_type >=", value, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeLessThan(String value) {
            addCriterion("safe_type <", value, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeLessThanOrEqualTo(String value) {
            addCriterion("safe_type <=", value, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeLike(String value) {
            addCriterion("safe_type like", value, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeNotLike(String value) {
            addCriterion("safe_type not like", value, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeIn(List<String> values) {
            addCriterion("safe_type in", values, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeNotIn(List<String> values) {
            addCriterion("safe_type not in", values, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeBetween(String value1, String value2) {
            addCriterion("safe_type between", value1, value2, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeTypeNotBetween(String value1, String value2) {
            addCriterion("safe_type not between", value1, value2, "safeType");
            return (Criteria) this;
        }

        public Criteria andSafeContentIsNull() {
            addCriterion("safe_content is null");
            return (Criteria) this;
        }

        public Criteria andSafeContentIsNotNull() {
            addCriterion("safe_content is not null");
            return (Criteria) this;
        }

        public Criteria andSafeContentEqualTo(String value) {
            addCriterion("safe_content =", value, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentNotEqualTo(String value) {
            addCriterion("safe_content <>", value, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentGreaterThan(String value) {
            addCriterion("safe_content >", value, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentGreaterThanOrEqualTo(String value) {
            addCriterion("safe_content >=", value, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentLessThan(String value) {
            addCriterion("safe_content <", value, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentLessThanOrEqualTo(String value) {
            addCriterion("safe_content <=", value, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentLike(String value) {
            addCriterion("safe_content like", value, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentNotLike(String value) {
            addCriterion("safe_content not like", value, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentIn(List<String> values) {
            addCriterion("safe_content in", values, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentNotIn(List<String> values) {
            addCriterion("safe_content not in", values, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentBetween(String value1, String value2) {
            addCriterion("safe_content between", value1, value2, "safeContent");
            return (Criteria) this;
        }

        public Criteria andSafeContentNotBetween(String value1, String value2) {
            addCriterion("safe_content not between", value1, value2, "safeContent");
            return (Criteria) this;
        }

        public Criteria andFkCustomerIdIsNull() {
            addCriterion("fk_customer_id is null");
            return (Criteria) this;
        }

        public Criteria andFkCustomerIdIsNotNull() {
            addCriterion("fk_customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andFkCustomerIdEqualTo(String value) {
            addCriterion("fk_customer_id =", value, "fkCustomerId");
            return (Criteria) this;
        }

        public Criteria andFkCustomerIdNotEqualTo(String value) {
            addCriterion("fk_customer_id <>", value, "fkCustomerId");
            return (Criteria) this;
        }

        public Criteria andFkCustomerIdGreaterThan(String value) {
            addCriterion("fk_customer_id >", value, "fkCustomerId");
            return (Criteria) this;
        }

        public Criteria andFkCustomerIdGreaterThanOrEqualTo(String value) {
            addCriterion("fk_customer_id >=", value, "fkCustomerId");
            return (Criteria) this;
        }

        public Criteria andFkCustomerIdLessThan(String value) {
            addCriterion("fk_customer_id <", value, "fkCustomerId");
            return (Criteria) this;
        }

        public Criteria andFkCustomerIdLessThanOrEqualTo(String value) {
            addCriterion("fk_customer_id <=", value, "fkCustomerId");
            return (Criteria) this;
        }

        public Criteria andFkCustomerIdLike(String value) {
            addCriterion("fk_customer_id like", value, "fkCustomerId");
            return (Criteria) this;
        }

        public Criteria andFkCustomerIdNotLike(String value) {
            addCriterion("fk_customer_id not like", value, "fkCustomerId");
            return (Criteria) this;
        }

        public Criteria andFkCustomerIdIn(List<String> values) {
            addCriterion("fk_customer_id in", values, "fkCustomerId");
            return (Criteria) this;
        }

        public Criteria andFkCustomerIdNotIn(List<String> values) {
            addCriterion("fk_customer_id not in", values, "fkCustomerId");
            return (Criteria) this;
        }

        public Criteria andFkCustomerIdBetween(String value1, String value2) {
            addCriterion("fk_customer_id between", value1, value2, "fkCustomerId");
            return (Criteria) this;
        }

        public Criteria andFkCustomerIdNotBetween(String value1, String value2) {
            addCriterion("fk_customer_id not between", value1, value2, "fkCustomerId");
            return (Criteria) this;
        }

        public Criteria andFkChildIdIsNull() {
            addCriterion("fk_child_id is null");
            return (Criteria) this;
        }

        public Criteria andFkChildIdIsNotNull() {
            addCriterion("fk_child_id is not null");
            return (Criteria) this;
        }

        public Criteria andFkChildIdEqualTo(String value) {
            addCriterion("fk_child_id =", value, "fkChildId");
            return (Criteria) this;
        }

        public Criteria andFkChildIdNotEqualTo(String value) {
            addCriterion("fk_child_id <>", value, "fkChildId");
            return (Criteria) this;
        }

        public Criteria andFkChildIdGreaterThan(String value) {
            addCriterion("fk_child_id >", value, "fkChildId");
            return (Criteria) this;
        }

        public Criteria andFkChildIdGreaterThanOrEqualTo(String value) {
            addCriterion("fk_child_id >=", value, "fkChildId");
            return (Criteria) this;
        }

        public Criteria andFkChildIdLessThan(String value) {
            addCriterion("fk_child_id <", value, "fkChildId");
            return (Criteria) this;
        }

        public Criteria andFkChildIdLessThanOrEqualTo(String value) {
            addCriterion("fk_child_id <=", value, "fkChildId");
            return (Criteria) this;
        }

        public Criteria andFkChildIdLike(String value) {
            addCriterion("fk_child_id like", value, "fkChildId");
            return (Criteria) this;
        }

        public Criteria andFkChildIdNotLike(String value) {
            addCriterion("fk_child_id not like", value, "fkChildId");
            return (Criteria) this;
        }

        public Criteria andFkChildIdIn(List<String> values) {
            addCriterion("fk_child_id in", values, "fkChildId");
            return (Criteria) this;
        }

        public Criteria andFkChildIdNotIn(List<String> values) {
            addCriterion("fk_child_id not in", values, "fkChildId");
            return (Criteria) this;
        }

        public Criteria andFkChildIdBetween(String value1, String value2) {
            addCriterion("fk_child_id between", value1, value2, "fkChildId");
            return (Criteria) this;
        }

        public Criteria andFkChildIdNotBetween(String value1, String value2) {
            addCriterion("fk_child_id not between", value1, value2, "fkChildId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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