package anno3;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//<bean id="myFood" class="anno3.MyFoodMgr" /> 와 동일, 자동 등록
@Component("myFood")	
public class MyFoodMgr {
	/* test1 */
	/*
	@Autowired
	@Qualifier(value="favoriteFood1")
	private Food favoriteFood;
	@Autowired
	@Qualifier(value="unFavoriteFood1")
	private Food unFavoriteFood;
	*/
	
	/* test2 */
	@Autowired
	@Qualifier(value="unFavoriteFood1")
	private Food favoriteFood;
	@Resource(name="unFavoriteFood1")
	private Food unFavoriteFood;
	
	@Override
	public String toString() {
		return "[좋아하는 음식=" + favoriteFood 
	        + "\n싫어하는 음식=" + unFavoriteFood + "]";
	}	
}










