import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WeatherInfoReader {

    public List<WeatherInfo> readCityFromFile(String fileName) {
        ArrayList<String> cityList = new ArrayList<>();
        FileReader fileReader;
        BufferedReader reader = null;
        try {
            fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);
            String nextLine = null;

            while ((nextLine = reader.readLine()) != null) {
                cityList.add(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        WeatherApi api = new WeatherApi();

        ArrayList<WeatherInfo> infoTable = new ArrayList<>();

        //tworze liste obiektow
        for (int j = 0; j < cityList.size(); j++) {
            try {
                infoTable.add(new WeatherInfo(cityList.get(j), api.getDescription(cityList.get(j)), api.getTemperature(cityList.get(j))));
            } catch (IOException e) {
                System.out.println("Nie ma danych");
            }
        }
        return infoTable;
    }
}
