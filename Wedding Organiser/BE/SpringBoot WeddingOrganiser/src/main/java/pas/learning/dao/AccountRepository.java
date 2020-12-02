package pas.learning.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pas.learning.entity.Account;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "Accounts", path = "Accounts")
public interface AccountRepository extends JpaRepository<Account,Integer> {

    @Override
    Optional<Account> findById(Integer integer);
}
