package com.jakir.permissions_v2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {
    Button btn_permissions, btn_stn_permissions, btn_spcl_acc, btn_stn_spcl_acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn_permissions = findViewById(R.id.btn_permissions);
        btn_stn_permissions = findViewById(R.id.btn_stn_permissions);
        btn_spcl_acc = findViewById(R.id.btn_spcl_acc);
        btn_stn_spcl_acc = findViewById(R.id.btn_stn_spcl_acc);

        btn_permissions.setOnClickListener(v -> {
            startActivity(new Intent(this, RuntimePermissionsActivity.class));
        });
        btn_stn_permissions.setOnClickListener(v -> {
            startActivity(new Intent(this, SettingsRuntimePermissionsActivity.class));
        });
        btn_spcl_acc.setOnClickListener(v -> {
            startActivity(new Intent(this, SpecialAccessActivity.class));
        });
        btn_stn_spcl_acc.setOnClickListener(v -> {
            startActivity(new Intent(this, SettingsSpecialAccessActivity.class));
        });
    }
}