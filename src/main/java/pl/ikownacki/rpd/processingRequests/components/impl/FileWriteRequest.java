package pl.ikownacki.rpd.processingRequests.components.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.ikownacki.rpd.dto.RequestDto;
import pl.ikownacki.rpd.processingRequests.components.interfaces.ProcessRequest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Slf4j
@Component
public class FileWriteRequest implements ProcessRequest {

    @Value("${file-write-request.path}")
    String path;

    @Override
    public void processRequest(RequestDto requestDto) {
        log.info("FileWriteRequest, writing requestDto to file: " + requestDto);

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path),StandardOpenOption.APPEND)) {
            writer.append(requestDto.toString());
            writer.append('\n');

        } catch (IOException e) {
            log.warn("FileWriteRequest, writing error " + e.getMessage());
            e.printStackTrace();

        }

    }
}
