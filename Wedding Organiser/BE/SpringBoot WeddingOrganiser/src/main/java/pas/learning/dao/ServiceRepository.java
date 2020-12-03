package pas.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pas.learning.entity.Service;

@RepositoryRestResource(collectionResourceRel = "services", path = "services")
public interface ServiceRepository extends JpaRepository<Service, Integer>{
}
