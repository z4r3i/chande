package com.saeed.chandwidget.data;

import android.util.Log;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 4mir.ir API fetcher
 *
 * Single endpoint: GET https://4mir.ir/price/api.php
 * Response structure: { fiat: {...}, gold: {...}, crypto: {...} }
 * Each item: { price: "X,XXX", change: {value: Y, direction: "up"|"down"}, name: "...", symbol: "..." }
 */
public class TgjuApi {
    private static final String TAG = "4mirApi";
    private static final int TIMEOUT = 12000;
    private static final String API_URL = "https://4mir.ir/price/api.php";

    public static PriceData fetch(String key) {
        try {
            String json = httpGet(API_URL);
            if (json == null) return null;

            JSONObject root = new JSONObject(json);
            JSONObject item = findItem(root, key);
            if (item == null) {
                Log.w(TAG, "Key not found: " + key);
                return null;
            }

            double price = parseDouble(item.optString("price", "0"));
            JSONObject changeObj = item.optJSONObject("change");
            double changeVal = 0;
            if (changeObj != null) {
                changeVal = parseDouble(changeObj.optString("value", "0"));
                String direction = changeObj.optString("direction", "");
                if ("down".equals(direction)) changeVal = -Math.abs(changeVal);
                else changeVal = Math.abs(changeVal);
            }

            return new PriceData(key, price, changeVal);
        } catch (Exception e) {
            Log.e(TAG, "fetch error for " + key, e);
            return null;
        }
    }

    private static JSONObject findItem(JSONObject root, String key) throws Exception {
        for (String category : new String[]{"fiat", "gold", "crypto"}) {
            if (root.has(category)) {
                JSONObject cat = root.getJSONObject(category);
                if (cat.has(key)) {
                    return cat.getJSONObject(key);
                }
            }
        }
        return null;
    }

    private static String httpGet(String urlStr) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(TIMEOUT);
            conn.setReadTimeout(TIMEOUT);
            conn.setRequestProperty("User-Agent", "ChandWidget/1.0");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) return null;
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) sb.append(line);
            br.close();
            return sb.toString();
        } catch (Exception e) {
            Log.e(TAG, "httpGet error: " + urlStr, e);
            return null;
        }
    }

    private static double parseDouble(String s) {
        try { return Double.parseDouble(s.replace(",", "").trim()); }
        catch (Exception e) { return 0; }
    }
}
