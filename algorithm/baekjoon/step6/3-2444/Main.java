import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<2*n-1;i++){
            if(i<n-1){
                for(int j=n-1-i;j>0;j--)s();
                for(int k=0; k<(2*(i+1)-1);k++)a();
            }
            else if(i==n-1)for(int j=0;j<2*n-1;j++)a();
            else{
                for(int j=0;j<i-(n-1);j++)s();
                for(int k=(2*n)-(2*(i-(n-1)))-1;k>0;k--)a();
            }
            System.out.println();
        }
    }
    static void s(){System.out.print(" ");}
    static void a(){System.out.print("*");}
}
