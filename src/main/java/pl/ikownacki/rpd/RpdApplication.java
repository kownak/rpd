package pl.ikownacki.rpd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@ComponentScan("pl.ikownacki.rpd")
@EntityScan("pl.ikownacki.rpd.processingRequests")
@SpringBootApplication
public class RpdApplication {

    public static void main(String[] args) {

        SpringApplication.run(RpdApplication.class, args);
        log.info("Request Processing Demo started");
    }
}
