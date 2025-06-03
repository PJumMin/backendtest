package co.kr.metacoding.backendtest.lottos;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LottosController {
    private final LottosService lottosService;

    @PostMapping("/lottos")
    public LottosRespons.RandomNumberDTO addNumber() {
        return lottosService.addNumber();
//        LottosRespons.RandomNumberDTO resp = lottosService.addNumber();
//        return Resp.OK(resp);
    }
}
