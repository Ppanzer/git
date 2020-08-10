package com.example.excalhandler.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xjq
 * @date 2020/8/5
 */
public class DataInsides {

    private Integer uid;

    private Float wind;

    private Float rain;

    private Float temperature;

    private Float rainacc;

    private Float pressure;

    private Float humidity;

    private Integer direction;

    private Float noise;

    private Integer illumination;

    private Integer pm10;

    private Integer pm25;

    private Date creatingtime;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Float getWind() {
        return wind;
    }

    public void setWind(Float wind) {
        this.wind = wind;
    }


    public Float getRain() {
        return rain;
    }

    public void setRain(Float rain) {
        this.rain = rain;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getRainacc() {
        return rainacc;
    }

    public void setRainacc(Float rainacc) {
        this.rainacc = rainacc;
    }

    public Float getPressure() {
        return pressure;
    }

    public void setPressure(Float presure) {
        this.pressure = presure;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Float getNoise() {
        return noise;
    }

    public void setNoise(Float noise) {
        this.noise = noise;
    }

    public Integer getIllumination() {
        return illumination;
    }

    public void setIllumination(Integer illumination) {
        this.illumination = illumination;
    }

    public Integer getPm10() {
        return pm10;
    }

    public void setPm10(Integer pm10) {
        this.pm10 = pm10;
    }

    public Integer getPm25() {
        return pm25;
    }

    public void setPm25(Integer pm25) {
        this.pm25 = pm25;
    }

    public Date getCreatingtime() {
        return creatingtime;
    }

    public void setCreatingtime(Date creatingtime) {
        this.creatingtime = creatingtime;
    }

}
