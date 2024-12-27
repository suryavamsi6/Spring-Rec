package com.recommendo.springrec.repository;

import com.recommendo.springrec.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    public Account getAccountByUsername(String username);

}
