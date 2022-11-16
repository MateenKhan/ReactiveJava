package org.example.nonreactive.kafka;

import org.example.nonreactive.pojo.PostRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
public class KakfaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KakfaProducer.class);


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(PostRequest postRequest){
        LOGGER.info(String.format("Message sent -> %s", postRequest.getMessage()));
        kafkaTemplate.send(postRequest.getTopic(), postRequest.getMessage());
    }

    @PostMapping("/produce")
    public String produce(@RequestBody PostRequest postRequest){
        sendMessage(postRequest);
        return "success";
    }

    @GetMapping
    public String test(){
        return "test";
    }
}
