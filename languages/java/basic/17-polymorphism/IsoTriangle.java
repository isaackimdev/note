
public class IsoTriangle extends DrawData{// 출력문자로 도형그리기
	@Override
	void draw(){ 
		for (int x=1; x<=getHeight() ; x++) { // 별 출력
			for (int y=1; y<=x; y++) {
			System.out.println(getOutchar());
			}
		}
		System.out.println();
	} 
}
