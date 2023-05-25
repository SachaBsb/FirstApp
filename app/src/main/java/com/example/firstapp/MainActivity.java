package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.bt_devices_id);
        btn.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_devices_id:
                // Button bt_devices = (Button) findViewById(R.id.bt_devices_id);
                // bt_devices.setText("ready");
                // Création d’une intention
                Intent devicesIntent = new Intent(this, DevicesActivity.class);
                // Ajout d’un parametre à l’intention
                // devicesIntent.putExtra("name", "My devices");
                startActivity(devicesIntent);
                break;
        }
    }
}