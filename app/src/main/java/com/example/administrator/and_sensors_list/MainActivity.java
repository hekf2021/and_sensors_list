package com.example.administrator.and_sensors_list;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private SensorManager manager;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = this.findViewById(R.id.listView);
        manager =(SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> list = manager.getSensorList(Sensor.TYPE_ALL);
        List<String> listName = new ArrayList<>();
        for(Sensor sensor:list){
            listName.add(sensor.getName());
        }
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listName);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
