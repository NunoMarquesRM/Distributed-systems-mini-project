package TAA;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class Servidor {
    private ServerSocket ss;
    private Socket s;
    private Connection c;
    private ArrayList<String> liv;
    private ArrayList<Livros> deal;
    
    public Servidor(){
        try{
            ss = new ServerSocket(5432);
            liv = new ArrayList<>();
            deal = new ArrayList<>();
            
            while(true){
                s = ss.accept();
                c = new Connection(s,liv,deal);
            }
        }catch( IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        Servidor server = new Servidor();
    }
}