package org.example.JsonClasses;

import com.google.gson.annotations.SerializedName;
//Класс "EquipmentInfo" содержит информацию о конкретном оборудовании.

//Аннотация @SerializedName используется для указания имени поля при десериализации объекта из JSON.
//Поле "equipId" хранит уникальный идентификатор оборудования.
//Поле "equipType" хранит тип оборудования (ссылается на соответствующий объект класса "Equipment").
//Поле "equipName" содержит название конкретного оборудования.
//Поле "equipActive" указывает, активно ли данное оборудование.
public class EquipmentInfo {
    @SerializedName("equip_id")
    private int equipId;
    @SerializedName("equip_type")
    private int equipType;
    @SerializedName("equip_name")
    private String equipName;
    @SerializedName("equip_active")
    private boolean equipActive;

    public int getEquipId() {
        return equipId;
    }

    public int getEquipType() {
        return equipType;
    }

    public String getEquipName() {
        return equipName;
    }

    public boolean isEquipActive() {
        return equipActive;
    }

    public void setEquipId(int equipId) {
        this.equipId = equipId;
    }

    public void setEquipType(int equipType) {
        this.equipType = equipType;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public void setEquipActive(boolean equipActive) {
        this.equipActive = equipActive;
    }
}