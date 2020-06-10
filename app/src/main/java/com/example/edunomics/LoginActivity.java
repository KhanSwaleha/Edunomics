package com.example.edunomics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import io.kommunicate.Kommunicate;
import io.kommunicate.callbacks.KmCallback;

public class LoginActivity extends AppCompatActivity {

    Button submibtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        submibtn = findViewById(R.id.submitbtn);

        submibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(LoginActivity.this,ChatActivity.class);
//                startActivity(intent);

                String key = "26df2799f993b9cd04f5b147a5c3de53e";

                Kommunicate.init(LoginActivity.this, key);

                List<String> agentList = new ArrayList();
                agentList.add("khan.swaleha.17it5010@gmail.com"); //add your agentID

                List<String> botList = new ArrayList();
                botList.add("studentqueryresolution-vvbqu"); //enter your integrated bot Ids

                Kommunicate.launchSingleChat(LoginActivity.this, "Support", Kommunicate.getVisitor(), false, true, agentList, botList, new KmCallback(){
                    @Override
                    public void onSuccess(Object message) {
                        Log.d("success", "ChatLaunch" + "Success : " + message);
                    }

                    @Override
                    public void onFailure(Object error) {
                        Log.d("fail", "ChatLaunch" + "Failure : " + error);
                    }


                });
            }
        });
    }
}
