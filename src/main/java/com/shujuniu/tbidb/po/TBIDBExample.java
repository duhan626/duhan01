package com.shujuniu.tbidb.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TBIDBExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TBIDBExample() {
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
            addCriterion("Bid is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("Bid is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(String value) {
            addCriterion("Bid =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(String value) {
            addCriterion("Bid <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(String value) {
            addCriterion("Bid >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(String value) {
            addCriterion("Bid >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(String value) {
            addCriterion("Bid <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(String value) {
            addCriterion("Bid <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLike(String value) {
            addCriterion("Bid like", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotLike(String value) {
            addCriterion("Bid not like", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<String> values) {
            addCriterion("Bid in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<String> values) {
            addCriterion("Bid not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(String value1, String value2) {
            addCriterion("Bid between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(String value1, String value2) {
            addCriterion("Bid not between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andDtIsNull() {
            addCriterion("DT is null");
            return (Criteria) this;
        }

        public Criteria andDtIsNotNull() {
            addCriterion("DT is not null");
            return (Criteria) this;
        }

        public Criteria andDtEqualTo(String value) {
            addCriterion("DT =", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtNotEqualTo(String value) {
            addCriterion("DT <>", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtGreaterThan(String value) {
            addCriterion("DT >", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtGreaterThanOrEqualTo(String value) {
            addCriterion("DT >=", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtLessThan(String value) {
            addCriterion("DT <", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtLessThanOrEqualTo(String value) {
            addCriterion("DT <=", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtLike(String value) {
            addCriterion("DT like", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtNotLike(String value) {
            addCriterion("DT not like", value, "dt");
            return (Criteria) this;
        }

        public Criteria andDtIn(List<String> values) {
            addCriterion("DT in", values, "dt");
            return (Criteria) this;
        }

        public Criteria andDtNotIn(List<String> values) {
            addCriterion("DT not in", values, "dt");
            return (Criteria) this;
        }

        public Criteria andDtBetween(String value1, String value2) {
            addCriterion("DT between", value1, value2, "dt");
            return (Criteria) this;
        }

        public Criteria andDtNotBetween(String value1, String value2) {
            addCriterion("DT not between", value1, value2, "dt");
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

        public Criteria andUaIsNull() {
            addCriterion("Ua is null");
            return (Criteria) this;
        }

        public Criteria andUaIsNotNull() {
            addCriterion("Ua is not null");
            return (Criteria) this;
        }

        public Criteria andUaEqualTo(String value) {
            addCriterion("Ua =", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaNotEqualTo(String value) {
            addCriterion("Ua <>", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaGreaterThan(String value) {
            addCriterion("Ua >", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaGreaterThanOrEqualTo(String value) {
            addCriterion("Ua >=", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaLessThan(String value) {
            addCriterion("Ua <", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaLessThanOrEqualTo(String value) {
            addCriterion("Ua <=", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaLike(String value) {
            addCriterion("Ua like", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaNotLike(String value) {
            addCriterion("Ua not like", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaIn(List<String> values) {
            addCriterion("Ua in", values, "ua");
            return (Criteria) this;
        }

        public Criteria andUaNotIn(List<String> values) {
            addCriterion("Ua not in", values, "ua");
            return (Criteria) this;
        }

        public Criteria andUaBetween(String value1, String value2) {
            addCriterion("Ua between", value1, value2, "ua");
            return (Criteria) this;
        }

        public Criteria andUaNotBetween(String value1, String value2) {
            addCriterion("Ua not between", value1, value2, "ua");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("Code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("Code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("Code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("Code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("Code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("Code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("Code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("Code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("Code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("Code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("Code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("Code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("Code not between", value1, value2, "code");
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

        public Criteria andMsgIsNull() {
            addCriterion("Msg is null");
            return (Criteria) this;
        }

        public Criteria andMsgIsNotNull() {
            addCriterion("Msg is not null");
            return (Criteria) this;
        }

        public Criteria andMsgEqualTo(String value) {
            addCriterion("Msg =", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotEqualTo(String value) {
            addCriterion("Msg <>", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThan(String value) {
            addCriterion("Msg >", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThanOrEqualTo(String value) {
            addCriterion("Msg >=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThan(String value) {
            addCriterion("Msg <", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThanOrEqualTo(String value) {
            addCriterion("Msg <=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLike(String value) {
            addCriterion("Msg like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotLike(String value) {
            addCriterion("Msg not like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgIn(List<String> values) {
            addCriterion("Msg in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotIn(List<String> values) {
            addCriterion("Msg not in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgBetween(String value1, String value2) {
            addCriterion("Msg between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotBetween(String value1, String value2) {
            addCriterion("Msg not between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andExcIsNull() {
            addCriterion("Exc is null");
            return (Criteria) this;
        }

        public Criteria andExcIsNotNull() {
            addCriterion("Exc is not null");
            return (Criteria) this;
        }

        public Criteria andExcEqualTo(String value) {
            addCriterion("Exc =", value, "exc");
            return (Criteria) this;
        }

        public Criteria andExcNotEqualTo(String value) {
            addCriterion("Exc <>", value, "exc");
            return (Criteria) this;
        }

        public Criteria andExcGreaterThan(String value) {
            addCriterion("Exc >", value, "exc");
            return (Criteria) this;
        }

        public Criteria andExcGreaterThanOrEqualTo(String value) {
            addCriterion("Exc >=", value, "exc");
            return (Criteria) this;
        }

        public Criteria andExcLessThan(String value) {
            addCriterion("Exc <", value, "exc");
            return (Criteria) this;
        }

        public Criteria andExcLessThanOrEqualTo(String value) {
            addCriterion("Exc <=", value, "exc");
            return (Criteria) this;
        }

        public Criteria andExcLike(String value) {
            addCriterion("Exc like", value, "exc");
            return (Criteria) this;
        }

        public Criteria andExcNotLike(String value) {
            addCriterion("Exc not like", value, "exc");
            return (Criteria) this;
        }

        public Criteria andExcIn(List<String> values) {
            addCriterion("Exc in", values, "exc");
            return (Criteria) this;
        }

        public Criteria andExcNotIn(List<String> values) {
            addCriterion("Exc not in", values, "exc");
            return (Criteria) this;
        }

        public Criteria andExcBetween(String value1, String value2) {
            addCriterion("Exc between", value1, value2, "exc");
            return (Criteria) this;
        }

        public Criteria andExcNotBetween(String value1, String value2) {
            addCriterion("Exc not between", value1, value2, "exc");
            return (Criteria) this;
        }

        public Criteria andMsglenIsNull() {
            addCriterion("MsgLen is null");
            return (Criteria) this;
        }

        public Criteria andMsglenIsNotNull() {
            addCriterion("MsgLen is not null");
            return (Criteria) this;
        }

        public Criteria andMsglenEqualTo(Short value) {
            addCriterion("MsgLen =", value, "msglen");
            return (Criteria) this;
        }

        public Criteria andMsglenNotEqualTo(Short value) {
            addCriterion("MsgLen <>", value, "msglen");
            return (Criteria) this;
        }

        public Criteria andMsglenGreaterThan(Short value) {
            addCriterion("MsgLen >", value, "msglen");
            return (Criteria) this;
        }

        public Criteria andMsglenGreaterThanOrEqualTo(Short value) {
            addCriterion("MsgLen >=", value, "msglen");
            return (Criteria) this;
        }

        public Criteria andMsglenLessThan(Short value) {
            addCriterion("MsgLen <", value, "msglen");
            return (Criteria) this;
        }

        public Criteria andMsglenLessThanOrEqualTo(Short value) {
            addCriterion("MsgLen <=", value, "msglen");
            return (Criteria) this;
        }

        public Criteria andMsglenIn(List<Short> values) {
            addCriterion("MsgLen in", values, "msglen");
            return (Criteria) this;
        }

        public Criteria andMsglenNotIn(List<Short> values) {
            addCriterion("MsgLen not in", values, "msglen");
            return (Criteria) this;
        }

        public Criteria andMsglenBetween(Short value1, Short value2) {
            addCriterion("MsgLen between", value1, value2, "msglen");
            return (Criteria) this;
        }

        public Criteria andMsglenNotBetween(Short value1, Short value2) {
            addCriterion("MsgLen not between", value1, value2, "msglen");
            return (Criteria) this;
        }

        public Criteria andMlenIsNull() {
            addCriterion("MLen is null");
            return (Criteria) this;
        }

        public Criteria andMlenIsNotNull() {
            addCriterion("MLen is not null");
            return (Criteria) this;
        }

        public Criteria andMlenEqualTo(Short value) {
            addCriterion("MLen =", value, "mlen");
            return (Criteria) this;
        }

        public Criteria andMlenNotEqualTo(Short value) {
            addCriterion("MLen <>", value, "mlen");
            return (Criteria) this;
        }

        public Criteria andMlenGreaterThan(Short value) {
            addCriterion("MLen >", value, "mlen");
            return (Criteria) this;
        }

        public Criteria andMlenGreaterThanOrEqualTo(Short value) {
            addCriterion("MLen >=", value, "mlen");
            return (Criteria) this;
        }

        public Criteria andMlenLessThan(Short value) {
            addCriterion("MLen <", value, "mlen");
            return (Criteria) this;
        }

        public Criteria andMlenLessThanOrEqualTo(Short value) {
            addCriterion("MLen <=", value, "mlen");
            return (Criteria) this;
        }

        public Criteria andMlenIn(List<Short> values) {
            addCriterion("MLen in", values, "mlen");
            return (Criteria) this;
        }

        public Criteria andMlenNotIn(List<Short> values) {
            addCriterion("MLen not in", values, "mlen");
            return (Criteria) this;
        }

        public Criteria andMlenBetween(Short value1, Short value2) {
            addCriterion("MLen between", value1, value2, "mlen");
            return (Criteria) this;
        }

        public Criteria andMlenNotBetween(Short value1, Short value2) {
            addCriterion("MLen not between", value1, value2, "mlen");
            return (Criteria) this;
        }

        public Criteria andMsgnumIsNull() {
            addCriterion("MsgNum is null");
            return (Criteria) this;
        }

        public Criteria andMsgnumIsNotNull() {
            addCriterion("MsgNum is not null");
            return (Criteria) this;
        }

        public Criteria andMsgnumEqualTo(Short value) {
            addCriterion("MsgNum =", value, "msgnum");
            return (Criteria) this;
        }

        public Criteria andMsgnumNotEqualTo(Short value) {
            addCriterion("MsgNum <>", value, "msgnum");
            return (Criteria) this;
        }

        public Criteria andMsgnumGreaterThan(Short value) {
            addCriterion("MsgNum >", value, "msgnum");
            return (Criteria) this;
        }

        public Criteria andMsgnumGreaterThanOrEqualTo(Short value) {
            addCriterion("MsgNum >=", value, "msgnum");
            return (Criteria) this;
        }

        public Criteria andMsgnumLessThan(Short value) {
            addCriterion("MsgNum <", value, "msgnum");
            return (Criteria) this;
        }

        public Criteria andMsgnumLessThanOrEqualTo(Short value) {
            addCriterion("MsgNum <=", value, "msgnum");
            return (Criteria) this;
        }

        public Criteria andMsgnumIn(List<Short> values) {
            addCriterion("MsgNum in", values, "msgnum");
            return (Criteria) this;
        }

        public Criteria andMsgnumNotIn(List<Short> values) {
            addCriterion("MsgNum not in", values, "msgnum");
            return (Criteria) this;
        }

        public Criteria andMsgnumBetween(Short value1, Short value2) {
            addCriterion("MsgNum between", value1, value2, "msgnum");
            return (Criteria) this;
        }

        public Criteria andMsgnumNotBetween(Short value1, Short value2) {
            addCriterion("MsgNum not between", value1, value2, "msgnum");
            return (Criteria) this;
        }

        public Criteria andMobnumIsNull() {
            addCriterion("MobNum is null");
            return (Criteria) this;
        }

        public Criteria andMobnumIsNotNull() {
            addCriterion("MobNum is not null");
            return (Criteria) this;
        }

        public Criteria andMobnumEqualTo(Integer value) {
            addCriterion("MobNum =", value, "mobnum");
            return (Criteria) this;
        }

        public Criteria andMobnumNotEqualTo(Integer value) {
            addCriterion("MobNum <>", value, "mobnum");
            return (Criteria) this;
        }

        public Criteria andMobnumGreaterThan(Integer value) {
            addCriterion("MobNum >", value, "mobnum");
            return (Criteria) this;
        }

        public Criteria andMobnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("MobNum >=", value, "mobnum");
            return (Criteria) this;
        }

        public Criteria andMobnumLessThan(Integer value) {
            addCriterion("MobNum <", value, "mobnum");
            return (Criteria) this;
        }

        public Criteria andMobnumLessThanOrEqualTo(Integer value) {
            addCriterion("MobNum <=", value, "mobnum");
            return (Criteria) this;
        }

        public Criteria andMobnumIn(List<Integer> values) {
            addCriterion("MobNum in", values, "mobnum");
            return (Criteria) this;
        }

        public Criteria andMobnumNotIn(List<Integer> values) {
            addCriterion("MobNum not in", values, "mobnum");
            return (Criteria) this;
        }

        public Criteria andMobnumBetween(Integer value1, Integer value2) {
            addCriterion("MobNum between", value1, value2, "mobnum");
            return (Criteria) this;
        }

        public Criteria andMobnumNotBetween(Integer value1, Integer value2) {
            addCriterion("MobNum not between", value1, value2, "mobnum");
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

        public Criteria andNumIsNull() {
            addCriterion("Num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("Num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("Num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("Num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("Num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("Num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("Num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("Num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("Num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("Num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("Num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("Num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andMesIsNull() {
            addCriterion("Mes is null");
            return (Criteria) this;
        }

        public Criteria andMesIsNotNull() {
            addCriterion("Mes is not null");
            return (Criteria) this;
        }

        public Criteria andMesEqualTo(String value) {
            addCriterion("Mes =", value, "mes");
            return (Criteria) this;
        }

        public Criteria andMesNotEqualTo(String value) {
            addCriterion("Mes <>", value, "mes");
            return (Criteria) this;
        }

        public Criteria andMesGreaterThan(String value) {
            addCriterion("Mes >", value, "mes");
            return (Criteria) this;
        }

        public Criteria andMesGreaterThanOrEqualTo(String value) {
            addCriterion("Mes >=", value, "mes");
            return (Criteria) this;
        }

        public Criteria andMesLessThan(String value) {
            addCriterion("Mes <", value, "mes");
            return (Criteria) this;
        }

        public Criteria andMesLessThanOrEqualTo(String value) {
            addCriterion("Mes <=", value, "mes");
            return (Criteria) this;
        }

        public Criteria andMesLike(String value) {
            addCriterion("Mes like", value, "mes");
            return (Criteria) this;
        }

        public Criteria andMesNotLike(String value) {
            addCriterion("Mes not like", value, "mes");
            return (Criteria) this;
        }

        public Criteria andMesIn(List<String> values) {
            addCriterion("Mes in", values, "mes");
            return (Criteria) this;
        }

        public Criteria andMesNotIn(List<String> values) {
            addCriterion("Mes not in", values, "mes");
            return (Criteria) this;
        }

        public Criteria andMesBetween(String value1, String value2) {
            addCriterion("Mes between", value1, value2, "mes");
            return (Criteria) this;
        }

        public Criteria andMesNotBetween(String value1, String value2) {
            addCriterion("Mes not between", value1, value2, "mes");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Byte value) {
            addCriterion("FLAG =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Byte value) {
            addCriterion("FLAG <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Byte value) {
            addCriterion("FLAG >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("FLAG >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Byte value) {
            addCriterion("FLAG <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Byte value) {
            addCriterion("FLAG <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Byte> values) {
            addCriterion("FLAG in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Byte> values) {
            addCriterion("FLAG not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Byte value1, Byte value2) {
            addCriterion("FLAG between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("FLAG not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andApptimeIsNull() {
            addCriterion("AppTime is null");
            return (Criteria) this;
        }

        public Criteria andApptimeIsNotNull() {
            addCriterion("AppTime is not null");
            return (Criteria) this;
        }

        public Criteria andApptimeEqualTo(Date value) {
            addCriterion("AppTime =", value, "apptime");
            return (Criteria) this;
        }

        public Criteria andApptimeNotEqualTo(Date value) {
            addCriterion("AppTime <>", value, "apptime");
            return (Criteria) this;
        }

        public Criteria andApptimeGreaterThan(Date value) {
            addCriterion("AppTime >", value, "apptime");
            return (Criteria) this;
        }

        public Criteria andApptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("AppTime >=", value, "apptime");
            return (Criteria) this;
        }

        public Criteria andApptimeLessThan(Date value) {
            addCriterion("AppTime <", value, "apptime");
            return (Criteria) this;
        }

        public Criteria andApptimeLessThanOrEqualTo(Date value) {
            addCriterion("AppTime <=", value, "apptime");
            return (Criteria) this;
        }

        public Criteria andApptimeIn(List<Date> values) {
            addCriterion("AppTime in", values, "apptime");
            return (Criteria) this;
        }

        public Criteria andApptimeNotIn(List<Date> values) {
            addCriterion("AppTime not in", values, "apptime");
            return (Criteria) this;
        }

        public Criteria andApptimeBetween(Date value1, Date value2) {
            addCriterion("AppTime between", value1, value2, "apptime");
            return (Criteria) this;
        }

        public Criteria andApptimeNotBetween(Date value1, Date value2) {
            addCriterion("AppTime not between", value1, value2, "apptime");
            return (Criteria) this;
        }

        public Criteria andSendwayIsNull() {
            addCriterion("SENDWAY is null");
            return (Criteria) this;
        }

        public Criteria andSendwayIsNotNull() {
            addCriterion("SENDWAY is not null");
            return (Criteria) this;
        }

        public Criteria andSendwayEqualTo(Byte value) {
            addCriterion("SENDWAY =", value, "sendway");
            return (Criteria) this;
        }

        public Criteria andSendwayNotEqualTo(Byte value) {
            addCriterion("SENDWAY <>", value, "sendway");
            return (Criteria) this;
        }

        public Criteria andSendwayGreaterThan(Byte value) {
            addCriterion("SENDWAY >", value, "sendway");
            return (Criteria) this;
        }

        public Criteria andSendwayGreaterThanOrEqualTo(Byte value) {
            addCriterion("SENDWAY >=", value, "sendway");
            return (Criteria) this;
        }

        public Criteria andSendwayLessThan(Byte value) {
            addCriterion("SENDWAY <", value, "sendway");
            return (Criteria) this;
        }

        public Criteria andSendwayLessThanOrEqualTo(Byte value) {
            addCriterion("SENDWAY <=", value, "sendway");
            return (Criteria) this;
        }

        public Criteria andSendwayIn(List<Byte> values) {
            addCriterion("SENDWAY in", values, "sendway");
            return (Criteria) this;
        }

        public Criteria andSendwayNotIn(List<Byte> values) {
            addCriterion("SENDWAY not in", values, "sendway");
            return (Criteria) this;
        }

        public Criteria andSendwayBetween(Byte value1, Byte value2) {
            addCriterion("SENDWAY between", value1, value2, "sendway");
            return (Criteria) this;
        }

        public Criteria andSendwayNotBetween(Byte value1, Byte value2) {
            addCriterion("SENDWAY not between", value1, value2, "sendway");
            return (Criteria) this;
        }

        public Criteria andDiuIsNull() {
            addCriterion("DIU is null");
            return (Criteria) this;
        }

        public Criteria andDiuIsNotNull() {
            addCriterion("DIU is not null");
            return (Criteria) this;
        }

        public Criteria andDiuEqualTo(Integer value) {
            addCriterion("DIU =", value, "diu");
            return (Criteria) this;
        }

        public Criteria andDiuNotEqualTo(Integer value) {
            addCriterion("DIU <>", value, "diu");
            return (Criteria) this;
        }

        public Criteria andDiuGreaterThan(Integer value) {
            addCriterion("DIU >", value, "diu");
            return (Criteria) this;
        }

        public Criteria andDiuGreaterThanOrEqualTo(Integer value) {
            addCriterion("DIU >=", value, "diu");
            return (Criteria) this;
        }

        public Criteria andDiuLessThan(Integer value) {
            addCriterion("DIU <", value, "diu");
            return (Criteria) this;
        }

        public Criteria andDiuLessThanOrEqualTo(Integer value) {
            addCriterion("DIU <=", value, "diu");
            return (Criteria) this;
        }

        public Criteria andDiuIn(List<Integer> values) {
            addCriterion("DIU in", values, "diu");
            return (Criteria) this;
        }

        public Criteria andDiuNotIn(List<Integer> values) {
            addCriterion("DIU not in", values, "diu");
            return (Criteria) this;
        }

        public Criteria andDiuBetween(Integer value1, Integer value2) {
            addCriterion("DIU between", value1, value2, "diu");
            return (Criteria) this;
        }

        public Criteria andDiuNotBetween(Integer value1, Integer value2) {
            addCriterion("DIU not between", value1, value2, "diu");
            return (Criteria) this;
        }

        public Criteria andXtypeIsNull() {
            addCriterion("XTYPE is null");
            return (Criteria) this;
        }

        public Criteria andXtypeIsNotNull() {
            addCriterion("XTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andXtypeEqualTo(Byte value) {
            addCriterion("XTYPE =", value, "xtype");
            return (Criteria) this;
        }

        public Criteria andXtypeNotEqualTo(Byte value) {
            addCriterion("XTYPE <>", value, "xtype");
            return (Criteria) this;
        }

        public Criteria andXtypeGreaterThan(Byte value) {
            addCriterion("XTYPE >", value, "xtype");
            return (Criteria) this;
        }

        public Criteria andXtypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("XTYPE >=", value, "xtype");
            return (Criteria) this;
        }

        public Criteria andXtypeLessThan(Byte value) {
            addCriterion("XTYPE <", value, "xtype");
            return (Criteria) this;
        }

        public Criteria andXtypeLessThanOrEqualTo(Byte value) {
            addCriterion("XTYPE <=", value, "xtype");
            return (Criteria) this;
        }

        public Criteria andXtypeIn(List<Byte> values) {
            addCriterion("XTYPE in", values, "xtype");
            return (Criteria) this;
        }

        public Criteria andXtypeNotIn(List<Byte> values) {
            addCriterion("XTYPE not in", values, "xtype");
            return (Criteria) this;
        }

        public Criteria andXtypeBetween(Byte value1, Byte value2) {
            addCriterion("XTYPE between", value1, value2, "xtype");
            return (Criteria) this;
        }

        public Criteria andXtypeNotBetween(Byte value1, Byte value2) {
            addCriterion("XTYPE not between", value1, value2, "xtype");
            return (Criteria) this;
        }

        public Criteria andDoopIsNull() {
            addCriterion("DOOP is null");
            return (Criteria) this;
        }

        public Criteria andDoopIsNotNull() {
            addCriterion("DOOP is not null");
            return (Criteria) this;
        }

        public Criteria andDoopEqualTo(String value) {
            addCriterion("DOOP =", value, "doop");
            return (Criteria) this;
        }

        public Criteria andDoopNotEqualTo(String value) {
            addCriterion("DOOP <>", value, "doop");
            return (Criteria) this;
        }

        public Criteria andDoopGreaterThan(String value) {
            addCriterion("DOOP >", value, "doop");
            return (Criteria) this;
        }

        public Criteria andDoopGreaterThanOrEqualTo(String value) {
            addCriterion("DOOP >=", value, "doop");
            return (Criteria) this;
        }

        public Criteria andDoopLessThan(String value) {
            addCriterion("DOOP <", value, "doop");
            return (Criteria) this;
        }

        public Criteria andDoopLessThanOrEqualTo(String value) {
            addCriterion("DOOP <=", value, "doop");
            return (Criteria) this;
        }

        public Criteria andDoopLike(String value) {
            addCriterion("DOOP like", value, "doop");
            return (Criteria) this;
        }

        public Criteria andDoopNotLike(String value) {
            addCriterion("DOOP not like", value, "doop");
            return (Criteria) this;
        }

        public Criteria andDoopIn(List<String> values) {
            addCriterion("DOOP in", values, "doop");
            return (Criteria) this;
        }

        public Criteria andDoopNotIn(List<String> values) {
            addCriterion("DOOP not in", values, "doop");
            return (Criteria) this;
        }

        public Criteria andDoopBetween(String value1, String value2) {
            addCriterion("DOOP between", value1, value2, "doop");
            return (Criteria) this;
        }

        public Criteria andDoopNotBetween(String value1, String value2) {
            addCriterion("DOOP not between", value1, value2, "doop");
            return (Criteria) this;
        }

        public Criteria andQmIsNull() {
            addCriterion("QM is null");
            return (Criteria) this;
        }

        public Criteria andQmIsNotNull() {
            addCriterion("QM is not null");
            return (Criteria) this;
        }

        public Criteria andQmEqualTo(String value) {
            addCriterion("QM =", value, "qm");
            return (Criteria) this;
        }

        public Criteria andQmNotEqualTo(String value) {
            addCriterion("QM <>", value, "qm");
            return (Criteria) this;
        }

        public Criteria andQmGreaterThan(String value) {
            addCriterion("QM >", value, "qm");
            return (Criteria) this;
        }

        public Criteria andQmGreaterThanOrEqualTo(String value) {
            addCriterion("QM >=", value, "qm");
            return (Criteria) this;
        }

        public Criteria andQmLessThan(String value) {
            addCriterion("QM <", value, "qm");
            return (Criteria) this;
        }

        public Criteria andQmLessThanOrEqualTo(String value) {
            addCriterion("QM <=", value, "qm");
            return (Criteria) this;
        }

        public Criteria andQmLike(String value) {
            addCriterion("QM like", value, "qm");
            return (Criteria) this;
        }

        public Criteria andQmNotLike(String value) {
            addCriterion("QM not like", value, "qm");
            return (Criteria) this;
        }

        public Criteria andQmIn(List<String> values) {
            addCriterion("QM in", values, "qm");
            return (Criteria) this;
        }

        public Criteria andQmNotIn(List<String> values) {
            addCriterion("QM not in", values, "qm");
            return (Criteria) this;
        }

        public Criteria andQmBetween(String value1, String value2) {
            addCriterion("QM between", value1, value2, "qm");
            return (Criteria) this;
        }

        public Criteria andQmNotBetween(String value1, String value2) {
            addCriterion("QM not between", value1, value2, "qm");
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

        public Criteria andOkIsNull() {
            addCriterion("OK is null");
            return (Criteria) this;
        }

        public Criteria andOkIsNotNull() {
            addCriterion("OK is not null");
            return (Criteria) this;
        }

        public Criteria andOkEqualTo(Byte value) {
            addCriterion("OK =", value, "ok");
            return (Criteria) this;
        }

        public Criteria andOkNotEqualTo(Byte value) {
            addCriterion("OK <>", value, "ok");
            return (Criteria) this;
        }

        public Criteria andOkGreaterThan(Byte value) {
            addCriterion("OK >", value, "ok");
            return (Criteria) this;
        }

        public Criteria andOkGreaterThanOrEqualTo(Byte value) {
            addCriterion("OK >=", value, "ok");
            return (Criteria) this;
        }

        public Criteria andOkLessThan(Byte value) {
            addCriterion("OK <", value, "ok");
            return (Criteria) this;
        }

        public Criteria andOkLessThanOrEqualTo(Byte value) {
            addCriterion("OK <=", value, "ok");
            return (Criteria) this;
        }

        public Criteria andOkIn(List<Byte> values) {
            addCriterion("OK in", values, "ok");
            return (Criteria) this;
        }

        public Criteria andOkNotIn(List<Byte> values) {
            addCriterion("OK not in", values, "ok");
            return (Criteria) this;
        }

        public Criteria andOkBetween(Byte value1, Byte value2) {
            addCriterion("OK between", value1, value2, "ok");
            return (Criteria) this;
        }

        public Criteria andOkNotBetween(Byte value1, Byte value2) {
            addCriterion("OK not between", value1, value2, "ok");
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