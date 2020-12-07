package pas.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pas.learning.entity.GuestTable;

@RepositoryRestResource(collectionResourceRel = "guesttables", path = "guesttables")
public interface GuestTableRepository extends JpaRepository<GuestTable,Integer> {
}
