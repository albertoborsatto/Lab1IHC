package com.example.myapplication6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;

public class MainActivity extends Activity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor light;
    private Sensor proximity;
    TextView lightValue;
    TextView proximityValue;
    TextView latValue;
    TextView longValue;
    Button getGPSBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lightValue = (TextView)findViewById(R.id.valLuz);
        proximityValue = (TextView)findViewById(R.id.valProx);
        getGPSBtn = (Button) findViewById(R.id.getGPSBtn);
        latValue = (TextView)findViewById(R.id.valLat);
        longValue = (TextView)findViewById(R.id.valLong);

        sensorManager = (SensorManager)
                getSystemService(Context.SENSOR_SERVICE);
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        ActivityCompat.requestPermissions(MainActivity.this, new
                String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        if(light != null)
        {
            sensorManager.registerListener(MainActivity.this, light,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }else
        {
            lightValue.setText("Light sensor not supported");
        }
        if(proximity != null) {
            sensorManager.registerListener(MainActivity.this, proximity,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            proximityValue.setText("Proximity sensor not supported");
        }

        getGPSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GPSTracker g = new GPSTracker(getApplicationContext());
                Location l = g.getLocation();
                if(l!=null)
                {
                    double lat = l.getLatitude();
                    double longi = l.getLongitude();
                    latValue.setText("Latitude: " + lat);
                    longValue.setText("Longitutde: " + longi);
                }
            }
        });
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if(sensor.getType() == Sensor.TYPE_LIGHT)
        {
            lightValue.setText("Intensidade da luz: " +event.values[0]);
        }
        else if(sensor.getType() == Sensor.TYPE_PROXIMITY) {
            proximityValue.setText("Proximidade: " + event.values[0]);
        }
    }
}

