package com.jnsierra.components;

import java.util.Arrays;
import java.util.List;

public enum DataTypeField {
    TEXT("varchar", "String"),
    BOOLEAN("boolean", "Boolean"),
    CURRENCY("decimal", "BigDecimal"),
    DATE("date", "Date");

    private String liquidbase;
    private String java;

    DataTypeField(String liquidbase, String java) {
        this.liquidbase = liquidbase;
        this.java = java;
    }
    // Método para obtener una lista con los valores del campo "java"
    public static List<String> getJavaTypes() {
        return Arrays.stream(DataTypeField.values())
                .map(DataTypeField::getJava)
                .toList();
    }

    public String getLiquidbase() {
        return liquidbase;
    }

    public String getJava() {
        return java;
    }

    public static DataTypeField getEnumByJavaDataType(String javaType){
        DataTypeField enumData = switch (javaType) {
            case "String" -> DataTypeField.TEXT;
            case "Boolean" -> DataTypeField.BOOLEAN;
            case "BigDecimal" -> DataTypeField.CURRENCY;
            case "Date" -> DataTypeField.DATE;
            default -> null;
        };
        return enumData;
    }
}
