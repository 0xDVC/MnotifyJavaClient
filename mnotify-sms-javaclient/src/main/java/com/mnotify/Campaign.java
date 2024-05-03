package com.mnotify;

import com.mnotify.common.RequestBuilder;
import com.mnotify.common.RequestExecutor;
import com.mnotify.constants.URLDefinitions;
import okhttp3.*;

import java.io.File;
import java.io.IOException;

import java.time.LocalDateTime;

import java.util.List;


/**
 * The Campaign class provides methods to send Bulk SMS or Bulk Voice Call to individuals or groups.
 * Each campaign consists of both sending using quick or group.
**/

public class Campaign {
    RequestBuilder builder;
    public Campaign(String API_KEY) {
        builder = new RequestBuilder(API_KEY);
    }

    public ResponseBody quickBulkSMS(List<String> recipients,
                                     String sender,
                                     String message,
                                     boolean isSchedule,
                                     LocalDateTime scheduledDate) {
        RequestBody requestBody = new FormBody.Builder()
                .add("recipient", String.join(",", recipients))
                .add("sender", sender)
                .add("message", message)
                .add("is_schedule", String.valueOf(isSchedule))
                .add("scheduled_date", String.valueOf(scheduledDate))
                .build();

        builder.URL = URLDefinitions.QUICK_BULK_SMS;
        Request request = builder.buildRequestWithBody(requestBody);
        return RequestExecutor.executeRequest(request);
    }


    public ResponseBody groupBulkSMS(List<String> groupIds,
                                     String sender,
                                     int messageID,
                                     boolean isSchedule,
                                     LocalDateTime scheduledDate) {

        RequestBody requestBody = new FormBody.Builder()
                .add("group_id", String.join(",", groupIds))
                .add("sender", sender)
                .add("message", String.valueOf(messageID))
                .add("is_schedule", String.valueOf(isSchedule))
                .add("scheduled_date", String.valueOf(scheduledDate))
                .build();

        Request request = builder.buildRequestWithBody(requestBody);

        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody scheduledSMS() {
        builder.URL = URLDefinitions.SCHEDULED_SMS;
        Request request = builder.buildRequest();
        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody updateScheduledSMS(int id,
                                           String sender,
                                           String message,
                                           LocalDateTime scheduledDateTime) {
        RequestBody requestBody = new FormBody.Builder()
                .add("sender", sender)
                .add("message", message)
                .add("scheduled_date", String.valueOf(scheduledDateTime))
                .build();

        Request request = builder.buildRequestWithBody(id, requestBody);
        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody quickBulkVoiceCall(
            String campaign,
            List<String> recipients,
            File file,
            String voiceId,
            boolean isSchedule,
            LocalDateTime scheduleDate) {

        RequestBody fileBody = RequestBody.create(MediaType.parse(getMimeType(file.getName())), file);

        MultipartBody multipartBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("campaign", campaign)
                .addFormDataPart("group_id", String.join(",", recipients))
                .addFormDataPart("file", file.getName(), fileBody)
                .addFormDataPart("voice_id", voiceId)
                .addFormDataPart("is_schedule", String.valueOf(isSchedule))
                .addFormDataPart("schedule_date", scheduleDate.toString())
                .build();

        builder.URL = URLDefinitions.QUICK_BULK_VOICE_CALL;
        Request request = builder.buildRequestWithBody(multipartBody);

        return RequestExecutor.executeRequest(request);

    }

    public ResponseBody groupBulkVoiceCall(
            String campaign,
            List<String> groupIds,
            File file,
            String voiceId,
            boolean isSchedule,
            LocalDateTime scheduleDate) {
        RequestBody fileBody = RequestBody.create(MediaType.parse(getMimeType(file.getName())), file);

        MultipartBody multipartBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("campaign", campaign)
                .addFormDataPart("recipient", String.join(",", groupIds))
                .addFormDataPart("file", file.getName(), fileBody)
                .addFormDataPart("voice_id", voiceId)
                .addFormDataPart("is_schedule", String.valueOf(isSchedule))
                .addFormDataPart("schedule_date", scheduleDate.toString())
                .build();

        builder.URL = URLDefinitions.GROUP_BULK_VOICE_CALL;
        Request request = builder.buildRequestWithBody(multipartBody);

        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody senderIdRegistration(String sender, String purpose) {
        RequestBody requestBody = new FormBody.Builder()
                .add("sender_name", sender)
                .add("purpose", purpose)
                .build();
        builder.URL = URLDefinitions.SENDER_ID_REGISTRATION;
        Request request = builder.buildRequestWithBody(requestBody);

        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody checkSenderIdStatus(String sender) {
        RequestBody requestBody = new FormBody.Builder()
                .add("sender_name", sender)
                .build();

        builder.URL = URLDefinitions.SENDER_ID_STATUS;
        Request request = builder.buildRequestWithBody(requestBody);

        return RequestExecutor.executeRequest(request);
    }


    private String getMimeType(String fileName) {
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);

        return switch (extension.toLowerCase()) {
            case "mp3" -> "audio/mpeg";
            case "wav" -> "audio/wav";
            default -> "application/octet-stream";
        };
    }

}
