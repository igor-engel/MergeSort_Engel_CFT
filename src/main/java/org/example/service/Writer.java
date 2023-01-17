package org.example.service;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class Writer {
    public void wrightIntegerArrayToFile(List<Integer> name) {
        try (FileOutputStream fos = new FileOutputStream("out.txt");
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos)) {

            for (Integer integer : name) {
                outputStreamWriter.write(integer + "\n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void wrightStringArrayToFile(List<String> name) {
        try (FileOutputStream fos = new FileOutputStream("out.txt");
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos)) {

            for (String string : name) {
                outputStreamWriter.write(string + "\n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
