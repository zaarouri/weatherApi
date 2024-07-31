package org.sid.org.sid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mock-api")
public class WeatherController {

    @GetMapping("/weather")
    public ResponseEntity<Map<String, Object>> getWeather(
            @RequestParam String location,
            @RequestParam(required = false) String units) {

        Map<String, Object> response = new HashMap<>();
        response.put("location", location);
        response.put("temperature", 22.5);
        response.put("units", units != null ? units : "celsius");
        response.put("description", "Partly cloudy");

        return ResponseEntity.ok(response);
    }
}