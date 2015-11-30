package com.rv.tour;

import com.rv.tour.service.InternalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SpringBootApplication
public class TourApplication implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(TourApplication.class);

    @Autowired
    private InternalService internalService;

    public static void main(String[] args) {
        SpringApplication.run(TourApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        //Get scanner instance
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./data/User.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        boolean firstLine = true;

        while(scanner.hasNext()) {
            if(firstLine) {
                scanner.nextLine();
                firstLine = false;
            }
            String line = scanner.nextLine();
            String[] fragments = line.split(",");
            internalService.saveUser(fragments[0], fragments[1]);
        }

        try {
            scanner = new Scanner(new File("./data/State.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        firstLine = true;

        while(scanner.hasNext()) {
            if(firstLine) {
                scanner.nextLine();
                firstLine = false;
            }
            String line = scanner.nextLine();
            String[] fragments = line.split(",");
            internalService.saveState(fragments[0], fragments[1]);
        }

        try {
            scanner = new Scanner(new File("./data/City.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        firstLine = true;

        while(scanner.hasNext()) {
            if(firstLine) {
                scanner.nextLine();
                firstLine = false;
            }
            String line = scanner.nextLine();
            String[] fragments = line.split(",");
            internalService.saveCity(fragments[0], Long.parseLong(fragments[1]),
                    Double.parseDouble(fragments[3]), Double.parseDouble(fragments[4]), fragments[2]);
        }

        scanner.close();
    }
}
