package com.seamfix.nin.controller;
import com.seamfix.nin.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ResponseDto> exception(final Exception throwable) {
        ResponseDto outResponseDTO=new ResponseDto();
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        outResponseDTO.setErrorDesc(errorMessage);
        outResponseDTO.setResponseStatus("FAILED");
        return new  ResponseEntity<>(outResponseDTO, HttpStatus.BAD_REQUEST);
    }

}
