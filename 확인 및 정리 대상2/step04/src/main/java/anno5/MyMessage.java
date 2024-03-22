package anno5;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("myMessage")
//@Scope("prototype")
public class MyMessage {
	String message;
	
	public MyMessage() {
		message = "즐겁게 삽시다.";
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
