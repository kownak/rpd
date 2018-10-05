package pl.ikownacki.rpd.processingRequests.components.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.ikownacki.rpd.dto.RequestDto;
import pl.ikownacki.rpd.processingRequests.components.interfaces.ProcessRequest;
import pl.ikownacki.rpd.processingRequests.entities.RequestEntity;
import pl.ikownacki.rpd.processingRequests.repositories.RequestRepository;

@Slf4j
@Component
public class DbWriteRequest implements ProcessRequest {

    private final RequestRepository requestRepository;

    @Autowired
    public DbWriteRequest(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public void processRequest(RequestDto requestDto) {
        log.info("DbWriteRequest, saving requestDto in db: " + requestDto);

        RequestEntity requestEntity = RequestEntity.builder()
                .requestType(requestDto.getType())
                .requestValue(requestDto.getValue())
                .build();

        requestRepository.save(requestEntity);

    }
}
