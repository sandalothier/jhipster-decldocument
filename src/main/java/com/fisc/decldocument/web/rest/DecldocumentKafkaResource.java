package com.fisc.decldocument.web.rest;

import com.fisc.decldocument.service.DecldocumentKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/decldocument-kafka")
public class DecldocumentKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DecldocumentKafkaResource.class);

    private DecldocumentKafkaProducer kafkaProducer;

    public DecldocumentKafkaResource(DecldocumentKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
