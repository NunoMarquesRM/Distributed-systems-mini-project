package TAA;

import java.io.*;
import java.net.*;
import java.util.*;

public class Connection extends Thread {
    private Socket S;
    private ArrayList<String> liv;
    private ArrayList<Livros> deal;
    
    public ArrayList<String> getLivros(){
        return liv;
    }
    
    public void setLivros(ArrayList<String> livros){
        liv = livros;
    }
    
    public ArrayList<Livros> getDeal(){
        return deal;
    }
    
    public void setDeal(ArrayList<Livros> deal){
        this.deal = deal;
    }
    
    public synchronized String levantar(String nome_levantar){
        for (int i = 0; i < liv.size(); i++) {
            if (liv.get(i).equals(nome_levantar)) {
                liv.remove(liv.get(i));
                return "Sucesso!";
            }
        }
        return "Erro!";
    }
    @Override
    public String toString() {
        return "Connection{" + "liv=" + liv + '}';
    }
    
    public Connection (Socket s, ArrayList<String> liv, ArrayList<Livros> deal){
        super();
        S = s;
        this.liv = liv;
        this.deal = deal;
        start();
    }
    @Override
    public void run(){
        try{
            ObjectOutputStream os = new ObjectOutputStream(S.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(S.getInputStream());
            
            String de_ip = (String) is.readObject(); // ip de cliente
            os.writeObject("Introduza o numero de aluno:");
            int num = Integer.parseInt((String)is.readObject());
            
            boolean flag = false;
            
            while(true){
                os.writeObject("1 - Oferecer um livro.\n2 - Levantar um livro.\n"
                        + "3 - Consultar livros.\n0 - Sair.\nOpcao:");
                int aux = Integer.parseInt((String) is.readObject());//recebe a opcao
                
                switch(aux){
                    case 1:
                        os.writeObject("Qual o nome do livro?");
                        String nome = (String) is.readObject();
                        
                        Livros x = new Livros(nome,de_ip);
                        ArrayList<String> liv = this.getLivros();
                        ArrayList<Livros> deal = this.getDeal();
                        
                        liv.add(nome);
                        deal.add(x);
                        this.setLivros(liv);
                        this.setDeal(deal);
                        
                        //Sorteio
                        int sorteio = (num % 10) + 7;
                        if(deal.size() % sorteio == 0){
                            os.writeObject("Parabens, " + de_ip + " tem um bilhete para o sorteio.");
                        }
                        else{
                            os.writeObject("Ola " + de_ip + ", obrigada pelo livro.");
                        }
                        break;
                    case 2:
                        os.writeObject("Qual o nome do livro?");
                        String nome_levantar = (String) is.readObject();
                        os.writeObject(levantar(nome_levantar));
                        break;
                    case 3:
                        os.writeObject(this.toString());
                        break;
                    case 0:
                        flag = true;
                        break;
                    default:
                        System.out.println("Erro, opcao incorreta!");
                        break;
                }
                if(flag){
                    break;
                }
            }
        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}