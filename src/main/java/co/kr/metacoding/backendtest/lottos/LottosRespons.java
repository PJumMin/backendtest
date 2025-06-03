package co.kr.metacoding.backendtest.lottos;

import lombok.Data;

import java.util.List;

public class LottosRespons {

    @Data
    public static class RandomNumberDTO {
        private List<Integer> numbers;

        public RandomNumberDTO(List<Integer> numbers) {
            this.numbers = numbers;
        }
    }

    @Data
    public static class LottosDTO {
        private List<Lottos> numbers;

        public LottosDTO(List<Lottos> numbers) {
            this.numbers = numbers;
        }
    }
}
