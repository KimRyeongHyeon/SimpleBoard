package com.myandroid.simpleboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class InsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        final EditText nameEditText = (EditText)findViewById(R.id.nameEditText);
        final EditText passwordEditText = (EditText)findViewById(R.id.passwordEditText);
        final EditText contentEditText = (EditText)findViewById(R.id.contentEditText);

        final Button insertButton = (Button)findViewById(R.id.insertButton);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String content = contentEditText.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            if(success) {
                                Toast.makeText(getApplicationContext(), "글 작성이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                                finish();

                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };

                SimpleBoardRegisterRequest sbRegisterRequest = new SimpleBoardRegisterRequest(name, password, content, responseListener);
                RequestQueue queue = Volley.newRequestQueue(InsertActivity.this);
                queue.add(sbRegisterRequest);
            }
        });
    }
}
