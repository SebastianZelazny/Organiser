package pas.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pas.learning.entity.Budget;


@RepositoryRestResource(collectionResourceRel = "budgets", path = "budgets")
public interface BudgetRepository extends JpaRepository<Budget,Integer>{
}
