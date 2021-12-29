package com.example.weatherapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button minskWeather;
    private Button newYorkWeather;
    private Button londonWeather;
    private Button tokyoWeather;
    private Button romeWeather;
    private Button parisWeather;
    private Button hongKongWeather;
    private Button berlinWeather;
    private Button moscowWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FindAllButtonsById();

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {});

        minskWeather.setOnClickListener(getWeatherButtonListener(this, "minsk", launcher));
        newYorkWeather.setOnClickListener(getWeatherButtonListener(this, "newYork", launcher));
        londonWeather.setOnClickListener(getWeatherButtonListener(this, "london", launcher));

        tokyoWeather.setOnClickListener(getWeatherButtonListener(this, "tokyo", launcher));
        romeWeather.setOnClickListener(getWeatherButtonListener(this, "rome", launcher));
        parisWeather.setOnClickListener(getWeatherButtonListener(this, "paris", launcher));

        hongKongWeather.setOnClickListener(getWeatherButtonListener(this, "hongKong", launcher));
        berlinWeather.setOnClickListener(getWeatherButtonListener(this, "berlin", launcher));
        moscowWeather.setOnClickListener(getWeatherButtonListener(this, "moscow", launcher));
    }


    //intent from Main to WebWeather
    private View.OnClickListener getWeatherButtonListener(AppCompatActivity from, String city, ActivityResultLauncher<Intent> launcher){
        Class to = WebWeatherActivity.class;
        return v -> {
            Intent intent = new Intent(from, to);
            intent.putExtra("city", city);
            launcher.launch(intent);
        };
    }






    private void FindAllButtonsById(){
        this.minskWeather = this.findViewById(R.id.minskWeatherButton);
        this.newYorkWeather = this.findViewById(R.id.newYorkWeatherButton);
        this.londonWeather = this.findViewById(R.id.londonWeatherButton);
        this.tokyoWeather = this.findViewById(R.id.tokyoWeatherButton);
        this.romeWeather = this.findViewById(R.id.romeWeatherButton);
        this.parisWeather = this.findViewById(R.id.parisWeatherButton);
        this.hongKongWeather = this.findViewById(R.id.hongKongWeatherButton);
        this.berlinWeather = this.findViewById(R.id.berlinWeatherButton);
        this.moscowWeather = this.findViewById(R.id.moscowWeatherButton);
    }
}