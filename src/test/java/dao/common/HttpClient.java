package dao.common;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.config.SSLConfig.sslConfig;
import static utill.properties.TestProperties.HOST;

public class HttpClient {

    private static final String baseUrl = HOST;

    private static final RestAssuredConfig config = RestAssured.config()
            .sslConfig(sslConfig().relaxedHTTPSValidation("TLS"))
            .httpClient(HttpClientConfig.httpClientConfig()
                    .setParam("http.connection.timeout", 20000)
            );

    private static final RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(baseUrl)
            .setAccept(ContentType.JSON)
            .addFilter(new AllureRestAssuredCustom())
            .setConfig(config)
            .build();

    public ExtractableResponse executeGetRequest(String url, Map<String, Object> mapQueryParams) {
        return given().log().all()
                .spec(spec)
                .contentType(ContentType.JSON)
                .queryParams(mapQueryParams)
                .config(RestAssured.config().sslConfig(sslConfig().relaxedHTTPSValidation("TLS")))
                .when()
                .get(url)
                .then().log().all()
                .extract();
    }
}
