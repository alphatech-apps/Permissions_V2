package com.jakir.permissions;


import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_ALL_PERMISSION;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_CALLLOG;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_CAMERA;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_CONTACTS;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_FILESTORAGE;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_LOCATION;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_MEDIASTORAGE;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_MICROPHONE;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_NOTIFICATION;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_PHONE;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_SMS;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.jakir.permissions.dialogs.Bottomsheet_dialog_Access;
import com.jakir.permissions.dialogs.Bottomsheet_dialog_Multiple;
import com.jakir.permissions.dialogs.Bottomsheet_dialog_Single;

public class PermissionsRuntime {

    // 🔐 Check single permission
    public static boolean isPermissionGranted(Context context, String permissionName) {
        return ContextCompat.checkSelfPermission(context, permissionName) == PackageManager.PERMISSION_GRANTED;
    }

    // 🔐 Check multiple permissions
    public static boolean isMultiplePermissionGranted(Context context, String[] permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    // 📥 Request single permission using dialog
    public static void requestPermission(Context context, String permission, int requestCode, String message, boolean showDialog, Drawable image) {
        Bottomsheet_dialog_Single dialog = new Bottomsheet_dialog_Single(context);
        if (showDialog) {
            dialog.show(permission, requestCode, message, image);
        } else {
            dialog.Notshow(permission, requestCode);
        }
    }

    // 📥 Request multiple permissions using dialog
    public static void requestMultiplePermission(Context context, String[] permissions, int requestCode, String message, boolean showDialog, Drawable image) {
        Bottomsheet_dialog_Multiple dialog = new Bottomsheet_dialog_Multiple(context);
        if (showDialog) {
            dialog.show(permissions, requestCode, message, image);
        } else {
            dialog.Notshow(permissions, requestCode);
        }
    }

    // 🧾 All-in-one multiple permission request
    public static void requestAllPermission(Context context, String message, boolean showDialog, Drawable image) {
        requestMultiplePermission(context, PermissionsRuntime_helper.AllPermissions, REQUEST_CODE_ALL_PERMISSION, message, showDialog, image);
    }

    // 🎵 Media Storage (images + audio)
    public static boolean checkMediaStoragePermission(Context context) {
        return isPermissionGranted(context, PermissionsRuntime_helper.MediaImagePermission) && isPermissionGranted(context, PermissionsRuntime_helper.MediaAudioPermission);
    }

    public static void requestMediaStoragePermission(Context context, String message, boolean showDialog, Drawable image) {
        requestMultiplePermission(context, PermissionsRuntime_helper.MediaStoragePermissions, REQUEST_CODE_MEDIASTORAGE, message, showDialog, image);
    }

    // 📁 File storage (scoped or legacy)
    public static boolean checkFileStoragePermission(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            return Environment.isExternalStorageManager();
        } else {
            return isPermissionGranted(context, PermissionsRuntime_helper.READ_EXTERNAL_STORAGE);
        }
    }

