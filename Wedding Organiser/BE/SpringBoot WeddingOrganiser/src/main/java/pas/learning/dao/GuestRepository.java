package pas.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pas.learning.entity.Guest;


@RepositoryRestResource(collectionResourceRel = "guests", path = "guests")
public interface GuestRepository extends JpaRepository<Guest, Integer>{
}
