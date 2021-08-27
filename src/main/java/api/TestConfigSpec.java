package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class TestConfigSpec {
    public final static String BASE_URL = "https://status.encoding.com/status.php";
    public static Response response;
    public static String formatAsString;
    public static String formatString;
    public static RequestSpecification SPEC;

    public static RequestSpecification initSpec(ContentType type, String formatValue) {
        return SPEC = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addQueryParam("format", formatValue)
                .setContentType(type)
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
    }

    public static Response getResponse(ContentType type, String formatValue, int statusCode) {
        return response =
                given()
                        .spec(initSpec(type, formatValue))
                        .when()
                        .get()
                        .then()
                        .statusCode(statusCode)
                        .log()
                        .body()
                        .extract()
                        .response();
    }

    public static String getResponseString(ContentType type, String path) {
       if (type.equals(ContentType.JSON)) {
           return response.jsonPath().getString(path);
       } else if (type.equals(ContentType.XML)) {
           return response.xmlPath().getString(path);
       }
       return getResponseString(type,path);
    }
}
