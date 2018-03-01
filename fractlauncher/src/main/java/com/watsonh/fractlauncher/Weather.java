package com.watsonh.fractlauncher;

/**
 * Created by WatsonH on 2018/2/28.
 */

public class Weather {
    String cityname;
    String text_day;
    int code_day;
    String text_night;
    int code_night;
    int high;
    int low;
    String wind;
    int wind_speed;
    String update_time;

    public Weather(){};

    public Weather(String cityname, String text_day, int code_day, String text_night, int code_night, int high, int low, String wind, int wind_speed, String update_time){
        super();
        this.cityname = cityname;
        this.text_day = text_day;
        this.code_day = code_day;
        this.text_night = text_night;
        this.code_night = code_night;
        this.high = high;
        this.low = low;
        this.wind = wind;
        this.wind_speed =wind_speed;
        this.update_time = update_time;
    }

    public String getCityname(){
        return cityname;
    }

    public String getText_day(){
        return text_day;
    }

    public int getCode_day(){
        return code_day;
    }

    public String getText_night(){
        return text_night;
    }

    public int getCode_night(){
        return code_night;
    }

    public int getHigh(){
        return high;
    }

    public int getLow(){
        return low;
    }

    public String getWind(){
        return wind;
    }
    public int getWind_speed(){
        return wind_speed;
    }
    public String getUpdate_time(){
        return update_time;
    }

    public void setCityname(String cityname){
        this.cityname = cityname;
    }

    public void setText_day(String text_day) {
        this.text_day = text_day;
    }

    public void setCode_day(int code_day) {
        this.code_day = code_day;
    }

    public void setText_night(String text_night) {
        this.text_night = text_night;
    }

    public void setCode_night(int code_night) {
        this.code_night = code_night;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public void setWind_speed(int wind_speed) {
        this.wind_speed = wind_speed;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

}
