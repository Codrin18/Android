package com.example.finalsensorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "MainActivity";

    private SensorManager sensorManager;

    private Sensor accelerometer;

    private Sensor mPressure;

    private Sensor mGyro;

    private Sensor mMagno;

    private Sensor mLight;

    private Sensor mTemp;

    private Sensor mHumi;

    TextView xValue,yValue,zValue;

    TextView xGyroValue, yGyroValue,zGyroValue;

    TextView xMagnoValue,yMagnoValue,zMagnoValue;

    TextView light,pressure,temp,humi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xValue = (TextView) findViewById(R.id.xValue);
        yValue = (TextView) findViewById(R.id.yValue);
        zValue = (TextView) findViewById(R.id.zValue);

        xGyroValue = (TextView) findViewById(R.id.xGyroValue);
        yGyroValue = (TextView) findViewById(R.id.yGyroValue);
        zGyroValue = (TextView) findViewById(R.id.zGyroValue);

        xMagnoValue = (TextView) findViewById(R.id.xMagnoValue);
        yMagnoValue = (TextView) findViewById(R.id.yMagnoValue);
        zMagnoValue = (TextView) findViewById(R.id.zMagnoValue);

        light = (TextView) findViewById(R.id.light);
        pressure = (TextView) findViewById(R.id.pressure);
        temp = (TextView) findViewById(R.id.temp);
        humi = (TextView) findViewById(R.id.humi);




        Log.d(TAG,"onCreate: Initializing Sensor Service");
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (accelerometer != null)
        {
            sensorManager.registerListener(MainActivity.this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG,"on create: Register accelerometer listener");
        }
        else
        {
            xValue.setText("Acceleromater not supported");
            yValue.setText("Acceleromater not supported");
            zValue.setText("Acceleromater not supported");
        }

        mGyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        if (mGyro != null)
        {
            sensorManager.registerListener(MainActivity.this,mGyro,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG,"on create: Register gyroscope listener");
        }
        else
        {
            xGyroValue.setText("Gyroscope not supported");
            yGyroValue.setText("Gyroscope not supported");
            zGyroValue.setText("Gyroscope not supported");
        }

        mMagno = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        if (mMagno != null)
        {
            sensorManager.registerListener(MainActivity.this,mMagno,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG,"on create: Register magnometer listener");
        }
        else
        {
            xMagnoValue.setText("Magnetic field not supported");
            yMagnoValue.setText("Magnetic field not supported");
            zMagnoValue.setText("Magnetic field not supported");
        }

        mLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if (mLight != null)
        {
            sensorManager.registerListener(MainActivity.this,mLight,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG,"on create: Register light listener");
        }
        else
        {
           light.setText("Light not supported");
        }

        mPressure = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);

        if (mPressure != null)
        {
            sensorManager.registerListener(MainActivity.this,mPressure,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG,"on create: Register pressure listener");
        }
        else
        {
            pressure.setText("Pressure not supported");
        }

        mTemp = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        if (mTemp != null)
        {
            sensorManager.registerListener(MainActivity.this,mTemp,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG,"on create: Register temperature listener");
        }
        else
        {
            temp.setText("Temperature not supported");
        }

        mHumi = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);

        if (mHumi != null)
        {
            sensorManager.registerListener(MainActivity.this,mHumi,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG,"on create: Register humidity listener");
        }
        else
        {
            humi.setText("Humidity not supported");
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        Sensor sensor = event.sensor;

        if (sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            Log.d(TAG,"onSensorChanged: X: " + event.values[0] + " Y: " + event.values[1] + " Z: " + event.values[2]);

            xValue.setText("xValue: " + event.values[0]);
            yValue.setText("yValue: " + event.values[1]);
            zValue.setText("zValue: " + event.values[2]);
        }
        else if (sensor.getType() == Sensor.TYPE_GYROSCOPE)
        {
            xGyroValue.setText("xGyroValue: " + event.values[0]);
            yGyroValue.setText("yGyroValue: " + event.values[1]);
            zGyroValue.setText("zGyroValue: " + event.values[2]);
        }
        else if (sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
        {
            xMagnoValue.setText("xMagnoValue: " + event.values[0]);
            yMagnoValue.setText("yMagnoValue: " + event.values[1]);
            zMagnoValue.setText("zMagnoValue: " + event.values[2]);
        }
        else if (sensor.getType() == Sensor.TYPE_LIGHT)
        {
            light.setText("lightValue " + event.values[0]);
        }
        else if (sensor.getType() == Sensor.TYPE_PRESSURE)
        {
            pressure.setText("pressureValue " + event.values[0]);
        }
        else if (sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE)
        {
            temp.setText("tempValue " + event.values[0]);
        }
        else if (sensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY)
        {
            humi.setText("humiValue " + event.values[0]);
        }


    }
}
