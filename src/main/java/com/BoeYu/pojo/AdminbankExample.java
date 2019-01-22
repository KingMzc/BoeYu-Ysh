package com.BoeYu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminbankExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminbankExample() {
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

        public Criteria andFkAdminIdIsNull() {
            addCriterion("fk_admin_id is null");
            return (Criteria) this;
        }

        public Criteria andFkAdminIdIsNotNull() {
            addCriterion("fk_admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andFkAdminIdEqualTo(String value) {
            addCriterion("fk_admin_id =", value, "fkAdminId");
            return (Criteria) this;
        }

        public Criteria andFkAdminIdNotEqualTo(String value) {
            addCriterion("fk_admin_id <>", value, "fkAdminId");
            return (Criteria) this;
        }

        public Criteria andFkAdminIdGreaterThan(String value) {
            addCriterion("fk_admin_id >", value, "fkAdminId");
            return (Criteria) this;
        }

        public Criteria andFkAdminIdGreaterThanOrEqualTo(String value) {
            addCriterion("fk_admin_id >=", value, "fkAdminId");
            return (Criteria) this;
        }

        public Criteria andFkAdminIdLessThan(String value) {
            addCriterion("fk_admin_id <", value, "fkAdminId");
            return (Criteria) this;
        }

        public Criteria andFkAdminIdLessThanOrEqualTo(String value) {
            addCriterion("fk_admin_id <=", value, "fkAdminId");
            return (Criteria) this;
        }

        public Criteria andFkAdminIdLike(String value) {
            addCriterion("fk_admin_id like", value, "fkAdminId");
            return (Criteria) this;
        }

        public Criteria andFkAdminIdNotLike(String value) {
            addCriterion("fk_admin_id not like", value, "fkAdminId");
            return (Criteria) this;
        }

        public Criteria andFkAdminIdIn(List<String> values) {
            addCriterion("fk_admin_id in", values, "fkAdminId");
            return (Criteria) this;
        }

        public Criteria andFkAdminIdNotIn(List<String> values) {
            addCriterion("fk_admin_id not in", values, "fkAdminId");
            return (Criteria) this;
        }

        public Criteria andFkAdminIdBetween(String value1, String value2) {
            addCriterion("fk_admin_id between", value1, value2, "fkAdminId");
            return (Criteria) this;
        }

        public Criteria andFkAdminIdNotBetween(String value1, String value2) {
            addCriterion("fk_admin_id not between", value1, value2, "fkAdminId");
            return (Criteria) this;
        }

        public Criteria andBankimgIsNull() {
            addCriterion("bankimg is null");
            return (Criteria) this;
        }

        public Criteria andBankimgIsNotNull() {
            addCriterion("bankimg is not null");
            return (Criteria) this;
        }

        public Criteria andBankimgEqualTo(String value) {
            addCriterion("bankimg =", value, "bankimg");
            return (Criteria) this;
        }

        public Criteria andBankimgNotEqualTo(String value) {
            addCriterion("bankimg <>", value, "bankimg");
            return (Criteria) this;
        }

        public Criteria andBankimgGreaterThan(String value) {
            addCriterion("bankimg >", value, "bankimg");
            return (Criteria) this;
        }

        public Criteria andBankimgGreaterThanOrEqualTo(String value) {
            addCriterion("bankimg >=", value, "bankimg");
            return (Criteria) this;
        }

        public Criteria andBankimgLessThan(String value) {
            addCriterion("bankimg <", value, "bankimg");
            return (Criteria) this;
        }

        public Criteria andBankimgLessThanOrEqualTo(String value) {
            addCriterion("bankimg <=", value, "bankimg");
            return (Criteria) this;
        }

        public Criteria andBankimgLike(String value) {
            addCriterion("bankimg like", value, "bankimg");
            return (Criteria) this;
        }

        public Criteria andBankimgNotLike(String value) {
            addCriterion("bankimg not like", value, "bankimg");
            return (Criteria) this;
        }

        public Criteria andBankimgIn(List<String> values) {
            addCriterion("bankimg in", values, "bankimg");
            return (Criteria) this;
        }

        public Criteria andBankimgNotIn(List<String> values) {
            addCriterion("bankimg not in", values, "bankimg");
            return (Criteria) this;
        }

        public Criteria andBankimgBetween(String value1, String value2) {
            addCriterion("bankimg between", value1, value2, "bankimg");
            return (Criteria) this;
        }

        public Criteria andBankimgNotBetween(String value1, String value2) {
            addCriterion("bankimg not between", value1, value2, "bankimg");
            return (Criteria) this;
        }

        public Criteria andBankidIsNull() {
            addCriterion("bankId is null");
            return (Criteria) this;
        }

        public Criteria andBankidIsNotNull() {
            addCriterion("bankId is not null");
            return (Criteria) this;
        }

        public Criteria andBankidEqualTo(String value) {
            addCriterion("bankId =", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotEqualTo(String value) {
            addCriterion("bankId <>", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidGreaterThan(String value) {
            addCriterion("bankId >", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidGreaterThanOrEqualTo(String value) {
            addCriterion("bankId >=", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidLessThan(String value) {
            addCriterion("bankId <", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidLessThanOrEqualTo(String value) {
            addCriterion("bankId <=", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidLike(String value) {
            addCriterion("bankId like", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotLike(String value) {
            addCriterion("bankId not like", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidIn(List<String> values) {
            addCriterion("bankId in", values, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotIn(List<String> values) {
            addCriterion("bankId not in", values, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidBetween(String value1, String value2) {
            addCriterion("bankId between", value1, value2, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotBetween(String value1, String value2) {
            addCriterion("bankId not between", value1, value2, "bankid");
            return (Criteria) this;
        }

        public Criteria andBanknameIsNull() {
            addCriterion("bankname is null");
            return (Criteria) this;
        }

        public Criteria andBanknameIsNotNull() {
            addCriterion("bankname is not null");
            return (Criteria) this;
        }

        public Criteria andBanknameEqualTo(String value) {
            addCriterion("bankname =", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameNotEqualTo(String value) {
            addCriterion("bankname <>", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameGreaterThan(String value) {
            addCriterion("bankname >", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameGreaterThanOrEqualTo(String value) {
            addCriterion("bankname >=", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameLessThan(String value) {
            addCriterion("bankname <", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameLessThanOrEqualTo(String value) {
            addCriterion("bankname <=", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameLike(String value) {
            addCriterion("bankname like", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameNotLike(String value) {
            addCriterion("bankname not like", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameIn(List<String> values) {
            addCriterion("bankname in", values, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameNotIn(List<String> values) {
            addCriterion("bankname not in", values, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameBetween(String value1, String value2) {
            addCriterion("bankname between", value1, value2, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameNotBetween(String value1, String value2) {
            addCriterion("bankname not between", value1, value2, "bankname");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
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