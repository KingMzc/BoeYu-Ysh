package com.BoeYu.pojo;

import java.util.ArrayList;
import java.util.List;

public class TestoneExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestoneExample() {
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

        public Criteria andAsdaIsNull() {
            addCriterion("asda is null");
            return (Criteria) this;
        }

        public Criteria andAsdaIsNotNull() {
            addCriterion("asda is not null");
            return (Criteria) this;
        }

        public Criteria andAsdaEqualTo(String value) {
            addCriterion("asda =", value, "asda");
            return (Criteria) this;
        }

        public Criteria andAsdaNotEqualTo(String value) {
            addCriterion("asda <>", value, "asda");
            return (Criteria) this;
        }

        public Criteria andAsdaGreaterThan(String value) {
            addCriterion("asda >", value, "asda");
            return (Criteria) this;
        }

        public Criteria andAsdaGreaterThanOrEqualTo(String value) {
            addCriterion("asda >=", value, "asda");
            return (Criteria) this;
        }

        public Criteria andAsdaLessThan(String value) {
            addCriterion("asda <", value, "asda");
            return (Criteria) this;
        }

        public Criteria andAsdaLessThanOrEqualTo(String value) {
            addCriterion("asda <=", value, "asda");
            return (Criteria) this;
        }

        public Criteria andAsdaLike(String value) {
            addCriterion("asda like", value, "asda");
            return (Criteria) this;
        }

        public Criteria andAsdaNotLike(String value) {
            addCriterion("asda not like", value, "asda");
            return (Criteria) this;
        }

        public Criteria andAsdaIn(List<String> values) {
            addCriterion("asda in", values, "asda");
            return (Criteria) this;
        }

        public Criteria andAsdaNotIn(List<String> values) {
            addCriterion("asda not in", values, "asda");
            return (Criteria) this;
        }

        public Criteria andAsdaBetween(String value1, String value2) {
            addCriterion("asda between", value1, value2, "asda");
            return (Criteria) this;
        }

        public Criteria andAsdaNotBetween(String value1, String value2) {
            addCriterion("asda not between", value1, value2, "asda");
            return (Criteria) this;
        }

        public Criteria andAsdasIsNull() {
            addCriterion("asdas is null");
            return (Criteria) this;
        }

        public Criteria andAsdasIsNotNull() {
            addCriterion("asdas is not null");
            return (Criteria) this;
        }

        public Criteria andAsdasEqualTo(String value) {
            addCriterion("asdas =", value, "asdas");
            return (Criteria) this;
        }

        public Criteria andAsdasNotEqualTo(String value) {
            addCriterion("asdas <>", value, "asdas");
            return (Criteria) this;
        }

        public Criteria andAsdasGreaterThan(String value) {
            addCriterion("asdas >", value, "asdas");
            return (Criteria) this;
        }

        public Criteria andAsdasGreaterThanOrEqualTo(String value) {
            addCriterion("asdas >=", value, "asdas");
            return (Criteria) this;
        }

        public Criteria andAsdasLessThan(String value) {
            addCriterion("asdas <", value, "asdas");
            return (Criteria) this;
        }

        public Criteria andAsdasLessThanOrEqualTo(String value) {
            addCriterion("asdas <=", value, "asdas");
            return (Criteria) this;
        }

        public Criteria andAsdasLike(String value) {
            addCriterion("asdas like", value, "asdas");
            return (Criteria) this;
        }

        public Criteria andAsdasNotLike(String value) {
            addCriterion("asdas not like", value, "asdas");
            return (Criteria) this;
        }

        public Criteria andAsdasIn(List<String> values) {
            addCriterion("asdas in", values, "asdas");
            return (Criteria) this;
        }

        public Criteria andAsdasNotIn(List<String> values) {
            addCriterion("asdas not in", values, "asdas");
            return (Criteria) this;
        }

        public Criteria andAsdasBetween(String value1, String value2) {
            addCriterion("asdas between", value1, value2, "asdas");
            return (Criteria) this;
        }

