/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobanco.controller;

import conexaobanco.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class ClienteController {

    public boolean inserir(int codigo, String nm) {
        String sql = "INSERT INTO cliente(nome,codigo) VALUES (?, ?)";//define instrução SQL
        PreparedStatement ps;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);//prepara instrução SQL
            ps.setString(1, nm);// primeiro parâmetro indica a ? correspondente, segundo parâmetro a variável que substituirá a ?
            ps.setInt(2, codigo); // primeiro parâmetro indica a ? correspondente, segundo parâmetro a variável que substituirá a ?
            ps.execute(); //executa SQL preparada
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void mostrarTodosClientes(){
        String sql = "SELECT codigo, nome FROM cliente";
        PreparedStatement ps;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("codigo")+" - "+rs.getString("nome"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public static void main(String[] args) {
        //crie um objeto da classe Cliente controller
        ClienteController controller = new ClienteController();
        //chame o método inserir desse objeto
        //controller.inserir(11, "Pietra");
        //controller.inserir(12, "Maila");
        //controller.inserir(13, "Patrícia");
        
        controller.mostrarTodosClientes();
        
        //execute e confira no BD -- BD é muito legal, neh :)
    }

}
