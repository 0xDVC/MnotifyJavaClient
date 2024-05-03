package com.mnotify;

final class MnotifyClientConfiguration {
    public static MnotifyClient buildClientFrom(String secretKey) {
        return new MnotifyClient.Impl(secretKey);
    }
}
