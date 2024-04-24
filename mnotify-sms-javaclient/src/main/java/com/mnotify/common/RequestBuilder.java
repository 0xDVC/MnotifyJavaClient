package com.mnotify.common;

import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * A utility class for building HTTP requests.
 */
public class RequestBuilder {
    private final Request.Builder builder;
    public static String URL;

    public RequestBuilder(String API_KEY) {
        builder = new Request.Builder()
                .addHeader("Authorization", API_KEY)
                .addHeader("Content-Type", "application/json");
    }

    public RequestBuilder(String API_KEY, String URL) {
        builder = new Request.Builder()
                .addHeader("Authorization", API_KEY)
                .addHeader("Content-Type", "application/json");

        this.URL = URL;
    }
    /**
     * Builds an HTTP request with the given URL and API key.
     * @return        The HTTP request object.
     */

    public Request buildRequest() {
        return builder
                .url(URL)
                .build();
    }

    /**
     * Builds an HTTP request with the given URL, ID, and API key.
     * @param id      The ID of the resource.
     * @return        The HTTP request object.
     */

    public Request buildRequest(int id) {
        return builder
                .url(URL + "/" + id)
                .build();
    }

    /**
     * Builds an HTTP request with the given URL, IDs, and API key.
     * @param id1     The first ID of the resource.
     * @param id2     The second ID of the resource.
     * @return        The HTTP request object.
     */
    public Request buildRequest(int id1, int id2) {
        return builder
                .url(URL + "/" + id1 + "/" + id2)
                .build();
    }

    /**
     * Builds an HTTP request with the given URL, request body, and API key.
     * @param requestBody  The request body for the API request.
     * @return        The HTTP request object.
     */
    public Request buildRequestWithBody(RequestBody requestBody) {
        return builder
                .url(URL)
                .post(requestBody)
                .build();
    }

    /**
     * Builds an HTTP request with the given URL, ID, request body, and API key.
     * @param id      The ID of the resource.
     * @param requestBody  The request body for the API request.
     * @return        The HTTP request object.
     */
    public Request buildRequestWithBody(int id, RequestBody requestBody) {
        return builder
                .url(URL + "/" + id)
                .post(requestBody)
                .build();
    }

    /**
     * Builds an HTTP delete request with the given URL and ID.
     * @param id      The ID of the resource.
     * @return        The HTTP delete request object.
     */
    public Request deleteRequest(int id) {
        return builder
                .url(URL + "/" + id)
                .delete()
                .build();
    }

    /**
     * Builds an HTTP delete request with the given URL and IDs.
     * @param id1      The ID of the resource.
     * @param id2      The ID of the resource.
     * @return        The HTTP delete request object.
     */
    public Request deleteRequest(int id1, int id2) {
        return builder
                .url(URL + "/" + id1 + "/" + id2)
                .delete()
                .build();
    }
}
