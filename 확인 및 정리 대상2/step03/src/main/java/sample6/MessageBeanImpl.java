package sample6;

import java.io.IOException;

public class MessageBeanImpl implements MessageBean {
	private String name;
	private String phone;
	private Outputter outputter;
	// 생성자로 name을 받음
	public MessageBeanImpl(String name) {
		this.name = name;
		System.out.println("1. Bean의 생성자 호출");
	}
	// setter를 통해서 phone와 outputter를 입력받음
	public void setPhone(String phone) {
		this.phone = phone;
		System.out.println("3. phone을 입력받음");
	}


	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
		System.out.println("4. outputter를 입력받음");
	}

	
	@Override
	public void helloCall() {
		String message = name + " : " + phone;
		System.out.println(message);
		try {
			outputter.output(message);
			System.out.println("6. 작업끝");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}
