package com.xiangzi.accountservice.repository;

import com.xiangzi.accountservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Long> {

    Account findByUserId(String userId);
}
