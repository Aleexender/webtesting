package com.example.websitetest.company;

import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private final CompanyRepository repository;

    public CompanyService(CompanyRepository companyRepository) {
        this.repository = companyRepository;
    }

    public boolean getAllAbSamSung() {
        repository.getSamsungInfo();
        return true;
    }

}
