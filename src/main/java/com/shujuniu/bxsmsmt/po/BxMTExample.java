package com.shujuniu.bxsmsmt.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BxMTExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BxMTExample() {
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
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBidIsNull() {
            addCriterion("BID is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("BID is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(String value) {
            addCriterion("BID =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(String value) {
            addCriterion("BID <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(String value) {
            addCriterion("BID >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(String value) {
            addCriterion("BID >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(String value) {
            addCriterion("BID <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(String value) {
            addCriterion("BID <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLike(String value) {
            addCriterion("BID like", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotLike(String value) {
            addCriterion("BID not like", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<String> values) {
            addCriterion("BID in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<String> values) {
            addCriterion("BID not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(String value1, String value2) {
            addCriterion("BID between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(String value1, String value2) {
            addCriterion("BID not between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("UID is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("UID is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("UID =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("UID <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("UID >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("UID >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("UID <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("UID <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("UID in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("UID not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("UID between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("UID not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andMsgidIsNull() {
            addCriterion("MsgId is null");
            return (Criteria) this;
        }

        public Criteria andMsgidIsNotNull() {
            addCriterion("MsgId is not null");
            return (Criteria) this;
        }

        public Criteria andMsgidEqualTo(String value) {
            addCriterion("MsgId =", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidNotEqualTo(String value) {
            addCriterion("MsgId <>", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidGreaterThan(String value) {
            addCriterion("MsgId >", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidGreaterThanOrEqualTo(String value) {
            addCriterion("MsgId >=", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidLessThan(String value) {
            addCriterion("MsgId <", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidLessThanOrEqualTo(String value) {
            addCriterion("MsgId <=", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidLike(String value) {
            addCriterion("MsgId like", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidNotLike(String value) {
            addCriterion("MsgId not like", value, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidIn(List<String> values) {
            addCriterion("MsgId in", values, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidNotIn(List<String> values) {
            addCriterion("MsgId not in", values, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidBetween(String value1, String value2) {
            addCriterion("MsgId between", value1, value2, "msgid");
            return (Criteria) this;
        }

        public Criteria andMsgidNotBetween(String value1, String value2) {
            addCriterion("MsgId not between", value1, value2, "msgid");
            return (Criteria) this;
        }

        public Criteria andGwidIsNull() {
            addCriterion("GwId is null");
            return (Criteria) this;
        }

        public Criteria andGwidIsNotNull() {
            addCriterion("GwId is not null");
            return (Criteria) this;
        }

        public Criteria andGwidEqualTo(Integer value) {
            addCriterion("GwId =", value, "gwid");
            return (Criteria) this;
        }

        public Criteria andGwidNotEqualTo(Integer value) {
            addCriterion("GwId <>", value, "gwid");
            return (Criteria) this;
        }

        public Criteria andGwidGreaterThan(Integer value) {
            addCriterion("GwId >", value, "gwid");
            return (Criteria) this;
        }

        public Criteria andGwidGreaterThanOrEqualTo(Integer value) {
            addCriterion("GwId >=", value, "gwid");
            return (Criteria) this;
        }

        public Criteria andGwidLessThan(Integer value) {
            addCriterion("GwId <", value, "gwid");
            return (Criteria) this;
        }

        public Criteria andGwidLessThanOrEqualTo(Integer value) {
            addCriterion("GwId <=", value, "gwid");
            return (Criteria) this;
        }

        public Criteria andGwidIn(List<Integer> values) {
            addCriterion("GwId in", values, "gwid");
            return (Criteria) this;
        }

        public Criteria andGwidNotIn(List<Integer> values) {
            addCriterion("GwId not in", values, "gwid");
            return (Criteria) this;
        }

        public Criteria andGwidBetween(Integer value1, Integer value2) {
            addCriterion("GwId between", value1, value2, "gwid");
            return (Criteria) this;
        }

        public Criteria andGwidNotBetween(Integer value1, Integer value2) {
            addCriterion("GwId not between", value1, value2, "gwid");
            return (Criteria) this;
        }

        public Criteria andMbIsNull() {
            addCriterion("MB is null");
            return (Criteria) this;
        }

        public Criteria andMbIsNotNull() {
            addCriterion("MB is not null");
            return (Criteria) this;
        }

        public Criteria andMbEqualTo(String value) {
            addCriterion("MB =", value, "mb");
            return (Criteria) this;
        }

        public Criteria andMbNotEqualTo(String value) {
            addCriterion("MB <>", value, "mb");
            return (Criteria) this;
        }

        public Criteria andMbGreaterThan(String value) {
            addCriterion("MB >", value, "mb");
            return (Criteria) this;
        }

        public Criteria andMbGreaterThanOrEqualTo(String value) {
            addCriterion("MB >=", value, "mb");
            return (Criteria) this;
        }

        public Criteria andMbLessThan(String value) {
            addCriterion("MB <", value, "mb");
            return (Criteria) this;
        }

        public Criteria andMbLessThanOrEqualTo(String value) {
            addCriterion("MB <=", value, "mb");
            return (Criteria) this;
        }

        public Criteria andMbLike(String value) {
            addCriterion("MB like", value, "mb");
            return (Criteria) this;
        }

        public Criteria andMbNotLike(String value) {
            addCriterion("MB not like", value, "mb");
            return (Criteria) this;
        }

        public Criteria andMbIn(List<String> values) {
            addCriterion("MB in", values, "mb");
            return (Criteria) this;
        }

        public Criteria andMbNotIn(List<String> values) {
            addCriterion("MB not in", values, "mb");
            return (Criteria) this;
        }

        public Criteria andMbBetween(String value1, String value2) {
            addCriterion("MB between", value1, value2, "mb");
            return (Criteria) this;
        }

        public Criteria andMbNotBetween(String value1, String value2) {
            addCriterion("MB not between", value1, value2, "mb");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("CTime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("CTime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(Date value) {
            addCriterion("CTime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(Date value) {
            addCriterion("CTime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(Date value) {
            addCriterion("CTime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CTime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(Date value) {
            addCriterion("CTime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(Date value) {
            addCriterion("CTime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<Date> values) {
            addCriterion("CTime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<Date> values) {
            addCriterion("CTime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(Date value1, Date value2) {
            addCriterion("CTime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(Date value1, Date value2) {
            addCriterion("CTime not between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andRetIsNull() {
            addCriterion("Ret is null");
            return (Criteria) this;
        }

        public Criteria andRetIsNotNull() {
            addCriterion("Ret is not null");
            return (Criteria) this;
        }

        public Criteria andRetEqualTo(String value) {
            addCriterion("Ret =", value, "ret");
            return (Criteria) this;
        }

        public Criteria andRetNotEqualTo(String value) {
            addCriterion("Ret <>", value, "ret");
            return (Criteria) this;
        }

        public Criteria andRetGreaterThan(String value) {
            addCriterion("Ret >", value, "ret");
            return (Criteria) this;
        }

        public Criteria andRetGreaterThanOrEqualTo(String value) {
            addCriterion("Ret >=", value, "ret");
            return (Criteria) this;
        }

        public Criteria andRetLessThan(String value) {
            addCriterion("Ret <", value, "ret");
            return (Criteria) this;
        }

        public Criteria andRetLessThanOrEqualTo(String value) {
            addCriterion("Ret <=", value, "ret");
            return (Criteria) this;
        }

        public Criteria andRetLike(String value) {
            addCriterion("Ret like", value, "ret");
            return (Criteria) this;
        }

        public Criteria andRetNotLike(String value) {
            addCriterion("Ret not like", value, "ret");
            return (Criteria) this;
        }

        public Criteria andRetIn(List<String> values) {
            addCriterion("Ret in", values, "ret");
            return (Criteria) this;
        }

        public Criteria andRetNotIn(List<String> values) {
            addCriterion("Ret not in", values, "ret");
            return (Criteria) this;
        }

        public Criteria andRetBetween(String value1, String value2) {
            addCriterion("Ret between", value1, value2, "ret");
            return (Criteria) this;
        }

        public Criteria andRetNotBetween(String value1, String value2) {
            addCriterion("Ret not between", value1, value2, "ret");
            return (Criteria) this;
        }

        public Criteria andStatIsNull() {
            addCriterion("Stat is null");
            return (Criteria) this;
        }

        public Criteria andStatIsNotNull() {
            addCriterion("Stat is not null");
            return (Criteria) this;
        }

        public Criteria andStatEqualTo(String value) {
            addCriterion("Stat =", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotEqualTo(String value) {
            addCriterion("Stat <>", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThan(String value) {
            addCriterion("Stat >", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatGreaterThanOrEqualTo(String value) {
            addCriterion("Stat >=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThan(String value) {
            addCriterion("Stat <", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLessThanOrEqualTo(String value) {
            addCriterion("Stat <=", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatLike(String value) {
            addCriterion("Stat like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotLike(String value) {
            addCriterion("Stat not like", value, "stat");
            return (Criteria) this;
        }

        public Criteria andStatIn(List<String> values) {
            addCriterion("Stat in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotIn(List<String> values) {
            addCriterion("Stat not in", values, "stat");
            return (Criteria) this;
        }

        public Criteria andStatBetween(String value1, String value2) {
            addCriterion("Stat between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andStatNotBetween(String value1, String value2) {
            addCriterion("Stat not between", value1, value2, "stat");
            return (Criteria) this;
        }

        public Criteria andOretIsNull() {
            addCriterion("ORet is null");
            return (Criteria) this;
        }

        public Criteria andOretIsNotNull() {
            addCriterion("ORet is not null");
            return (Criteria) this;
        }

        public Criteria andOretEqualTo(String value) {
            addCriterion("ORet =", value, "oret");
            return (Criteria) this;
        }

        public Criteria andOretNotEqualTo(String value) {
            addCriterion("ORet <>", value, "oret");
            return (Criteria) this;
        }

        public Criteria andOretGreaterThan(String value) {
            addCriterion("ORet >", value, "oret");
            return (Criteria) this;
        }

        public Criteria andOretGreaterThanOrEqualTo(String value) {
            addCriterion("ORet >=", value, "oret");
            return (Criteria) this;
        }

        public Criteria andOretLessThan(String value) {
            addCriterion("ORet <", value, "oret");
            return (Criteria) this;
        }

        public Criteria andOretLessThanOrEqualTo(String value) {
            addCriterion("ORet <=", value, "oret");
            return (Criteria) this;
        }

        public Criteria andOretLike(String value) {
            addCriterion("ORet like", value, "oret");
            return (Criteria) this;
        }

        public Criteria andOretNotLike(String value) {
            addCriterion("ORet not like", value, "oret");
            return (Criteria) this;
        }

        public Criteria andOretIn(List<String> values) {
            addCriterion("ORet in", values, "oret");
            return (Criteria) this;
        }

        public Criteria andOretNotIn(List<String> values) {
            addCriterion("ORet not in", values, "oret");
            return (Criteria) this;
        }

        public Criteria andOretBetween(String value1, String value2) {
            addCriterion("ORet between", value1, value2, "oret");
            return (Criteria) this;
        }

        public Criteria andOretNotBetween(String value1, String value2) {
            addCriterion("ORet not between", value1, value2, "oret");
            return (Criteria) this;
        }

        public Criteria andOstatIsNull() {
            addCriterion("OStat is null");
            return (Criteria) this;
        }

        public Criteria andOstatIsNotNull() {
            addCriterion("OStat is not null");
            return (Criteria) this;
        }

        public Criteria andOstatEqualTo(String value) {
            addCriterion("OStat =", value, "ostat");
            return (Criteria) this;
        }

        public Criteria andOstatNotEqualTo(String value) {
            addCriterion("OStat <>", value, "ostat");
            return (Criteria) this;
        }

        public Criteria andOstatGreaterThan(String value) {
            addCriterion("OStat >", value, "ostat");
            return (Criteria) this;
        }

        public Criteria andOstatGreaterThanOrEqualTo(String value) {
            addCriterion("OStat >=", value, "ostat");
            return (Criteria) this;
        }

        public Criteria andOstatLessThan(String value) {
            addCriterion("OStat <", value, "ostat");
            return (Criteria) this;
        }

        public Criteria andOstatLessThanOrEqualTo(String value) {
            addCriterion("OStat <=", value, "ostat");
            return (Criteria) this;
        }

        public Criteria andOstatLike(String value) {
            addCriterion("OStat like", value, "ostat");
            return (Criteria) this;
        }

        public Criteria andOstatNotLike(String value) {
            addCriterion("OStat not like", value, "ostat");
            return (Criteria) this;
        }

        public Criteria andOstatIn(List<String> values) {
            addCriterion("OStat in", values, "ostat");
            return (Criteria) this;
        }

        public Criteria andOstatNotIn(List<String> values) {
            addCriterion("OStat not in", values, "ostat");
            return (Criteria) this;
        }

        public Criteria andOstatBetween(String value1, String value2) {
            addCriterion("OStat between", value1, value2, "ostat");
            return (Criteria) this;
        }

        public Criteria andOstatNotBetween(String value1, String value2) {
            addCriterion("OStat not between", value1, value2, "ostat");
            return (Criteria) this;
        }

        public Criteria andDsIsNull() {
            addCriterion("DS is null");
            return (Criteria) this;
        }

        public Criteria andDsIsNotNull() {
            addCriterion("DS is not null");
            return (Criteria) this;
        }

        public Criteria andDsEqualTo(String value) {
            addCriterion("DS =", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsNotEqualTo(String value) {
            addCriterion("DS <>", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsGreaterThan(String value) {
            addCriterion("DS >", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsGreaterThanOrEqualTo(String value) {
            addCriterion("DS >=", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsLessThan(String value) {
            addCriterion("DS <", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsLessThanOrEqualTo(String value) {
            addCriterion("DS <=", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsLike(String value) {
            addCriterion("DS like", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsNotLike(String value) {
            addCriterion("DS not like", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsIn(List<String> values) {
            addCriterion("DS in", values, "ds");
            return (Criteria) this;
        }

        public Criteria andDsNotIn(List<String> values) {
            addCriterion("DS not in", values, "ds");
            return (Criteria) this;
        }

        public Criteria andDsBetween(String value1, String value2) {
            addCriterion("DS between", value1, value2, "ds");
            return (Criteria) this;
        }

        public Criteria andDsNotBetween(String value1, String value2) {
            addCriterion("DS not between", value1, value2, "ds");
            return (Criteria) this;
        }

        public Criteria andRpttimeIsNull() {
            addCriterion("RPTTIME is null");
            return (Criteria) this;
        }

        public Criteria andRpttimeIsNotNull() {
            addCriterion("RPTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andRpttimeEqualTo(Date value) {
            addCriterion("RPTTIME =", value, "rpttime");
            return (Criteria) this;
        }

        public Criteria andRpttimeNotEqualTo(Date value) {
            addCriterion("RPTTIME <>", value, "rpttime");
            return (Criteria) this;
        }

        public Criteria andRpttimeGreaterThan(Date value) {
            addCriterion("RPTTIME >", value, "rpttime");
            return (Criteria) this;
        }

        public Criteria andRpttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RPTTIME >=", value, "rpttime");
            return (Criteria) this;
        }

        public Criteria andRpttimeLessThan(Date value) {
            addCriterion("RPTTIME <", value, "rpttime");
            return (Criteria) this;
        }

        public Criteria andRpttimeLessThanOrEqualTo(Date value) {
            addCriterion("RPTTIME <=", value, "rpttime");
            return (Criteria) this;
        }

        public Criteria andRpttimeIn(List<Date> values) {
            addCriterion("RPTTIME in", values, "rpttime");
            return (Criteria) this;
        }

        public Criteria andRpttimeNotIn(List<Date> values) {
            addCriterion("RPTTIME not in", values, "rpttime");
            return (Criteria) this;
        }

        public Criteria andRpttimeBetween(Date value1, Date value2) {
            addCriterion("RPTTIME between", value1, value2, "rpttime");
            return (Criteria) this;
        }

        public Criteria andRpttimeNotBetween(Date value1, Date value2) {
            addCriterion("RPTTIME not between", value1, value2, "rpttime");
            return (Criteria) this;
        }

        public Criteria andScIsNull() {
            addCriterion("SC is null");
            return (Criteria) this;
        }

        public Criteria andScIsNotNull() {
            addCriterion("SC is not null");
            return (Criteria) this;
        }

        public Criteria andScEqualTo(String value) {
            addCriterion("SC =", value, "sc");
            return (Criteria) this;
        }

        public Criteria andScNotEqualTo(String value) {
            addCriterion("SC <>", value, "sc");
            return (Criteria) this;
        }

        public Criteria andScGreaterThan(String value) {
            addCriterion("SC >", value, "sc");
            return (Criteria) this;
        }

        public Criteria andScGreaterThanOrEqualTo(String value) {
            addCriterion("SC >=", value, "sc");
            return (Criteria) this;
        }

        public Criteria andScLessThan(String value) {
            addCriterion("SC <", value, "sc");
            return (Criteria) this;
        }

        public Criteria andScLessThanOrEqualTo(String value) {
            addCriterion("SC <=", value, "sc");
            return (Criteria) this;
        }

        public Criteria andScLike(String value) {
            addCriterion("SC like", value, "sc");
            return (Criteria) this;
        }

        public Criteria andScNotLike(String value) {
            addCriterion("SC not like", value, "sc");
            return (Criteria) this;
        }

        public Criteria andScIn(List<String> values) {
            addCriterion("SC in", values, "sc");
            return (Criteria) this;
        }

        public Criteria andScNotIn(List<String> values) {
            addCriterion("SC not in", values, "sc");
            return (Criteria) this;
        }

        public Criteria andScBetween(String value1, String value2) {
            addCriterion("SC between", value1, value2, "sc");
            return (Criteria) this;
        }

        public Criteria andScNotBetween(String value1, String value2) {
            addCriterion("SC not between", value1, value2, "sc");
            return (Criteria) this;
        }

        public Criteria andPIsNull() {
            addCriterion("P is null");
            return (Criteria) this;
        }

        public Criteria andPIsNotNull() {
            addCriterion("P is not null");
            return (Criteria) this;
        }

        public Criteria andPEqualTo(String value) {
            addCriterion("P =", value, "p");
            return (Criteria) this;
        }

        public Criteria andPNotEqualTo(String value) {
            addCriterion("P <>", value, "p");
            return (Criteria) this;
        }

        public Criteria andPGreaterThan(String value) {
            addCriterion("P >", value, "p");
            return (Criteria) this;
        }

        public Criteria andPGreaterThanOrEqualTo(String value) {
            addCriterion("P >=", value, "p");
            return (Criteria) this;
        }

        public Criteria andPLessThan(String value) {
            addCriterion("P <", value, "p");
            return (Criteria) this;
        }

        public Criteria andPLessThanOrEqualTo(String value) {
            addCriterion("P <=", value, "p");
            return (Criteria) this;
        }

        public Criteria andPLike(String value) {
            addCriterion("P like", value, "p");
            return (Criteria) this;
        }

        public Criteria andPNotLike(String value) {
            addCriterion("P not like", value, "p");
            return (Criteria) this;
        }

        public Criteria andPIn(List<String> values) {
            addCriterion("P in", values, "p");
            return (Criteria) this;
        }

        public Criteria andPNotIn(List<String> values) {
            addCriterion("P not in", values, "p");
            return (Criteria) this;
        }

        public Criteria andPBetween(String value1, String value2) {
            addCriterion("P between", value1, value2, "p");
            return (Criteria) this;
        }

        public Criteria andPNotBetween(String value1, String value2) {
            addCriterion("P not between", value1, value2, "p");
            return (Criteria) this;
        }

        public Criteria andCIsNull() {
            addCriterion("C is null");
            return (Criteria) this;
        }

        public Criteria andCIsNotNull() {
            addCriterion("C is not null");
            return (Criteria) this;
        }

        public Criteria andCEqualTo(String value) {
            addCriterion("C =", value, "c");
            return (Criteria) this;
        }

        public Criteria andCNotEqualTo(String value) {
            addCriterion("C <>", value, "c");
            return (Criteria) this;
        }

        public Criteria andCGreaterThan(String value) {
            addCriterion("C >", value, "c");
            return (Criteria) this;
        }

        public Criteria andCGreaterThanOrEqualTo(String value) {
            addCriterion("C >=", value, "c");
            return (Criteria) this;
        }

        public Criteria andCLessThan(String value) {
            addCriterion("C <", value, "c");
            return (Criteria) this;
        }

        public Criteria andCLessThanOrEqualTo(String value) {
            addCriterion("C <=", value, "c");
            return (Criteria) this;
        }

        public Criteria andCLike(String value) {
            addCriterion("C like", value, "c");
            return (Criteria) this;
        }

        public Criteria andCNotLike(String value) {
            addCriterion("C not like", value, "c");
            return (Criteria) this;
        }

        public Criteria andCIn(List<String> values) {
            addCriterion("C in", values, "c");
            return (Criteria) this;
        }

        public Criteria andCNotIn(List<String> values) {
            addCriterion("C not in", values, "c");
            return (Criteria) this;
        }

        public Criteria andCBetween(String value1, String value2) {
            addCriterion("C between", value1, value2, "c");
            return (Criteria) this;
        }

        public Criteria andCNotBetween(String value1, String value2) {
            addCriterion("C not between", value1, value2, "c");
            return (Criteria) this;
        }

        public Criteria andPtIsNull() {
            addCriterion("PT is null");
            return (Criteria) this;
        }

        public Criteria andPtIsNotNull() {
            addCriterion("PT is not null");
            return (Criteria) this;
        }

        public Criteria andPtEqualTo(Byte value) {
            addCriterion("PT =", value, "pt");
            return (Criteria) this;
        }

        public Criteria andPtNotEqualTo(Byte value) {
            addCriterion("PT <>", value, "pt");
            return (Criteria) this;
        }

        public Criteria andPtGreaterThan(Byte value) {
            addCriterion("PT >", value, "pt");
            return (Criteria) this;
        }

        public Criteria andPtGreaterThanOrEqualTo(Byte value) {
            addCriterion("PT >=", value, "pt");
            return (Criteria) this;
        }

        public Criteria andPtLessThan(Byte value) {
            addCriterion("PT <", value, "pt");
            return (Criteria) this;
        }

        public Criteria andPtLessThanOrEqualTo(Byte value) {
            addCriterion("PT <=", value, "pt");
            return (Criteria) this;
        }

        public Criteria andPtIn(List<Byte> values) {
            addCriterion("PT in", values, "pt");
            return (Criteria) this;
        }

        public Criteria andPtNotIn(List<Byte> values) {
            addCriterion("PT not in", values, "pt");
            return (Criteria) this;
        }

        public Criteria andPtBetween(Byte value1, Byte value2) {
            addCriterion("PT between", value1, value2, "pt");
            return (Criteria) this;
        }

        public Criteria andPtNotBetween(Byte value1, Byte value2) {
            addCriterion("PT not between", value1, value2, "pt");
            return (Criteria) this;
        }

        public Criteria andPuIsNull() {
            addCriterion("PU is null");
            return (Criteria) this;
        }

        public Criteria andPuIsNotNull() {
            addCriterion("PU is not null");
            return (Criteria) this;
        }

        public Criteria andPuEqualTo(Byte value) {
            addCriterion("PU =", value, "pu");
            return (Criteria) this;
        }

        public Criteria andPuNotEqualTo(Byte value) {
            addCriterion("PU <>", value, "pu");
            return (Criteria) this;
        }

        public Criteria andPuGreaterThan(Byte value) {
            addCriterion("PU >", value, "pu");
            return (Criteria) this;
        }

        public Criteria andPuGreaterThanOrEqualTo(Byte value) {
            addCriterion("PU >=", value, "pu");
            return (Criteria) this;
        }

        public Criteria andPuLessThan(Byte value) {
            addCriterion("PU <", value, "pu");
            return (Criteria) this;
        }

        public Criteria andPuLessThanOrEqualTo(Byte value) {
            addCriterion("PU <=", value, "pu");
            return (Criteria) this;
        }

        public Criteria andPuIn(List<Byte> values) {
            addCriterion("PU in", values, "pu");
            return (Criteria) this;
        }

        public Criteria andPuNotIn(List<Byte> values) {
            addCriterion("PU not in", values, "pu");
            return (Criteria) this;
        }

        public Criteria andPuBetween(Byte value1, Byte value2) {
            addCriterion("PU between", value1, value2, "pu");
            return (Criteria) this;
        }

        public Criteria andPuNotBetween(Byte value1, Byte value2) {
            addCriterion("PU not between", value1, value2, "pu");
            return (Criteria) this;
        }

        public Criteria andAppidIsNull() {
            addCriterion("APPID is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("APPID is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(Integer value) {
            addCriterion("APPID =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(Integer value) {
            addCriterion("APPID <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(Integer value) {
            addCriterion("APPID >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(Integer value) {
            addCriterion("APPID >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(Integer value) {
            addCriterion("APPID <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(Integer value) {
            addCriterion("APPID <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<Integer> values) {
            addCriterion("APPID in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<Integer> values) {
            addCriterion("APPID not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(Integer value1, Integer value2) {
            addCriterion("APPID between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(Integer value1, Integer value2) {
            addCriterion("APPID not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andOperIsNull() {
            addCriterion("OPER is null");
            return (Criteria) this;
        }

        public Criteria andOperIsNotNull() {
            addCriterion("OPER is not null");
            return (Criteria) this;
        }

        public Criteria andOperEqualTo(Byte value) {
            addCriterion("OPER =", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperNotEqualTo(Byte value) {
            addCriterion("OPER <>", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperGreaterThan(Byte value) {
            addCriterion("OPER >", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperGreaterThanOrEqualTo(Byte value) {
            addCriterion("OPER >=", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperLessThan(Byte value) {
            addCriterion("OPER <", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperLessThanOrEqualTo(Byte value) {
            addCriterion("OPER <=", value, "oper");
            return (Criteria) this;
        }

        public Criteria andOperIn(List<Byte> values) {
            addCriterion("OPER in", values, "oper");
            return (Criteria) this;
        }

        public Criteria andOperNotIn(List<Byte> values) {
            addCriterion("OPER not in", values, "oper");
            return (Criteria) this;
        }

        public Criteria andOperBetween(Byte value1, Byte value2) {
            addCriterion("OPER between", value1, value2, "oper");
            return (Criteria) this;
        }

        public Criteria andOperNotBetween(Byte value1, Byte value2) {
            addCriterion("OPER not between", value1, value2, "oper");
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