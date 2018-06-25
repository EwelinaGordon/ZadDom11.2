import java.util.List;

public class WeatherForecast {
    public static void main(String[] args) {

       WeatherInfoReader reader = new WeatherInfoReader();
       List<WeatherInfo> infoTable = reader.readCityFromFile("cities.txt");
        WeatherInfoWriter writer = new WeatherInfoWriter();
        writer.writeOnConsole(infoTable);
        writer.writeToCSVFile(infoTable, "forecasts.txt");
    }
}
