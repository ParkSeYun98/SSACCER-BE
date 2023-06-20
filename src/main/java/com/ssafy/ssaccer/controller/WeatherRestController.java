package com.ssafy.ssaccer.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.json.simple.parser.JSONParser;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@ApiModel(value="Weather RestController")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET , RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor
@RestController
@RequestMapping("/weather")
public class WeatherRestController {

    @Value("${Weather-key}")
    private String Weather_Key;
    String key = "TOAWL0f1DYTXyZiJRU4xXoEtL8ttE7ZXXU5rPNuCyxOI4Wd2XwYCgqdg7MPICUt6EHDFdV3%2BNczM8CpeZzehtQ%3D%3D";

    /* 기상청 단기예보(동네예보) API */
    /* 기상개황, 육상, 해상 */
    /* 통보문 발표시간 05시 11시 17시 */
    @ApiOperation(value = "단기 예보 날씨 데이터 받기")
    @GetMapping(value = "/data")
    public ResponseEntity<ModelAndView> shortWeatherData(@RequestParam String baseDate, @RequestParam String baseTime, @RequestParam int nx, @RequestParam int ny) throws IOException, IOException, ParseException {

        ModelAndView jsonView = new ModelAndView("jsonView");

        System.out.println(baseDate);
        System.out.println(baseTime);

        //동네예보 -- 전날 05시 부터 225개의 데이터를 조회하면 모레까지의 날씨를 알 수 있음
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst");

        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + key); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(baseDate, "UTF-8")); /*‘21년 6월 28일 발표*/
        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(baseTime, "UTF-8")); /*06시 발표(정시단위) */
        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode(String.valueOf(nx), "UTF-8")); /*예보지점의 X 좌표값*/
        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode(String.valueOf(ny), "UTF-8")); /*예보지점의 Y 좌표값*/

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

        System.out.println(data);

        try {

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj = (JSONObject) jsonParser.parse(data);
            JSONObject parse_response = (JSONObject) jsonObj.get("response");
            JSONObject parse_body = (JSONObject) parse_response.get("body");
            JSONObject parse_items = (JSONObject) parse_body.get("items");
            JSONArray parse_item = (JSONArray) parse_items.get("item");

            jsonView.addObject("result", parse_item);

        } catch(Exception e) {

            e.printStackTrace();

        }

        return new ResponseEntity<ModelAndView>(jsonView, HttpStatus.OK);
    }

    @ApiOperation(value = "중기 기온 조회 날씨 데이터 받기")
    @GetMapping(value = "/longdata/temperature")
    public ResponseEntity<ModelAndView> longWeatherTemperatureData(@RequestParam String regId, @RequestParam String tmFc) throws IOException, IOException, ParseException {

        ModelAndView jsonView = new ModelAndView("jsonView");

        //동네예보 -- 전날 05시 부터 225개의 데이터를 조회하면 모레까지의 날씨를 알 수 있음
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidTa"); /*URL*/

        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + key); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("regId","UTF-8") + "=" + URLEncoder.encode(regId, "UTF-8")); /*11B10101 서울, 11B20201 인천 등 ( 별첨엑셀자료 참고)*/
        urlBuilder.append("&" + URLEncoder.encode("tmFc","UTF-8") + "=" + URLEncoder.encode(tmFc, "UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력- YYYYMMDD0600(1800) 최근 24시간 자료만 제공*/

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

        System.out.println("중기 온도 : " + data);

        try {

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj = (JSONObject) jsonParser.parse(data);
            JSONObject parse_response = (JSONObject) jsonObj.get("response");
            JSONObject parse_body = (JSONObject) parse_response.get("body");
            JSONObject parse_items = (JSONObject) parse_body.get("items");
            JSONArray parse_item = (JSONArray) parse_items.get("item");

            jsonView.addObject("result", parse_item);

        } catch(Exception e) {

            e.printStackTrace();

        }

        return new ResponseEntity<ModelAndView>(jsonView, HttpStatus.OK);
    }

    @ApiOperation(value = "중기 육상 예보 조회 날씨 데이터 받기")
    @GetMapping(value = "/longdata/weather")
    public ResponseEntity<?> longWeatherInfoData(@RequestParam String regId, @RequestParam String tmFc) throws IOException, IOException, ParseException {

        ModelAndView jsonView = new ModelAndView("jsonView");
        String data = null;



//        while(true) {

            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/MidFcstInfoService/getMidLandFcst"); /*URL*/

            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + key); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
            urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON)Default: XML*/
            urlBuilder.append("&" + URLEncoder.encode("regId","UTF-8") + "=" + URLEncoder.encode(regId, "UTF-8")); /*11B0000 서울, 인천, 경기도 11D10000 등 (활용가이드 하단 참고자료 참조)*/
            urlBuilder.append("&" + URLEncoder.encode("tmFc","UTF-8") + "=" + URLEncoder.encode(tmFc, "UTF-8")); /*-일 2회(06:00,18:00)회 생성 되며 발표시각을 입력 YYYYMMDD0600(1800)-최근 24시간 자료만 제공*/

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

            data= sb.toString();

            System.out.println("중기날씨 : " + data);

//            if(!data.equals("{\"response\":{\"header\":{\"resultCode\":\"03\",\"resultMsg\":\"NO_DATA\"}}}")) {
//                break;
//            }

//        }

//        if(!data.equals("{\"response\":{\"header\":{\"resultCode\":\"03\",\"resultMsg\":\"NO_DATA\"}}}")) {
            try {

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObj = (JSONObject) jsonParser.parse(data);
                JSONObject parse_response = (JSONObject) jsonObj.get("response");
                JSONObject parse_body = (JSONObject) parse_response.get("body");
                JSONObject parse_items = (JSONObject) parse_body.get("items");
                JSONArray parse_item = (JSONArray) parse_items.get("item");

                jsonView.addObject("result", parse_item);

            } catch(Exception e) {

                e.printStackTrace();

            }


        return new ResponseEntity<ModelAndView>(jsonView, HttpStatus.OK);
    }

    @ApiOperation(value = "자바로부터 날짜 / 시간 정보 받기")
    @GetMapping(value = "/now")
    public ResponseEntity<?> nowDate() {
        List<String> nowList = getLastBaseTime();

        return new ResponseEntity<List<String>>(nowList, HttpStatus.OK);
    }

    // calBase : 현재시간의 Calendar 객체
    private List<String> getLastBaseTime() {
        Calendar now = Calendar.getInstance();

        int t = now.get(Calendar.HOUR_OF_DAY);
        if (t < 2) {
            now.add(Calendar.DATE, -1);
            now.set(Calendar.HOUR_OF_DAY, 23);
        } else {
            now.set(Calendar.HOUR_OF_DAY, t - (t + 1) % 3);
        }

        SimpleDateFormat DateFormatter = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat TimeFormatter = new SimpleDateFormat("HH");

        System.out.println("now : " + DateFormatter.format(now.getTime()) + " " + TimeFormatter.format(now.getTime()));
//        now.add(Calendar.HOUR_OF_DAY, -3);
//        System.out.println("now - " +  DateFormatter.format(now.getTime()) + " " + TimeFormatter.format(now.getTime()));

        List<String> nowList = new ArrayList<>();

        nowList.add(DateFormatter.format(now.getTime()));
        nowList.add(TimeFormatter.format(now.getTime()));

        return nowList;
    }
}
