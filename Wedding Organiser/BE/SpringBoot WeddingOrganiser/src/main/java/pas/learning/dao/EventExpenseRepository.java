package pas.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pas.learning.entity.EventExpense;


@RepositoryRestResource(collectionResourceRel = "eventexpenses", path = "eventexpenses")
public interface EventExpenseRepository extends JpaRepository<EventExpense,Integer>{
}
