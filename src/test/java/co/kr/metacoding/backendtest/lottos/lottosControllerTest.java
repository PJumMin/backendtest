package co.kr.metacoding.backendtest.lottos;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class lottosControllerTest {

    @Autowired
    private ObjectMapper om;

    @Autowired
    private MockMvc mvc;

    @Test
    public void addNumber() throws Exception {
        // given (가짜데이터)

        // when (테스트 실행)
        ResultActions actions = mvc.perform( // Exception으로 미리 알려주는 에러를 잡음
                MockMvcRequestBuilders
                        .post("/lottos")
                        .contentType(MediaType.APPLICATION_JSON)
        );
        // eye (결과 눈으로 검증)
        String responseBody = actions.andReturn().getResponse().getContentAsString();
        System.out.println(responseBody);


        // then (결과 코드로 검증)
        actions.andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200));
        actions.andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("OK"));
        actions.andExpect(MockMvcResultMatchers.jsonPath("$.body.numbers.length()").value(6));
    }

    @Test
    public void findNumber() throws Exception {
        // given (가짜데이터)

        // when (테스트 실행)
        ResultActions actions = mvc.perform( // Exception으로 미리 알려주는 에러를 잡음
                MockMvcRequestBuilders
                        .get("/lottos")
                        .contentType(MediaType.APPLICATION_JSON)
        );
//
//        // eye (결과 눈으로 검증)
        String responseBody = actions.andReturn().getResponse().getContentAsString();
        System.out.println(responseBody);
//
//        // then (결과 코드로 검증)
        actions.andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200));
        actions.andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("OK"));
        actions.andExpect(MockMvcResultMatchers.jsonPath("$.body.numbers[0].id").value(1));
        actions.andExpect(MockMvcResultMatchers.jsonPath("$.body.numbers[0].numbers").value("[3, 7, 12, 18, 33, 42]"));
    }

}
