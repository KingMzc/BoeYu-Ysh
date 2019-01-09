package com.BoeYu.pojo;

import java.util.ArrayList;
import java.util.List;

public class CashlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CashlogExample() {
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

        public Criteria andNickNameLike(String value) {
            addCriterion("nickname like", value, "nickname");
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

        public Criteria andIdcardzIsNull() {
            addCriterion("idcardz is null");
            return (Criteria) this;
        }

        public Criteria andIdcardzIsNotNull() {
            addCriterion("idcardz is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardzEqualTo(String value) {
            addCriterion("idcardz =", value, "idcardz");
            return (Criteria) this;
        }

        public Criteria andIdcardzNotEqualTo(String value) {
            addCriterion("idcardz <>", value, "idcardz");
            return (Criteria) this;
        }

        public Criteria andIdcardzGreaterThan(String value) {
            addCriterion("idcardz >", value, "idcardz");
            return (Criteria) this;
        }

        public Criteria andIdcardzGreaterThanOrEqualTo(String value) {
            addCriterion("idcardz >=", value, "idcardz");
            return (Criteria) this;
        }

        public Criteria andIdcardzLessThan(String value) {
            addCriterion("idcardz <", value, "idcardz");
            return (Criteria) this;
        }

        public Criteria andIdcardzLessThanOrEqualTo(String value) {
            addCriterion("idcardz <=", value, "idcardz");
            return (Criteria) this;
        }

        public Criteria andIdcardzLike(String value) {
            addCriterion("idcardz like", value, "idcardz");
            return (Criteria) this;
        }

        public Criteria andIdcardzNotLike(String value) {
            addCriterion("idcardz not like", value, "idcardz");
            return (Criteria) this;
        }

        public Criteria andIdcardzIn(List<String> values) {
            addCriterion("idcardz in", values, "idcardz");
            return (Criteria) this;
        }

        public Criteria andIdcardzNotIn(List<String> values) {
            addCriterion("idcardz not in", values, "idcardz");
            return (Criteria) this;
        }

        public Criteria andIdcardzBetween(String value1, String value2) {
            addCriterion("idcardz between", value1, value2, "idcardz");
            return (Criteria) this;
        }

        public Criteria andIdcardzNotBetween(String value1, String value2) {
            addCriterion("idcardz not between", value1, value2, "idcardz");
            return (Criteria) this;
        }

        public Criteria andIdcardfIsNull() {
            addCriterion("idcardf is null");
            return (Criteria) this;
        }

        public Criteria andIdcardfIsNotNull() {
            addCriterion("idcardf is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardfEqualTo(String value) {
            addCriterion("idcardf =", value, "idcardf");
            return (Criteria) this;
        }

        public Criteria andIdcardfNotEqualTo(String value) {
            addCriterion("idcardf <>", value, "idcardf");
            return (Criteria) this;
        }

        public Criteria andIdcardfGreaterThan(String value) {
            addCriterion("idcardf >", value, "idcardf");
            return (Criteria) this;
        }

        public Criteria andIdcardfGreaterThanOrEqualTo(String value) {
            addCriterion("idcardf >=", value, "idcardf");
            return (Criteria) this;
        }

        public Criteria andIdcardfLessThan(String value) {
            addCriterion("idcardf <", value, "idcardf");
            return (Criteria) this;
        }

        public Criteria andIdcardfLessThanOrEqualTo(String value) {
            addCriterion("idcardf <=", value, "idcardf");
            return (Criteria) this;
        }

        public Criteria andIdcardfLike(String value) {
            addCriterion("idcardf like", value, "idcardf");
            return (Criteria) this;
        }

        public Criteria andIdcardfNotLike(String value) {
            addCriterion("idcardf not like", value, "idcardf");
            return (Criteria) this;
        }

        public Criteria andIdcardfIn(List<String> values) {
            addCriterion("idcardf in", values, "idcardf");
            return (Criteria) this;
        }

        public Criteria andIdcardfNotIn(List<String> values) {
            addCriterion("idcardf not in", values, "idcardf");
            return (Criteria) this;
        }

        public Criteria andIdcardfBetween(String value1, String value2) {
            addCriterion("idcardf between", value1, value2, "idcardf");
            return (Criteria) this;
        }

        public Criteria andIdcardfNotBetween(String value1, String value2) {
            addCriterion("idcardf not between", value1, value2, "idcardf");
            return (Criteria) this;
        }

        public Criteria andBankIsNull() {
            addCriterion("bank is null");
            return (Criteria) this;
        }

        public Criteria andBankIsNotNull() {
            addCriterion("bank is not null");
            return (Criteria) this;
        }

        public Criteria andBankEqualTo(String value) {
            addCriterion("bank =", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotEqualTo(String value) {
            addCriterion("bank <>", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThan(String value) {
            addCriterion("bank >", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankGreaterThanOrEqualTo(String value) {
            addCriterion("bank >=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThan(String value) {
            addCriterion("bank <", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLessThanOrEqualTo(String value) {
            addCriterion("bank <=", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankLike(String value) {
            addCriterion("bank like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotLike(String value) {
            addCriterion("bank not like", value, "bank");
            return (Criteria) this;
        }

        public Criteria andBankIn(List<String> values) {
            addCriterion("bank in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotIn(List<String> values) {
            addCriterion("bank not in", values, "bank");
            return (Criteria) this;
        }

        public Criteria andBankBetween(String value1, String value2) {
            addCriterion("bank between", value1, value2, "bank");
            return (Criteria) this;
        }

        public Criteria andBankNotBetween(String value1, String value2) {
            addCriterion("bank not between", value1, value2, "bank");
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

        public Criteria andAdnameIsNull() {
            addCriterion("adname is null");
            return (Criteria) this;
        }

        public Criteria andAdnameIsNotNull() {
            addCriterion("adname is not null");
            return (Criteria) this;
        }

        public Criteria andAdnameEqualTo(String value) {
            addCriterion("adname =", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameNotEqualTo(String value) {
            addCriterion("adname <>", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameGreaterThan(String value) {
            addCriterion("adname >", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameGreaterThanOrEqualTo(String value) {
            addCriterion("adname >=", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameLessThan(String value) {
            addCriterion("adname <", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameLessThanOrEqualTo(String value) {
            addCriterion("adname <=", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameLike(String value) {
            addCriterion("adname like", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameNotLike(String value) {
            addCriterion("adname not like", value, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameIn(List<String> values) {
            addCriterion("adname in", values, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameNotIn(List<String> values) {
            addCriterion("adname not in", values, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameBetween(String value1, String value2) {
            addCriterion("adname between", value1, value2, "adname");
            return (Criteria) this;
        }

        public Criteria andAdnameNotBetween(String value1, String value2) {
            addCriterion("adname not between", value1, value2, "adname");
            return (Criteria) this;
        }

        public Criteria andAdmsgIsNull() {
            addCriterion("admsg is null");
            return (Criteria) this;
        }

        public Criteria andAdmsgIsNotNull() {
            addCriterion("admsg is not null");
            return (Criteria) this;
        }

        public Criteria andAdmsgEqualTo(String value) {
            addCriterion("admsg =", value, "admsg");
            return (Criteria) this;
        }

        public Criteria andAdmsgNotEqualTo(String value) {
            addCriterion("admsg <>", value, "admsg");
            return (Criteria) this;
        }

        public Criteria andAdmsgGreaterThan(String value) {
            addCriterion("admsg >", value, "admsg");
            return (Criteria) this;
        }

        public Criteria andAdmsgGreaterThanOrEqualTo(String value) {
            addCriterion("admsg >=", value, "admsg");
            return (Criteria) this;
        }

        public Criteria andAdmsgLessThan(String value) {
            addCriterion("admsg <", value, "admsg");
            return (Criteria) this;
        }

        public Criteria andAdmsgLessThanOrEqualTo(String value) {
            addCriterion("admsg <=", value, "admsg");
            return (Criteria) this;
        }

        public Criteria andAdmsgLike(String value) {
            addCriterion("admsg like", value, "admsg");
            return (Criteria) this;
        }

        public Criteria andAdmsgNotLike(String value) {
            addCriterion("admsg not like", value, "admsg");
            return (Criteria) this;
        }

        public Criteria andAdmsgIn(List<String> values) {
            addCriterion("admsg in", values, "admsg");
            return (Criteria) this;
        }

        public Criteria andAdmsgNotIn(List<String> values) {
            addCriterion("admsg not in", values, "admsg");
            return (Criteria) this;
        }

        public Criteria andAdmsgBetween(String value1, String value2) {
            addCriterion("admsg between", value1, value2, "admsg");
            return (Criteria) this;
        }

        public Criteria andAdmsgNotBetween(String value1, String value2) {
            addCriterion("admsg not between", value1, value2, "admsg");
            return (Criteria) this;
        }

        public Criteria andZhanghuIsNull() {
            addCriterion("zhanghu is null");
            return (Criteria) this;
        }

        public Criteria andZhanghuIsNotNull() {
            addCriterion("zhanghu is not null");
            return (Criteria) this;
        }

        public Criteria andZhanghuEqualTo(String value) {
            addCriterion("zhanghu =", value, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuNotEqualTo(String value) {
            addCriterion("zhanghu <>", value, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuGreaterThan(String value) {
            addCriterion("zhanghu >", value, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuGreaterThanOrEqualTo(String value) {
            addCriterion("zhanghu >=", value, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuLessThan(String value) {
            addCriterion("zhanghu <", value, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuLessThanOrEqualTo(String value) {
            addCriterion("zhanghu <=", value, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuLike(String value) {
            addCriterion("zhanghu like", value, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuNotLike(String value) {
            addCriterion("zhanghu not like", value, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuIn(List<String> values) {
            addCriterion("zhanghu in", values, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuNotIn(List<String> values) {
            addCriterion("zhanghu not in", values, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuBetween(String value1, String value2) {
            addCriterion("zhanghu between", value1, value2, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andZhanghuNotBetween(String value1, String value2) {
            addCriterion("zhanghu not between", value1, value2, "zhanghu");
            return (Criteria) this;
        }

        public Criteria andBankidIsNull() {
            addCriterion("bankid is null");
            return (Criteria) this;
        }

        public Criteria andBankidIsNotNull() {
            addCriterion("bankid is not null");
            return (Criteria) this;
        }

        public Criteria andBankidEqualTo(String value) {
            addCriterion("bankid =", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotEqualTo(String value) {
            addCriterion("bankid <>", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidGreaterThan(String value) {
            addCriterion("bankid >", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidGreaterThanOrEqualTo(String value) {
            addCriterion("bankid >=", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidLessThan(String value) {
            addCriterion("bankid <", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidLessThanOrEqualTo(String value) {
            addCriterion("bankid <=", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidLike(String value) {
            addCriterion("bankid like", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotLike(String value) {
            addCriterion("bankid not like", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidIn(List<String> values) {
            addCriterion("bankid in", values, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotIn(List<String> values) {
            addCriterion("bankid not in", values, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidBetween(String value1, String value2) {
            addCriterion("bankid between", value1, value2, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotBetween(String value1, String value2) {
            addCriterion("bankid not between", value1, value2, "bankid");
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