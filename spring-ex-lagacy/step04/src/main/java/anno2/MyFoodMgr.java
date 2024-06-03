package anno2;

public class MyFoodMgr {
	private Food favoriteFood;
	private Food unFavoriteFood;
	
	@Override
	public String toString() {
		return "[좋아하는 음식=" + favoriteFood 
	        + "\n싫어하는 음식=" + unFavoriteFood + "]";
	}
	public Food getFavoriteFood() {
		return favoriteFood;
	}
	public void setFavoriteFood(Food favoriteFood) {
		this.favoriteFood = favoriteFood;
	}
	public Food getUnFavoriteFood() {
		return unFavoriteFood;
	}
	public void setUnFavoriteFood(Food unFavoriteFood) {
		this.unFavoriteFood = unFavoriteFood;
	}
	
}
