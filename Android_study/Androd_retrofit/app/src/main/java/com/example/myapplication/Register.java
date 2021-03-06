package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.BinderThread;
import androidx.appcompat.app.AppCompatActivity;
//`import butterknife.Bind;
import butterknife.BindAnim;
import butterknife.BindArray;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by KBPark on 2017. 1. 15..
 */

public class Register extends AppCompatActivity
{
    @BindView(R.id.email_input) EditText email_input;
    @BindView(R.id.password_input) EditText pw_input;
    @BindView(R.id.birth_input) EditText birth_input;
    @BindView(R.id.address_input) EditText address_input;
    @BindView(R.id.phone_input) EditText phone_input;
    @BindView(R.id.name_input) EditText name_input;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.register_btn)
    void onRegisterClicked()
    {
        String email = email_input.getText().toString();
        String name =  name_input.getText().toString();
        String pw = pw_input.getText().toString();
        String birth = birth_input.getText().toString();
        String address = address_input.getText().toString();
        String phone = phone_input.getText().toString();


        if(email.isEmpty() || name.isEmpty() || pw.isEmpty() || birth.isEmpty() || address.isEmpty() || phone.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "모든 항목을 기입하십시오.", Toast.LENGTH_SHORT).show();
        } else
        {
            // 1. register (w/ created token(init))
            User user = User.getInstance();
            user.setId(email);
            user.setName(name);
            user.setPw(pw);
            user.setAddress(address);
            user.setBirth(birth);
            user.setPhone(phone);
            user.setToken(user.getToken());

            Log.i("PHONE", "phone : " + phone);

            String registerRes = user.register(); // 실제 register가 일어나는 부분

            // 2. token to server
            Log.i("TOKEN", "token to server(register) : " + user.getToken());
            User.getInstance().pushTokenToServer();

            Intent intent = new Intent(getApplicationContext(), LoginMain.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
        }
        // check the empty values!
    }

}
