import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
class WeatherData {
    private String month;
    private double temperature;
    private double precipitation;
    private int humidity;
    private double windSpeed;
    WeatherData(String month, double temperature, double precipitation, int humidity, double windSpeed) {
        this.month = month;
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }
    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }
    @Override
    public String toString() {
        return "WeatherData{" +
                "month='" + month + '\'' +
                ", temperature=" + temperature +
                ", precipitation=" + precipitation +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                '}';
    }
}
public class CSV_DATA_STORE_WEATHER {
    public static void main(String[] args) {
        List<WeatherData> weatherDataList = new ArrayList<>();
        weatherDataList.add(new WeatherData("Jan", 21.0, 12.9, 73, 5.0));
        weatherDataList.add(new WeatherData("Feb", 25.7, 20.4, 66, 5.3));
        weatherDataList.add(new WeatherData("Mar", 30.3, 42.4, 66, 6.1));
        weatherDataList.add(new WeatherData("Apr", 32.6, 48.8, 70, 7.2));
        weatherDataList.add(new WeatherData("May", 34.8, 124.5, 76, 7.8));
        weatherDataList.add(new WeatherData("Jun", 33.1, 259.3, 84, 7.6));
        weatherDataList.add(new WeatherData("Jul", 31.4, 334.4, 85, 7.0));
        weatherDataList.add(new WeatherData("Aug", 30.8, 303.6, 84, 6.6));
        weatherDataList.add(new WeatherData("Sep", 29.8, 270.0, 82, 6.0));
        weatherDataList.add(new WeatherData("Oct", 27.8, 160.0, 79, 5.7));
        weatherDataList.add(new WeatherData("Nov", 24.4, 25.4, 73, 4.7));
        weatherDataList.add(new WeatherData("Dec", 22.3, 6.6, 67, 4.3));
        writeWeatherDataToCsv(weatherDataList);
    }
    public static void writeWeatherDataToCsv(List<WeatherData> weatherDataList) {
        try (FileWriter writer = new FileWriter("C:\\Users\\KIIT\\BISMAYA\\PROGRAMMING_FILES\\BISMAYA_CODE\\JAVA_CODES\\JAVA_PROJECT\\HTML_FILE\\weather_data.csv")) {
            writer.append("Month, Temperature(°C), Precipitation(mm), Humidity(%), Wind Speed(kmph)\n");
            for (WeatherData weatherData : weatherDataList) {
                writer.append(String.format("%s, %.1f, %.1f, %d, %.1f\n",
                        weatherData.getMonth(), weatherData.getTemperature(),
                        weatherData.getPrecipitation(), weatherData.getHumidity(),
                        weatherData.getWindSpeed()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}