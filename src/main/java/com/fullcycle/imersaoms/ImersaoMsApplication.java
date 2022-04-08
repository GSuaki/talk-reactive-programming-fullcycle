package com.fullcycle.imersaoms;

import com.fullcycle.imersaoms.models.PubSubMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Sinks;

@SpringBootApplication
public class ImersaoMsApplication {

  public static void main(String[] args) {
    SpringApplication.run(ImersaoMsApplication.class, args);
  }

  @Bean
  public Sinks.Many<PubSubMessage> sink() {
    return Sinks.many().multicast()
        .onBackpressureBuffer(1000);
  }
}