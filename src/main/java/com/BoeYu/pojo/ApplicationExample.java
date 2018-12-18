package com.BoeYu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplicationExample() {
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

        public Criteria andApplicationTypeIsNull() {
            addCriterion("application_type is null");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeIsNotNull() {
            addCriterion("application_type is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeEqualTo(String value) {
            addCriterion("application_type =", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeNotEqualTo(String value) {
            addCriterion("application_type <>", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeGreaterThan(String value) {
            addCriterion("application_type >", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("application_type >=", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeLessThan(String value) {
            addCriterion("application_type <", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeLessThanOrEqualTo(String value) {
            addCriterion("application_type <=", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeLike(String value) {
            addCriterion("application_type like", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeNotLike(String value) {
            addCriterion("application_type not like", value, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeIn(List<String> values) {
            addCriterion("application_type in", values, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeNotIn(List<String> values) {
            addCriterion("application_type not in", values, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeBetween(String value1, String value2) {
            addCriterion("application_type between", value1, value2, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationTypeNotBetween(String value1, String value2) {
            addCriterion("application_type not between", value1, value2, "applicationType");
            return (Criteria) this;
        }

        public Criteria andApplicationImgIsNull() {
            addCriterion("application_img is null");
            return (Criteria) this;
        }

        public Criteria andApplicationImgIsNotNull() {
            addCriterion("application_img is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationImgEqualTo(String value) {
            addCriterion("application_img =", value, "applicationImg");
            return (Criteria) this;
        }

        public Criteria andApplicationImgNotEqualTo(String value) {
            addCriterion("application_img <>", value, "applicationImg");
            return (Criteria) this;
        }

        public Criteria andApplicationImgGreaterThan(String value) {
            addCriterion("application_img >", value, "applicationImg");
            return (Criteria) this;
        }

        public Criteria andApplicationImgGreaterThanOrEqualTo(String value) {
            addCriterion("application_img >=", value, "applicationImg");
            return (Criteria) this;
        }

        public Criteria andApplicationImgLessThan(String value) {
            addCriterion("application_img <", value, "applicationImg");
            return (Criteria) this;
        }

        public Criteria andApplicationImgLessThanOrEqualTo(String value) {
            addCriterion("application_img <=", value, "applicationImg");
            return (Criteria) this;
        }

        public Criteria andApplicationImgLike(String value) {
            addCriterion("application_img like", value, "applicationImg");
            return (Criteria) this;
        }

        public Criteria andApplicationImgNotLike(String value) {
            addCriterion("application_img not like", value, "applicationImg");
            return (Criteria) this;
        }

        public Criteria andApplicationImgIn(List<String> values) {
            addCriterion("application_img in", values, "applicationImg");
            return (Criteria) this;
        }

        public Criteria andApplicationImgNotIn(List<String> values) {
            addCriterion("application_img not in", values, "applicationImg");
            return (Criteria) this;
        }

        public Criteria andApplicationImgBetween(String value1, String value2) {
            addCriterion("application_img between", value1, value2, "applicationImg");
            return (Criteria) this;
        }

        public Criteria andApplicationImgNotBetween(String value1, String value2) {
            addCriterion("application_img not between", value1, value2, "applicationImg");
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

        public Criteria andLockTypeIsNull() {
            addCriterion("lock_type is null");
            return (Criteria) this;
        }

        public Criteria andLockTypeIsNotNull() {
            addCriterion("lock_type is not null");
            return (Criteria) this;
        }

        public Criteria andLockTypeEqualTo(String value) {
            addCriterion("lock_type =", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeNotEqualTo(String value) {
            addCriterion("lock_type <>", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeGreaterThan(String value) {
            addCriterion("lock_type >", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeGreaterThanOrEqualTo(String value) {
            addCriterion("lock_type >=", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeLessThan(String value) {
            addCriterion("lock_type <", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeLessThanOrEqualTo(String value) {
            addCriterion("lock_type <=", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeLike(String value) {
            addCriterion("lock_type like", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeNotLike(String value) {
            addCriterion("lock_type not like", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeIn(List<String> values) {
            addCriterion("lock_type in", values, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeNotIn(List<String> values) {
            addCriterion("lock_type not in", values, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeBetween(String value1, String value2) {
            addCriterion("lock_type between", value1, value2, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeNotBetween(String value1, String value2) {
            addCriterion("lock_type not between", value1, value2, "lockType");
            return (Criteria) this;
        }

        public Criteria andAppTimeIsNull() {
            addCriterion("app_time is null");
            return (Criteria) this;
        }

        public Criteria andAppTimeIsNotNull() {
            addCriterion("app_time is not null");
            return (Criteria) this;
        }

        public Criteria andAppTimeEqualTo(String value) {
            addCriterion("app_time =", value, "appTime");
            return (Criteria) this;
        }

        public Criteria andAppTimeNotEqualTo(String value) {
            addCriterion("app_time <>", value, "appTime");
            return (Criteria) this;
        }

        public Criteria andAppTimeGreaterThan(String value) {
            addCriterion("app_time >", value, "appTime");
            return (Criteria) this;
        }

        public Criteria andAppTimeGreaterThanOrEqualTo(String value) {
            addCriterion("app_time >=", value, "appTime");
            return (Criteria) this;
        }

        public Criteria andAppTimeLessThan(String value) {
            addCriterion("app_time <", value, "appTime");
            return (Criteria) this;
        }

        public Criteria andAppTimeLessThanOrEqualTo(String value) {
            addCriterion("app_time <=", value, "appTime");
            return (Criteria) this;
        }

        public Criteria andAppTimeLike(String value) {
            addCriterion("app_time like", value, "appTime");
            return (Criteria) this;
        }

        public Criteria andAppTimeNotLike(String value) {
            addCriterion("app_time not like", value, "appTime");
            return (Criteria) this;
        }

        public Criteria andAppTimeIn(List<String> values) {
            addCriterion("app_time in", values, "appTime");
            return (Criteria) this;
        }

        public Criteria andAppTimeNotIn(List<String> values) {
            addCriterion("app_time not in", values, "appTime");
            return (Criteria) this;
        }

        public Criteria andAppTimeBetween(String value1, String value2) {
            addCriterion("app_time between", value1, value2, "appTime");
            return (Criteria) this;
        }

        public Criteria andAppTimeNotBetween(String value1, String value2) {
            addCriterion("app_time not between", value1, value2, "appTime");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIsNull() {
            addCriterion("application_id is null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIsNotNull() {
            addCriterion("application_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdEqualTo(String value) {
            addCriterion("application_id =", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotEqualTo(String value) {
            addCriterion("application_id <>", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThan(String value) {
            addCriterion("application_id >", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThanOrEqualTo(String value) {
            addCriterion("application_id >=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThan(String value) {
            addCriterion("application_id <", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThanOrEqualTo(String value) {
            addCriterion("application_id <=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLike(String value) {
            addCriterion("application_id like", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotLike(String value) {
            addCriterion("application_id not like", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIn(List<String> values) {
            addCriterion("application_id in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotIn(List<String> values) {
            addCriterion("application_id not in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdBetween(String value1, String value2) {
            addCriterion("application_id between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotBetween(String value1, String value2) {
            addCriterion("application_id not between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationNameIsNull() {
            addCriterion("application_name is null");
            return (Criteria) this;
        }

        public Criteria andApplicationNameIsNotNull() {
            addCriterion("application_name is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationNameEqualTo(String value) {
            addCriterion("application_name =", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameNotEqualTo(String value) {
            addCriterion("application_name <>", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameGreaterThan(String value) {
            addCriterion("application_name >", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameGreaterThanOrEqualTo(String value) {
            addCriterion("application_name >=", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameLessThan(String value) {
            addCriterion("application_name <", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameLessThanOrEqualTo(String value) {
            addCriterion("application_name <=", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameLike(String value) {
            addCriterion("application_name like", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameNotLike(String value) {
            addCriterion("application_name not like", value, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameIn(List<String> values) {
            addCriterion("application_name in", values, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameNotIn(List<String> values) {
            addCriterion("application_name not in", values, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameBetween(String value1, String value2) {
            addCriterion("application_name between", value1, value2, "applicationName");
            return (Criteria) this;
        }

        public Criteria andApplicationNameNotBetween(String value1, String value2) {
            addCriterion("application_name not between", value1, value2, "applicationName");
            return (Criteria) this;
        }

        public Criteria andAppUpdatetimeIsNull() {
            addCriterion("app_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andAppUpdatetimeIsNotNull() {
            addCriterion("app_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andAppUpdatetimeEqualTo(String value) {
            addCriterion("app_updatetime =", value, "appUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAppUpdatetimeNotEqualTo(String value) {
            addCriterion("app_updatetime <>", value, "appUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAppUpdatetimeGreaterThan(String value) {
            addCriterion("app_updatetime >", value, "appUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAppUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("app_updatetime >=", value, "appUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAppUpdatetimeLessThan(String value) {
            addCriterion("app_updatetime <", value, "appUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAppUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("app_updatetime <=", value, "appUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAppUpdatetimeLike(String value) {
            addCriterion("app_updatetime like", value, "appUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAppUpdatetimeNotLike(String value) {
            addCriterion("app_updatetime not like", value, "appUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAppUpdatetimeIn(List<String> values) {
            addCriterion("app_updatetime in", values, "appUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAppUpdatetimeNotIn(List<String> values) {
            addCriterion("app_updatetime not in", values, "appUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAppUpdatetimeBetween(String value1, String value2) {
            addCriterion("app_updatetime between", value1, value2, "appUpdatetime");
            return (Criteria) this;
        }

        public Criteria andAppUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("app_updatetime not between", value1, value2, "appUpdatetime");
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