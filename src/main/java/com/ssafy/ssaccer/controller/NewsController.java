package com.ssafy.ssaccer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value="News RestController")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET , RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor
@RestController
@RequestMapping("/news")
public class NewsController {

    @ApiOperation(value = "리그별 특정 라운드 경기 결과")
    @GetMapping("/matchday/list/{league}/{round}")
    public ResponseEntity<?> getPLMatchdayList(@PathVariable String league, @PathVariable int round) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        List<String> list = new ArrayList<>();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.football-data.org/v4/competitions/" + league + "/matches?matchday=" + round))
                .header("X-Auth-Token", "326e84aea1b349f79639d3991db01596")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());

        return new ResponseEntity<String>(response.body(), HttpStatus.OK);
    }

    @ApiOperation(value = "리그 별 최고 득점자")
    @GetMapping("/topscorer/{league}")
    public ResponseEntity<?> getTopScorerByLeague(@PathVariable String league) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        List<String> list = new ArrayList<>();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.football-data.org/v4/competitions/" + league +"/scorers"))
                .header("X-Auth-Token", "326e84aea1b349f79639d3991db01596")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());

        return new ResponseEntity<String>(response.body(), HttpStatus.OK);
    }
}
