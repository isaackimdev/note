package languages.java.npe;

public class NPE1 {
    public static void main(String[] args) {
        User[] users = new User[2];
        users[0].name = "isaac"; // error
    }    
}

class User {
    String name;
}