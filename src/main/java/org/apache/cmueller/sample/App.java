package org.apache.cmueller.sample;

import org.apache.camel.main.Main;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class App {

    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.bind("amazonS3Client", AmazonS3ClientBuilder.standard().withRegion(Regions.EU_CENTRAL_1).build());
        main.addRouteBuilder(new MyRouteBuilder());
        main.run(args);
    }
}