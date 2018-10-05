package pl.ikownacki.rpd.processingRequests.components.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.ikownacki.rpd.dto.RequestDto;
import pl.ikownacki.rpd.processingRequests.components.interfaces.ProcessRequest;

@Slf4j
@Component
public class CancelRequest implements ProcessRequest {

    @Override
    public void processRequest(RequestDto requestDto) {
        log.info("CancelRequest, canceling requestDto: " + requestDto);
    }
}
