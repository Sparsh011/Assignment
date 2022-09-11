package com.example.myapplication.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.notificationUtil.NotificationService;

public class MainActivity extends AppCompatActivity {
    private EditText etText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Initialising views -
        etText = findViewById(R.id.et_text);
        Button sendNotification = findViewById(R.id.btn_generate_notification);
        Button generateToast = findViewById(R.id.btn_generate_toast);
        Button changeTextViewText = findViewById(R.id.btn_change_text_of_textview);
        Button showPopup = findViewById(R.id.btn_show_popup);


//        Generating notification -
        sendNotification.setOnClickListener(view -> {
            String message = etText.getText().toString();
            if (message.trim().isEmpty()){
                Toast.makeText(this, "EditText is empty", Toast.LENGTH_SHORT).show();
            }
            else{
                NotificationService service = new NotificationService(getApplicationContext(), message);
                service.showNotification();
            }
        });

//        Generating toast -
        generateToast.setOnClickListener(view ->{
            String message = etText.getText().toString();
            if (message.trim().isEmpty()){
                Toast.makeText(this, "EditText is empty", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
        });

//        Changing content of textview -
        TextView textView = findViewById(R.id.tv_text);
        changeTextViewText.setOnClickListener(view -> {
            String message = etText.getText().toString();
            if (message.trim().isEmpty()){
                Toast.makeText(this, "EditText is empty", Toast.LENGTH_SHORT).show();
            }
            else{
                String completed = "Completed";
                textView.setText(completed);
            }
        });

//        Generating a popup -
        showPopup.setOnClickListener(view ->{
            String message = etText.getText().toString();
            if (message.trim().isEmpty()){
                Toast.makeText(this, "EditText is empty", Toast.LENGTH_SHORT).show();
            }
            else{
                showDialog(message);
            }
        });
    }

    private void showDialog(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.alert_dialog_style);
        builder.setMessage(message)
                .setNegativeButton("Dismiss Dialog", null);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}