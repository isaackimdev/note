import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[][] chars=new char[5][15];
        String rs="";
        for(int i=0;i<5;i++)chars[i]=sc.next().toCharArray();
        for(int i=0;i<15;i++){//word
            for(int j=0;j<5;j++){//line
                if(chars[j].length>i){
                    rs+=chars[j][i];
                }
            }
        }
        System.out.println(rs);
    }
}