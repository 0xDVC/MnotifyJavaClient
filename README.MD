# MNOTIFY JAVA CLIENT

> A typed Java Rest client interface for [MNotify BMS APIs](https://readthedocs.mnotify.com/)


## Usage

Here's a basic example of how to use the Mnotify Java Client Library:

```java

import com.mnotify.MnotifyClient;

import com.mnotify.MnotifyClientConfiguration;


public Test {

    public static void main(String[] args) {

        // Create a client using your API key
        MnotifyClient client = MnotifyClientConfiguration.buildClientFrom("YOUR_API_KEY");


        // Use the client to interact with the API
        Campaign campaign = client.campaign();
        Contact contact = client.contact();
        Group group = client.group();
        MessageTemplate messageTemplate = client.messageTemplate();
        ReportsAndStats reportsAndStats = client.reportsAndStats();

        // Use these objects to interact with the corresponding parts of the API

        // For example:

        campaign.createCampaign("Campaign Name","Campaign Message");

    }

}
```


_Still under construction_
