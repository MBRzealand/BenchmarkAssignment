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

    Model model;
    ArrayList<String> listOfInputs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new Model();
        listOfInputs = new ArrayList<>();

    }

    public void goToBackwardsActivity(){

        Intent intent = new Intent(this, Backwards.class);

        intent.putExtra("modelObject", model);

        startActivityForResult(intent, 666);

    }

    public void sendMessage(View view) {

        EditText inputText = findViewById(R.id.inputText);

        String textInput = inputText.getText().toString();

        String reversedTextInput = model.reverseString(textInput);

        listOfInputs.add(textInput);

        model.setData(textInput);
        model.setReversedData(reversedTextInput);
        model.setDataList(listOfInputs);

        inputText.setText("");


        goToBackwardsActivity();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 666:
                if (resultCode == Activity.RESULT_OK) {

                    model = (Model) data.getSerializableExtra("returnedModelObject");

                }
                break;
        }

    }

}