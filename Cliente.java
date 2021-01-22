package TAA;

import java.io.*;
import java.net.*;

public class Cliente {
    public Cliente(){
        int aux = 0;
        boolean flag = false;
        try{
            Socket s = new Socket("127.0.0.1", 5432);
            ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(s.getInputStream());
            
            // obter o valor do ip do cliente
            InetAddress host = null;
            String  ip_from = "";
            host = InetAddress.getLocalHost();
            byte ip [] = host.getAddress();
            for(int i= 0 ; i < ip.length; i++){
                if (i>0) 
                    ip_from += ".";
                ip_from += (ip[i] & 0xff);
            }
            os.writeObject(ip_from);
            System.out.println(is.readObject());
            os.writeObject(Ler.umaString());
            
            while(true) {
                //Menu
                System.out.println((String) is.readObject());
                aux = Ler.umInt();
                os.writeObject(Integer.toString(aux));
                switch(aux){
                    case 1:
                        System.out.println((String) is.readObject()); //nome do livro
                        os.writeObject(Ler.umaString());
                        System.out.println((String) is.readObject()); //Sorteio
                        break;
                    case 2:
                        System.out.println((String) is.readObject()); //nome do livro
                        os.writeObject(Ler.umaString());
                        System.out.println((String) is.readObject()); //apresenta sucesso ou erro
                        break;
                    case 3:
                        System.out.println((String) is.readObject());
                        break;
                    case 0:
                        flag = true;
                        s.close();
                        break;
                    default:
                        System.out.println("Erro, opcao incorreta!");
                        break;
                }
                if(flag){
                    break;
                }
            }
        }catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        Cliente c = new Cliente();
    }
}