        public Criteria andAsdasNotBetween(String value1, String value2) {
            addCriterion("asdas not between", value1, value2, "asdas");
            return (Criteria) this;
        }

        public Criteria andRtyIsNull() {
            addCriterion("rty is null");
            return (Criteria) this;
        }

        public Criteria andRtyIsNotNull() {
            addCriterion("rty is not null");
            return (Criteria) this;
        }

        public Criteria andRtyEqualTo(String value) {
            addCriterion("rty =", value, "rty");
            return (Criteria) this;
        }

        public Criteria andRtyNotEqualTo(String value) {
            addCriterion("rty <>", value, "rty");
            return (Criteria) this;
        }

        public Criteria andRtyGreaterThan(String value) {
            addCriterion("rty >", value, "rty");
            return (Criteria) this;
        }

        public Criteria andRtyGreaterThanOrEqualTo(String value) {
            addCriterion("rty >=", value, "rty");
            return (Criteria) this;
        }

        public Criteria andRtyLessThan(String value) {
            addCriterion("rty <", value, "rty");
            return (Criteria) this;
        }

        public Criteria andRtyLessThanOrEqualTo(String value) {
            addCriterion("rty <=", value, "rty");
            return (Criteria) this;
        }

        public Criteria andRtyLike(String value) {
            addCriterion("rty like", value, "rty");
            return (Criteria) this;
        }

        public Criteria andRtyNotLike(String value) {
            addCriterion("rty not like", value, "rty");
            return (Criteria) this;
        }

        public Criteria andRtyIn(List<String> values) {
            addCriterion("rty in", values, "rty");
            return (Criteria) this;
        }

        public Criteria andRtyNotIn(List<String> values) {
            addCriterion("rty not in", values, "rty");
            return (Criteria) this;
        }

        public Criteria andRtyBetween(String value1, String value2) {
            addCriterion("rty between", value1, value2, "rty");
            return (Criteria) this;
        }

        public Criteria andRtyNotBetween(String value1, String value2) {
            addCriterion("rty not between", value1, value2, "rty");
            return (Criteria) this;
        }

        public Criteria andTyhertyIsNull() {
            addCriterion("tyherty is null");
            return (Criteria) this;
        }

        public Criteria andTyhertyIsNotNull() {
            addCriterion("tyherty is not null");
            return (Criteria) this;
        }

        public Criteria andTyhertyEqualTo(String value) {
            addCriterion("tyherty =", value, "tyherty");
            return (Criteria) this;
        }

        public Criteria andTyhertyNotEqualTo(String value) {
            addCriterion("tyherty <>", value, "tyherty");
            return (Criteria) this;
        }

        public Criteria andTyhertyGreaterThan(String value) {
            addCriterion("tyherty >", value, "tyherty");
            return (Criteria) this;
        }

        public Criteria andTyhertyGreaterThanOrEqualTo(String value) {
            addCriterion("tyherty >=", value, "tyherty");
            return (Criteria) this;
        }

        public Criteria andTyhertyLessThan(String value) {
            addCriterion("tyherty <", value, "tyherty");
            return (Criteria) this;
        }

        public Criteria andTyhertyLessThanOrEqualTo(String value) {
            addCriterion("tyherty <=", value, "tyherty");
            return (Criteria) this;
        }

        public Criteria andTyhertyLike(String value) {
            addCriterion("tyherty like", value, "tyherty");
            return (Criteria) this;
        }

        public Criteria andTyhertyNotLike(String value) {
            addCriterion("tyherty not like", value, "tyherty");
            return (Criteria) this;
        }

        public Criteria andTyhertyIn(List<String> values) {
            addCriterion("tyherty in", values, "tyherty");
            return (Criteria) this;
        }

        public Criteria andTyhertyNotIn(List<String> values) {
            addCriterion("tyherty not in", values, "tyherty");
            return (Criteria) this;
        }

        public Criteria andTyhertyBetween(String value1, String value2) {
            addCriterion("tyherty between", value1, value2, "tyherty");
            return (Criteria) this;
        }

