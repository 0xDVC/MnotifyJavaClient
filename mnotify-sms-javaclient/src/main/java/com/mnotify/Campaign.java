package com.mnotify;

import com.mnotify.common.RequestBuilder;
import com.mnotify.common.RequestExecutor;
import com.mnotify.constants.URLDefinitions;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import java.io.IOException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Campaign class provides methods to send Bulk SMS or Bulk Voice Call to individuals or groups.
 * Each campaign consists of both sending using quick or group.
 *
 * @author Neil Ohene on 2024-04-23
**/

public class Campaign {
    private final String apiKey;

    public Campaign(String apiKey) {
        this.apiKey = apiKey;
    }

    public ResponseBody quickBulkSMS(List<String> recipients, String sender, String message, boolean isSchedule, LocalDateTime scheduledDate) throws IOException {
        RequestBody requestBody = new FormBody.Builder()
                .add("recipient", String.join(",", recipients))
                .add("sender", sender)
                .add("message", message)
                .add("is_schedule", String.valueOf(isSchedule))
                .add("scheduled_date", String.valueOf(scheduledDate))
                .build();

        Request request = RequestBuilder.buildRequestWithBody(URLDefinitions.QUICK_BULK_SMS, requestBody, apiKey);

        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody groupBulkSMS(List<Integer> groupIds, String sender, int messageID, boolean isSchedule, LocalDateTime scheduledDate) throws IOException {
        List<String> stringGroupIds = groupIds.stream().map(Object::toString).collect(Collectors.toList());

        RequestBody requestBody = new FormBody.Builder()
                .add("group_id", String.join(",", stringGroupIds))
                .add("sender", sender)
                .add("message", String.valueOf(messageID))
                .add("is_schedule", String.valueOf(isSchedule))
                .add("scheduled_date", String.valueOf(scheduledDate))
                .build();

        Request request = RequestBuilder.buildRequestWithBody(URLDefinitions.QUICK_BULK_SMS, requestBody, apiKey);

        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody scheduledSMS() throws IOException {
        Request request = RequestBuilder.buildRequest(URLDefinitions.SCHEDULED_SMS, apiKey);
        return RequestExecutor.executeRequest(request);
    }

    public ResponseBody updateScheduledSMS(int id, String sender, String message, LocalDateTime scheduledDateTime) throws IOException {
        RequestBody requestBody = new FormBody.Builder()
                .add("sender", sender)
                .add("message", message)
                .add("scheduled_date", String.valueOf(scheduledDateTime))
                .build();

        Request request = RequestBuilder.buildRequestWithBody(URLDefinitions.SCHEDULED_SMS, id, requestBody, apiKey);
        return RequestExecutor.executeRequest(request);
    }



}
