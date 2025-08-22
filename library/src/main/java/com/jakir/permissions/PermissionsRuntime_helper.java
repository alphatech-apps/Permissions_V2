package com.jakir.permissions;

import android.Manifest;
import android.os.Build;

import java.util.HashMap;

public class PermissionsRuntime_helper {
    // 🔢 All request codes
    public static final int REQUEST_CODE_ALL_PERMISSION = 10001, REQUEST_CODE_MEDIASTORAGE_AUDIO = 1010101010, REQUEST_CODE_MEDIASTORAGE_IMAGE = 10101010, REQUEST_CODE_MICROPHONE = 1111, REQUEST_CODE_SMS = 2222, REQUEST_CODE_PHONE = 3333, REQUEST_CODE_CALLLOG = 4444, REQUEST_CODE_LOCATION = 5555, REQUEST_CODE_CAMERA = 6666, REQUEST_CODE_CONTACTS = 7777, REQUEST_CODE_MEDIASTORAGE = 8888, REQUEST_CODE_FILESTORAGE = 1111013, REQUEST_CODE_NOTIFICATION = 9999;


    private static final HashMap<String, String> permissionNameMap = new HashMap<>();
    private static final HashMap<String, Integer> permissionAnimMap = new HashMap<>();
    private static final HashMap<String, String> permissionMessageMap = new HashMap<>();

    public static String[] AllPermissions = getAllPermissions();
    public static String[] MediaStoragePermissions = getMediaStoragePermissions();
    public static String MediaImagePermission = getMediaImagePermissionNameFromApi();
    public static String MediaAudioPermission = getMediaAudioPermissionNameFromApi();
    public static String ContactsPermission = Manifest.permission.READ_CONTACTS;
    public static String CameraPermission = Manifest.permission.CAMERA;
    public static String LocationPermission = Manifest.permission.ACCESS_FINE_LOCATION;
    public static String CalLogPermission = Manifest.permission.READ_CALL_LOG;
    public static String PhonePermission = Manifest.permission.READ_PHONE_STATE;
    public static String SmsPermission = Manifest.permission.READ_SMS;
    public static String RecordAudioPermission = Manifest.permission.RECORD_AUDIO;
    public static String NotificationPermission = Manifest.permission.POST_NOTIFICATIONS;
    public static String SEND_SMS = Manifest.permission.SEND_SMS;
    public static String READ_SMS = Manifest.permission.READ_SMS;
    public static String RECEIVE_SMS = Manifest.permission.RECEIVE_SMS;
    public static String READ_CALL_LOG = Manifest.permission.READ_CALL_LOG;
    public static String PROCESS_OUTGOING_CALLS = Manifest.permission.PROCESS_OUTGOING_CALLS;
    public static String CALL_PHONE = Manifest.permission.CALL_PHONE;
    public static String READ_CONTACTS = Manifest.permission.READ_CONTACTS;
    public static String WRITE_CONTACTS = Manifest.permission.WRITE_CONTACTS;
    public static String READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;
    public static String CAMERA = Manifest.permission.CAMERA;
    public static String ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    public static String ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    public static String RECORD_AUDIO = Manifest.permission.RECORD_AUDIO;
    public static String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public static String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public static String READ_MEDIA_AUDIO = Manifest.permission.READ_MEDIA_AUDIO;
    public static String READ_MEDIA_IMAGES = Manifest.permission.READ_MEDIA_IMAGES;
    public static String READ_MEDIA_VIDEO = Manifest.permission.READ_MEDIA_VIDEO;
    public static String POST_NOTIFICATIONS = Manifest.permission.POST_NOTIFICATIONS;

    static {
        permissionNameMap.put(Manifest.permission.SEND_SMS, "SMS");
        permissionNameMap.put(Manifest.permission.READ_SMS, "SMS");
        permissionNameMap.put(Manifest.permission.RECEIVE_SMS, "SMS");
        permissionNameMap.put(Manifest.permission.READ_CALL_LOG, "Call Logs");
        permissionNameMap.put(Manifest.permission.PROCESS_OUTGOING_CALLS, "Call Logs");
        permissionNameMap.put(Manifest.permission.CALL_PHONE, "Call Logs");
        permissionNameMap.put(Manifest.permission.READ_CONTACTS, "Contacts");
        permissionNameMap.put(Manifest.permission.WRITE_CONTACTS, "Contacts");
        permissionNameMap.put(Manifest.permission.READ_PHONE_STATE, "Phone");
        permissionNameMap.put(Manifest.permission.CAMERA, "Camera");
        permissionNameMap.put(Manifest.permission.ACCESS_COARSE_LOCATION, "Location");
        permissionNameMap.put(Manifest.permission.ACCESS_FINE_LOCATION, "Location");
        permissionNameMap.put(Manifest.permission.RECORD_AUDIO, "Microphone");
        permissionNameMap.put(Manifest.permission.WRITE_EXTERNAL_STORAGE, "Storage");
        permissionNameMap.put(Manifest.permission.READ_EXTERNAL_STORAGE, "Storage");
        permissionNameMap.put(Manifest.permission.POST_NOTIFICATIONS, "Notifications");
        permissionNameMap.put(Manifest.permission.READ_MEDIA_AUDIO, "Music & Audio");
        permissionNameMap.put(Manifest.permission.READ_MEDIA_IMAGES, "Photos & Videos");
        permissionNameMap.put(Manifest.permission.READ_MEDIA_VIDEO, "Photos & Videos");
    }

