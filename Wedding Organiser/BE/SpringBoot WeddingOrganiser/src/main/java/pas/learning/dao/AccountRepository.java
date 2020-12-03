package pas.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pas.learning.entity.Account;


@RepositoryRestResource(collectionResourceRel = "accounts", path = "accounts")
public interface AccountRepository extends JpaRepository<Account,Integer> {


}