package pas.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pas.learning.entity.FileTag;

@RepositoryRestResource(collectionResourceRel = "filetags", path = "filetags")
public interface FileTagRepository extends JpaRepository<FileTag, Integer>{
}
