package com.mnotify;


import com.mnotify.common.RequestBuilder;
import com.mnotify.common.RequestExecutor;
import com.mnotify.constants.URLDefinitions;
import okhttp3.Request;
import okhttp3.ResponseBody;

import java.io.IOException;

/**
 * The ReportsAndStats class provides methods to interact with the report and stats templates API.
 * It allows users to retrieve report and statistics on sms and voice calls.
 */

public class ReportsAndStats {
    RequestBuilder builder;
    public ReportsAndStats(String API_KEY) {
        builder = new RequestBuilder(API_KEY);
    }

    public ResponseBody checkSMSBalance() throws IOException {
        builder.URL = URLDefinitions.SMS_BALANCE;
        Request request = builder.buildRequest();

        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody checkVoiceBalance() throws IOException {
        builder.URL = URLDefinitions.VOICE_BALANCE;
        Request request = builder.buildRequest();

        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody smsDeliveryReport(String id) throws IOException {
        builder.URL = URLDefinitions.SMS_DELIVERY_REPORT;
        Request request  = builder.buildRequest(id);

        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody specificSMSDeliveryReport(int id) throws IOException {
        builder.URL = URLDefinitions.SPECIFIC_SMS_DELIVERY_REPORT;
        Request request = builder.buildRequest(id);

        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody periodicDeliveryReport() throws IOException {
        builder.URL = URLDefinitions.PERIODIC_DELIVERY_REPORT;
        Request request = builder.buildRequest();

        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody voiceCallReport(String id) throws IOException {
        builder.URL = URLDefinitions.VOICE_CALL_REPORT;
        Request request  = builder.buildRequest(id);

        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody specificVoiceCallReport(int id) throws IOException {
        builder.URL = URLDefinitions.SPECIFIC_VOICE_CALL_REPORT;
        Request request = builder.buildRequest(id);

        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody periodicVoiceCallReport() throws IOException {
        builder.URL = URLDefinitions.PERIODIC_VOICE_CALL_REPORT;
        Request request = builder.buildRequest();

        return RequestExecutor.executeRequest(request);
    }


}