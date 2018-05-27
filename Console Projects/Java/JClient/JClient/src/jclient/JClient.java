/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jclient;

import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Mag
 */
public class JClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            System.out.print("Host: ");
            String host = new Scanner(System.in).nextLine();
            System.out.print("Port: ");
            int port = Integer.valueOf(new Scanner(System.in).nextLine());
            Socket client = new Socket(host, port);
            ObjectInputStream enter = new ObjectInputStream(client.getInputStream());
            String str;
            while(true){
                str = (String)enter.readObject();
                if(str!=null && str!=""){
                    if(str=="break"){
                        System.out.println("Conexão encenrrada");
                        client.close();
                        enter.close();
                        break;
                    }
                    System.out.println("Server: "+str);
                    //JOptionPane.showMessageDialog(null, "s");
                    //System.out.println(str);
                    //break;
                }
            }
            
            client.close();
            enter.close();
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
        
    }
    
}
