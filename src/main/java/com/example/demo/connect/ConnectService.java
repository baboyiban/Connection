package com.example.demo.connect;

/* POST 방식 요청 예 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class ConnectService {
    private final String USER_AGENT = "Mozilla/5.0";
    private final String DATA = "test data";
    
    public String get(String url) throws IOException {
        URL url2 = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) url2.openConnection();

        connection.setRequestMethod("GET");    // GET 방식 요청
        connection.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = connection.getResponseCode();
        System.out.println("resposneCode:"+responseCode);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer stringBuffer = new StringBuffer();
        String inputLine;

        while ((inputLine = bufferedReader.readLine()) != null)  {
            stringBuffer.append(inputLine);
        }
        bufferedReader.close();

        String response = stringBuffer.toString();
        System.out.println("response:"+response);
        
        return response;
    }
    
    public String post(String url, Map<String,String> map) throws IOException, ParseException {
        URL url2 = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) url2.openConnection();

        connection.setRequestMethod("POST");     // POST 방식 요청
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        OutputStream os = connection.getOutputStream();
        os.write(new JSONObject(map).toJSONString().getBytes());
        os.flush();
        os.close();

        int responseCode = connection.getResponseCode();
        System.out.println("resposneCode:"+responseCode);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer stringBuffer = new StringBuffer();
        String inputLine;

        while ((inputLine = bufferedReader.readLine()) != null) {
            stringBuffer.append(inputLine);
        }
        bufferedReader.close();

        String response = stringBuffer.toString();
        System.out.println("response:"+response);
        
        return response;
    }
}
