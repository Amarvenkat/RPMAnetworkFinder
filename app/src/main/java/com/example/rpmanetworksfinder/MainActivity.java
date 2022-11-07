package com.example.rpmanetworksfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.rpmanetworksfinder.ApiInterface.ApiTemperature;
import com.example.rpmanetworksfinder.RetrofitClass.GetForcast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    CardView btn;
    LottieAnimationView mapanimation;
    StringBuilder format = new StringBuilder();
    String currentdate;
    String currenttemp;
    TextView temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (CardView) findViewById(R.id.button);
        mapanimation = (LottieAnimationView) findViewById(R.id.mapanimation);
        temp = (TextView) findViewById(R.id.temp);
        mapanimation.setAnimation("mapanimation.json");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            String hour = String.valueOf(LocalDateTime.now().getHour());
            Log.d("hour",hour);
            LocalDate date = LocalDate.now();
            if (hour.equals("0") || hour.equals("1") || hour.equals("2") || hour.equals("3") || hour.equals("4") || hour.equals("5") || hour.equals("6") || hour.equals("7") || hour.equals("8") || hour.equals("9")){
                currentdate =  String.valueOf(date).concat("T0"+hour+":00");
            }else{
                currentdate =  String.valueOf(date).concat("T"+hour+":00");
            }

        }

        Log.d("currentdate",currentdate);
        ApiTemperature apiTemperature =ApiClient.getClient().create(ApiTemperature.class);
        Call<GetForcast> call = apiTemperature.getReport();

        call.enqueue(new Callback<GetForcast>() {
            @Override
            public void onResponse(Response<GetForcast> response) {

                GetForcast resp = response.body();

                Log.d("tag", String.valueOf(resp.getHourlyTime().getHourlyTimeArrayList().get(1)));

                for (int i=0;i<resp.getHourlyTime().getHourlyTimeArrayList().size();i++){
                    Log.d("all", String.valueOf(resp.getHourlyTime().getHourlyTimeArrayList().get(i)));
                    if (resp.getHourlyTime().getHourlyTimeArrayList().get(i).equals(currentdate)){
                        Log.d("now",String.valueOf(resp.getHourlyTime().getHourlyTimeArrayList().get(i)));
                        currenttemp = resp.getHourlyTime().getTemperature().get(i);
                        Log.d("now",""+currenttemp);
                        temp.setText(currenttemp+" °C");
                    }
                }

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });



    }
//    public String getCurrentDate(){
//        StringBuilder builder=new StringBuilder();;
//        builder.append(+"-");
//        builder.append((picker.getMonth()+1)+"-");
//        builder.append(picker.getDayOfMonth());
//        ;//month is 0 based
//        return builder.toString();
//    }
//    public String getCurrentTime(){
//        String currentTime= "T"+timepicker.getCurrentHour()+":"+timepicker.getCurrentMinute()+":00%2B05:30";
//        return currentTime;
//    }
}