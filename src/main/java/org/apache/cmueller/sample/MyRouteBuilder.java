package org.apache.cmueller.sample;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

    public void configure() {
        from("timer://simple?period=10000")
            .setHeader("CamelAwsS3Key").simple("${exchangeProperty[CamelTimerCounter]}")
            .setBody().simple("${exchangeProperty[CamelTimerName]}: fired ${exchangeProperty[CamelTimerPeriod]} ms after starting the route.")
            .to("aws-s3://camel-aws-test-bucket?amazonS3Client=#amazonS3Client");
    }
}