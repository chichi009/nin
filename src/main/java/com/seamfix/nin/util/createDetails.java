package com.seamfix.nin.util;
import com.seamfix.nin.model.NairaWallet;
import com.seamfix.nin.model.PhoneNumber;
import com.seamfix.nin.model.Users;
import com.seamfix.nin.repository.PhoneRepository;
import com.seamfix.nin.repository.UserRepository;
import com.seamfix.nin.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
public class createDetails {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PhoneRepository phoneRepository;
    @Autowired
    WalletRepository walletRepository;

    @PostConstruct
    public void createUser(){
        Users users=new Users();
        if(userRepository.findFirstByCustomerName("Chukelu Chioma Rosemary")==null){
            users.setCustomerName("Chukelu Chioma Rosemary");
            userRepository.save(users);
        }
    }
    @PostConstruct
    public void  createPhoneNumber(){
        PhoneNumber oldPhoneNumber= phoneRepository.findByPhoneNumber("08033242886");
        Users users= userRepository.findFirstByCustomerName("Chukelu Chioma Rosemary");
        if(oldPhoneNumber==null){
            PhoneNumber phoneNumber=new PhoneNumber();
            phoneNumber.setPhoneNumber("08033242886");
            phoneNumber.setUser(users);
            phoneRepository.save(phoneNumber);
        }

    }

    @PostConstruct
    public void createWallet(){
        NairaWallet wallet=new NairaWallet();
        Users users= userRepository.findFirstByCustomerName("Chukelu Chioma Rosemary");
        if(walletRepository.findByWalletRequestId("124")==null){
            wallet.setAvailableAmount(new BigDecimal("290000"));
            wallet.setUsers(users);
            wallet.setWalletRequestId("124");
            walletRepository.save(wallet);
        }
    }





}
