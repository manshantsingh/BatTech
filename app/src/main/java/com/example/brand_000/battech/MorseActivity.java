package com.example.brand_000.battech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MorseActivity extends AppCompatActivity {
    EditText codeEdit;
    TextView codeView;
    Button codeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        codeButton = (Button) findViewById(R.id.buttonMorse);
        codeView = (TextView) findViewById(R.id.textViewCode);
        codeEdit = (EditText) findViewById(R.id.editTextCode);

        codeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codeView.setText(Convert(codeEdit.getText().toString()));
            }
        });


    }

    public String Convert(String text) {
        String temp = "";
        temp = text;

        temp = temp.replace("0", "----- ");
        temp = temp.replace("1", ".---- ");
        temp = temp.replace("2", "..--- ");
        temp = temp.replace("3", "...-- ");
        temp = temp.replace("4", "....- ");
        temp = temp.replace("5", "..... ");
        temp = temp.replace("6", "-....");
        temp = temp.replace("7", "--... ");
        temp = temp.replace("8", "---.. ");
        temp = temp.replace("9", "----. ");

        temp = temp.replace("a", ".- ");
        temp = temp.replace("b", "-... ");
        temp = temp.replace("c", "-.-. ");
        temp = temp.replace("d", "-.. ");
        temp = temp.replace("e", ". ");
        temp = temp.replace("f", "..-. ");
        temp = temp.replace("g", "--. ");
        temp = temp.replace("h", ".... ");
        temp = temp.replace("i", ".. ");
        temp = temp.replace("j", ".--- ");
        temp = temp.replace("k", "-.- ");
        temp = temp.replace("l", ".-.. ");
        temp = temp.replace("m", "-- ");
        temp = temp.replace("n", "-. ");
        temp = temp.replace("o", "--- ");
        temp = temp.replace("p", ".--. ");
        temp = temp.replace("q", "--.- ");
        temp = temp.replace("r", ".-. ");
        temp = temp.replace("s", "... ");
        temp = temp.replace("t", "- ");
        temp = temp.replace("u", "..- ");
        temp = temp.replace("v", "...- ");
        temp = temp.replace("w", ".-- ");
        temp = temp.replace("x", "-..- ");
        temp = temp.replace("y", "-.-- ");
        temp = temp.replace("z", "--.. ");


        return temp;

    }
}
