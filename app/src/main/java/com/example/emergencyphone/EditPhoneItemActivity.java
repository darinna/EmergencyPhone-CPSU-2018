package com.example.emergencyphone;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.emergencyphone.db.DatabaseHelper;

import static com.example.emergencyphone.db.DatabaseHelper.COL_ID;
import static com.example.emergencyphone.db.DatabaseHelper.COL_NAME;
import static com.example.emergencyphone.db.DatabaseHelper.COL_AGE;
import static com.example.emergencyphone.db.DatabaseHelper.COL_POSITION;
import static com.example.emergencyphone.db.DatabaseHelper.COL_DEPARTMENT;
import static com.example.emergencyphone.db.DatabaseHelper.COL_TEL;
import static com.example.emergencyphone.db.DatabaseHelper.TABLE_NAME;

public class EditPhoneItemActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mAgeEditText;
    private EditText mPositionEditText;
    private EditText mDepartmentEditText;
    private EditText mTelEditText;

    private Button mSaveButton;

    private long mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_phone_item);

        Button back_to_main = findViewById(R.id.back_button2);
        back_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditPhoneItemActivity.this, MainActivity.class);
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

        mNameEditText = findViewById(R.id.name_edit_text);
        mAgeEditText = findViewById(R.id.age_edit_text);
        mPositionEditText = findViewById(R.id.position_edit_text);
        mDepartmentEditText = findViewById(R.id.department_edit_text);
        mTelEditText = findViewById(R.id.tel_edit_text);
        mSaveButton = findViewById(R.id.save_button);

        mNameEditText.setText(name);
        mAgeEditText.setText(age);
        mPositionEditText.setText(position);
        mDepartmentEditText.setText(department);
        mTelEditText.setText(tel);


        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo: บันทึกข้อมูลใหม่ลง db
                DatabaseHelper helper = new DatabaseHelper(EditPhoneItemActivity.this);
                SQLiteDatabase db = helper.getWritableDatabase();

                String newName = mNameEditText.getText().toString().trim();
                String newAge = mAgeEditText.getText().toString().trim();
                String newPosition = mPositionEditText.getText().toString().trim();
                String newDepartment = mDepartmentEditText.getText().toString().trim();
                String newTel = mTelEditText.getText().toString().trim();

                ContentValues cv = new ContentValues();
                cv.put(COL_NAME, newName);
                cv.put(COL_AGE, newAge);
                cv.put(COL_POSITION, newPosition);
                cv.put(COL_DEPARTMENT, newDepartment);
                cv.put(COL_TEL, newTel);

                db.update(
                        TABLE_NAME,
                        cv,
                        COL_ID + " = ?",
                        new String[]{String.valueOf(mId)}

                );

                finish();
            }
        });
    }
}
