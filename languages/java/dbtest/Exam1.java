public class Exam1 {
    public static void main(String[] args) {
        try {
            // OracleDriver가 존재하는지 확인
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver Registraion Success");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Registration Failure");
            e.printStackTrace();
        }
    }
}
