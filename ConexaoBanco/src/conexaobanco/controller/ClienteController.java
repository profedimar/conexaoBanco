/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobanco.controller;

import conexaobanco.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class ClienteController {

    public boolean inserir() {
        String sql = "INSERT INTO cliente(nome,codigo) VALUES ('Jole', 7)";
        PreparedStatement ps;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.execute();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static void main(String[] args) {
        //crie um objeto da classe Cliente controller
        ClienteController controller = new ClienteController();
        //chame o método inserir desse objeto
        controller.inserir();
        //execute e confira no BD -- BD é muito legal, neh :)
    }

}
