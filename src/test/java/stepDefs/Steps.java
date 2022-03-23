package stepDefs;

import com.google.gson.Gson;
import dao.common.HttpClient;
import dao.fishService.models.JsonResponse;
import hooks.Hooks;
import io.cucumber.java.ru.Когда;
import io.restassured.response.ExtractableResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static dao.common.Helper.transformMap;
import static org.junit.Assert.*;

public class Steps {

    private static final Logger logger = LoggerFactory.getLogger(Steps.class);
    private HttpClient httpClient = new HttpClient();
    private final String path = "/get";

    @Когда("GET fish-text. Format .json")
    public void getFishTextFormatJson(Map<String, String> map) {
        map = transformMap(map);
        Map<String, Object> mapQueryParams = new HashMap<>();
        if (map.containsKey("type")) {
            mapQueryParams.put("type", map.get("type"));
        }
        if (map.containsKey("number")) {
            mapQueryParams.put("number", Integer.parseInt(map.get("number")));
        }
        mapQueryParams.put("format", "json");
        ExtractableResponse response = httpClient.executeGetRequest(path, mapQueryParams);
        checkResponse(response, map);

    }

    private void checkResponse(ExtractableResponse response, Map<String, String> map) {
        assertEquals(Integer.parseInt(map.get("HTTP Code")), response.statusCode());
        JsonResponse jsonResponse = new Gson().fromJson(response.body().asString(), JsonResponse.class);
        logger.info(jsonResponse.toString());
        assertFalse(jsonResponse.getText().isEmpty());
        assertEquals(map.get("response.status"), jsonResponse.getStatus());
        if (map.get("response.textError") != null) {
            assertEquals(map.get("response.textError"), jsonResponse.getText());
        }
        if (map.get("response.errorCode") != null) {
            assertEquals(map.get("response.errorCode"), jsonResponse.getErrorCode());
        }
    }
}
