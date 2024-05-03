package com.mnotify.common;

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
    /**
     * Executes an HTTP request and returns the response body.
     *
     * @param request The HTTP request object.
     * @return        The response body as a ResponseBody object.
     * @throws MNotifyAPICallException If the request fails or the response is not successful.
     */
    public static ResponseBody executeRequest(Request request) {
        OkHttpClient client = new OkHttpClient();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new MNotifyAPICallException("Unexpected response code: ", response.code());
            }
        } catch(IOException e) {
            throw new MNotifyAPICallException("Failed to make request: ", e);
        }
    }

}
