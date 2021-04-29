package com.example.docker.service;

import org.springframework.stereotype.Service;

@Service
public class WebAppService {

    private final String TEST_INFO = "This is a test";

    public String getInfoTest() {
        return TEST_INFO;
    }
}
