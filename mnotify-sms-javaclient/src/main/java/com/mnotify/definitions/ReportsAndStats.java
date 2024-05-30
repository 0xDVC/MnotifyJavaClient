package com.mnotify.definitions;


import com.mnotify.common.RequestBuilder;
import com.mnotify.common.RequestExecutor;
import com.mnotify.constants.URLDefinitions;
import okhttp3.Request;
import com.google.gson.JsonElement;

/**
 * The ReportsAndStats class provides methods to interact with the report and stats templates API.
 * It allows users to retrieve report and statistics on sms and voice calls.
 */
@SuppressWarnings(value = "unused")
public class ReportsAndStats {
    RequestBuilder builder;
    public ReportsAndStats() {
        builder = new RequestBuilder();
    }

    public JsonElement checkSMSBalance() {
        RequestBuilder.URL = URLDefinitions.SMS_BALANCE;
        Request request = builder.buildRequest();

        return RequestExecutor.executeRequest(request);
    }

    public JsonElement checkVoiceBalance() {
        RequestBuilder.URL = URLDefinitions.VOICE_BALANCE;
        Request request = builder.buildRequest();

        return RequestExecutor.executeRequest(request);
    }

    public JsonElement smsDeliveryReport(String id) {
        RequestBuilder.URL = URLDefinitions.SMS_DELIVERY_REPORT;
        Request request  = builder.buildRequest(id);

        return RequestExecutor.executeRequest(request);
    }

    public JsonElement specificSMSDeliveryReport(int id) {
        RequestBuilder.URL = URLDefinitions.SPECIFIC_SMS_DELIVERY_REPORT;
        Request request = builder.buildRequest(id);

        return RequestExecutor.executeRequest(request);
    }

    public JsonElement periodicDeliveryReport() {
        RequestBuilder.URL = URLDefinitions.PERIODIC_DELIVERY_REPORT;
        Request request = builder.buildRequest();

        return RequestExecutor.executeRequest(request);
    }

    public JsonElement voiceCallReport(String id) {
        RequestBuilder.URL = URLDefinitions.VOICE_CALL_REPORT;
        Request request  = builder.buildRequest(id);

        return RequestExecutor.executeRequest(request);
    }

    public JsonElement specificVoiceCallReport(int id) {
        RequestBuilder.URL = URLDefinitions.SPECIFIC_VOICE_CALL_REPORT;
        Request request = builder.buildRequest(id);

        return RequestExecutor.executeRequest(request);
    }

    public JsonElement periodicVoiceCallReport() {
        RequestBuilder.URL = URLDefinitions.PERIODIC_VOICE_CALL_REPORT;
        Request request = builder.buildRequest();

        return RequestExecutor.executeRequest(request);
    }


}