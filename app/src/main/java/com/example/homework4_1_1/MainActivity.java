package com.example.homework4_1_1;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.list);

        List<Map<String, String>> values = prepareContent();

        SimpleAdapter listContentAdapter = createAdapter(values);

        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private SimpleAdapter createAdapter(List<Map<String, String>> values) {
        return new SimpleAdapter(this,
                                 values,
                                 R.layout.list_item,
                                 new String[]{"name","text"},
                                 new int[]{R.id.name,R.id.text});
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {
        String[] arrayContent = getString(R.string.large_text).split("\n\n");
        List <Map<String, String>> values = new ArrayList<>();
        for (int i = 0; i < arrayContent.length; i++){
            Map<String, String> value = new HashMap<>();
            value.put("name", String.valueOf(arrayContent[i].length()));
            value.put("text", arrayContent[i]);
            values.add(value);
        }
        return values;
    }
}
