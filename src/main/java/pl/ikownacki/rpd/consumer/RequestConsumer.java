package pl.ikownacki.rpd.consumer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import pl.ikownacki.rpd.dto.RequestDto;
import pl.ikownacki.rpd.enums.RequestType;
import pl.ikownacki.rpd.processingRequests.components.impl.CancelRequest;
import pl.ikownacki.rpd.processingRequests.components.impl.ConsolePrintRequest;
import pl.ikownacki.rpd.processingRequests.components.impl.DbWriteRequest;
import pl.ikownacki.rpd.processingRequests.components.impl.FileWriteRequest;

@Slf4j
@Component
public class RequestConsumer {

    private final CancelRequest cancelRequest;
    private final ConsolePrintRequest consolePrintRequest;
    private final DbWriteRequest dbWriteRequest;
    private final FileWriteRequest fileWriteRequest;

    @Autowired
    public RequestConsumer(CancelRequest cancelRequest, ConsolePrintRequest consolePrintRequest, DbWriteRequest dbWriteRequest, FileWriteRequest fileWriteRequest) {
        this.cancelRequest = cancelRequest;
        this.consolePrintRequest = consolePrintRequest;
        this.dbWriteRequest = dbWriteRequest;
        this.fileWriteRequest = fileWriteRequest;
    }

    @JmsListener(destination = "request_queue")
    public void consume(RequestDto requestDto) {
        log.info("Consumer, revived requestDto: " + requestDto);

        String currentRequestType = requestDto.getType();
        if (currentRequestType.equals(RequestType.TYPE_1.getTypeName())) {
            dbWriteRequest.processRequest(requestDto);

        } else if (currentRequestType.equals(RequestType.TYPE_2.getTypeName())) {
            cancelRequest.processRequest(requestDto);

        } else if (currentRequestType.equals(RequestType.TYPE_3.getTypeName())) {
            fileWriteRequest.processRequest(requestDto);

        } else if (currentRequestType.equals(RequestType.TYPE_4.getTypeName())) {
            consolePrintRequest.processRequest(requestDto);

        } else {
            log.warn("Unsupported requestDto type: " + requestDto);
        }

    }
}
