package co.kr.metacoding.backendtest.users;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UsersController {
    private final UsersService usersService;

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @PostMapping("/users")
    public Integer signup(@RequestBody UsersRequest.SaveDTO reqDTO) {
        Users resp = usersService.signUp(reqDTO);
        return resp.getId();
    }

    @GetMapping("/users/{id}")
    public String UsersDetail(@PathVariable Integer id) {
        return null;
    }
}
