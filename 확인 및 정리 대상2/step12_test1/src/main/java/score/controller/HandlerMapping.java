package score.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	// properties 역할을 함.
	private Map<String, Controller> map;
	
	public HandlerMapping() {
		map = new HashMap<String, Controller>();
		map.put("/scoreDelete.do", new ScoreDeleteController());
		map.put("/scoreList.do", new ScoreListController());
		map.put("/scoreView.do", new ScoreViewController());
		map.put("/scoreWrite.do", new ScoreWriteContoller());
		map.put("/scoreWriteForm.do", new ScoreWriteFormController());
	}
	
	public Controller getController(String path) {
		return map.get(path);
	}
	
}
