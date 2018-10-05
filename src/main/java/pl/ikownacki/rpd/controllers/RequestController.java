package pl.ikownacki.rpd.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ikownacki.rpd.dto.RequestDto;

import javax.jms.Queue;

@Slf4j
@RestController
@RequestMapping("/request")
public class RequestController {

    private final Queue queue;

    private final JmsTemplate jmsTemplate;


    @Autowired
    public RequestController(Queue queue, JmsTemplate jmsTemplate) {
        this.queue = queue;
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping
    public ResponseEntity retrieveRequest(@RequestBody RequestDto requestDto) {
        log.info("RequestController, incoming requestDto: " + requestDto);

        jmsTemplate.convertAndSend(queue, requestDto);
        return ResponseEntity.accepted().build();
    }

}
