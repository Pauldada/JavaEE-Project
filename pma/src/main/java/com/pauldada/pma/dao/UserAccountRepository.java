package com.pauldada.pma.dao;

import com.pauldada.pma.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount,Long> {

}
