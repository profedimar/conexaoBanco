/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import persistencia.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class PessoaDao {

    public boolean inserir(String nome, int cpf) {
        String sql = "INSERT INTO pessoa(nome,cpf) VALUES (?, ?)";//define instrução SQL
        PreparedStatement ps;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);//prepara instrução SQL
            ps.setString(1, nome);// primeiro parâmetro indica a ? correspondente, segundo parâmetro a variável que substituirá a ?
            ps.setInt(2, cpf); // primeiro parâmetro indica a ? correspondente, segundo parâmetro a variável que substituirá a ?
            ps.execute(); //executa SQL preparada
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PessoaDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void main(String[] args) {
        //crie um objeto da classe Cliente controller
        PessoaDao controller = new PessoaDao();
        //chame o método inserir desse objeto
        boolean result = controller.inserir("Pietra", 01030371016);
        if (result) {
            JOptionPane.showMessageDialog(null, "Inserção realizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Problemas com a inserção!");
        }

        //execute e confira no BD -- BD é muito legal, neh :)
    }

}
