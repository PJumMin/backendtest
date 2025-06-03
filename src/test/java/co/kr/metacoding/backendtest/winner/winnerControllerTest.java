package co.kr.metacoding.backendtest.winner;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class winnerControllerTest {
    @Autowired
    private ObjectMapper om;

    @Autowired
    private MockMvc mvc;


    @Test
    public void signup() throws Exception {
        // when (테스트 실행)
        ResultActions actions = mvc.perform( // Exception으로 미리 알려주는 에러를 잡음
                MockMvcRequestBuilders
                        .post("/batch")
                        .contentType(MediaType.APPLICATION_JSON)
        );
//
//        // eye (결과 눈으로 검증)
        String responseBody = actions.andReturn().getResponse().getContentAsString();
        System.out.println(responseBody);
//
        // then (결과 코드로 검증)
        actions.andExpect(MockMvcResultMatchers.jsonPath("$.status").value(200));
        actions.andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("OK"));
        actions.andExpect(MockMvcResultMatchers.jsonPath("$.body.id").value(1));
        actions.andExpect(MockMvcResultMatchers.jsonPath("$.body.rank", anyOf(
                is("1등"),
                is("2등"),
                is("3등"),
                is("4등"),
                is("5등"),
                is("꽝")
        )));
        actions.andExpect(MockMvcResultMatchers.jsonPath("$.body.lottos.id").isNumber());
        actions.andExpect(MockMvcResultMatchers.jsonPath("$.body.lottos.numbers").value(Matchers.matchesRegex("^\\[(\\d+,\\s*){5}\\d+\\]$")));
    }

    @Test
    public void findWinner() throws Exception {
//
//        ResultActions actions = mvc.perform( // Exception으로 미리 알려주는 에러를 잡음
//                MockMvcRequestBuilders
//                        .get("/winner")
//                        .contentType(MediaType.APPLICATION_JSON)
//        );
//
//        // eye (결과 눈으로 검증)
//        String responseBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println(responseBody);
//////
//////        // then (결과 코드로 검증)
//        actions.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
//        actions.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("ssar"));
    }


}
