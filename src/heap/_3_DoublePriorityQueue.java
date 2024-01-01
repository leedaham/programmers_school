package heap;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 이중우선순위큐
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42628">이중우선순위큐: 문제 페이지</a>
 */
public class _3_DoublePriorityQueue {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        final String INPUT_CMD = "I";
        final String DELETE_MAX = "D 1";
        final String DELETE_MIN = "D -1";

        ArrayList<Integer> answerList = new ArrayList<>();
        for (var command : operations) {
            if (command.startsWith(INPUT_CMD)) {
                int addValue = Integer.parseInt(command.substring(2, command.length()));
                answerList.add(addValue);
            }else{
                if(!answerList.isEmpty()){
                    if (command.equals(DELETE_MAX)) {
                        answerList.remove(Collections.max(answerList));
                    }else if(command.equals(DELETE_MIN)){
                        answerList.remove(Collections.min(answerList));
                    }
                }
            }
        }

        if (!answerList.isEmpty()) {
            answer[0] = Collections.max(answerList);
            answer[1] = Collections.min(answerList);
        }
        return answer;
    }
}
