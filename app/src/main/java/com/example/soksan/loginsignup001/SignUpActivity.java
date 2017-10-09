package com.example.soksan.loginsignup001;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.soksan.loginsignup001.R.styleable.View;

public class SignUpActivity extends AppCompatActivity {
    boolean res;
    Button signup,aha;
    EditText name,phone,email,pass,conpass;
    DBClass mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mydb=new DBClass(this);
        name=(EditText)findViewById(R.id.editText3);
        phone=(EditText)findViewById(R.id.editText4);
        email=(EditText)findViewById(R.id.editText5);
        pass=(EditText)findViewById(R.id.editText6);
        conpass=(EditText)findViewById(R.id.editText7);
        signup=(Button) findViewById(R.id.button3);
        aha=(Button) findViewById(R.id.button4);
        addData();

        aha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
    public void addData(){
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1=name.getText().toString();
                String phone1=phone.getText().toString();
                String email1=email.getText().toString();
                String pass1=pass.getText().toString();
                String conpass1=conpass.getText().toString();
                Intent i =new Intent(SignUpActivity.this,MainActivity.class);
                if(pass1.equals(conpass1)){
                    res =mydb.insertData(name1,phone1,email1,pass1);
                    if(res){
                        Toast.makeText(SignUpActivity.this,"Your data has been insert succesfully",Toast.LENGTH_LONG).show();
                        startActivity(i);
                    }
                    else {
                        Toast.makeText(SignUpActivity.this,"Your data has fail to insert",Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(SignUpActivity.this, "Your password is not match", Toast.LENGTH_LONG).show();
                }
//                res =mydb.insertData(name1,phone1,email1,pass1);

            }
        });
    }
}
