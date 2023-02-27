package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("S3 Bucket : " + System.getenv("EVENT_BUCKET"));
        System.out.println("S3 Key :  " + System.getenv("EVENT_OBJECT_KEY"));
        FileCreation.createFile();
    }

}