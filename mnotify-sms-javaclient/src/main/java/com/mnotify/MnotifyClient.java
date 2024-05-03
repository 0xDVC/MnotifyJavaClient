package com.mnotify;

import com.mnotify.definitions.*;

public interface MnotifyClient {
    Campaign campaign();
    Contact contact();
    Group group();
    MessageTemplate messageTemplate();
    ReportsAndStats reportsAndStats();

    final class Impl implements MnotifyClient {
        private String key;
        Impl(String API_KEY) {
            this.key = API_KEY;
        }
        @Override
        public Campaign campaign() {
            return new Campaign(this.key);
        }

        @Override
        public Contact contact() {
            return new Contact(this.key);
        }

        @Override
        public Group group() {
            return new Group(this.key);
        }

        @Override
        public MessageTemplate messageTemplate() {
            return new MessageTemplate(this.key);
        }

        @Override
        public ReportsAndStats reportsAndStats() {
            return new ReportsAndStats(this.key);
        }
    }
}