    public static void requestFileStoragePermission(Context context, String message, boolean showDialog, Drawable image) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            Bottomsheet_dialog_Access dialog = new Bottomsheet_dialog_Access(context);
            if (showDialog) {
                dialog.show(REQUEST_CODE_FILESTORAGE, message, image, null);
            } else {
                dialog.Notshow(REQUEST_CODE_FILESTORAGE, null);
            }
        } else {
            requestMultiplePermission(context, PermissionsRuntime_helper.MediaStoragePermissions, REQUEST_CODE_FILESTORAGE, message, showDialog, image);
        }
    }

    // 🔄 Below are shortcut wrappers for common permissions
    public static boolean checkContactsPermission(Context context) {
        return isPermissionGranted(context, PermissionsRuntime_helper.ContactsPermission);
    }

    public static void requestContactsPermission(Context context, String msg, boolean showDialog, Drawable image) {
        requestPermission(context, PermissionsRuntime_helper.ContactsPermission, REQUEST_CODE_CONTACTS, msg, showDialog, image);
    }

    public static boolean checkCameraPermission(Context context) {
        return isPermissionGranted(context, PermissionsRuntime_helper.CameraPermission);
    }

    public static void requestCameraPermission(Context context, String msg, boolean showDialog, Drawable image) {
        requestPermission(context, PermissionsRuntime_helper.CameraPermission, REQUEST_CODE_CAMERA, msg, showDialog, image);
    }

    public static boolean checkLocationPermission(Context context) {
        return isPermissionGranted(context, PermissionsRuntime_helper.LocationPermission);
    }

    public static void requestLocationPermission(Context context, String msg, boolean showDialog, Drawable image) {
        requestPermission(context, PermissionsRuntime_helper.LocationPermission, REQUEST_CODE_LOCATION, msg, showDialog, image);
    }

    public static boolean checkCallLogPermission(Context context) {
        return isPermissionGranted(context, PermissionsRuntime_helper.CalLogPermission);
    }

    public static void requestCallLogPermission(Context context, String msg, boolean showDialog, Drawable image) {
        requestPermission(context, PermissionsRuntime_helper.CalLogPermission, REQUEST_CODE_CALLLOG, msg, showDialog, image);
    }

    public static boolean checkPhonePermission(Context context) {
        return isPermissionGranted(context, PermissionsRuntime_helper.PhonePermission);
    }

    public static void requestPhonePermission(Context context, String msg, boolean showDialog, Drawable image) {
        requestPermission(context, PermissionsRuntime_helper.PhonePermission, REQUEST_CODE_PHONE, msg, showDialog, image);
    }

    public static boolean checkSmsPermission(Context context) {
        return isPermissionGranted(context, PermissionsRuntime_helper.SmsPermission);
    }

    public static void requestSmsPermission(Context context, String msg, boolean showDialog, Drawable image) {
        requestPermission(context, PermissionsRuntime_helper.SmsPermission, REQUEST_CODE_SMS, msg, showDialog, image);
    }

    public static boolean checkMicrophonePermission(Context context) {
        return isPermissionGranted(context, PermissionsRuntime_helper.RecordAudioPermission);
    }

    public static void requestMicrophonePermission(Context context, String msg, boolean showDialog, Drawable image) {
        requestPermission(context, PermissionsRuntime_helper.RecordAudioPermission, REQUEST_CODE_MICROPHONE, msg, showDialog, image);
    }

    public static boolean checkNotificationPermission(Context context) {
        return isPermissionGranted(context, PermissionsRuntime_helper.NotificationPermission);
    }

    public static void requestNotificationPermission(Context context, String msg, boolean showDialog, Drawable image) {
        requestPermission(context, PermissionsRuntime_helper.NotificationPermission, REQUEST_CODE_NOTIFICATION, msg, showDialog, image);
    }


    public static void checkRationale_RequestPermission(Activity activity, String permissionName, int allow_code) {
        if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, permissionName)) {
            LayoutInflater layoutInflater;
            if (!permissionName.equals(PermissionsRuntime_helper.NotificationPermission)) { // first check permission is Notification or not
                BottomSheetDialog dialog;
                View view = activity.getLayoutInflater().inflate(R.layout.bottomsheet_permission_settings, null);
                dialog = new BottomSheetDialog(activity, R.style.AppBottomSheetDialogTheme); // Style here
                dialog.setContentView(view);
                dialog.show();
                if (dialog.getWindow() != null) {
                    dialog.getWindow().setNavigationBarColor(ContextCompat.getColor(activity, R.color.DayLight_NightDark)); //✅ NavigationBar color fix
                }
//                TextView allow_settings = dialog.findViewById(R.id.allow_settings);
                Button allow_settings = dialog.findViewById(R.id.allow_settings_btn);
                allow_settings.setOnClickListener(view1 -> {
                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
                    intent.setData(uri);
                    activity.startActivity(intent);
                });
                ActivityCompat.requestPermissions(activity, new String[]{permissionName}, allow_code);
            } else { // permission is notification so go direct notification settings
                Intent intent;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    intent = new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
                    intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
                } else {
                    intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    String packageName = activity.getPackageName();
                    intent.setData(Uri.parse("package:" + packageName));
                }
                activity.startActivity(intent);

            }
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{permissionName}, allow_code);
        }
    }

    public static void checkRationale_RequestMultiplePermission(Activity activity, String[] permissions, int allow_code) {
        boolean rtnl = false;
        for (String permission : permissions) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                rtnl = true;
                break;
            }
        }
        if (rtnl) {
            BottomSheetDialog dialog;
            View view = activity.getLayoutInflater().inflate(R.layout.bottomsheet_permission_settings, null);
            dialog = new BottomSheetDialog(activity, R.style.AppBottomSheetDialogTheme); // Style here
            dialog.setContentView(view);
            dialog.show();
            if (dialog.getWindow() != null) {
                dialog.getWindow().setNavigationBarColor(ContextCompat.getColor(activity, R.color.DayLight_NightDark)); //✅ NavigationBar color fix
            }
//            TextView allow_settings = dialog.findViewById(R.id.allow_settings);
            Button allow_settings = dialog.findViewById(R.id.allow_settings_btn);
            allow_settings.setOnClickListener(view1 -> {
                dialog.dismiss();
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
                intent.setData(uri);
                activity.startActivity(intent);
            });
        }
        ActivityCompat.requestPermissions(activity, permissions, allow_code);
    }

}
