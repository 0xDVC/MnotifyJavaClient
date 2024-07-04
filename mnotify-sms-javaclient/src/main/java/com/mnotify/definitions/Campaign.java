package com.mnotify.definitions;

import com.google.gson.JsonElement;
import com.mnotify.common.RequestBuilder;
import com.mnotify.common.RequestExecutor;
import com.mnotify.constants.URLDefinitions;
import okhttp3.*;

import java.io.File;
import java.time.LocalDateTime;

import java.util.List;


/**
 * The Campaign class provides methods to send Bulk SMS or Bulk Voice Call to individuals or groups.
 * Each campaign consists of both sending using quick or group.
**/
@SuppressWarnings(value = "unused")
public class Campaign {
    RequestBuilder builder;
    public Campaign() {
        builder = new RequestBuilder();
    }

    public JsonElement quickBulkSMS(List<String> recipients,
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

        RequestBuilder.URL = URLDefinitions.QUICK_BULK_SMS;
        Request request = builder.buildRequestWithBody(requestBody);
        return RequestExecutor.executeRequest(request);
    }


    public JsonElement groupBulkSMS(List<String> groupIds,
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

        RequestBuilder.URL = URLDefinitions.GROUP_BULK_SMS;
        Request request = builder.buildRequestWithBody(requestBody);

        return RequestExecutor.executeRequest(request);
    }

    public JsonElement scheduledSMS() {
        RequestBuilder.URL = URLDefinitions.SCHEDULED_SMS;
        Request request = builder.buildRequest();
        return RequestExecutor.executeRequest(request);
    }

    public JsonElement updateScheduledSMS(int id,
                                           String sender,
                                           String message,
                                           LocalDateTime scheduledDateTime) {
        RequestBody requestBody = new FormBody.Builder()
                .add("sender", sender)
                .add("message", message)
                .add("scheduled_date", String.valueOf(scheduledDateTime))
                .build();

        RequestBuilder.URL = URLDefinitions.SCHEDULED_SMS;
        Request request = builder.buildRequestWithBody(id, requestBody);
        return RequestExecutor.executeRequest(request);
    }

    public JsonElement quickBulkVoiceCall(
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

        RequestBuilder.URL = URLDefinitions.QUICK_BULK_VOICE_CALL;
        Request request = builder.buildRequestWithBody(multipartBody);

        return RequestExecutor.executeRequest(request);

    }

    public JsonElement groupBulkVoiceCall(
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

        RequestBuilder.URL = URLDefinitions.GROUP_BULK_VOICE_CALL;
        Request request = builder.buildRequestWithBody(multipartBody);

        return RequestExecutor.executeRequest(request);
    }

    public JsonElement senderIdRegistration(String sender, String purpose) {
        RequestBody requestBody = new FormBody.Builder()
                .add("sender_name", sender)
                .add("purpose", purpose)
                .build();
        RequestBuilder.URL = URLDefinitions.SENDER_ID_REGISTRATION;
        Request request = builder.buildRequestWithBody(requestBody);

        return RequestExecutor.executeRequest(request);
    }

    public JsonElement checkSenderIdStatus(String sender) {
        RequestBody requestBody = new FormBody.Builder()
                .add("sender_name", sender)
                .build();

        RequestBuilder.URL = URLDefinitions.SENDER_ID_STATUS;
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
