package com.example.grad;

import java.util.Date;

public class sensorInfo {
    String weather;
    String time;
    int fasten;
    int random;
    int active;
    int eat;

    public sensorInfo() {
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getFasten() {
        return fasten;
    }

    public void setFasten(int fasten) {
        this.fasten = fasten;
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    public int getActive() {
        return active;
    }

    public int getEat() {
        return eat;
    }

    public void setActive(int active) {
        this.active = active;

    }

    public void setEat(int eat) {
        this.eat = eat;
    }
}
