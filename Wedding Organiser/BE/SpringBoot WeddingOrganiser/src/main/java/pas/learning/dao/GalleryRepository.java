package pas.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pas.learning.entity.Gallery;

@RepositoryRestResource(collectionResourceRel = "galleries", path = "galleries")
public interface GalleryRepository extends JpaRepository<Gallery, Integer>{
}
