package com.jnsierra.dto;

import java.util.List;

public class LiquidBaseDataDTO {
    private String tableName;
    private List<FieldDTO> fields;

    public LiquidBaseDataDTO() {
    }

    public LiquidBaseDataDTO(String tableName, List<FieldDTO> fields) {
        this.tableName = tableName;
        this.fields = fields;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<FieldDTO> getFields() {
        return fields;
    }

    public void setFields(List<FieldDTO> fields) {
        this.fields = fields;
    }
}
