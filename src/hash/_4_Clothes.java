package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _4_Clothes {

    public static void main(String[] args) {
        String[][] test = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}, {"green_hand", "handgear"}, {"red_sunglasses", "headgear"}};
        solution(test);
    }
    public static int solution(String[][] clothes) {
        int answer = 0;

        //clothes[0][0]: 이름
        //clothes[0][1]: 종류

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i < clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        int size = map.size();
        System.out.println("size = " + size);

        List<Integer> list = new ArrayList<>();
        for(String key : map.keySet()){
            System.out.println("key = " + key + " / "+map.get(key));
            list.add(map.get(key));
        }

        int[] arr = list.stream().mapToInt(i -> i).toArray();
        int n = arr.length;
        boolean[] visited = new boolean[n];

        for(int i=1; i<=n; i++){
            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
            int result = combination(arr, visited, 0, n, i);
            answer = answer + result;
        }
        System.out.println("answer = " + answer);

        return answer;
    }

    static int combination(int[] arr, boolean[] visited, int start, int n, int r) {
        int answer=0;
        int result=0;
        if (r == 0) {
            answer = print(arr, visited, n);
            return answer;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            result = combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
        answer = answer +result;
        return answer;
    }

    // 배열 출력
    static int print(int[] arr, boolean[] visited, int n) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                if(answer != 0){
                    answer = answer * arr[i];
                }else{
                    answer = arr[i];
                }
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
        System.out.print("answer: "+answer);
        System.out.println();
        return answer;
    }
}
