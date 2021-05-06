package com.fc.entity;

import java.util.ArrayList;
import java.util.List;

public class CarOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarOrderExample() {
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

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andGetidIsNull() {
            addCriterion("getid is null");
            return (Criteria) this;
        }

        public Criteria andGetidIsNotNull() {
            addCriterion("getid is not null");
            return (Criteria) this;
        }

        public Criteria andGetidEqualTo(Integer value) {
            addCriterion("getid =", value, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidNotEqualTo(Integer value) {
            addCriterion("getid <>", value, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidGreaterThan(Integer value) {
            addCriterion("getid >", value, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidGreaterThanOrEqualTo(Integer value) {
            addCriterion("getid >=", value, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidLessThan(Integer value) {
            addCriterion("getid <", value, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidLessThanOrEqualTo(Integer value) {
            addCriterion("getid <=", value, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidIn(List<Integer> values) {
            addCriterion("getid in", values, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidNotIn(List<Integer> values) {
            addCriterion("getid not in", values, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidBetween(Integer value1, Integer value2) {
            addCriterion("getid between", value1, value2, "getid");
            return (Criteria) this;
        }

        public Criteria andGetidNotBetween(Integer value1, Integer value2) {
            addCriterion("getid not between", value1, value2, "getid");
            return (Criteria) this;
        }

        public Criteria andBackidIsNull() {
            addCriterion("backid is null");
            return (Criteria) this;
        }

        public Criteria andBackidIsNotNull() {
            addCriterion("backid is not null");
            return (Criteria) this;
        }

        public Criteria andBackidEqualTo(Integer value) {
            addCriterion("backid =", value, "backid");
            return (Criteria) this;
        }

        public Criteria andBackidNotEqualTo(Integer value) {
            addCriterion("backid <>", value, "backid");
            return (Criteria) this;
        }

        public Criteria andBackidGreaterThan(Integer value) {
            addCriterion("backid >", value, "backid");
            return (Criteria) this;
        }

        public Criteria andBackidGreaterThanOrEqualTo(Integer value) {
            addCriterion("backid >=", value, "backid");
            return (Criteria) this;
        }

        public Criteria andBackidLessThan(Integer value) {
            addCriterion("backid <", value, "backid");
            return (Criteria) this;
        }

        public Criteria andBackidLessThanOrEqualTo(Integer value) {
            addCriterion("backid <=", value, "backid");
            return (Criteria) this;
        }

        public Criteria andBackidIn(List<Integer> values) {
            addCriterion("backid in", values, "backid");
            return (Criteria) this;
        }

        public Criteria andBackidNotIn(List<Integer> values) {
            addCriterion("backid not in", values, "backid");
            return (Criteria) this;
        }

        public Criteria andBackidBetween(Integer value1, Integer value2) {
            addCriterion("backid between", value1, value2, "backid");
            return (Criteria) this;
        }

        public Criteria andBackidNotBetween(Integer value1, Integer value2) {
            addCriterion("backid not between", value1, value2, "backid");
            return (Criteria) this;
        }

        public Criteria andOpriceIsNull() {
            addCriterion("oprice is null");
            return (Criteria) this;
        }

        public Criteria andOpriceIsNotNull() {
            addCriterion("oprice is not null");
            return (Criteria) this;
        }

        public Criteria andOpriceEqualTo(Double value) {
            addCriterion("oprice =", value, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceNotEqualTo(Double value) {
            addCriterion("oprice <>", value, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceGreaterThan(Double value) {
            addCriterion("oprice >", value, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("oprice >=", value, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceLessThan(Double value) {
            addCriterion("oprice <", value, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceLessThanOrEqualTo(Double value) {
            addCriterion("oprice <=", value, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceIn(List<Double> values) {
            addCriterion("oprice in", values, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceNotIn(List<Double> values) {
            addCriterion("oprice not in", values, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceBetween(Double value1, Double value2) {
            addCriterion("oprice between", value1, value2, "oprice");
            return (Criteria) this;
        }

        public Criteria andOpriceNotBetween(Double value1, Double value2) {
            addCriterion("oprice not between", value1, value2, "oprice");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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