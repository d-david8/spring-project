package ro.ddavid.springproject.services;

import ro.ddavid.springproject.models.WeatherResponse;

import java.io.IOException;

public interface WeatherService {

    WeatherResponse getCityWeather(String city) throws IOException;
}
