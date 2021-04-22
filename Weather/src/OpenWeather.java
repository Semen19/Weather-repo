
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class OpenWeather {
    public static void main(String[] args) throws IOException {

        String token = "f454674aaa616245d8bc306b6a75d297";
        // String city = "Moscow";

        System.out.println("Please enter city");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String city = reader.readLine();

        System.out.println(token);
        String weather_url = "http://api.openweathermap.org/data/2.5/forecast?q=" + city +"&appid=" + token;
        System.out.println(weather_url);

        URL url = new URL(weather_url);
        HttpURLConnection weather_connection = (HttpURLConnection) url.openConnection();
        weather_connection.setRequestMethod("GET");

        BufferedReader incoming = new BufferedReader(
                new InputStreamReader(weather_connection.getInputStream()));
        String inputLine;
        StringBuffer weather_result = new StringBuffer();
        while ((inputLine = incoming.readLine()) != null) {
            weather_result.append(inputLine);
        }
        incoming.close();

        System.out.println(weather_result);
    }
}


