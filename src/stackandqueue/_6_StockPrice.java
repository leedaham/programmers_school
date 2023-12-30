package stackandqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * 주식 가격
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42584">주식 가격: 문제 페이지</a>
 */
public class _6_StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        LinkedList<Integer> list = Arrays.stream(prices).boxed().collect(Collectors.toCollection(LinkedList::new));

        int order = 0;
        while (!list.isEmpty()){
            int seconds = 0;
            int currentPrice = list.pop();
            for (int comparePrice : list) {
                seconds += 1;
                if(currentPrice > comparePrice){
                    break;
                }
            }
            answer[order] = seconds;
            order += 1;
        }
        return answer;
    }
}
