package org.example.JsonClasses;
//Класс "Equipment" содержит информацию об оборудовании.

import com.google.gson.annotations.SerializedName;
//Поле "equipTypeId" хранит уникальный идентификатор типа оборудования.
//Поле "equipTypeName" содержит название типа оборудования.
public class Equipment {
    @SerializedName("equip_type_id")
    private int equipTypeId;
    @SerializedName("equip_type_name")
    private String equipTypeName;

    public int getEquipTypeId() {
        return equipTypeId;
    }

    public String getEquipTypeName() {
        return equipTypeName;
    }

    public void setEquipTypeId(int equipTypeId) {
        this.equipTypeId = equipTypeId;
    }

    public void setEquipTypeName(String equipTypeName) {
        this.equipTypeName = equipTypeName;
    }
}