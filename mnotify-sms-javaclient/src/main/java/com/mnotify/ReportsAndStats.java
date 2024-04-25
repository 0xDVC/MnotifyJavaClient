package com.mnotify;


import com.mnotify.common.RequestBuilder;
import com.mnotify.common.RequestExecutor;
import com.mnotify.constants.URLDefinitions;
import okhttp3.Request;
import okhttp3.ResponseBody;

import java.io.IOException;

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

        return RequestExecutor.executeRequest(request)
    }

//    public ResponseBody smsDeliveryReport() {
//        builder.URL = URLDefinitions.SMS_DELIVERY_REPORT;
//        Request request  = builder.buildRequest();
//    }
}