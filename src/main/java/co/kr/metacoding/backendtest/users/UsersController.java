package co.kr.metacoding.backendtest.users;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UsersController {
    private final UsersService usersService;

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @PostMapping("/users")
    public Map<String, Object> signup(@RequestBody UsersRequest.SaveDTO reqDTO) {
        Users resp = usersService.signUp(reqDTO);
        return Map.of("id", resp.getId());

//        Resp Util을 사용하여 status, msg, body 데이터가 보이는 코드
//        Users resp = usersService.signUp(reqDTO);
//        return Resp.Ok(resp);
    }

    @GetMapping("/users/{id}")
    public Users UsersDetail(@PathVariable Integer id) {
        return usersService.detail(id);

//        Resp Util을 사용하여 status, msg, body 데이터가 보이는 코드
//        Users resp = usersService.detail(id);
//        return Resp.OK(resp);
    }

    @PutMapping("/users/{id}")
    public Users update(@PathVariable Integer id, @RequestBody UsersRequest.UpdateDTO reqDTO) {
        return usersService.update(id, reqDTO);

//        Resp Util을 사용하여 status, msg, body 데이터가 보이는 코드
//        Users resp = usersService.update(id, reqDTO);
//        return Resp.OK(resp);

    }
}
