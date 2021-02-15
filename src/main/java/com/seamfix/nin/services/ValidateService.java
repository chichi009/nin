package com.seamfix.nin.services;

public interface ValidateService {
    boolean validateInformation(String phoneNumber);
    boolean transactNinNumber(String phoneNumber, String ninNumber);
}
