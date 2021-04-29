package com.example.docker.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.docker.service.WebAppServiceTest.TestData.expectedTestInfo;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class WebAppServiceTest {

    @InjectMocks
    private WebAppService service;

    @Test
    void whenGetInfoTest_thenInfoIsRetrieved() {
        assertThat(service.getInfoTest()).isEqualTo(expectedTestInfo);
    }

    interface TestData {
        String expectedTestInfo = "This is a test";
    }
}