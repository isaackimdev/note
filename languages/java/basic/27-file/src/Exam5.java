import java.util.ArrayList;
import java.util.List;

public class Exam5 {

	public static void main(String[] args) {
		ObjectInOut objectInOut = new ObjectInOut();
		List<Student> list = new ArrayList<Student>();
		
		list.add(new Student("È«±æµ¿", 17, "¼ö¿ø"));
		list.add(new Student("°í±æµ¿", 27, "ÀåÈï"));
		list.add(new Student("±èÃ¶¼ö", 20, "¿ï»ê"));
		list.add(new Student("ÀÌ¿µÈñ", 19, "»ïÃ´"));
		
		objectInOut.write("student.txt", list);
		System.out.println("-------------------------------");
		objectInOut.read("student.txt");
		
	}

}





