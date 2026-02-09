package programmers;

public class Q0209NeighboringBoard {

    public static void main(String[] args) {
        String[][] board = {{"yellow", "green", "blue"},
                {"blue", "green", "yellow"},
                {"yellow", "blue", "blue"}}; // 색깔 이름 저장된 2차원 리스트, 정사각형
        int h = 0; // 행
        int w = 1; // 열
        int answer = 0;

        // board[h][w] 색깔과 상하좌우를 비교하여 같은 색깔인 칸을 출력
        int[] dh = {0, -1, 1, 0};
        int[] dw = {-1, 0, 0, 1};

        for (int i = 0; i < 4; i ++) {
            int row = h + dh[i];
            int column = w + dw[i];

            if (row < 0 || row >= board.length || column < 0 || column >= board.length)
                continue;

            if (board[h][w].equals(board[row][column]))
                answer ++;
        }

        System.out.println(answer);
    }
}
