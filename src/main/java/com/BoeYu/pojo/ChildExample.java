package com.BoeYu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChildExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChildExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andYearsIsNull() {
            addCriterion("years is null");
            return (Criteria) this;
        }

        public Criteria andYearsIsNotNull() {
            addCriterion("years is not null");
            return (Criteria) this;
        }

        public Criteria andYearsEqualTo(Date value) {
            addCriterion("years =", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsNotEqualTo(Date value) {
            addCriterion("years <>", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsGreaterThan(Date value) {
            addCriterion("years >", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsGreaterThanOrEqualTo(Date value) {
            addCriterion("years >=", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsLessThan(Date value) {
            addCriterion("years <", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsLessThanOrEqualTo(Date value) {
            addCriterion("years <=", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsIn(List<Date> values) {
            addCriterion("years in", values, "years");
            return (Criteria) this;
        }

        public Criteria andYearsNotIn(List<Date> values) {
            addCriterion("years not in", values, "years");
            return (Criteria) this;
        }

        public Criteria andYearsBetween(Date value1, Date value2) {
            addCriterion("years between", value1, value2, "years");
            return (Criteria) this;
        }

        public Criteria andYearsNotBetween(Date value1, Date value2) {
            addCriterion("years not between", value1, value2, "years");
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

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("flag like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("flag not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFkFamilyIdIsNull() {
            addCriterion("fk_family_id is null");
            return (Criteria) this;
        }

        public Criteria andFkFamilyIdIsNotNull() {
            addCriterion("fk_family_id is not null");
            return (Criteria) this;
        }

        public Criteria andFkFamilyIdEqualTo(String value) {
            addCriterion("fk_family_id =", value, "fkFamilyId");
            return (Criteria) this;
        }

        public Criteria andFkFamilyIdNotEqualTo(String value) {
            addCriterion("fk_family_id <>", value, "fkFamilyId");
            return (Criteria) this;
        }

        public Criteria andFkFamilyIdGreaterThan(String value) {
            addCriterion("fk_family_id >", value, "fkFamilyId");
            return (Criteria) this;
        }

        public Criteria andFkFamilyIdGreaterThanOrEqualTo(String value) {
            addCriterion("fk_family_id >=", value, "fkFamilyId");
            return (Criteria) this;
        }

        public Criteria andFkFamilyIdLessThan(String value) {
            addCriterion("fk_family_id <", value, "fkFamilyId");
            return (Criteria) this;
        }

        public Criteria andFkFamilyIdLessThanOrEqualTo(String value) {
            addCriterion("fk_family_id <=", value, "fkFamilyId");
            return (Criteria) this;
        }

        public Criteria andFkFamilyIdLike(String value) {
            addCriterion("fk_family_id like", value, "fkFamilyId");
            return (Criteria) this;
        }

        public Criteria andFkFamilyIdNotLike(String value) {
            addCriterion("fk_family_id not like", value, "fkFamilyId");
            return (Criteria) this;
        }

        public Criteria andFkFamilyIdIn(List<String> values) {
            addCriterion("fk_family_id in", values, "fkFamilyId");
            return (Criteria) this;
        }

        public Criteria andFkFamilyIdNotIn(List<String> values) {
            addCriterion("fk_family_id not in", values, "fkFamilyId");
            return (Criteria) this;
        }

        public Criteria andFkFamilyIdBetween(String value1, String value2) {
            addCriterion("fk_family_id between", value1, value2, "fkFamilyId");
            return (Criteria) this;
        }

        public Criteria andFkFamilyIdNotBetween(String value1, String value2) {
            addCriterion("fk_family_id not between", value1, value2, "fkFamilyId");
            return (Criteria) this;
        }

        public Criteria andFkImgIdIsNull() {
            addCriterion("fk_img_id is null");
            return (Criteria) this;
        }

        public Criteria andFkImgIdIsNotNull() {
            addCriterion("fk_img_id is not null");
            return (Criteria) this;
        }

        public Criteria andFkImgIdEqualTo(String value) {
            addCriterion("fk_img_id =", value, "fkImgId");
            return (Criteria) this;
        }

        public Criteria andFkImgIdNotEqualTo(String value) {
            addCriterion("fk_img_id <>", value, "fkImgId");
            return (Criteria) this;
        }

        public Criteria andFkImgIdGreaterThan(String value) {
            addCriterion("fk_img_id >", value, "fkImgId");
            return (Criteria) this;
        }

        public Criteria andFkImgIdGreaterThanOrEqualTo(String value) {
            addCriterion("fk_img_id >=", value, "fkImgId");
            return (Criteria) this;
        }

        public Criteria andFkImgIdLessThan(String value) {
            addCriterion("fk_img_id <", value, "fkImgId");
            return (Criteria) this;
        }

        public Criteria andFkImgIdLessThanOrEqualTo(String value) {
            addCriterion("fk_img_id <=", value, "fkImgId");
            return (Criteria) this;
        }

        public Criteria andFkImgIdLike(String value) {
            addCriterion("fk_img_id like", value, "fkImgId");
            return (Criteria) this;
        }

        public Criteria andFkImgIdNotLike(String value) {
            addCriterion("fk_img_id not like", value, "fkImgId");
            return (Criteria) this;
        }

        public Criteria andFkImgIdIn(List<String> values) {
            addCriterion("fk_img_id in", values, "fkImgId");
            return (Criteria) this;
        }

        public Criteria andFkImgIdNotIn(List<String> values) {
            addCriterion("fk_img_id not in", values, "fkImgId");
            return (Criteria) this;
        }

        public Criteria andFkImgIdBetween(String value1, String value2) {
            addCriterion("fk_img_id between", value1, value2, "fkImgId");
            return (Criteria) this;
        }

        public Criteria andFkImgIdNotBetween(String value1, String value2) {
            addCriterion("fk_img_id not between", value1, value2, "fkImgId");
            return (Criteria) this;
        }

        public Criteria andCoordinateIsNull() {
            addCriterion("coordinate is null");
            return (Criteria) this;
        }

        public Criteria andCoordinateIsNotNull() {
            addCriterion("coordinate is not null");
            return (Criteria) this;
        }

        public Criteria andCoordinateEqualTo(String value) {
            addCriterion("coordinate =", value, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateNotEqualTo(String value) {
            addCriterion("coordinate <>", value, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateGreaterThan(String value) {
            addCriterion("coordinate >", value, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateGreaterThanOrEqualTo(String value) {
            addCriterion("coordinate >=", value, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateLessThan(String value) {
            addCriterion("coordinate <", value, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateLessThanOrEqualTo(String value) {
            addCriterion("coordinate <=", value, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateLike(String value) {
            addCriterion("coordinate like", value, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateNotLike(String value) {
            addCriterion("coordinate not like", value, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateIn(List<String> values) {
            addCriterion("coordinate in", values, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateNotIn(List<String> values) {
            addCriterion("coordinate not in", values, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateBetween(String value1, String value2) {
            addCriterion("coordinate between", value1, value2, "coordinate");
            return (Criteria) this;
        }

        public Criteria andCoordinateNotBetween(String value1, String value2) {
            addCriterion("coordinate not between", value1, value2, "coordinate");
            return (Criteria) this;
        }

        public Criteria andChildTypeIsNull() {
            addCriterion("child_type is null");
            return (Criteria) this;
        }

        public Criteria andChildTypeIsNotNull() {
            addCriterion("child_type is not null");
            return (Criteria) this;
        }

        public Criteria andChildTypeEqualTo(String value) {
            addCriterion("child_type =", value, "childType");
            return (Criteria) this;
        }

        public Criteria andChildTypeNotEqualTo(String value) {
            addCriterion("child_type <>", value, "childType");
            return (Criteria) this;
        }

        public Criteria andChildTypeGreaterThan(String value) {
            addCriterion("child_type >", value, "childType");
            return (Criteria) this;
        }

        public Criteria andChildTypeGreaterThanOrEqualTo(String value) {
            addCriterion("child_type >=", value, "childType");
            return (Criteria) this;
        }

        public Criteria andChildTypeLessThan(String value) {
            addCriterion("child_type <", value, "childType");
            return (Criteria) this;
        }

        public Criteria andChildTypeLessThanOrEqualTo(String value) {
            addCriterion("child_type <=", value, "childType");
            return (Criteria) this;
        }

        public Criteria andChildTypeLike(String value) {
            addCriterion("child_type like", value, "childType");
            return (Criteria) this;
        }

        public Criteria andChildTypeNotLike(String value) {
            addCriterion("child_type not like", value, "childType");
            return (Criteria) this;
        }

        public Criteria andChildTypeIn(List<String> values) {
            addCriterion("child_type in", values, "childType");
            return (Criteria) this;
        }

        public Criteria andChildTypeNotIn(List<String> values) {
            addCriterion("child_type not in", values, "childType");
            return (Criteria) this;
        }

        public Criteria andChildTypeBetween(String value1, String value2) {
            addCriterion("child_type between", value1, value2, "childType");
            return (Criteria) this;
        }

        public Criteria andChildTypeNotBetween(String value1, String value2) {
            addCriterion("child_type not between", value1, value2, "childType");
            return (Criteria) this;
        }

        public Criteria andLockStartetimeIsNull() {
            addCriterion("lock_startetime is null");
            return (Criteria) this;
        }

        public Criteria andLockStartetimeIsNotNull() {
            addCriterion("lock_startetime is not null");
            return (Criteria) this;
        }

        public Criteria andLockStartetimeEqualTo(Date value) {
            addCriterion("lock_startetime =", value, "lockStartetime");
            return (Criteria) this;
        }

        public Criteria andLockStartetimeNotEqualTo(Date value) {
            addCriterion("lock_startetime <>", value, "lockStartetime");
            return (Criteria) this;
        }

        public Criteria andLockStartetimeGreaterThan(Date value) {
            addCriterion("lock_startetime >", value, "lockStartetime");
            return (Criteria) this;
        }

        public Criteria andLockStartetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lock_startetime >=", value, "lockStartetime");
            return (Criteria) this;
        }

        public Criteria andLockStartetimeLessThan(Date value) {
            addCriterion("lock_startetime <", value, "lockStartetime");
            return (Criteria) this;
        }

        public Criteria andLockStartetimeLessThanOrEqualTo(Date value) {
            addCriterion("lock_startetime <=", value, "lockStartetime");
            return (Criteria) this;
        }

        public Criteria andLockStartetimeIn(List<Date> values) {
            addCriterion("lock_startetime in", values, "lockStartetime");
            return (Criteria) this;
        }

        public Criteria andLockStartetimeNotIn(List<Date> values) {
            addCriterion("lock_startetime not in", values, "lockStartetime");
            return (Criteria) this;
        }

        public Criteria andLockStartetimeBetween(Date value1, Date value2) {
            addCriterion("lock_startetime between", value1, value2, "lockStartetime");
            return (Criteria) this;
        }

        public Criteria andLockStartetimeNotBetween(Date value1, Date value2) {
            addCriterion("lock_startetime not between", value1, value2, "lockStartetime");
            return (Criteria) this;
        }

        public Criteria andLockEndtimeIsNull() {
            addCriterion("lock_endtime is null");
            return (Criteria) this;
        }

        public Criteria andLockEndtimeIsNotNull() {
            addCriterion("lock_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andLockEndtimeEqualTo(Date value) {
            addCriterion("lock_endtime =", value, "lockEndtime");
            return (Criteria) this;
        }

        public Criteria andLockEndtimeNotEqualTo(Date value) {
            addCriterion("lock_endtime <>", value, "lockEndtime");
            return (Criteria) this;
        }

        public Criteria andLockEndtimeGreaterThan(Date value) {
            addCriterion("lock_endtime >", value, "lockEndtime");
            return (Criteria) this;
        }

        public Criteria andLockEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lock_endtime >=", value, "lockEndtime");
            return (Criteria) this;
        }

        public Criteria andLockEndtimeLessThan(Date value) {
            addCriterion("lock_endtime <", value, "lockEndtime");
            return (Criteria) this;
        }

        public Criteria andLockEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("lock_endtime <=", value, "lockEndtime");
            return (Criteria) this;
        }

        public Criteria andLockEndtimeIn(List<Date> values) {
            addCriterion("lock_endtime in", values, "lockEndtime");
            return (Criteria) this;
        }

        public Criteria andLockEndtimeNotIn(List<Date> values) {
            addCriterion("lock_endtime not in", values, "lockEndtime");
            return (Criteria) this;
        }

        public Criteria andLockEndtimeBetween(Date value1, Date value2) {
            addCriterion("lock_endtime between", value1, value2, "lockEndtime");
            return (Criteria) this;
        }

        public Criteria andLockEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("lock_endtime not between", value1, value2, "lockEndtime");
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