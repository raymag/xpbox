package estudojdbc.pkg01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import jdbc.com.ConnectionFactory;

/**
 *
 * @author Mag
 */
public class EstudoJDBC01 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        /*Scanner leitor = new Scanner(System.in);;
        
        System.out.print("Informe: ");
        String resp = leitor.nextLine();
        System.out.println("Você: "+resp);*/
        ConnectionFactory mycon = new ConnectionFactory();
        Connection con = mycon.getConexao();
        String sql = "SELECT nome, senha FROM clientes;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        while(result.next()){
            String nome = result.getString("nome");
            String senha = result.getString("senha");
            System.out.println(nome);
            System.out.println(senha);
            System.out.println("________________\n");
        }
    }
    
}
