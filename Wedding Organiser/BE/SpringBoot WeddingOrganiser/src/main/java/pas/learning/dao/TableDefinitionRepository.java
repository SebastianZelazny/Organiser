package pas.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pas.learning.entity.TableDefinition;

@RepositoryRestResource(collectionResourceRel = "tabledefinitions", path = "tabledefinitions")
public interface TableDefinitionRepository extends JpaRepository<TableDefinition,Integer> {
}
