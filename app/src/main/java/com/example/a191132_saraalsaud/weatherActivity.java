package com.example.a191132_saraalsaud;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.savedstate.SavedStateRegistry;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class weatherActivity extends AppCompatActivity {
    // Textview to show temperature and description
    TextView temperature, humidity1, town1;
    ImageView weatherBackground;
    EditText txtcity;
     ImageView imgweather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        // JSON object that contains weather information
        JSONObject jsonObj;

        temperature = (TextView) findViewById(R.id.temperature);
        Button btnChoose = (Button) findViewById(R.id.btnchoose);
        humidity1 = (TextView) findViewById(R.id.humidity1);
        town1 = (TextView) findViewById(R.id.town);
        txtcity = (EditText) findViewById(R.id.txtcity);

        imgweather = (ImageView) findViewById(R.id.imgweather);

        weatherBackground = (ImageView) findViewById(R.id.weatherbackground);


        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String city = txtcity.getText().toString();
                    String url = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=4a4b884c3ff272a5ac40b4ac63e45c35&units=metric";
                    weather(url);

                }
            });



    }
    public void weather(String url){
        JsonObjectRequest jsonObj = new JsonObjectRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Sara", "Response recieved");
                        Log.d("Sara",response.toString());
                        try {
                            String town = response.getString("name");
                            town1.setText(town);

                            JSONObject jsonMain = response.getJSONObject("main");


                            double temp = jsonMain.getDouble("temp");
                            temperature.setText(String.valueOf(temp)+"°C");

                            double humidity = jsonMain.getDouble("humidity");
                            humidity1.setText("humidity: "+String.valueOf(humidity));


                            JSONArray jsonArray = response.getJSONArray("weather");
                            Log.d("Sara-array-string", jsonArray.toString());
                            for (int i = 0; i < jsonArray.length(); i++) {
                                Log.d("Sara-array", jsonArray.getString(i));
                                JSONObject oneObject = jsonArray.getJSONObject(i);
                                String wheather = oneObject.getString("main");
                                Log.d("sara", wheather);
                                if (wheather.equals("Clear")) {

                                    Glide.with(weatherActivity.this)
                                            .load("https://i.picsum.photos/id/1056/3988/2720.jpg?hmac=qX6hO_75zxeYI7C-1TOspJ0_bRDbYInBwYeoy_z_h08")
                                            .fitCenter()
                                            .into(weatherBackground);
                                       imgweather.setImageResource(R.drawable.sun);



                                } else if (wheather.equals("Clouds")) {

                                    Glide.with(weatherActivity.this)
                                            .load("https://i.picsum.photos/id/1019/5472/3648.jpg?hmac=2mFzeV1mPbDvR0WmuOWSiW61mf9DDEVPDL0RVvg1HPs")
                                            .fitCenter()
                                            .into(weatherBackground);
                                    imgweather.setImageResource(R.drawable.cloud);



                                } else if (wheather.equals("Rain")) {
                                   imgweather.setImageResource(R.drawable.rain);
                                    Glide.with(weatherActivity.this)
                                            .load("https://i.picsum.photos/id/123/4928/3264.jpg?hmac=Aq7Fp6OSHX5dfjSi9CiQUyK_wwjR7qskMJR1DHhoNuo")
                                            .fitCenter()
                                            .into(weatherBackground);
                                    imgweather.setImageResource(R.drawable.rain);


                                }
                            }
                        }catch(JSONException e){
                            e.printStackTrace();
                            Log.e("JSON error",e.toString());
                        }
                    }
                }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Sara", "Error, recieving URL");
            }
        }
        );
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jsonObj);
    }




}