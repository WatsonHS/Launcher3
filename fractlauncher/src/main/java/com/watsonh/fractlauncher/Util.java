package com.watsonh.fractlauncher;

/**
 * Created by WatsonH on 2018/2/28.
 */


import org.json.JSONArray;
import org.json.JSONObject;

public class Util {

    public Weather getInformation(String jonString)
            throws Exception {
        JSONObject jsonObject = new JSONObject(jonString);
        /*
        获取json对象
         */
        Weather weather = new Weather();
        JSONArray results = jsonObject.getJSONArray("results");
        JSONObject location = results.getJSONObject(0).getJSONObject("location");
        JSONObject updateTime = results.getJSONObject(0);
        JSONArray daily = results.getJSONObject(0).getJSONArray("daily");
        JSONObject today = daily.getJSONObject(0);
        weather.setCityname(location.getString("name"));
        weather.setCode_day(today.getInt("code_day"));
        weather.setText_day(today.getString("text_day"));
        weather.setText_night(today.getString("text_night"));
        weather.setCode_night(today.getInt("code_night"));
        weather.setHigh(today.getInt("high"));
        weather.setLow(today.getInt("low"));
        weather.setWind(today.getString("wind_direction"));
        weather.setWind_speed(today.getInt("wind_speed"));
        weather.setUpdate_time(updateTime.getString("last_update"));
        return weather;
    }

}
