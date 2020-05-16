package com.myandroid.simpleboard;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SimpleBoardRegisterRequest extends StringRequest {
    final static private String URL = "https://soulstring94.cafe24.com/simpleboard_insert.php";
    private Map<String, String> parameters;

    public SimpleBoardRegisterRequest(String name, String password, String content, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("NAME", name);
        parameters.put("PASSWORD", password);
        parameters.put("CONTENT", content);
    }

    @Override
    protected Map<String, String> getParams() {
        return parameters;
    }
}
