package programmers;

import java.util.ArrayList;

public class Q0210SumQueue {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] queue1 = {1, 2, 1, 2};
        int[] queue2 = {1, 10, 1, 2};

        int solution = sol.solution(queue1, queue2);
        System.out.println(solution);
    }
}

// 24번 case만 timeout
class Solution {

    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;

        ArrayList<Integer> listQueue1 = new ArrayList<>();
        ArrayList<Integer> listQueue2 = new ArrayList<>();
        long sum = 0;
        long queue1Sum = 0;
        long queue2Sum = 0;
        int count = 0;
        int maxLength = (queue1.length + queue2.length) * 3 - 3;  // 왜 ????

        for (int num : queue1) {
            listQueue1.add(num);
            sum += num;
            queue1Sum += num;
        }

        for (int num : queue2) {
            listQueue2.add(num);
            sum += num;
            queue2Sum += num;
        }

        if (sum % 2 != 0) {
            answer = -1;
            return answer;
        }
        else if (sum / 2 == queue1Sum) {
            answer = 0;
            return answer;
        }

        while (count < maxLength) {
            if (queue1Sum == sum / 2) {
                break;
            }
            else if (queue1Sum > queue2Sum) {
                int num = listQueue1.get(0);
                listQueue1.remove(0);
                //listQueue2.addLast(num);
                listQueue2.add(listQueue2.size(), num);
                queue1Sum -= num;
                queue2Sum += num;
                count ++;
            }
            else {
                int num = listQueue2.getFirst();
                listQueue2.removeFirst();
                //listQueue1.addLast(num);
                listQueue1.add(listQueue1.size(), num);
                queue1Sum += num;
                queue2Sum -= num;
                count ++;
            }
        }

        if (count == maxLength) {
            answer = -1;
        } else {
            answer = count;
        }

        return answer;
    }
}
