package com.ssafy.ssaccer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class WeatherAPITest {
    public static void main(String[] args) throws IOException, ParseException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst");
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=TOAWL0f1DYTXyZiJRU4xXoEtL8ttE7ZXXU5rPNuCyxOI4Wd2XwYCgqdg7MPICUt6EHDFdV3%2BNczM8CpeZzehtQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode("20230522", "UTF-8")); /*‘21년 6월 28일 발표*/
        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode("1400", "UTF-8")); /*06시 발표(정시단위) */
        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode("67", "UTF-8")); /*예보지점의 X 좌표값*/
        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode("101", "UTF-8")); /*예보지점의 Y 좌표값*/
        // GET방식으로 전송해서 파라미터 받아오기
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        String data= sb.toString();

//        System.out.println(data);

        // Json parser를 만들어 만들어진 문자열 데이터를 객체화
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(data);
        // response 키를 가지고 데이터를 파싱
        JSONObject parse_response = (JSONObject) obj.get("response");
        // response 로 부터 body 찾기
        JSONObject parse_body = (JSONObject) parse_response.get("body");
        // body 로 부터 items 찾기
        JSONObject parse_items = (JSONObject) parse_body.get("items");

        // items로 부터 itemlist 를 받기
        JSONArray parse_item = (JSONArray) parse_items.get("item");



        JSONObject weather = new JSONObject();
        Object fcstTime;
        Object category;
        Object value;

        /**
         * parse_item.size()/10 : 몇 개의 시간 데이터를 받아 왔는지
         * 받아온 데이터의 갯수 / 시간당 데이터 갯수 =
         */
        int dataSize = parse_item.size()/10;

        for(int i=0;i<dataSize;i++) {
            for(int k=0;k<10;k++) {
                weather = (JSONObject) parse_item.get((i*dataSize)+k);
                fcstTime = weather.get("fcstTime");
                category = weather.get("category");
                value = weather.get("fcstValue");
                System.out.println(fcstTime+" : " +category+"  "+value);
                System.out.println(weather);
            }
        }

    }
}