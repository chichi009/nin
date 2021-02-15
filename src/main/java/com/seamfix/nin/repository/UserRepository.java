package com.seamfix.nin.repository;
import com.seamfix.nin.model.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    @Transactional
    @Query("update Users u set u.ninNumber=:ninNumber where u.id=:id ")
    @Modifying
    void updateUserNin(@Param( value="ninNumber")String ninNumber,@Param(value="id")Long id);

    Users findFirstByCustomerName(String customerName);

}
