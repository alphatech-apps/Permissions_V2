package com.jakir.permissions_v2;

import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_ALL_PERMISSION;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_CALLLOG;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_CAMERA;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_CONTACTS;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_FILESTORAGE;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_LOCATION;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_MEDIASTORAGE;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_MEDIASTORAGE_AUDIO;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_MEDIASTORAGE_IMAGE;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_MICROPHONE;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_NOTIFICATION;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_PHONE;
import static com.jakir.permissions.PermissionsRuntime_helper.REQUEST_CODE_SMS;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.materialswitch.MaterialSwitch;
import com.jakir.permissions.PermissionsRuntime;
import com.jakir.permissions.PermissionsRuntime_helper;

public class RuntimePermissionsActivity extends AppCompatActivity {
    MaterialSwitch sw_mediastorage_audio_allow, sw_mediastorage_image_allow, sw_mediastorage_allow, sw_contacts_allow, sw_camera_allow, sw_location_allow, sw_calllog_allow, sw_phone_allow, sw_sms_allow, sw_microphone_allow, sw_notification_allow, sw_filestorage_allow, sw_grant_all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_permissions);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        setListeners();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setSwitchToggle(sw_mediastorage_audio_allow, sw_mediastorage_image_allow, sw_mediastorage_allow, sw_contacts_allow, sw_camera_allow, sw_location_allow, sw_calllog_allow, sw_phone_allow, sw_sms_allow, sw_microphone_allow, sw_notification_allow, sw_filestorage_allow, sw_grant_all);
    }

    private void setSwitchToggle(MaterialSwitch sw_mediastorage_audio_allow, MaterialSwitch sw_mediastorage_image_allow, MaterialSwitch sw_mediastorage_allow, MaterialSwitch sw_contacts_allow, MaterialSwitch sw_camera_allow, MaterialSwitch sw_location_allow, MaterialSwitch sw_calllog_allow, MaterialSwitch sw_phone_allow, MaterialSwitch sw_sms_allow, MaterialSwitch sw_microphone_allow, MaterialSwitch sw_notification_allow, MaterialSwitch sw_filestorage_allow, MaterialSwitch sw_grant_all) {
        if (sw_mediastorage_audio_allow != null)
            sw_mediastorage_audio_allow.setChecked(PermissionsRuntime.checkMediaStoragePermission(this));
        if (sw_mediastorage_image_allow != null)
            sw_mediastorage_image_allow.setChecked(PermissionsRuntime.checkMediaStoragePermission(this));
        if (sw_mediastorage_allow != null)
            sw_mediastorage_allow.setChecked(PermissionsRuntime.checkMediaStoragePermission(this));
        if (sw_contacts_allow != null)
            sw_contacts_allow.setChecked(PermissionsRuntime.checkContactsPermission(this));
        if (sw_camera_allow != null)
            sw_camera_allow.setChecked(PermissionsRuntime.checkCameraPermission(this));
        if (sw_location_allow != null)
            sw_location_allow.setChecked(PermissionsRuntime.checkLocationPermission(this));
        if (sw_calllog_allow != null)
            sw_calllog_allow.setChecked(PermissionsRuntime.checkCallLogPermission(this));
        if (sw_phone_allow != null)
            sw_phone_allow.setChecked(PermissionsRuntime.checkPhonePermission(this));
        if (sw_sms_allow != null)
            sw_sms_allow.setChecked(PermissionsRuntime.checkSmsPermission(this));
        if (sw_microphone_allow != null)
            sw_microphone_allow.setChecked(PermissionsRuntime.checkMicrophonePermission(this));
        if (sw_notification_allow != null)
            sw_notification_allow.setChecked(PermissionsRuntime.checkNotificationPermission(this));
        if (sw_filestorage_allow != null)
            sw_filestorage_allow.setChecked(PermissionsRuntime.checkFileStoragePermission(this));
    }

    private void initViews() {
        sw_mediastorage_audio_allow = findViewById(R.id.sw_mediastorage_audio_allow);
        sw_mediastorage_image_allow = findViewById(R.id.sw_mediastorage_image_allow);
        sw_mediastorage_allow = findViewById(R.id.sw_mediastorage_allow);
        sw_contacts_allow = findViewById(R.id.sw_contacts_allow);
        sw_camera_allow = findViewById(R.id.sw_camera_allow);
        sw_location_allow = findViewById(R.id.sw_location_allow);
        sw_calllog_allow = findViewById(R.id.sw_calllog_allow);
        sw_phone_allow = findViewById(R.id.sw_phone_allow);
        sw_sms_allow = findViewById(R.id.sw_sms_allow);
        sw_microphone_allow = findViewById(R.id.sw_microphone_allow);
        sw_notification_allow = findViewById(R.id.sw_notification_allow);
        sw_filestorage_allow = findViewById(R.id.sw_filestorage_allow);
        sw_grant_all = findViewById(R.id.sw_grant_all);
    }

    private void setListeners() {


        sw_mediastorage_audio_allow.setOnClickListener(v -> {
            if (!PermissionsRuntime.checkMediaStoragePermission(this)) {
                PermissionsRuntime.requestPermission(this, PermissionsRuntime_helper.MediaAudioPermission, 262, "", true, null);
            }
        });
        sw_mediastorage_image_allow.setOnClickListener(v -> {
            if (!PermissionsRuntime.checkMediaStoragePermission(this)) {
                PermissionsRuntime.requestPermission(this, PermissionsRuntime_helper.MediaImagePermission, 292, "", true, null);
            }
        });
        sw_mediastorage_allow.setOnClickListener(v -> {
            if (!PermissionsRuntime.checkMediaStoragePermission(this)) {
                PermissionsRuntime.requestMediaStoragePermission(this, "", true, null);
            }
        });
        sw_contacts_allow.setOnClickListener(v -> {
            if (!PermissionsRuntime.checkContactsPermission(this)) {
                PermissionsRuntime.requestContactsPermission(this, "", true, null);
            }
        });
        sw_camera_allow.setOnClickListener(v -> {
            if (!PermissionsRuntime.checkCameraPermission(this)) {
                PermissionsRuntime.requestCameraPermission(this, "", true, null);
            }
        });
        sw_location_allow.setOnClickListener(v -> {
            if (!PermissionsRuntime.checkLocationPermission(this)) {
                PermissionsRuntime.requestLocationPermission(this, "", true, null);
            }
        });
        sw_calllog_allow.setOnClickListener(v -> {
            if (!PermissionsRuntime.checkCallLogPermission(this)) {
                PermissionsRuntime.requestCallLogPermission(this, "", true, null);
            }
        });
        sw_phone_allow.setOnClickListener(v -> {
            if (!PermissionsRuntime.checkPhonePermission(this)) {
                PermissionsRuntime.requestPhonePermission(this, "", true, null);
            }
        });
        sw_sms_allow.setOnClickListener(v -> {
            if (!PermissionsRuntime.checkSmsPermission(this)) {
                PermissionsRuntime.requestSmsPermission(this, "", true, null);
            }
        });
        sw_microphone_allow.setOnClickListener(v -> {
            if (!PermissionsRuntime.checkMicrophonePermission(this)) {
                PermissionsRuntime.requestMicrophonePermission(this, "", true, null);
            }
        });
        sw_notification_allow.setOnClickListener(v -> {
            if (!PermissionsRuntime.checkNotificationPermission(this)) {
                PermissionsRuntime.requestNotificationPermission(this, "", true, null);
            }
        });
        sw_filestorage_allow.setOnClickListener(v -> {
            if (!PermissionsRuntime.checkFileStoragePermission(this)) {
                PermissionsRuntime.requestFileStoragePermission(this, "", true, null);
            }
        });
        sw_grant_all.setOnClickListener(v -> {
            PermissionsRuntime.requestAllPermission(this, "", true, null);
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_ALL_PERMISSION) {
            setSwitchToggle(sw_mediastorage_audio_allow, sw_mediastorage_image_allow, sw_mediastorage_allow, sw_contacts_allow, sw_camera_allow, sw_location_allow, sw_calllog_allow, sw_phone_allow, sw_sms_allow, sw_microphone_allow, sw_notification_allow, sw_filestorage_allow, sw_grant_all);
        } else if (requestCode == REQUEST_CODE_MEDIASTORAGE_AUDIO) {
            boolean sw_mediastorage_state = PermissionsRuntime.checkMediaStoragePermission(this);
            sw_mediastorage_audio_allow.setChecked(sw_mediastorage_state);
            Toast.makeText(this, sw_mediastorage_state ? "✅ Audio Permission Granted" : "❌ Audio Permission Denied", Toast.LENGTH_SHORT).show();
         } else if (requestCode == REQUEST_CODE_MEDIASTORAGE_IMAGE) {
            boolean sw_mediastorage_state = PermissionsRuntime.checkMediaStoragePermission(this);
            sw_mediastorage_image_allow.setChecked(sw_mediastorage_state);
            Toast.makeText(this, sw_mediastorage_state ? "✅ Image Permission Granted" : "❌ Image Permission Denied", Toast.LENGTH_SHORT).show();
         } else if (requestCode == REQUEST_CODE_MEDIASTORAGE) {
            boolean sw_mediastorage_state = PermissionsRuntime.checkMediaStoragePermission(this);
            sw_mediastorage_allow.setChecked(sw_mediastorage_state);
            Toast.makeText(this, sw_mediastorage_state ? "✅ MEDIASTORAGE Permission Granted" : "❌ MEDIASTORAGE Permission Denied", Toast.LENGTH_SHORT).show();
        } else if (requestCode == REQUEST_CODE_CONTACTS) {
            boolean sw_contacts_state = PermissionsRuntime.checkContactsPermission(this);
            sw_contacts_allow.setChecked(sw_contacts_state);
            Toast.makeText(this, sw_contacts_state ? "✅ CONTACTS Permission Granted" : "❌ CONTACTS Permission Denied", Toast.LENGTH_SHORT).show();
        } else if (requestCode == REQUEST_CODE_CAMERA) {
            boolean sw_camera_state = PermissionsRuntime.checkCameraPermission(this);
            sw_camera_allow.setChecked(sw_camera_state);
            Toast.makeText(this, sw_camera_state ? "✅ CAMERA Permission Granted" : "❌ CAMERA Permission Denied", Toast.LENGTH_SHORT).show();
        } else if (requestCode == REQUEST_CODE_LOCATION) {
            boolean sw_location_state = PermissionsRuntime.checkLocationPermission(this);
            sw_location_allow.setChecked(sw_location_state);
            Toast.makeText(this, sw_location_state ? "✅ LOCATION Permission Granted" : "❌ LOCATION Permission Denied", Toast.LENGTH_SHORT).show();
        } else if (requestCode == REQUEST_CODE_CALLLOG) {
            boolean sw_calllog_state = PermissionsRuntime.checkCallLogPermission(this);
            sw_calllog_allow.setChecked(sw_calllog_state);
            Toast.makeText(this, sw_calllog_state ? "✅ CALLLOG Permission Granted" : "❌ CALLLOG Permission Denied", Toast.LENGTH_SHORT).show();
        } else if (requestCode == REQUEST_CODE_PHONE) {
            boolean sw_phone_state = PermissionsRuntime.checkPhonePermission(this);
            sw_phone_allow.setChecked(sw_phone_state);
            Toast.makeText(this, sw_phone_state ? "✅ PHONE Permission Granted" : "❌ PHONE Permission Denied", Toast.LENGTH_SHORT).show();
        } else if (requestCode == REQUEST_CODE_SMS) {
            boolean sw_sms_state = PermissionsRuntime.checkSmsPermission(this);
            sw_sms_allow.setChecked(sw_sms_state);
            Toast.makeText(this, sw_sms_state ? "✅ SMS Permission Granted" : "❌ SMS Permission Denied", Toast.LENGTH_SHORT).show();
        } else if (requestCode == REQUEST_CODE_MICROPHONE) {
            boolean sw_microphone_state = PermissionsRuntime.checkMicrophonePermission(this);
            sw_microphone_allow.setChecked(sw_microphone_state);
            Toast.makeText(this, sw_microphone_state ? "✅ MICROPHONE Permission Granted" : "❌ MICROPHONE Permission Denied", Toast.LENGTH_SHORT).show();
        } else if (requestCode == REQUEST_CODE_NOTIFICATION) {
            boolean sw_notification_state = PermissionsRuntime.checkNotificationPermission(this);
            sw_notification_allow.setChecked(sw_notification_state);
            Toast.makeText(this, sw_notification_state ? "✅ NOTIFICATION Permission Granted" : "❌ NOTIFICATION Permission Denied", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_CODE_FILESTORAGE: {
                boolean fileStorage = Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && PermissionsRuntime.checkFileStoragePermission(this);
                sw_filestorage_allow.setChecked(fileStorage);
                Toast.makeText(this, fileStorage ? "✅ File storage access granted!" : "❌ File storage access not granted", Toast.LENGTH_SHORT).show();
                break;
            }

        }

    }
}