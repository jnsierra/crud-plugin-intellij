package com.jnsierra.dto;

import com.jnsierra.components.DataTypeField;

public class FieldDTO {
    private String name;
    private DataTypeField dataTypeField;
    private Boolean primaryKey;
    private Boolean nullable;

    public FieldDTO(String name, DataTypeField dataTypeField, Boolean primaryKey, Boolean nullable) {
        this.name = name;
        this.dataTypeField = dataTypeField;
        this.primaryKey = primaryKey;
        this.nullable = nullable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataTypeField getDataTypeField() {
        return dataTypeField;
    }

    public void setDataTypeField(DataTypeField dataTypeField) {
        this.dataTypeField = dataTypeField;
    }

    public Boolean getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Boolean getNullable() {
        return nullable;
    }

    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
    }
}
