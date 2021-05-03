package com.example.helloworld.view;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.helloworld.R;

import com.example.helloworld.model.Model;

import java.util.ArrayList;

public class Main extends AppCompatActivity {

    Model model = new Model();
    ArrayList<String> listOfInputs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sendMessage(View view) {

        Intent intent = new Intent(this, Backwards.class);

        EditText inputText = findViewById(R.id.inputText);

        String textInput = inputText.getText().toString();

        String reversedTextInput = model.reverseString(textInput);

        model.setData(textInput);

        model.setReversedData(reversedTextInput);

        listOfInputs.add(textInput);

        model.setDataList(listOfInputs);

        inputText.setText("");

        intent.putExtra("modelObject", model);

        startActivityForResult(intent, 666);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 666:
                if (resultCode == Activity.RESULT_OK) {

                    Model returnmodel = (Model) data.getSerializableExtra("modelObject");

                    model.setDataList(returnmodel.getDataList());

                    model = returnmodel;

                }
                break;
        }

    }

}