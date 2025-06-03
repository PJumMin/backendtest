package co.kr.metacoding.backendtest.lottos;

import co.kr.metacoding.backendtest._core.util.Resp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LottosController {
    private final LottosService lottosService;

    @PostMapping("/lottos")
    public Resp addNumber() {
        LottosRespons.RandomNumberDTO resp = lottosService.addNumber();
        return Resp.OK(resp);
    }

    @GetMapping("/lottos")
    public Resp findNumber() {
        LottosRespons.LottosDTO resp = lottosService.findNumber();
        return Resp.OK(resp);
    }
}
