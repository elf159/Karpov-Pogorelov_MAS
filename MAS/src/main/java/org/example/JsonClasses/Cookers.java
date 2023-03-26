package org.example.JsonClasses;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Cookers {
    @SerializedName("cook_id")
    private int cookId;
    @SerializedName("cook_name")
    private String cookName;
    @SerializedName("cook_active")
    private boolean cookActive;

    public int getCookId() {
        return cookId;
    }

    public void setCookId(int cookId) {
        this.cookId = cookId;
    }

    public String getCookName() {
        return cookName;
    }

    public void setCookName(String cookName) {
        this.cookName = cookName;
    }

    public boolean isCookActive() {
        return cookActive;
    }

    public void setCookActive(boolean cookActive) {
        this.cookActive = cookActive;
    }
}