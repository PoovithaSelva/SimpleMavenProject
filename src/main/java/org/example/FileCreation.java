package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileCreation {


    public static void createFile() throws IOException {
       String text ="Hello World" ;
        File file = new File("HelloWorld.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter output = new BufferedWriter(fw);
        output.write(text);
        output.close();
        System.out.println("File Location : " + (file.getAbsoluteFile())) ;

}




}