    static {
        permissionAnimMap.put("Multiple", R.raw.permissionrequried);
//        permissionAnimMap.put("Media Storage", R.raw.folder01);

        permissionAnimMap.put("SMS", R.raw.message01);
        permissionAnimMap.put("Call Logs", R.raw.call01);
        permissionAnimMap.put("Contacts", R.raw.contacts01);
        permissionAnimMap.put("Phone", R.raw.call02);
        permissionAnimMap.put("Camera", R.raw.camera01);
        permissionAnimMap.put("Location", R.raw.maps01);
        permissionAnimMap.put("Microphone", R.raw.microphone02);
        permissionAnimMap.put("Storage", R.raw.folder01);
        permissionAnimMap.put("Notifications", R.raw.notification05);
        permissionAnimMap.put("Music & Audio", R.raw.audio01);
        permissionAnimMap.put("Photos & Videos", R.raw.imagefile);
    }

    static {
        permissionMessageMap.put("Multiple", "All permissions are required for the full functionality of the app.");
        permissionMessageMap.put("Media Storage", "Media Storage permission is required to access media files (photos and videos) on your device.");
        permissionMessageMap.put("SMS", "SMS permission is required to send and receive text messages.");
        permissionMessageMap.put("Call Logs", "Call Logs permission is required to read and manage your call history.");
        permissionMessageMap.put("Contacts", "Contacts permission is required to access and manage your contacts.");
        permissionMessageMap.put("Phone", "Phone permission is required to make and manage phone calls.");
        permissionMessageMap.put("Camera", "Camera permission is required to take photos and record videos.");
        permissionMessageMap.put("Location", "Location permission is required to access your current location.");
        permissionMessageMap.put("Microphone", "Microphone permission is required to record audio.");
        permissionMessageMap.put("Storage", "Storage permission is required to access photos, videos, audios and manage all files on your device.");
        permissionMessageMap.put("Notifications", "Notification permission is required to send you important alerts.");
        permissionMessageMap.put("Music & Audio", "Music & Audio access is required to read your audio files.");
        permissionMessageMap.put("Photos & Videos", "Photos & Videos permission is required to access media files (photos and videos) on your device.");
    }

    private static String[] getAllPermissions() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            String[] PermissionsOLd = {Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_CALL_LOG, Manifest.permission.PROCESS_OUTGOING_CALLS, Manifest.permission.CALL_PHONE, Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
            return PermissionsOLd;
        } else {
            return new String[]{Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_CALL_LOG, Manifest.permission.PROCESS_OUTGOING_CALLS, Manifest.permission.CALL_PHONE, Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.RECORD_AUDIO, Manifest.permission.POST_NOTIFICATIONS, Manifest.permission.READ_MEDIA_AUDIO, Manifest.permission.READ_MEDIA_IMAGES, Manifest.permission.READ_MEDIA_VIDEO};
        }
    }

    private static String[] getMediaStoragePermissions() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            return new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        } else {
            return new String[]{Manifest.permission.READ_MEDIA_AUDIO, Manifest.permission.READ_MEDIA_IMAGES, Manifest.permission.READ_MEDIA_VIDEO};
        }
    }

    public static String getMediaImagePermissionNameFromApi() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            return Manifest.permission.READ_EXTERNAL_STORAGE;
        } else {
            return Manifest.permission.READ_MEDIA_IMAGES;
        }
    }

    public static String getMediaAudioPermissionNameFromApi() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            return Manifest.permission.READ_EXTERNAL_STORAGE;
        } else {
            return Manifest.permission.READ_MEDIA_AUDIO;
        }
    }


    public static String getPermissionName(String permissionName) {
        String readableName = permissionNameMap.get(permissionName);
        return (readableName != null) ? readableName : "Unknown Permission";

    }

    public static int getPermissionAnim(String permissionName) {
        Integer animRes = permissionAnimMap.get(permissionName);
        return (animRes != null) ? animRes : R.raw.permissionrequried; // default fallback
    }

    public static String getPermissionMessage(String permissionName) {
        String msg = permissionMessageMap.get(permissionName);
        return (msg != null) ? msg : "This permission is required for app functionality.";
    }
}

