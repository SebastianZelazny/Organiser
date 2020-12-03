package pas.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pas.learning.entity.ServiceAddress;

@RepositoryRestResource(collectionResourceRel = "serviceaddresses", path = "serviceaddresses")
public interface ServiceAddressRepository extends JpaRepository<ServiceAddress, Integer>{
}
