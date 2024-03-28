import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import org.json.JSONArray;
import org.json.JSONObject;
public class CURRENT_TEMPERATURE_FORCAST {
    private static final String API_KEY = "Bismaya@4168";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/forecast";
    
    public static void main(String[] args) {
        try {
            // Get current weather
            JSONObject currentWeather = getWeatherData(API_URL + "?q=Bhubaneswar&appid=" + API_KEY);
            System.out.println("Current Weather: ");
            displayWeather(currentWeather);
            
            // Get weather for previous five days
            System.out.println("\nWeather for Previous Five Days: ");
            for (int i = 1; i <= 5; i++) {
                LocalDate date = LocalDate.now().minusDays(i);
                JSONObject weather = getWeatherData(API_URL + "?q=Bhubaneswar&appid=" + API_KEY + "&dt=" + date.atStartOfDay().toEpochSecond());
                displayWeather(weather);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static JSONObject getWeatherData(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        return new JSONObject(response.toString());
    }
    
    private static void displayWeather(JSONObject weather) {
        JSONArray weatherArray = weather.getJSONArray("list");
        for (int i = 0; i < weatherArray.length(); i++) {
            JSONObject data = weatherArray.getJSONObject(i);
            String dateTime = data.getString("dt_txt");
            JSONObject main = data.getJSONObject("main");
            double temperature = main.getDouble("temp");
            JSONArray weatherInfo = data.getJSONArray("weather");
            String description = weatherInfo.getJSONObject(0).getString("description");
            System.out.println(dateTime + " - Temperature: " + temperature + "°C, Description: " + description);
        }
    }
}