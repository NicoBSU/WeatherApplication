package com.example.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.webkit.WebView;

public class WebWeatherActivity extends AppCompatActivity {
    private WebView weatherView;
    private String htmlCodeTemplateParts[] = {
            "<a class=\"weatherwidget-io\" href=\"", //link to forecast
            "\" data-label_1=\"", //city title
            "\" data-label_2=\"WEATHER\" data-theme=\"original\" >", //city weather
            "</a>",
            "<script>",
            "!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src='https://weatherwidget.io/js/widget.min.js';fjs.parentNode.insertBefore(js,fjs);}}(document,'script','weatherwidget-io-js');",
            "</script>"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_weather);


        Intent intent = getIntent();
        String city = intent.getStringExtra("city");
        this.weatherView = this.findViewById(R.id.weatherView);
        weatherView.getSettings().setJavaScriptEnabled(true);

        switch (city){
            case "minsk":{
                loadHtmlCode("https://forecast7.com/en/53d9027d56/minsk/",
                        "MINSK",
                        "MINSK WEATHER");
                break;
            }
            case "newYork":{
                loadHtmlCode("https://forecast7.com/en/40d71n74d01/new-york/",
                        "NEW YORK",
                        "NEW YORK WEATHER");
                break;
            }
            case "london":{
                loadHtmlCode("https://forecast7.com/en/51d51n0d13/london/",
                        "LONDON",
                        "LONDON WEATHER");
                break;
            }
            case "tokyo":{
                loadHtmlCode("https://forecast7.com/en/35d71139d73/tokyo/",
                        "TOKYO",
                        "TOKYO WEATHER");
                break;
            }
            case "rome":{
                loadHtmlCode("https://forecast7.com/en/41d9012d50/rome/",
                        "ROME",
                        "ROME WEATHER");
                break;
            }
            case "paris":{
                loadHtmlCode("https://forecast7.com/en/48d862d35/paris/",
                        "PARIS",
                        "PARIS WEATHER");
                break;
            }
            case "hongKong":{
                loadHtmlCode("https://forecast7.com/en/22d40114d11/hong-kong/",
                        "HONG KONG",
                        "HONG KONG WEATHER");
                break;
            }
            case "berlin":{
                loadHtmlCode("https://forecast7.com/en/52d5213d40/berlin/",
                        "BERLIN",
                        "BERLIN WEATHER");
                break;
            }
            case "moscow":{
                loadHtmlCode("https://forecast7.com/en/55d7637d62/moscow/",
                        "MOSCOW",
                        "MOSCOW WEATHER");
                break;
            }
        }

    }

    private void loadHtmlCode(String forecastLink,String cityTitle, String cityWeather){
        String htmlCode =
                htmlCodeTemplateParts[0]+
                        forecastLink+
                        htmlCodeTemplateParts[1]+
                        cityTitle+
                        htmlCodeTemplateParts[2]+
                        cityWeather+
                        htmlCodeTemplateParts[3]+htmlCodeTemplateParts[4]+htmlCodeTemplateParts[5] + htmlCodeTemplateParts[6];
        String base64 = Base64.encodeToString(htmlCode.getBytes(), Base64.DEFAULT);
        weatherView.loadData(base64,"text/html; charset=utf-8", "base64");
    }
}