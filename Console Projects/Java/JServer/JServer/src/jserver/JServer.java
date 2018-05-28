/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jserver;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Mag
 */
public class JServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            System.out.print("Port Number: ");
            int port = new Scanner(System.in).nextInt();
            ServerSocket server = new ServerSocket(port);
            while(true){
                System.out.println("Aguardando Conexão...");
                Socket client = server.accept();
                System.out.println("Cliente Conectado: "+client.getInetAddress().getHostAddress());
                ObjectOutputStream exit = new ObjectOutputStream(client.getOutputStream());
                exit.flush();
                while(true){
                    System.out.print("Escreva: ");
                    String send = new Scanner(System.in).nextLine();
                    exit.writeObject(new String(send));
                    if(send=="break"){
                        exit.close();
                        client.close();
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
    
}
