package score.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	private Map<String, Controller> map;
	
	public HandlerMapping() {
		map = new HashMap<String, Controller>();
		map.put("/scoreWriteForm.do", new ScoreWriteFormController());
		map.put("/scoreWrite.do", new ScoreWriteController());
		map.put("/scoreList.do", new ScoreListController());
		map.put("/scoreView.do", new ScoreViewController());
		map.put("/scoreDelete.do", new ScoreDeleteController());
	}
	
	public Controller getController(String path) {	// 부모껄 보내 줌
		return map.get(path);
	}
	
}
