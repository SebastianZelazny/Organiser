package pas.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pas.learning.entity.GalleryAccess;

@RepositoryRestResource(collectionResourceRel = "galleryaccesses", path = "galleryaccesses")
public interface GalleryAccessRepository extends JpaRepository<GalleryAccess,Integer> {
}
