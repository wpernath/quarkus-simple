package org.wanja.quarkus.model;

import com.fasterxml.jackson.annotation.*;

public class Field {
    private String name;
    private Type type;
    private String alias;
    private SQLType sqlType;
    private Object domain;
    private Object defaultValue;
    private Long length;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("type")
    public Type getType() { return type; }
    @JsonProperty("type")
    public void setType(Type value) { this.type = value; }

    @JsonProperty("alias")
    public String getAlias() { return alias; }
    @JsonProperty("alias")
    public void setAlias(String value) { this.alias = value; }

    @JsonProperty("sqlType")
    public SQLType getSQLType() { return sqlType; }
    @JsonProperty("sqlType")
    public void setSQLType(SQLType value) { this.sqlType = value; }

    @JsonProperty("domain")
    public Object getDomain() { return domain; }
    @JsonProperty("domain")
    public void setDomain(Object value) { this.domain = value; }

    @JsonProperty("defaultValue")
    public Object getDefaultValue() { return defaultValue; }
    @JsonProperty("defaultValue")
    public void setDefaultValue(Object value) { this.defaultValue = value; }

    @JsonProperty("length")
    public Long getLength() { return length; }
    @JsonProperty("length")
    public void setLength(Long value) { this.length = value; }
}
