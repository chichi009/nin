package com.seamfix.nin.services.Implementation;

import com.seamfix.nin.dto.RequestDto;
import com.seamfix.nin.dto.ResponseDto;
import com.seamfix.nin.repository.UserRepository;
import com.seamfix.nin.repository.WalletRepository;
import com.seamfix.nin.services.NinService;
import com.seamfix.nin.services.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NinServiceImpl implements NinService {
    @Autowired
    ValidateService validateService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    WalletRepository walletRepository;

    @Override
    public ResponseDto saveNinNumber(RequestDto requestDto) {
        try{

            boolean result=validateService.validateInformation(requestDto.getPhoneNumber());
             if(result){
                 System.out.println("Phone Number is Invalid");
                 throw  new RuntimeException("Phone Number is Invalid");
            }
           boolean ninTransac=validateService.transactNinNumber(requestDto.getPhoneNumber(),requestDto.getNinNumber());
             if(ninTransac){
                 ResponseDto outResponseDTO=new ResponseDto();
                 outResponseDTO.setResponseMessage("Successfully Linked And A Charges Has Been Taken");
                 outResponseDTO.setResponseStatus("SUCCESS");
                 return outResponseDTO;
             }

           }
        catch (Exception e){
                throw new RuntimeException(e.getMessage());
        }

        return null;
    }
}
