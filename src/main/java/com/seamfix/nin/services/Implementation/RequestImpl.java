package com.seamfix.nin.services.Implementation;

import com.seamfix.nin.model.Request;
import com.seamfix.nin.model.RequestStatus;
import com.seamfix.nin.model.Users;
import com.seamfix.nin.repository.RequestRepository;
import com.seamfix.nin.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RequestImpl implements RequestService {
    @Autowired
    RequestRepository requestRepository;

    @Override
    public boolean updateRequest(Users user) {
        Request request=new Request();
        request.setRequestDateAndTime(new Date());
        request.setRequestStatus(RequestStatus.SUCCESSFUL);
        request.setUser(user);
        requestRepository.save(request);
        return true;
    }


}
