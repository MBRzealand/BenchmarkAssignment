package com.example.helloworld.view;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.R;
import com.example.helloworld.model.Model;

public class Backwards extends AppCompatActivity {

    Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = (Model) getIntent().getSerializableExtra("modelObject");

        setContentView(R.layout.activity_secondary);

        TextView outputView1 = findViewById(R.id.outputView1);

        TextView outputView2 = findViewById(R.id.outputView2);

        TextView outputView3 = findViewById(R.id.outputView3);

        outputView1.setText(model.getData());

        outputView2.setText(model.getReversedData());

        outputView3.setText(model.getDataList().toString());

    }

    public void returnToMain(View view){

        Intent intent = new Intent(this, Main.class);

        intent.putExtra("modelObject", model);

        setResult(Activity.RESULT_OK,intent);

        finish();

    }

}