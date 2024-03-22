package score.controller;

public class ViewResolver {
	public String prefix;	//    ./ 현재 폴더를 나타냄
	public String suffix;	//    .jsp
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String viewName) {     // ./scoreWrite.jsp
		return prefix + viewName + suffix;
	}
}
