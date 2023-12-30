package hash;

import java.util.HashMap;

/**
 * 완주하지 못한 선수
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42576">완주하지 못한 선수: 문제 페이지</a>
 */
public class _1_RunnerWhoFailedToFinish {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();
        for(String player : participant) map.put(player, map.getOrDefault(player, 0)+1);
        for(String player : completion)  map.put(player, map.get(player)-1);

        for(String key : map.keySet()){
            if(map.get(key) != 0){
                answer = key;
            }
        }

        return answer;
    }
}
