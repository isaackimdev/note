package languages.java.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPCheck {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ia = null;
        InetAddress[] ias = null;

        ia = InetAddress.getByName("www.naver.com");
        System.out.println("[www.naver.com] IP : " + ia.getHostAddress());
        System.out.println("host name : " + ia.getHostName());

        ias = InetAddress.getAllByName("www.google.com");
        for(int i = 0; i < ias.length; i++) {
            System.out.println("[www.google.com] IP : " + ias[i].getHostAddress());
            System.out.println("host name : " + ias[i].getHostName());
        }
    }
}
