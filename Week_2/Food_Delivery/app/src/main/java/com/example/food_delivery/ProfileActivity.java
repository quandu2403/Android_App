package com.example.food_delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView editProfile = findViewById(R.id.tv_Profile);


        editProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openFeedbackDialog(Gravity.CENTER);
                };
            });


        TextView tv_name = findViewById(R.id.tv_name);
        TextView tv_fullname = findViewById(R.id.editTextFullName);
        TextView tv_email = findViewById(R.id.editTextTextEmail);
        TextView tv_phone = findViewById(R.id.editTextPhoneNumber);

        tv_name.setText(String.format(
                "%s", getIntent().getStringExtra("name")
        ));
        tv_fullname.setText(String.format(
                "%s", getIntent().getStringExtra("name")
        ));
        tv_email.setText(String.format(
                "%s", getIntent().getStringExtra("email")
        ));

        tv_phone.setText(String.format(
                "%s", getIntent().getStringExtra("phone")
        ));




    }

    private void openFeedbackDialog(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dialog_editprofile);

        Window window = dialog.getWindow();
        if(window == null){
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);

        if(Gravity.CENTER == gravity) {
            dialog.setCancelable(true);

        }else {
            dialog.setCancelable(false);


        }

        Button btn_update = dialog.findViewById(R.id.btn_update);
        Button btn_cancel = dialog.findViewById(R.id.btn_cancel);

        EditText et_FullName = dialog.findViewById(R.id.editTextFullName);
        EditText et_Email = dialog.findViewById(R.id.editTextTextEmail);
        EditText et_Phone = dialog.findViewById(R.id.editTextPhoneNumber);
        TextView editProfile = findViewById(R.id.tv_Profile);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);

                intent.putExtra("name", et_FullName.getText().toString());
                intent.putExtra("email", et_Email.getText().toString());
                intent.putExtra("phone", et_Phone.getText().toString());
                Toast.makeText(ProfileActivity.this, "Update Success!!", Toast.LENGTH_SHORT).show();


                startActivity(intent);
                dialog.dismiss();
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();




    }




}