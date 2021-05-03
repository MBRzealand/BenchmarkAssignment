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

    TextView originalTextView;
    TextView reversedTextView;
    TextView listTextView;
    TextView reversedListTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backwards);

        model = (Model) getIntent().getSerializableExtra("modelObject");

        originalTextView = findViewById(R.id.originalOutput);
        reversedTextView = findViewById(R.id.reversedOutput);
        listTextView = findViewById(R.id.listOutput);
        reversedListTextView = findViewById(R.id.reversedListOutput);

        originalTextView.setText(model.getData());
        reversedTextView.setText(model.getReversedData());
        listTextView.setText(model.getDataList().toString());
        reversedListTextView.setText(model.getReversedDataList().toString());

    }

    public void returnToMain(View view){

        Intent intent = new Intent(this, Main.class);

        intent.putExtra("returnedModelObject", model);

        setResult(Activity.RESULT_OK,intent);

        finish();

    }

}