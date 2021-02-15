package com.seamfix.nin.repository;

import com.seamfix.nin.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PhoneRepository extends JpaRepository<PhoneNumber,Long> {

    PhoneNumber findByPhoneNumber(String phoneNumber);

    @Transactional
    @Query("update PhoneNumber  u set u.ninLinkingStatus=:status where u.phoneNumber=:phoneNumber")
    @Modifying
    void updateUserNin(@Param( value="phoneNumber")String phoneNumber,@Param(value="status") String status);

}

