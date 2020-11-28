package github.com.cryptocurrencyapplication.markets;

import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MarketService {

    private final RestData restData;

    public MarketService() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.bitbay.net/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        this.restData = retrofit.create(RestData.class);
    }

    public List<MarketDTO> getMarketList() {

        String jsonBody = "";
        try {
            jsonBody = restData.getMarkets().execute().body().string();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadListFromJSON(jsonBody);
    }

    private List<MarketDTO> loadListFromJSON(String s) {

        List<MarketDTO> resultList = new ArrayList<>();
        JSONObject json = new JSONObject(s);
        JSONArray names = json.getJSONObject("items").names();

        for (int i = 0; i < names.length(); i++) {

            resultList.add(new MarketDTO(
                    json.getJSONObject("items").getJSONObject(names.getString(i)).getJSONObject("market").getJSONObject("first").getString("currency"),
                    json.getJSONObject("items").getJSONObject(names.getString(i)).getJSONObject("market").getJSONObject("second").getString("currency"),
                    json.getJSONObject("items").getJSONObject(names.getString(i)).getString("rate")

            ));
        }
        return resultList;
    }
}