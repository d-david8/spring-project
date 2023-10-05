package ro.ddavid.springproject.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import ro.ddavid.springproject.models.WeatherResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class WeatherServiceImpl implements WeatherService {

    private static final String BASE_URL = "http://api.weatherapi.com/v1/current.json";
    private static final String KEY = "ec8face8cc00456babd144815230510";
    private static final String AIR_QUALITY = "no";

    @Override
    public WeatherResponse getCityWeather(String city) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(getUrlRequest(city)).build();
        Response response = client.newCall(request).execute();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.body().string());

        WeatherResponse weatherResponse = new WeatherResponse();

        weatherResponse.setCity(jsonNode.get("location").get("name").textValue());
        weatherResponse.setDescription(jsonNode.get("current").get("condition").get("text").textValue());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime lastUpdated = LocalDateTime.parse(jsonNode.get("current").get("last_updated").textValue(), formatter);
        weatherResponse.setLastUpdated(lastUpdated);
        return weatherResponse;
    }

    @NotNull
    private static String getUrlRequest(String city) {
        return BASE_URL +
                "?key=" +
                KEY +
                "&q=" +
                city +
                "&aqi=" +
                AIR_QUALITY;
    }
}
