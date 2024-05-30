package com.mnotify;

import com.mnotify.common.RequestExecutor;
import com.mnotify.definitions.*;

/**
 * This interface represents a client for the Mnotify API.
 * It provides factory methods for creating instances of various API resources.
 */
@SuppressWarnings(value = "unused")
public interface MnotifyClient {
    /**
     * Creates a new Campaign resource.
     * @return a new Campaign instance
     */
    Campaign campaign();

    /**
     * Creates a new Contact resource.
     * @return a new Contact instance
     */
    Contact contact();

    /**
     * Creates a new Group resource.
     * @return a new Group instance
     */
    Group group();

    /**
     * Creates a new MessageTemplate resource.
     * @return a new MessageTemplate instance
     */
    MessageTemplate messageTemplate();

    /**
     * Creates a new ReportsAndStats resource.
     * @return a new ReportsAndStats instance
     */
    ReportsAndStats reportsAndStats();

    /**
     * This class provides the actual implementation of the MnotifyClient interface.
     */
    final class Impl implements MnotifyClient {
        /**
         * Constructs a new Impl instance.
         * @param API_KEY the API key to use for authenticating with the Mnotify API
         */
        Impl(String API_KEY) {
            RequestExecutor.setApiKey(API_KEY);
        }
        @Override
        public Campaign campaign() {
            return new Campaign();
        }

        @Override
        public Contact contact() {
            return new Contact();
        }

        @Override
        public Group group() {
            return new Group();
        }

        @Override
        public MessageTemplate messageTemplate() {
            return new MessageTemplate();
        }

        @Override
        public ReportsAndStats reportsAndStats() {
            return new ReportsAndStats();
        }
    }
}
