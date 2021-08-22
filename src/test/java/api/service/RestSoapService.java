package api.service;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestSoapService {
    public static RequestSpecification SPEC;

    public static RequestSpecification initSpec(String url, ContentType type, String formatValue) {
        return SPEC = new RequestSpecBuilder()
                .setBaseUri(url)
                .addQueryParam("format",formatValue)
                .setContentType(type)
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
    }
}
