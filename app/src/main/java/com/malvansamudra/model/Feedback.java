package com.malvansamudra.model;

/**
 * Created by Rini Banerjee on 25-11-2017.
 */

public class Feedback {

    String sFeedbackId;
    String sCustomerName;
    String sCustomerMobMo;
    String sCustomerAddress;
    String sFoodTasteRating;
    String sServiceRating;
    String sAmbienceRating;
    String sCustomerSuggestion;
    String sDate;

    public Feedback() {
    }

    public Feedback(String sFeedbackId, String sCustomerName, String sCustomerMobMo, String sCustomerAddress, String sFoodTasteRating, String sServiceRating, String sAmbienceRating, String sCustomerSuggestion, String sDate) {
        this.sFeedbackId = sFeedbackId;
        this.sCustomerName = sCustomerName;
        this.sCustomerMobMo = sCustomerMobMo;
        this.sCustomerAddress = sCustomerAddress;
        this.sFoodTasteRating = sFoodTasteRating;
        this.sServiceRating = sServiceRating;
        this.sAmbienceRating = sAmbienceRating;
        this.sCustomerSuggestion = sCustomerSuggestion;
        this.sDate = sDate;
    }

    public String getsFeedbackId() {
        return sFeedbackId;
    }

    public void setsFeedbackId(String sFeedbackId) {
        this.sFeedbackId = sFeedbackId;
    }

    public String getsCustomerName() {
        return sCustomerName;
    }

    public void setsCustomerName(String sCustomerName) {
        this.sCustomerName = sCustomerName;
    }

    public String getsCustomerMobMo() {
        return sCustomerMobMo;
    }

    public void setsCustomerMobMo(String sCustomerMobMo) {
        this.sCustomerMobMo = sCustomerMobMo;
    }

    public String getsCustomerAddress() {
        return sCustomerAddress;
    }

    public void setsCustomerAddress(String sCustomerAddress) {
        this.sCustomerAddress = sCustomerAddress;
    }

    public String getsFoodTasteRating() {
        return sFoodTasteRating;
    }

    public void setsFoodTasteRating(String sFoodTasteRating) {
        this.sFoodTasteRating = sFoodTasteRating;
    }

    public String getsServiceRating() {
        return sServiceRating;
    }

    public void setsServiceRating(String sServiceRating) {
        this.sServiceRating = sServiceRating;
    }

    public String getsAmbienceRating() {
        return sAmbienceRating;
    }

    public void setsAmbienceRating(String sAmbienceRating) {
        this.sAmbienceRating = sAmbienceRating;
    }

    public String getsCustomerSuggestion() {
        return sCustomerSuggestion;
    }

    public void setsCustomerSuggestion(String sCustomerSuggestion) {
        this.sCustomerSuggestion = sCustomerSuggestion;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }
}
