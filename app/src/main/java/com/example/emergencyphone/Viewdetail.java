package com.example.emergencyphone;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;


public class Viewdetail extends AppCompatActivity {

    private TextView name_show;
    private TextView age_show;
    private TextView position_show;
    private TextView department_show;
    private TextView tel_show;
    private long mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewdetail);

        Button back_to_main = findViewById(R.id.back_to_main);
        back_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Viewdetail.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String age = intent.getStringExtra("age");
        String position = intent.getStringExtra("position");
        String department = intent.getStringExtra("department");
        String tel = intent.getStringExtra("tel");
        mId = intent.getLongExtra("id", 0);

        name_show = findViewById(R.id.name_textView);
        age_show = findViewById(R.id.age_textView);
        position_show = findViewById(R.id.position_textView);
        department_show = findViewById(R.id.department_textView);
        tel_show = findViewById(R.id.tel_textView);

        name_show.setText(name);
        age_show.setText(age);
        position_show.setText(position);
        department_show.setText(department);
        tel_show.setText(tel);

    }
}