        public Criteria andTyhertyNotBetween(String value1, String value2) {
            addCriterion("tyherty not between", value1, value2, "tyherty");
            return (Criteria) this;
        }

        public Criteria andTreIsNull() {
            addCriterion("tre is null");
            return (Criteria) this;
        }

        public Criteria andTreIsNotNull() {
            addCriterion("tre is not null");
            return (Criteria) this;
        }

        public Criteria andTreEqualTo(String value) {
            addCriterion("tre =", value, "tre");
            return (Criteria) this;
        }

        public Criteria andTreNotEqualTo(String value) {
            addCriterion("tre <>", value, "tre");
            return (Criteria) this;
        }

        public Criteria andTreGreaterThan(String value) {
            addCriterion("tre >", value, "tre");
            return (Criteria) this;
        }

        public Criteria andTreGreaterThanOrEqualTo(String value) {
            addCriterion("tre >=", value, "tre");
            return (Criteria) this;
        }

        public Criteria andTreLessThan(String value) {
            addCriterion("tre <", value, "tre");
            return (Criteria) this;
        }

        public Criteria andTreLessThanOrEqualTo(String value) {
            addCriterion("tre <=", value, "tre");
            return (Criteria) this;
        }

        public Criteria andTreLike(String value) {
            addCriterion("tre like", value, "tre");
            return (Criteria) this;
        }

        public Criteria andTreNotLike(String value) {
            addCriterion("tre not like", value, "tre");
            return (Criteria) this;
        }

        public Criteria andTreIn(List<String> values) {
            addCriterion("tre in", values, "tre");
            return (Criteria) this;
        }

        public Criteria andTreNotIn(List<String> values) {
            addCriterion("tre not in", values, "tre");
            return (Criteria) this;
        }

        public Criteria andTreBetween(String value1, String value2) {
            addCriterion("tre between", value1, value2, "tre");
            return (Criteria) this;
        }

        public Criteria andTreNotBetween(String value1, String value2) {
            addCriterion("tre not between", value1, value2, "tre");
            return (Criteria) this;
        }

        public Criteria andBbbIsNull() {
            addCriterion("bbb is null");
            return (Criteria) this;
        }

        public Criteria andBbbIsNotNull() {
            addCriterion("bbb is not null");
            return (Criteria) this;
        }

        public Criteria andBbbEqualTo(String value) {
            addCriterion("bbb =", value, "bbb");
            return (Criteria) this;
        }

        public Criteria andBbbNotEqualTo(String value) {
            addCriterion("bbb <>", value, "bbb");
            return (Criteria) this;
        }

        public Criteria andBbbGreaterThan(String value) {
            addCriterion("bbb >", value, "bbb");
            return (Criteria) this;
        }

        public Criteria andBbbGreaterThanOrEqualTo(String value) {
            addCriterion("bbb >=", value, "bbb");
            return (Criteria) this;
        }

        public Criteria andBbbLessThan(String value) {
            addCriterion("bbb <", value, "bbb");
            return (Criteria) this;
        }

        public Criteria andBbbLessThanOrEqualTo(String value) {
            addCriterion("bbb <=", value, "bbb");
            return (Criteria) this;
        }

        public Criteria andBbbLike(String value) {
            addCriterion("bbb like", value, "bbb");
            return (Criteria) this;
        }

        public Criteria andBbbNotLike(String value) {
            addCriterion("bbb not like", value, "bbb");
            return (Criteria) this;
        }

        public Criteria andBbbIn(List<String> values) {
            addCriterion("bbb in", values, "bbb");
            return (Criteria) this;
        }

        public Criteria andBbbNotIn(List<String> values) {
            addCriterion("bbb not in", values, "bbb");
            return (Criteria) this;
        }

        public Criteria andBbbBetween(String value1, String value2) {
            addCriterion("bbb between", value1, value2, "bbb");
            return (Criteria) this;
        }

        public Criteria andBbbNotBetween(String value1, String value2) {
            addCriterion("bbb not between", value1, value2, "bbb");
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