package org.example.JsonClasses;

import com.google.gson.annotations.SerializedName;

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