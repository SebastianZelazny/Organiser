package pas.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pas.learning.entity.FileGuestTag;


@RepositoryRestResource(collectionResourceRel = "fileguesttags", path = "fileguesttags")
public interface FileGuestTagRepository extends JpaRepository<FileGuestTag, Integer>{
}
