package com.watsonh.fractlauncher;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by WatsonH on 2018/2/26.
 */

public class FractLauncher extends Launcher {

    TextClock mTextClock;
    TextView weatherView, temperatureView, cityView, timeView;
    ImageView imageView, imageView2;


    protected boolean hasCustomContentToLeft() {
        return true;
    }

    protected void addToCustomContentPage() {
        View customView = getLayoutInflater().inflate(R.layout.activity_lscreen_view, null);

        CustomContentCallbacks callbacks = new CustomContentCallbacks() {

            @Override
            public void onShow(boolean fromResume) {
            }

            @Override
            public void onScrollProgressChanged(float progress) {
            }

            @Override
            public void onHide() {
            }

            @Override
            public boolean isScrollingAllowed() {
                return true;
            }
        };


        addToCustomContentPage(customView, callbacks, "custom view");
    }



    @Override
    public void finishBindingItems() {
        super.finishBindingItems();
        this.addToCustomContentPage();
        weatherView = (TextView) findViewById(R.id.textView2);
        temperatureView = (TextView) findViewById(R.id.textView3);
        cityView = (TextView) findViewById(R.id.textView4);
        timeView = (TextView) findViewById(R.id.textView5);
        imageView =(ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        imageView2.setImageResource(R.mipmap.refresh_icon);
        RfButtonListener rfButtonListener = new RfButtonListener();
        imageView2.setOnClickListener(rfButtonListener);
        WeatherThread weatherThread = new WeatherThread();
        weatherThread.start();

    }

    final RotateAnimation animation = new RotateAnimation(0.0f, 360.0f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f);

    class RfButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            animation.setDuration(500);
            imageView2.startAnimation(animation);
            WeatherThread weatherThread = new WeatherThread();
            weatherThread.start();
        }
    }
    /*获取天气数据*/
    class WeatherThread extends Thread{
        @Override
        public void run(){
            String url1 = null;
            WeatherUrl weatherUrl = new WeatherUrl();
            try {
                url1 = weatherUrl.generateGetDiaryWeatherURL(
                        "shanghai",
                        "zh-Hans",
                        "c",
                        "1",
                        "1"
                );
            } catch (SignatureException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            HttpDownload httpDownload = new HttpDownload();
            String wString = httpDownload.httpRequest(url1);
            Message msg = FractLauncher.this.handler
                    .obtainMessage(1);
            msg.obj = wString;
            FractLauncher.this.handler.sendMessage(msg);
        }
    }

    /*刷新负一屏数据*/
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Util util = new Util();
                    Weather nweather;
                    try {
                        nweather = util.getInformation((String)msg.obj);
                        weatherView.setText(nweather.text_day);
                        temperatureView.setText(nweather.getLow() + "℃ / " + nweather.getHigh() + "℃");
                        cityView.setText(nweather.getCityname());
                        String pattern = "T([\\s\\S]+)\\+";
                        Pattern r = Pattern.compile(pattern);
                        Matcher m = r.matcher(nweather.getUpdate_time());
                        if(m.find()){
                            timeView.setText("更新时间" + m.group(1));
                        }
                        switch (nweather.getCode_day())
                        {
                            case 0:imageView.setImageResource(R.mipmap.weather_icon_0);break;
                            case 1:imageView.setImageResource(R.mipmap.weather_icon_1);break;
                            case 2:imageView.setImageResource(R.mipmap.weather_icon_2);break;
                            case 3:imageView.setImageResource(R.mipmap.weather_icon_3);break;
                            case 4:imageView.setImageResource(R.mipmap.weather_icon_4);break;
                            case 5:imageView.setImageResource(R.mipmap.weather_icon_5);break;
                            case 6:imageView.setImageResource(R.mipmap.weather_icon_6);break;
                            case 7:imageView.setImageResource(R.mipmap.weather_icon_7);break;
                            case 8:imageView.setImageResource(R.mipmap.weather_icon_8);break;
                            case 9:imageView.setImageResource(R.mipmap.weather_icon_9);break;
                            case 10:imageView.setImageResource(R.mipmap.weather_icon_10);break;
                            case 11:imageView.setImageResource(R.mipmap.weather_icon_11);break;
                            case 12:imageView.setImageResource(R.mipmap.weather_icon_12);break;
                            case 13:imageView.setImageResource(R.mipmap.weather_icon_13);break;
                            case 14:imageView.setImageResource(R.mipmap.weather_icon_14);break;
                            case 15:imageView.setImageResource(R.mipmap.weather_icon_15);break;
                            case 16:imageView.setImageResource(R.mipmap.weather_icon_16);break;
                            case 17:imageView.setImageResource(R.mipmap.weather_icon_17);break;
                            case 18:imageView.setImageResource(R.mipmap.weather_icon_18);break;
                            case 19:imageView.setImageResource(R.mipmap.weather_icon_19);break;
                            case 20:imageView.setImageResource(R.mipmap.weather_icon_20);break;
                            case 21:imageView.setImageResource(R.mipmap.weather_icon_21);break;
                            case 22:imageView.setImageResource(R.mipmap.weather_icon_22);break;
                            case 23:imageView.setImageResource(R.mipmap.weather_icon_23);break;
                            case 24:imageView.setImageResource(R.mipmap.weather_icon_24);break;
                            case 25:imageView.setImageResource(R.mipmap.weather_icon_25);break;
                            case 26:imageView.setImageResource(R.mipmap.weather_icon_26);break;
                            case 27:imageView.setImageResource(R.mipmap.weather_icon_27);break;
                            case 28:imageView.setImageResource(R.mipmap.weather_icon_28);break;
                            case 29:imageView.setImageResource(R.mipmap.weather_icon_29);break;
                            case 30:imageView.setImageResource(R.mipmap.weather_icon_30);break;
                            case 31:imageView.setImageResource(R.mipmap.weather_icon_31);break;
                            case 32:imageView.setImageResource(R.mipmap.weather_icon_32);break;
                            case 33:imageView.setImageResource(R.mipmap.weather_icon_33);break;
                            case 34:imageView.setImageResource(R.mipmap.weather_icon_34);break;
                            case 35:imageView.setImageResource(R.mipmap.weather_icon_35);break;
                            case 36:imageView.setImageResource(R.mipmap.weather_icon_36);break;
                            case 37:imageView.setImageResource(R.mipmap.weather_icon_37);break;
                            case 38:imageView.setImageResource(R.mipmap.weather_icon_38);break;
                            default:imageView.setImageResource(R.mipmap.weather_icon_99);break;
                        }
                        System.out.println("Finish Refreshing Data");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }

        }

    };

}

