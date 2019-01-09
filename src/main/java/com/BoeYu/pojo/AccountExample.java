package com.BoeYu.pojo;

import java.util.ArrayList;
import java.util.List;

public class AccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountExample() {
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

        public Criteria andFkPartnerIdIsNull() {
            addCriterion("fk_partner_id is null");
            return (Criteria) this;
        }

        public Criteria andFkPartnerIdIsNotNull() {
            addCriterion("fk_partner_id is not null");
            return (Criteria) this;
        }

        public Criteria andFkPartnerIdEqualTo(String value) {
            addCriterion("fk_partner_id =", value, "fkPartnerId");
            return (Criteria) this;
        }

        public Criteria andFkPartnerIdNotEqualTo(String value) {
            addCriterion("fk_partner_id <>", value, "fkPartnerId");
            return (Criteria) this;
        }

        public Criteria andFkPartnerIdGreaterThan(String value) {
            addCriterion("fk_partner_id >", value, "fkPartnerId");
            return (Criteria) this;
        }

        public Criteria andFkPartnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("fk_partner_id >=", value, "fkPartnerId");
            return (Criteria) this;
        }

        public Criteria andFkPartnerIdLessThan(String value) {
            addCriterion("fk_partner_id <", value, "fkPartnerId");
            return (Criteria) this;
        }

        public Criteria andFkPartnerIdLessThanOrEqualTo(String value) {
            addCriterion("fk_partner_id <=", value, "fkPartnerId");
            return (Criteria) this;
        }

        public Criteria andFkPartnerIdLike(String value) {
            addCriterion("fk_partner_id like", value, "fkPartnerId");
            return (Criteria) this;
        }

        public Criteria andFkPartnerIdNotLike(String value) {
            addCriterion("fk_partner_id not like", value, "fkPartnerId");
            return (Criteria) this;
        }

        public Criteria andFkPartnerIdIn(List<String> values) {
            addCriterion("fk_partner_id in", values, "fkPartnerId");
            return (Criteria) this;
        }

        public Criteria andFkPartnerIdNotIn(List<String> values) {
            addCriterion("fk_partner_id not in", values, "fkPartnerId");
            return (Criteria) this;
        }

        public Criteria andFkPartnerIdBetween(String value1, String value2) {
            addCriterion("fk_partner_id between", value1, value2, "fkPartnerId");
            return (Criteria) this;
        }

        public Criteria andFkPartnerIdNotBetween(String value1, String value2) {
            addCriterion("fk_partner_id not between", value1, value2, "fkPartnerId");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(String value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(String value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(String value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(String value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(String value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLike(String value) {
            addCriterion("money like", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotLike(String value) {
            addCriterion("money not like", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<String> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<String> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(String value1, String value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(String value1, String value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andSmoneyIsNull() {
            addCriterion("smoney is null");
            return (Criteria) this;
        }

        public Criteria andSmoneyIsNotNull() {
            addCriterion("smoney is not null");
            return (Criteria) this;
        }

        public Criteria andSmoneyEqualTo(String value) {
            addCriterion("smoney =", value, "smoney");
            return (Criteria) this;
        }

        public Criteria andSmoneyNotEqualTo(String value) {
            addCriterion("smoney <>", value, "smoney");
            return (Criteria) this;
        }

        public Criteria andSmoneyGreaterThan(String value) {
            addCriterion("smoney >", value, "smoney");
            return (Criteria) this;
        }

        public Criteria andSmoneyGreaterThanOrEqualTo(String value) {
            addCriterion("smoney >=", value, "smoney");
            return (Criteria) this;
        }

        public Criteria andSmoneyLessThan(String value) {
            addCriterion("smoney <", value, "smoney");
            return (Criteria) this;
        }

        public Criteria andSmoneyLessThanOrEqualTo(String value) {
            addCriterion("smoney <=", value, "smoney");
            return (Criteria) this;
        }

        public Criteria andSmoneyLike(String value) {
            addCriterion("smoney like", value, "smoney");
            return (Criteria) this;
        }

        public Criteria andSmoneyNotLike(String value) {
            addCriterion("smoney not like", value, "smoney");
            return (Criteria) this;
        }

        public Criteria andSmoneyIn(List<String> values) {
            addCriterion("smoney in", values, "smoney");
            return (Criteria) this;
        }

        public Criteria andSmoneyNotIn(List<String> values) {
            addCriterion("smoney not in", values, "smoney");
            return (Criteria) this;
        }

        public Criteria andSmoneyBetween(String value1, String value2) {
            addCriterion("smoney between", value1, value2, "smoney");
            return (Criteria) this;
        }

        public Criteria andSmoneyNotBetween(String value1, String value2) {
            addCriterion("smoney not between", value1, value2, "smoney");
            return (Criteria) this;
        }

        public Criteria andTmoneyIsNull() {
            addCriterion("tmoney is null");
            return (Criteria) this;
        }

        public Criteria andTmoneyIsNotNull() {
            addCriterion("tmoney is not null");
            return (Criteria) this;
        }

        public Criteria andTmoneyEqualTo(String value) {
            addCriterion("tmoney =", value, "tmoney");
            return (Criteria) this;
        }

        public Criteria andTmoneyNotEqualTo(String value) {
            addCriterion("tmoney <>", value, "tmoney");
            return (Criteria) this;
        }

        public Criteria andTmoneyGreaterThan(String value) {
            addCriterion("tmoney >", value, "tmoney");
            return (Criteria) this;
        }

        public Criteria andTmoneyGreaterThanOrEqualTo(String value) {
            addCriterion("tmoney >=", value, "tmoney");
            return (Criteria) this;
        }

        public Criteria andTmoneyLessThan(String value) {
            addCriterion("tmoney <", value, "tmoney");
            return (Criteria) this;
        }

        public Criteria andTmoneyLessThanOrEqualTo(String value) {
            addCriterion("tmoney <=", value, "tmoney");
            return (Criteria) this;
        }

        public Criteria andTmoneyLike(String value) {
            addCriterion("tmoney like", value, "tmoney");
            return (Criteria) this;
        }

        public Criteria andTmoneyNotLike(String value) {
            addCriterion("tmoney not like", value, "tmoney");
            return (Criteria) this;
        }

        public Criteria andTmoneyIn(List<String> values) {
            addCriterion("tmoney in", values, "tmoney");
            return (Criteria) this;
        }

        public Criteria andTmoneyNotIn(List<String> values) {
            addCriterion("tmoney not in", values, "tmoney");
            return (Criteria) this;
        }

        public Criteria andTmoneyBetween(String value1, String value2) {
            addCriterion("tmoney between", value1, value2, "tmoney");
            return (Criteria) this;
        }

        public Criteria andTmoneyNotBetween(String value1, String value2) {
            addCriterion("tmoney not between", value1, value2, "tmoney");
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