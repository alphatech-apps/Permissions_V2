package com.jakir.permissions_v2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.preference.PermissionPreference;
import androidx.preference.PreferenceFragmentCompat;

import com.jakir.permissions.PermissionsRuntime;

public class SettingsRuntimePermissionsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(androidx.preference.R.layout.activity_settings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(androidx.preference.R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar = findViewById(androidx.preference.R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Settings");
            actionBar.setHomeAsUpIndicator(androidx.preference.R.drawable.round_arrow_back_ios_24);
        }

        // Load Settings Fragment
        getSupportFragmentManager().beginTransaction().replace(androidx.preference.R.id.container, new SettingsFragment()).commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {

        private PermissionPreference sw_mediastorage_allow, sw_contacts_allow, sw_camera_allow, sw_location_allow, sw_calllog_allow, sw_phone_allow, sw_sms_allow, sw_microphone_allow, sw_notification_allow, sw_filestorage_allow, sw_grant_all;

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.preferences2, rootKey);

            // Find preferences
            sw_mediastorage_allow = findPreference("sw_mediastorage_allow");
            sw_contacts_allow = findPreference("sw_contacts_allow");
            sw_camera_allow = findPreference("sw_camera_allow");
            sw_location_allow = findPreference("sw_location_allow");
            sw_calllog_allow = findPreference("sw_calllog_allow");
            sw_phone_allow = findPreference("sw_phone_allow");
            sw_sms_allow = findPreference("sw_sms_allow");
            sw_microphone_allow = findPreference("sw_microphone_allow");
            sw_notification_allow = findPreference("sw_notification_allow");
            sw_filestorage_allow = findPreference("sw_filestorage_allow");
            sw_grant_all = findPreference("sw_grant_all");

            // Set default state text
            initPermissionTexts();

            // Set click listeners
            setListeners();
        }

        private void initPermissionTexts() {
            PermissionPreference[] prefs = {sw_mediastorage_allow, sw_contacts_allow, sw_camera_allow, sw_location_allow, sw_calllog_allow, sw_phone_allow, sw_sms_allow, sw_microphone_allow, sw_notification_allow, sw_filestorage_allow};
            for (PermissionPreference p : prefs) {
                if (p != null) {
                    p.setAllowed(false);
                    p.setAcceptedText("Permission Granted");
                    p.setRequestText("Please Allow");
                }
            }
        }

        private void setListeners() {
            if (sw_mediastorage_allow != null) {
                sw_mediastorage_allow.setOnPreferenceClickListener(pref -> {
                    if (!PermissionsRuntime.checkMediaStoragePermission(getContext())) {
                        PermissionsRuntime.requestMediaStoragePermission(getContext(), "", true, null);
                    }
                    return true;
                });
            }

            if (sw_contacts_allow != null) {
                sw_contacts_allow.setOnPreferenceClickListener(pref -> {
                    if (!PermissionsRuntime.checkContactsPermission(getContext())) {
                        PermissionsRuntime.requestContactsPermission(getContext(), "", true, null);
                    }
                    return true;
                });
            }

            if (sw_camera_allow != null) {
                sw_camera_allow.setOnPreferenceClickListener(pref -> {
                    if (!PermissionsRuntime.checkCameraPermission(getContext())) {
                        PermissionsRuntime.requestCameraPermission(getContext(), "", true, null);
                    }
                    return true;
                });
            }

            if (sw_location_allow != null) {
                sw_location_allow.setOnPreferenceClickListener(pref -> {
                    if (!PermissionsRuntime.checkLocationPermission(getContext())) {
                        PermissionsRuntime.requestLocationPermission(getContext(), "", true, null);
                    }
                    return true;
                });
            }

            if (sw_calllog_allow != null) {
                sw_calllog_allow.setOnPreferenceClickListener(pref -> {
                    if (!PermissionsRuntime.checkCallLogPermission(getContext())) {
                        PermissionsRuntime.requestCallLogPermission(getContext(), "", true, null);
                    }
                    return true;
                });
            }

            if (sw_phone_allow != null) {
                sw_phone_allow.setOnPreferenceClickListener(pref -> {
                    if (!PermissionsRuntime.checkPhonePermission(getContext())) {
                        PermissionsRuntime.requestPhonePermission(getContext(), "", false, null);
                    }
                    return true;
                });
            }

            if (sw_sms_allow != null) {
                sw_sms_allow.setOnPreferenceClickListener(pref -> {
                    if (!PermissionsRuntime.checkSmsPermission(getContext())) {
                        PermissionsRuntime.requestSmsPermission(getContext(), "", true, null);
                    }
                    return true;
                });
            }

            if (sw_microphone_allow != null) {
                sw_microphone_allow.setOnPreferenceClickListener(pref -> {
                    if (!PermissionsRuntime.checkMicrophonePermission(getContext())) {
                        PermissionsRuntime.requestMicrophonePermission(getContext(), "", true, null);
                    }
                    return true;
                });
            }

            if (sw_notification_allow != null) {
                sw_notification_allow.setOnPreferenceClickListener(pref -> {
                    if (!PermissionsRuntime.checkNotificationPermission(getContext())) {
                        PermissionsRuntime.requestNotificationPermission(getContext(), "", true, getContext().getDrawable(R.drawable.ic_launcher_foreground));
                    }
                    return true;
                });
            }

            if (sw_filestorage_allow != null) {
                sw_filestorage_allow.setOnPreferenceClickListener(pref -> {
                    if (!PermissionsRuntime.checkFileStoragePermission(getContext())) {
                        PermissionsRuntime.requestFileStoragePermission(getContext(), "", true, null);
                    }
                    return true;
                });
            }

            if (sw_grant_all != null) {
                sw_grant_all.setOnPreferenceClickListener(pref -> {
                    PermissionsRuntime.requestAllPermission(getContext(), "", true, null);
                    return true;
                });
            }
        }
        @Override
        public void onResume() {
            super.onResume();

            if (sw_mediastorage_allow != null) {
                sw_mediastorage_allow.setAllowed(PermissionsRuntime.checkMediaStoragePermission(getContext()));
            }
            if (sw_contacts_allow != null) {
                sw_contacts_allow.setAllowed(PermissionsRuntime.checkContactsPermission(getContext()));
            }
            if (sw_camera_allow != null) {
                sw_camera_allow.setAllowed(PermissionsRuntime.checkCameraPermission(getContext()));
            }
            if (sw_location_allow != null) {
                sw_location_allow.setAllowed(PermissionsRuntime.checkLocationPermission(getContext()));
            }
            if (sw_calllog_allow != null) {
                sw_calllog_allow.setAllowed(PermissionsRuntime.checkCallLogPermission(getContext()));
            }
            if (sw_phone_allow != null) {
                sw_phone_allow.setAllowed(PermissionsRuntime.checkPhonePermission(getContext()));
            }
            if (sw_sms_allow != null) {
                sw_sms_allow.setAllowed(PermissionsRuntime.checkSmsPermission(getContext()));
            }
            if (sw_microphone_allow != null) {
                sw_microphone_allow.setAllowed(PermissionsRuntime.checkMicrophonePermission(getContext()));
            }
            if (sw_notification_allow != null) {
                sw_notification_allow.setAllowed(PermissionsRuntime.checkNotificationPermission(getContext()));
            }
            if (sw_filestorage_allow != null) {
                sw_filestorage_allow.setAllowed(PermissionsRuntime.checkFileStoragePermission(getContext()));
            }
            if (sw_grant_all != null) {
                // Grant All শুধুমাত্র সব পারমিশন চেক করবে
                boolean allGranted =
                        PermissionsRuntime.checkMediaStoragePermission(getContext()) &&
                                PermissionsRuntime.checkContactsPermission(getContext()) &&
                                PermissionsRuntime.checkCameraPermission(getContext()) &&
                                PermissionsRuntime.checkLocationPermission(getContext()) &&
                                PermissionsRuntime.checkCallLogPermission(getContext()) &&
                                PermissionsRuntime.checkPhonePermission(getContext()) &&
                                PermissionsRuntime.checkSmsPermission(getContext()) &&
                                PermissionsRuntime.checkMicrophonePermission(getContext()) &&
                                PermissionsRuntime.checkNotificationPermission(getContext()) &&
                                PermissionsRuntime.checkFileStoragePermission(getContext());
                sw_grant_all.setAllowed(allGranted);
            }
        }

    }
}
