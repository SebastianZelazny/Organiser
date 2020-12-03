package pas.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pas.learning.entity.Contact;


@RepositoryRestResource(collectionResourceRel = "contacts", path = "contacts")
public interface ContactRepository extends JpaRepository<Contact, Integer>{
}
