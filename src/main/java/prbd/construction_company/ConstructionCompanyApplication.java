package prbd.construction_company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConstructionCompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConstructionCompanyApplication.class, args);
        System.out.println("http://localhost:8080/");
    }

}
