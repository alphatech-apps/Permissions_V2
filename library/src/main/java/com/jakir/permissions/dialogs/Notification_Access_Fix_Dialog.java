package com.jakir.permissions.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Window;
import android.widget.TextView;

import com.jakir.permissions.R;


public class Notification_Access_Fix_Dialog extends Dialog {

    Activity activity;

    public Notification_Access_Fix_Dialog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().getAttributes().windowAnimations = R.style.DialogAnimation_fade_in_zoom; //dialog animation
        setContentView(R.layout.permission_notification_access_fix_dialog);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        TextView cancelx = findViewById(R.id.txt_close);
        TextView okx = findViewById(R.id.txt_allow);

        cancelx.setOnClickListener(view1 -> {
            dismiss();
        });
        okx.setOnClickListener(view1 -> {
            openAppInfo();
        });


    }

    private void openAppInfo() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
        intent.setData(uri);
        activity.startActivity(intent);
    }
}
