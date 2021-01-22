package TAA;

import java.io.*;

public class Ler {
    public static String umaString(){
        String s = "";
        try {
            BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
            s = in.readLine();
        }
        catch (IOException e){
            System.out.println("Erro ao ler fluxo de entrada.");
        }
        return s;
    }
    
    public static int umInt(){
        while (true){
            try{
                return Integer.parseInt(umaString().trim());
            }
            catch(Exception e){
                System.out.println("Não é válido!!");
            }
        }
    }
    
    public static double umDouble(){
        while(true){
            try{
                return Double.parseDouble(umaString().trim());
            }
            catch(Exception e){
                System.out.println("Não válido");
            }
        }
    }
    
    public static double umFloat(){
        while(true){
            try{
                return Float.valueOf(umaString().trim());
            }
            catch(Exception e){
                System.out.println("Não válido");
            }
        }
    }
    
    public static boolean umBoolean(){
        while(true){
            try{
                return Boolean.parseBoolean(umaString().trim());
            }
            catch(Exception e){
                System.out.println("Não válido");
            }
        }
    }
    
    public static char umChar(){
      char c = 0;
        try {
            BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
            c =(char) in.read();
        }
        catch (IOException e){
            System.out.println("Erro ao ler fluxo de entrada.");
        }
        return c;
    }
    
    public static byte umByte(){
        while(true){
            try{
                return Byte.parseByte(umaString().trim());
            }
            catch(Exception e){
                System.out.println("Não válido");
            }
        }
    }
    
    public static short umShort(){
        while(true){
            try{
                return Short.parseShort(umaString().trim());
            }
            catch(Exception e){
                System.out.println("Não válido");
            }
        }
    }
      
    public static long umLong(){
        while(true){
            try{
                return Long.parseLong(umaString().trim());
            }
            catch(Exception e){
                System.out.println("Não válido");
            }
        }
    }
}
