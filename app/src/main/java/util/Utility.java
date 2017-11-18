package util;

import android.text.TextUtils;

import db.CoolWeatherDB;
import model.City;
import model.County;
import model.Province;

/**
 * Created by lucky on 11/18/17.
 */

public class Utility {
    public synchronized static boolean handleProvinceResponse(CoolWeatherDB
        coolWeatherDB, String response) {
        if (!TextUtils.isEmpty(response)) {
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length > 0) {
                for (String p : allProvinces) {
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);

                    coolWeatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }
    
    public synchronized static boolean handleCityResponse(CoolWeatherDB
        coolWeatherDB, String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCitys = response.split(",");
            if (allCitys != null && allCitys.length > 0) {
                for (String p : allCitys) {
                    String[] array = p.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);

                    coolWeatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }
    public synchronized static boolean handleCountyResponse(CoolWeatherDB
        coolWeatherDB, String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCountys = response.split(",");
            if (allCountys != null && allCountys.length > 0) {
                for (String p : allCountys) {
                    String[] array = p.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);

                    coolWeatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }
    
    
    
}

