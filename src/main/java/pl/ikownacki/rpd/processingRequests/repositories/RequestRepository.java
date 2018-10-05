package pl.ikownacki.rpd.processingRequests.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ikownacki.rpd.processingRequests.entities.RequestEntity;

public interface RequestRepository extends JpaRepository<RequestEntity, Long> {
}
