package co.kr.metacoding.backendtest.winner;

public class WinnerRequest {

    public static class SaveDTO {
        public Long id;
        public String rank;


        public SaveDTO(Long id, String rank) {
            this.id = id;
            this.rank = rank;
        }

        public Winner toEntity() {
            return Winner.builder()
                    .id(id)
                    .rank(rank)
                    .build();
        }
    }
}
