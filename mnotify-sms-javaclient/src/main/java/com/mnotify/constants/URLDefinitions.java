package com.mnotify.constants;

/**
 * The URLDefinitions class provides constants for defining API endpoints used in the MNotify service.
 * It includes endpoints for interacting with various functionalities such as contacts, groups, messages, etc.
 *
 * @author Neil Ohene on 2024-04-23
 */

public class URLDefinitions {
    private final static String BASE_API_ENDPOINT = "https://api.mnotify.com/api";
    public static String CONTACT_ENDPOINT = BASE_API_ENDPOINT + "/contact";
    public static String GROUP_ENDPOINT = BASE_API_ENDPOINT + "/group";
    public static String MESSAGE_ENDPOINT = BASE_API_ENDPOINT + "/message";
    public static String QUICK_BULK_SMS = BASE_API_ENDPOINT + "/sms/quick";
    public static String GROUP_BULK_SMS = BASE_API_ENDPOINT + "/sms/group";
    public static String SCHEDULED_SMS = BASE_API_ENDPOINT + "/scheduled";
    public static String QUICK_BULK_VOICE_CALL = BASE_API_ENDPOINT + "/voice/quick";
    public static String GROUP_BULK_VOICE_CALL = BASE_API_ENDPOINT + "/voice/group";
    public static String SENDER_ID_REGISTRATION = BASE_API_ENDPOINT + "/senderid/register";
    public static String SENDER_ID_STATUS = BASE_API_ENDPOINT + "/senderid/status";
    public static String SMS_BALANCE = BASE_API_ENDPOINT + "/balance/sms";
    public static String SMS_DELIVERY_REPORT = BASE_API_ENDPOINT + "/campaign";
    public static String VOICE_BALANCE = BASE_API_ENDPOINT + "/balance/voice";
    public static String SPECIFIC_SMS_DELIVERY_REPORT = BASE_API_ENDPOINT + "/status";
    public static String PERIODIC_DELIVERY_REPORT = BASE_API_ENDPOINT + "/report";
    public static String VOICE_CALL_REPORT = BASE_API_ENDPOINT + "/calls";
    public static String SPECIFIC_VOICE_CALL_REPORT = BASE_API_ENDPOINT + "/call-status";
    public static String PERIODIC_VOICE_CALL_REPORT = BASE_API_ENDPOINT + "/call-period";

}
