package ro.ddavid.springproject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.ddavid.springproject.models.WeatherResponse;
import ro.ddavid.springproject.services.WeatherService;

import java.io.IOException;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/api/weather")
    public ResponseEntity<WeatherResponse> getWeather(@RequestParam String city) throws IOException {
        return ResponseEntity.ok(weatherService.getCityWeather(city));
    }
}
