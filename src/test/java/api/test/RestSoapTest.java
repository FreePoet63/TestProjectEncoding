package api.test;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import org.testng.annotations.Test;

import static api.dateday.DaySeconds.getSecondDay;
import static api.service.RestSoapService.initSpec;
import static api.testconfig.TestConfig.*;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public class RestSoapTest {
    @Test
    public void restTest() {
        response =
        given()
                .spec(initSpec(URL_JSON, ContentType.JSON,"json"))
                .when()
                .get()
                .then()
                .statusCode(200)
                .log()
                .body()
                .extract()
                .response();
        formatAsString = response.jsonPath().getString("incident_count.lastYear");
        formatString = response.jsonPath().getString("uptime");
        assertTrue(Integer.parseInt(formatAsString) < 10 &&
                           Integer.parseInt(formatString ) > getSecondDay());
    }

    @Test
    public void soapTest() {
        String asXmlString =
        given()
                .spec(initSpec(URL_XML, ContentType.XML,"xml"))
                .when()
                .get()
                .then()
                .statusCode(200)
                .log()
                .body()
                .extract()
                .asString();
        XmlPath xmlPath = new XmlPath(asXmlString);
        assertTrue(Integer.parseInt(xmlPath.getString("response.incident_count.lastYear")) < 10 &&
                           Integer.parseInt(xmlPath.getString("response.uptime")) > getSecondDay());
    }
}
