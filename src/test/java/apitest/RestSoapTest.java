package apitest;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static api.DaySeconds.getSecondDay;
import static api.TestConfigSpec.*;
import static org.testng.Assert.assertTrue;

public class RestSoapTest {
    @Test
    public void restTest() {
        response = getResponse(ContentType.JSON, "JSON",200);
        formatAsString = getResponseString(ContentType.JSON,"incident_count.lastYear");
        formatString = getResponseString(ContentType.JSON,"uptime");
        assertTrue(Integer.parseInt(formatAsString) < 10 &&
                Integer.parseInt(formatString) > getSecondDay());
    }

    @Test
    public void soapTest() {
        response = getResponse(ContentType.XML, "XML",200);
        formatAsString = getResponseString(ContentType.XML,"response.incident_count.lastYear");
        formatString = getResponseString(ContentType.XML,"response.uptime");
        assertTrue(Integer.parseInt(formatAsString) < 10 &&
                Integer.parseInt(formatString) > getSecondDay());
    }
}
