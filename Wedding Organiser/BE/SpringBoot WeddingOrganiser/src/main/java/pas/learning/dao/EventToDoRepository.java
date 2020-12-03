package pas.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pas.learning.entity.EventToDo;

@RepositoryRestResource(collectionResourceRel = "eventtodos", path = "eventtodos")
public interface EventToDoRepository extends JpaRepository<EventToDo, Integer>{
}
