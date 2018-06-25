import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WeatherInfoWriter {

    public void writeOnConsole(List<WeatherInfo> infoTable){
        for (WeatherInfo weatherInfo : infoTable) {
            System.out.println(weatherInfo);
        }

    }

    public void writeToCSVFile(List<WeatherInfo> infoTable, String fileName){


        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedReader = new BufferedWriter(fileWriter);
            for (WeatherInfo weatherInfo : infoTable) {
                bufferedReader.write(weatherInfo.getCity()+";"+weatherInfo.getDescription()+";"+weatherInfo.getTemperature());
                bufferedReader.write("\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Problem z plikiem: " + fileName);
        }


    }
}
