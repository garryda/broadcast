package com.example.broadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends BaseActivity {
    EditText account;
    EditText password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindView();
    }
    public void bindView(){
        account=(EditText)findViewById(R.id.account);
        password=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(account.getText().toString().equals("lpd")&&password.getText().toString().equals("123456")){
                    Intent intent=new Intent(Login.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(Login.this,"account or password is wrong",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
