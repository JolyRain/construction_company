package prbd.construction_company;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
public class ConstructionCompanyApplication {

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication.run(ConstructionCompanyApplication.class, args);
        log.info("ip: {}", InetAddress.getLocalHost());
    }

}
