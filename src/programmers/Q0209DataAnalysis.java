package programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q0209DataAnalysis {

    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80},
                {2, 20300804, 847, 37},
                {3, 20300401, 10, 8}}; // 코드번호, 제조일, 최대수량, 현재수량
        String ext = "date"; // 데이터 뽑을 기준 (code, date, maximum, remain)
        int val_ext = 20300501; // 뽑아낼 정보의 기준값 (보다 적은 값)
        String sort_by = "remain"; // 정렬 기준 (오름차순)

        ArrayList<int[]> answer = new ArrayList<>();
        List<String> column = List.of("code", "date", "maximum", "remain");

        int extIndex = column.indexOf(ext);
        int sortIndex = column.indexOf(sort_by);

        for (int i = 0; i < data.length; i ++) {
            if (data[i][extIndex] < val_ext)
                answer.add(data[i]);  // 이걸 기억하자...
        }

        answer.sort(Comparator.comparing(s -> s[sortIndex]));
        answer.toArray(int[][]::new);
    }

//    public static int searchIndex(String content) {
//        String[] contents = {"code", "date", "maximun", "remain"};
//        int result = -1;
//
//        for (int i = 0; i < contents.length; i ++) {
//            if (content.equals(contents[i]))
//                result = i;
//        }
//
//        return result;
//    }
}