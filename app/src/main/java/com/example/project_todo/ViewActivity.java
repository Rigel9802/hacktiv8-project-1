package com.example.project_todo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.project_todo.database.Database;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener {
    Button backButton, saveButton;
    EditText inputTitle, inputDesc;

    private Database database;
    private String id, title, desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        backButton = (Button) findViewById(R.id.backButton);
        saveButton = (Button) findViewById(R.id.saveButton);
        inputTitle = (EditText) findViewById(R.id.inputTitle);
        inputDesc = (EditText) findViewById(R.id.inputDesc);

        backButton.setOnClickListener(this);
        saveButton.setOnClickListener(this);

        database = new Database(this);

        getData();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.backButton:
                finish(); 
            case R.id.saveButton:

                // Seleksi buat update dan create karena kita pakai 1 page untuk 2 fungsi (create & update)

                database.createData(inputTitle.getText().toString().trim(), inputDesc.getText().toString().trim());
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
        }
    }

    void getData(){
        // Bagian update, buat ngedapetin data yang sudah di kirim dari adapter
    }
}