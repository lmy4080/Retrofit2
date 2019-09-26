package com.circleglasses.retrofit2;

/**
 * Data Format For A Response Of WebServer
 */

import com.google.gson.annotations.SerializedName;

public class ServerResponse {

    @SerializedName("message")
    public String message;
    @SerializedName("nums")
    public String nums;

    ServerResponse(String message, String nums) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getNums() {
        return nums;
    }

    public void setNums(String nums) {
        this.nums = nums;
    }
}
