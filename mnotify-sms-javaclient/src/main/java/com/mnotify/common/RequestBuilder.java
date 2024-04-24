package com.mnotify.common;

import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * A utility class for building HTTP requests.
 */
public class RequestBuilder {
    /**
     * Builds an HTTP request with the given URL and API key.
     *
     * @param url     The URL of the API endpoint.
     * @param apiKey  The API key for authentication.
     * @return        The HTTP request object.
     */

    public static Request buildRequest(String url, String apiKey) {
        return new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", apiKey)
                .build();
    }

    /**
     * Builds an HTTP request with the given URL, ID, and API key.
     *
     * @param url     The URL of the API endpoint.
     * @param id      The ID of the resource.
     * @param apiKey  The API key for authentication.
     * @return        The HTTP request object.
     */

    public static  Request buildRequest(String url, int id, String apiKey) {
        return new Request.Builder()
                .url(url + "/" + id)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", apiKey)
                .build();
    }

    /**
     * Builds an HTTP request with the given URL, IDs, and API key.
     *
     * @param url     The URL of the API endpoint.
     * @param id1     The first ID of the resource.
     * @param id2     The second ID of the resource.
     * @param apiKey  The API key for authentication.
     * @return        The HTTP request object.
     */
    public static  Request buildRequest(String url, int id1, int id2, String apiKey) {
        return new Request.Builder()
                .url(url + "/" + id1 + "/" + id2)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", apiKey)
                .build();
    }

    /**
     * Builds an HTTP request with the given URL, request body, and API key.
     *
     * @param url     The URL of the API endpoint.
     * @param requestBody  The request body for the API request.
     * @param apiKey  The API key for authentication.
     * @return        The HTTP request object.
     */
    public static Request buildRequestWithBody(String url, RequestBody requestBody, String apiKey) {
        return new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", apiKey)
                .post(requestBody)
                .build();
    }

    /**
     * Builds an HTTP request with the given URL, ID, request body, and API key.
     *
     * @param url     The URL of the API endpoint.
     * @param id      The ID of the resource.
     * @param requestBody  The request body for the API request.
     * @param apiKey  The API key for authentication.
     * @return        The HTTP request object.
     */
    public static Request buildRequestWithBody(String url, int id, RequestBody requestBody, String apiKey) {
        return new Request.Builder()
                .url(url + "/" + id)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", apiKey)
                .post(requestBody)
                .build();
    }

    /**
     * Builds an HTTP delete request with the given URL and ID.
     *
     * @param url     The URL of the API endpoint.
     * @param id      The ID of the resource.
     * @param apiKey  The API key for authentication.
     * @return        The HTTP delete request object.
     */
    public static Request deleteRequest(String url, int id, String apiKey) {
        return new Request.Builder()
                .url(url + "/" + id)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", apiKey)
                .delete()
                .build();
    }
}
