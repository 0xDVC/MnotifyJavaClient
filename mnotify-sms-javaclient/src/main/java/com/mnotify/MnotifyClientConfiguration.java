package com.mnotify;

final class MnotifyClientConfiguration {
    public static MnotifyClient buildClientFrom(String apiKey) {
        return new MnotifyClient.Impl(apiKey);
    }
}
