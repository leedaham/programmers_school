package stackandqueue;

/**
 * 올바른 괄호
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12909">올바른 괄호: 문제 페이지</a>
 */
public class _3_CorrectParentheses {
    boolean solution(String s) {
        boolean answer = true;

        //첫번째 필터
        answer = s.length() % 2 == 0;
        if(answer){
            answer = s.startsWith("(") && s.endsWith(")");
        }
        //두번째 필터
        char[] arr = s.toCharArray();
        if (answer) {
            int sum = 0;
            for(var a : arr){
                sum += a;
            }
            answer = sum % ('('+')') == 0;
        }

        //
        int count = 0;
        if(answer){
            for(int i=0; i <arr.length; i++){
                if(count == 0 && arr[i] != '('){
                    answer = false;
                    break;
                }
                if(arr[i] == '('){
                    count+=1;
                }else{
                    count-=1;
                }

                if(count < 0){
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}
