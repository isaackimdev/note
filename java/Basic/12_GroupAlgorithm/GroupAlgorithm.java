//[?] 컬렉션 형태의 데이터를 특정 키 값으로 그룹화
import java.util.Arrays;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
/*
 * 그룹 알고리즘 (Group Algorithm) : 특정 키 값에 해당하는 그룹화된 집계 리스트 만들기
 * 
 * 원본 > sort > sort원본 >
 */
public class GroupAlgorithm {

    public static class Recode {
        private final String name;  // 상품명
        private final int quantity; // 수량

        public Recode(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }
        public String getName() {
            return name;
        }
        public int getQuantity() {
            return quantity;
        }   
    }

    //[0][1] 테스트용 데이터 채우기용 로컬 함수
    public static List<Recode> getAll() {
        return Arrays.asList(
            new Recode("RADIO", 3),
            new Recode("TV", 1),
            new Recode("RADIO", 2),
            new Recode("DVD", 4)
        );
    }

    // [0][2] 컬렉션 데이터 출력용 로컬 함수
    public static void printData(String message, List<Recode> data) {
        System.out.println(message);
        for (Recode item : data) {
            System.out.println(String.format("%5s - %d", item.getName(), item.getQuantity()));
        }
    }

    public static void main(String[] args) {
        // 1. input
        List<Recode> recodes = getAll();            // 입력 데이터
        List<Recode> groups = new ArrayList<>();    // 출력 데이터
        int N = recodes.size(); // 의사코드

        // 2. process : Group Algorithm( SORT -> SUM -> GROUP )
        
        // [A] 그룹 정렬 : SORT - Selection Sort
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (recodes.get(i).getName().compareTo(recodes.get(j).getName()) > 0) {
                    Recode t = recodes.get(i);
                    recodes.set(i, recodes.get(j));
                    recodes.set(j, t);
                }
            }
        }

        // [B] 그룹 소계 : SUMMARY
        int subtotal = 0;   // 소계
        for (int i = 0; i < N; i++) {
            subtotal += recodes.get(i).getQuantity(); // 같은 상품명의 판매량을 누적(SUM)
            if ((i + 1) == N ||     // 단락 (Short Circuiting)이면 아래 조건 무시
                recodes.get(i).getName() != recodes.get(i+1).getName()) {
                //[!] 다음 레코드가 없거나, 현재 레코드와 다음 레코드가 다르면 저장
                Recode r = new Recode(recodes.get(i).getName(), subtotal);
                groups.add(r);  // 하나의 그룹 저장

                subtotal = 0;   // 하나의 그룹이 완료되면 소계 초기화
            }
        }


        // 3. output
        printData("[1] 정렬된 원본 데이터", recodes);
        printData("[2] 이름으로 그룹화된 데이터", groups);

    }
}
