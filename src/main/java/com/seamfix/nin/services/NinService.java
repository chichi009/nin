package com.seamfix.nin.services;

import com.seamfix.nin.dto.RequestDto;
import com.seamfix.nin.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface NinService {

    ResponseDto saveNinNumber(RequestDto requestDto);

}
