package programmers;

public class Q0207FlexibleWorkSystem {

    public static void main(String[] args) {

        int[] schedules = {700, 800, 1100};
        int[][] timelogs = {{710, 2359, 1050, 700, 650, 631, 659},
                {800, 801, 805, 800, 759, 810, 809},
                {1105, 1001, 1002, 600, 1059, 1001, 1100}
                };
        int startday = 5;

        int answer = 0;

        for (int people = 0; people < schedules.length; people ++) {
            int today = startday;
            boolean success = true;

            int startTime = schedules[people] + 10;
            if (startTime % 100 >= 60) {
                int startHour = startTime / 100 + 1;
                int startMin = startTime % 100 - 60;
                startTime = startHour * 100 + startMin;
            }

            for (int day = 0; day < 7; day++) {
                if (today % 7 == 6 || today % 7 == 0) {
                    today ++;
                    continue;
                }
                if (timelogs[people][day] > startTime) {
                    success = false;
                    break;
                }
                today ++;
            }

            if (success) answer++;
        }

        System.out.println(answer);
    }
}
