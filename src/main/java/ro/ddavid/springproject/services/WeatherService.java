package ro.ddavid.springproject.services;

import ro.ddavid.springproject.models.dtos.WeatherResponseDTO;

import java.io.IOException;

public interface WeatherService {

    WeatherResponseDTO getCityWeather(String city) throws IOException;
}
