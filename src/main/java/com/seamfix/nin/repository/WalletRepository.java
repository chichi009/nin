package com.seamfix.nin.repository;

import com.seamfix.nin.model.NairaWallet;
import com.seamfix.nin.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Repository
public interface WalletRepository extends JpaRepository<NairaWallet,Long> {
    @Transactional
    @Query("update NairaWallet  u set u.availableAmount=:currentAmount,u.chargeAmount=:chargeAmount where u.users=:id")
    @Modifying
    void updateWallet(@Param( value="id") Users id,@Param(value="currentAmount") BigDecimal currentAmount,@Param(value="chargeAmount") BigDecimal chargeAmount);
    NairaWallet findByWalletRequestId(String walletId);
    NairaWallet findByUsers(Users user);



}
