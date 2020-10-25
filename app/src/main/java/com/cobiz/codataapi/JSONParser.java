package com.cobiz.codataapi;

import android.util.Log;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.cobiz.codata.Corona;
import com.cobiz.codata.Coviddata;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSONParser {

    static InputStream is = null;
    static String json = "";
    List<Corona> coronaList = null;

    // constructor
    public JSONParser() {

    }

    public List<Corona> getJSONFromUrl(String url) {

        // Making HTTP request
        try {
            // defaultHttpClient
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpPost = new HttpGet(url);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "n");
            }
            is.close();
            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }

        // try parse the string to a JSON object
        try {
            ArrayList<Corona> coronaData = new ArrayList<Corona>();

            Corona cObj = new Corona();
            ObjectMapper objectMapper = new ObjectMapper();


            Coviddata data = null;

            data = objectMapper.readValue(json, Coviddata.class);

            coronaList = Arrays.asList(data.getData());
        } catch (IOException e) {
            e.printStackTrace();
        }


        // return Corona List
        return coronaList;

    }
}