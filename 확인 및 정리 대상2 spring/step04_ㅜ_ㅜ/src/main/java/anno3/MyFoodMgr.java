package anno3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// <bean id="myFood" class="anno3.MyFoodMgr" /> 와 동일, 자동 등록
@Component("myFood")
public class MyFoodMgr {
	/* test1 */
	/*
	@Autowired	// 자동적으로, 내부적으로 [ 생성자와 getter / setter] 를 만든다. -> 생성자 겟셋 삭제
	@Qualifier(value="favoriteFood1")
	private Food favoriteFood;
	@Autowired   // [코드가 매우 간편해짐]
	@Qualifier(value="unFavoriteFood1")
	private Food unFavoriteFood;
	*/
	
	/* test */
	@Autowired
	@Qualifier(value="unFavoriteFood1")
	private Food favoriteFood;
	@Resource(name="unFavoriteFood1")
	private Food unFavoriteFood;
	
	@Override
	public String toString() {
		return "[좋아하는 음식=" + favoriteFood + 
			 "\n싫어하는 음식=" + unFavoriteFood + "]";
	}
	
}
