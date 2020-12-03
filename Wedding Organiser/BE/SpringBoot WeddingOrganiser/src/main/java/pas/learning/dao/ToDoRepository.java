package pas.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pas.learning.entity.ToDo;

@RepositoryRestResource(collectionResourceRel = "todos", path = "todos")
public interface ToDoRepository extends JpaRepository<ToDo, Integer>{
}
