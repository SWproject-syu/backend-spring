package com.schoolproj2.schoolproj2.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class ApiController {
    @GetMapping("/search")
    public String callApi() throws IOException {
        StringBuilder result = new StringBuilder();
        // StringBuffer reult = new StringBuffer();
        String urlStr = "http://finlife.fss.or.kr/finlifeapi/depositProductsSearch.json?auth=e9bbf74e2601259689d7ffe71a8a9707&topFinGrpNo=020000&pageNo=1";

        URL url = new URL(urlStr);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");

        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

        String returnLine;

        while ((returnLine = br.readLine()) != null) {
            result.append(returnLine + "\n\r");

        }
        urlConnection.disconnect();

        return result.toString();

    }

}

// e9bbf74e2601259689d7ffe71a8a9707
