package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button login;
    private int counter=3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name= (EditText)findViewById(R.id.etName);
        Password= (EditText)findViewById(R.id.etPassword);
        Info=(TextView)findViewById(R.id.tvinfo);
        login= (Button)findViewById(R.id.btnlogin);
        Info.setText("No of attempets remaining:3");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());

            }
        });

    }
    private void validate(String userName,String userPassword)
    {
        if((userName.equals("SAKSHI")) &&(userPassword.equals("12345")))
        {
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        } else{
            counter--;
            Info.setText("No of attempets remaining:" +String.valueOf(counter));
            if(counter==0)
            {
                login.setEnabled(false);
            }

        }

    }
}
