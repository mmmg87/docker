package com.example.docker.controller;

import com.example.docker.service.WebAppService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.example.docker.controller.WebAppControllerTest.TestData.testInfo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(WebAppController.class)
class WebAppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WebAppService service;

    @Test
    void whenGetTest_thenMessageIsRetrieved() throws Exception {
        given(service.getInfoTest()).willReturn(testInfo);

        mockMvc.perform(get("/service/test"))
                .andExpect(status().isOk())
                .andExpect(content().string(testInfo));
    }

    @Test
    void whenGetNonDefinedURL_thenErrorMessageIsRetrieved() throws Exception {

        mockMvc.perform(get("/non-defined"))
                .andExpect(status().isNotFound());
    }

    interface TestData {
        String testInfo = "test-info";
    }
}
