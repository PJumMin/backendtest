package co.kr.metacoding.backendtest.winner;

import co.kr.metacoding.backendtest._core.util.Resp;

import co.kr.metacoding.backendtest.lottos.LottosService;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class WinnerController {
    private final WinnerService winnerService;

    @Scheduled(cron = "0 0 0 ? * SUN", zone = "Asia/Seoul")
    @PostMapping("/batch")
    public Resp batch() {
        Winner resp = winnerService.batch();
        return Resp.OK(resp);
    }

    @GetMapping("/winner")
    public List<Winner> findWinner() {
        List<Winner> winnerList = winnerService.findWinner();
        return winnerList;
    }
}
