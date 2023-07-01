package hash;

import java.util.HashMap;

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
