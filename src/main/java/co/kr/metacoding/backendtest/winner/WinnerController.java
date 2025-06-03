package co.kr.metacoding.backendtest.winner;

import co.kr.metacoding.backendtest.lottos.LottosService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class WinnerController {
    private final WinnerService winnerService;
    private final LottosService lottosService;

    @PostMapping("/batch")
    public String batch() {
        winnerService.batch();
        return null;
    }

    @GetMapping("/winner")
    public List<Winner> findWinner() {
        List<Winner> winnerList = winnerService.findWinner();
        return winnerList;
    }
}
