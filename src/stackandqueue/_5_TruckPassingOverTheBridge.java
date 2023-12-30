package stackandqueue;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 다리를 지나는 트럭
 * @see <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42583">다리를 지나는 트럭: 문제 페이지</a>
 */
public class _5_TruckPassingOverTheBridge {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        //순서대로 출발할 트럭 list 생성
        LinkedList<Integer> trucks = Arrays.stream(truck_weights).boxed().collect(Collectors.toCollection(LinkedList::new));

        //다리 생성
        Bridge bridge = new Bridge(bridge_length, weight);

        int time = 0;

        while (!trucks.isEmpty()) {
            //다리에 있는 트럭 한칸씩 움직임
            time += 1;
            bridge.moveTrucks();

            //다리에 새로운 트럭 올라갈 수 있는지 확인
            int waitingTruck = trucks.pop();
            boolean isPossibleAddTruck = bridge.isPossibleAddTruck(waitingTruck);

            //올라갈 수 있다면 트럭 진입
            if (isPossibleAddTruck) {
                bridge.getOnBridge(waitingTruck);
            }else{
                trucks.push(waitingTruck);
            }
        }

        answer = time + bridge_length;

        return answer;
    }
    public class Bridge {
        private int bridge_length;
        private int weight;
        private Map<Integer, Integer> bridgeStatus;

        Bridge(int bridge_length, int weight) {
            this.bridge_length = bridge_length;
            this.weight = weight;
            bridgeStatus = new HashMap<>();
        }

        void setBridgeStatus(Map<Integer, Integer> bridgeStatus) {
            this.bridgeStatus = bridgeStatus;
        }

        Map<Integer, Integer> getBridgeStatus() {
            return bridgeStatus;
        }

        int moveTrucks(){
            int finishedTrucks = 0;

            //트럭이 다리에 없다면 넘어감
            if(bridgeStatus.size() != 0){
                //트럭 위치들 내림차숨으로 정렬
                List<Integer> trucksLocation = new ArrayList<>(bridgeStatus.keySet());
                trucksLocation = trucksLocation.stream().filter(i -> i != 0).sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(ArrayList::new));

                //트럭들을 한칸씩 옮김
                for (Object truck : trucksLocation) {
                    int truck_location = (int) truck;
                    int truck_weight = bridgeStatus.get(truck);
                    bridgeStatus.remove(truck);

                    if(truck_location == bridge_length){
                        finishedTrucks =+ 1;
                    }else{
                        bridgeStatus.put(truck_location+1, truck_weight);
                    }
                }
            }

            return finishedTrucks;
        }

        boolean isPossibleAddTruck(int waitingTruck){
            boolean isPossibleAddTruck = false;

            Collection<Integer> allTrucks = bridgeStatus.values();
            int allTrucksWeight = allTrucks.stream().reduce(0, Integer::sum);
            if (weight >= allTrucksWeight + waitingTruck) {
                isPossibleAddTruck = true;
            }

            return  isPossibleAddTruck;
        }

        void getOnBridge(int waitingTruck) {
            bridgeStatus.put(1, waitingTruck);
        }

    }
}
