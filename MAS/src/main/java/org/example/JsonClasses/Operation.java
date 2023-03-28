package org.example.JsonClasses;

import com.google.gson.annotations.SerializedName;

import java.util.List;
//Класс Operation описывает операции, используемые в приложении.
//У класса есть два поля: operTypeId и operTypeName, которые представляют идентификатор и название типа операции соответственно.
public class Operation {
    @SerializedName("oper_type_id")
    private int operTypeId;
    @SerializedName("oper_type_name")
    private String operTypeName;
    public int getOperTypeId() {
            return operTypeId;
    }
    public void setOperTypeId(int operTypeId) {
        this.operTypeId = operTypeId;
    }
    public String getOperTypeName() {
        return operTypeName;
    }
    public void setOperTypeName(String operTypeName) {
        this.operTypeName = operTypeName;
    }
}