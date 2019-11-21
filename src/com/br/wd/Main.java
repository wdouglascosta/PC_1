package com.br.wd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    List<List<String>> records = new ArrayList<>();

    public static void main(String[] args) {
        readFile();

    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("/home/wd/int_base_59.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }

            System.out.println("rodou");
        } catch (IOException e) {
            System.out.println("---------------------erro!!!");
            e.printStackTrace();
        }
    }
}
