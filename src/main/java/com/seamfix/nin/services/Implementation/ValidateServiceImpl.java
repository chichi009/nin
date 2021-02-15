package com.seamfix.nin.services.Implementation;
import com.seamfix.nin.model.NairaWallet;
import com.seamfix.nin.model.PhoneNumber;
import com.seamfix.nin.repository.PhoneRepository;
import com.seamfix.nin.repository.UserRepository;
import com.seamfix.nin.repository.WalletRepository;
import com.seamfix.nin.services.RequestService;
import com.seamfix.nin.services.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.regex.Pattern;

@Service
public class ValidateServiceImpl implements ValidateService {

    @Autowired
    WalletRepository walletRepository;
    @Autowired
    PhoneRepository phoneRepository;
    @Autowired
    UserRepository userRepository;
    @Value("${charge.value}")
    private String chargeValue;
    @Autowired
    RequestService requestService;
    private static Pattern p = Pattern.compile("^[a-zA-Z]*$");


    @Override
    public boolean validateInformation(String phoneNumber) {
        return phoneNumber.matches("^[a-zA-Z]*$");
    }



    @Override
    @Transactional
    public boolean transactNinNumber(String phoneNumber, String ninNumber) {
        PhoneNumber retreiveNumber=phoneRepository.findByPhoneNumber(phoneNumber);
        if(retreiveNumber==null){
            throw new RuntimeException("Phone Number Does not Exist");
        }
        if(retreiveNumber.getNinLinkingStatus().equalsIgnoreCase("Y")){
            throw new RuntimeException("Phone Number Has Successfully Been Linked");
        }
        NairaWallet wallet= walletRepository.findByUsers(retreiveNumber.getUser());
        synchronized (this) {
            int value = wallet.getAvailableAmount().compareTo(new BigDecimal(chargeValue));
            if (value == -1) {
                throw new RuntimeException("Account Balance is inSufficient");
            }
        else {
                BigDecimal currentAmount=wallet.getAvailableAmount().subtract(new BigDecimal(chargeValue));
                updateTransaction(retreiveNumber, ninNumber,currentAmount);
            }
        }
        boolean requestValue=requestService.updateRequest(retreiveNumber.getUser());

        return requestValue;
    }



    public void updateTransaction(PhoneNumber phoneNumber,String ninNumber,BigDecimal currentAmount) {
            walletRepository.updateWallet(phoneNumber.getUser(),currentAmount,new BigDecimal(chargeValue));
            phoneRepository.updateUserNin(phoneNumber.getPhoneNumber(),"Y");
            userRepository.updateUserNin(ninNumber,phoneNumber.getUser().getId());
        }
    }




