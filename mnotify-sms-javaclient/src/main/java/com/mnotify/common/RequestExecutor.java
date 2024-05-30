package com.mnotify.common;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mnotify.exception.MNotifyAPICallException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;


/**
 * A utility class for executing HTTP requests and building responses.
 */
public class RequestExecutor {
    private static final OkHttpClient client = new OkHttpClient();
    private static String apiKey;

    public static void setApiKey(String apiKey) {
        RequestExecutor.apiKey = apiKey;
    }
    /**
     * Executes an HTTP request and returns the response body.
     *
     * @param request The HTTP request object.
     * @return        The response body as a ResponseBody object.
     * @throws MNotifyAPICallException If the request fails or the response is not successful.
     */
    public static JsonElement executeRequest(Request request) {
        Request requestWithApiKey = request.newBuilder()
                .header("Authorization", "Bearer " + apiKey)
                .build();

        try (Response response = client.newCall(requestWithApiKey).execute()) {
            if (response.isSuccessful()) {
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    return JsonParser.parseString(responseBody.string());
                } else {
                    throw new MNotifyAPICallException("Empty response for request: ", String.valueOf(request.url()));
                }
            } else {
                throw new MNotifyAPICallException("Unexpected response code: ", response.code());
            }
        } catch(IOException e) {
            throw new MNotifyAPICallException("Failed to make request: ", e);
        }
    }

}
