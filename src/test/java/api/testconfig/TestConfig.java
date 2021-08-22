package api.testconfig;

import io.restassured.response.Response;

public class TestConfig {
    public final static String URL_XML = "https://status.encoding.com/status.php";
    public final static String URL_JSON = "https://status.encoding.com/status.php?format=json";
    public static Response response;
    public static String formatAsString;
    public static String formatString;
}
