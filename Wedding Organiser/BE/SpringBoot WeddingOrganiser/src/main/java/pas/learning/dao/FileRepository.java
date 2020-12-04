package pas.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pas.learning.entity.File;

@RepositoryRestResource(collectionResourceRel = "files", path = "files")
public interface FileRepository extends JpaRepository<File, Integer>{
}
