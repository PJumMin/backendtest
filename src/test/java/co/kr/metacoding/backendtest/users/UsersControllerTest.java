package co.kr.metacoding.backendtest.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
public class UsersControllerTest {
    @Autowired
    private ObjectMapper om;

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    public void setUp() {
        // 테스트 시작 전에 실행할 코드
        System.out.println("setUp");
        Users haha = Users.builder()
                .id(1)
                .name("haha")
                .build();
    }

    @AfterEach
    public void tearDown() { // 끝나고 나서 마무리 함수
        // 테스트 후 정리할 코드
        System.out.println("tearDown");
    }

    @Test
    public void signup() throws Exception {
        // given (가짜데이터)
        UsersRequest.SaveDTO reqDTO = new UsersRequest.SaveDTO();
        reqDTO.setName("haha");

        String requestBody = om.writeValueAsString(reqDTO); // JAVA 오브젝트를 JSON 오브젝트로 바꿈
//        System.out.println(requestBody);

        // when (테스트 실행)
        ResultActions actions = mvc.perform( // Exception으로 미리 알려주는 에러를 잡음
                MockMvcRequestBuilders
                        .post("/users")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );
//
//        // eye (결과 눈으로 검증)
        String responseBody = actions.andReturn().getResponse().getContentAsString();
        System.out.println(responseBody);
//
//        // then (결과 코드로 검증)
        actions.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2));
    }

    @Test
    public void usersDetail() throws Exception {
        Users users = Users.builder()
                .id(1)
                .name("ssar")
                .build();

        ResultActions actions = mvc.perform( // Exception으로 미리 알려주는 에러를 잡음
                MockMvcRequestBuilders
                        .get("/users/{id}", users.getId())
                        .contentType(MediaType.APPLICATION_JSON)
        );
//
//        // eye (결과 눈으로 검증)
        String responseBody = actions.andReturn().getResponse().getContentAsString();
        System.out.println(responseBody);
//
//        // then (결과 코드로 검증)
        actions.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
        actions.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("ssar"));
    }

    @Test
    public void update() throws Exception {
        Long id = 1L;
        UsersRequest.UpdateDTO reqDTO = new UsersRequest.UpdateDTO();
        reqDTO.setName("qwer");

        String requestBody = om.writeValueAsString(reqDTO); // JAVA 오브젝트를 JSON 오브젝트로 바꿈
//        System.out.println(requestBody);


        ResultActions actions = mvc.perform( // Exception으로 미리 알려주는 에러를 잡음
                MockMvcRequestBuilders
                        .put("/users/{id}", id)
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye (결과 눈으로 검증)
        String responseBody = actions.andReturn().getResponse().getContentAsString();
        System.out.println(responseBody);
        
        // then (결과 코드로 검증)
        actions.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
        actions.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("qwer"));

    }

}
