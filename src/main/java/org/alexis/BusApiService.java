package org.alexis;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class BusApiService {
    private final OkHttpClient client = new OkHttpClient();
    private Request request;
    private Response response;
    private final String endPoint = "https://external.transitapp.com/v3/public/stop_departures?global_stop_id=NJTB:163326";
    private final String apiKey = System.getenv("API_KEY");
    private String jsonString;

    public BusApiService() {
        setJsonString();
    }

    public void setJsonString() {
        request = new Request.Builder()
                .url(endPoint)
                .addHeader("apiKey", apiKey)
                .build();
        try {
            response = client.newCall(request).execute();
            jsonString = response.body().string();
        } catch (IOException ignored) {
        }
    }
    public String getJsonString() {
        return jsonString;
    }
}
