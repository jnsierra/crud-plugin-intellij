package com.jnsierra.logic.liquidbase;

import com.jnsierra.dto.FieldDTO;

import java.util.List;

public class LiquidBasePrincipal {
    private final String tableName;
    private final String filePath;
    private final List<FieldDTO> tableData;

    public LiquidBasePrincipal(String tableName, String filePath, List<FieldDTO> tableData) {
        this.tableName = tableName;
        this.filePath = filePath;
        this.tableData = tableData;
    }

    public boolean executeLiquidBase(){
        System.out.println("Nicolas");
        return true;
    }
}
