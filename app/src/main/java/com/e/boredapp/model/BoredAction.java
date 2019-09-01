package com.e.boredapp.model;

import com.google.gson.annotations.SerializedName;

public class BoredAction {

    //{
//        "activity": "Learn Express.js",
//        "accessibility": 0.25,
//        "type": "education",
//        "participants": 1,
//        "price": 0.1,
//        "link": "https://expressjs.com/",
//        "key": "3943506"
//        }
    @SerializedName("activity")
    private String activity;

    @SerializedName("accessibility")
    private Float accessibility;

    @SerializedName("type")
    private String type;

    @SerializedName("participants")
    private Integer participants;

    @SerializedName("link")
    private  String link;

    public BoredAction(Integer key) {
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    @SerializedName("key")
    private Integer key;



    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Float getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(Float accessibility) {
        this.accessibility = accessibility;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getParticipants() {
        return participants;
    }

    public void setParticipants(Integer participants) {
        this.participants = participants;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    private Float price;

    public BoredAction(String activity, Float accessibility, String type, Integer participants, Float price, String link) {
        this.activity = activity;
        this.accessibility = accessibility;
        this.type = type;
        this.participants = participants;
        this.price = price;
        this.link = link;
    }



}
