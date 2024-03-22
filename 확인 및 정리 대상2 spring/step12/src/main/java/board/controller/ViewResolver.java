package board.controller;
// View의 경로 완성 
public class ViewResolver {
	public String prefix;	// 접두사
	public String suffix;	// 접미사
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}
	// 굳이 안써도 됨, 경로 완성..	

}
