package hash;

import java.util.HashMap;

/**
 * 폰켓몬
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/1845">폰켓몬: 문제 페이지</a>
 */
public class _2_Pokemon {
    public int solution(int[] nums) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int limit = nums.length/2;
        int typeCount = map.size();
        if(typeCount < limit){
            answer = typeCount;
        }else{
            answer = limit;
        }

        return answer;
    }
}
