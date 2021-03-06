/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import persistencia.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class FilmeDao {

    public boolean inserir(String titulo, String duracao, String dataEstreia, String genero, String rating) {//todos como String aqui nesta linha
        String sql = "INSERT INTO filme(titulo, duracao, data_estreia, genero, rating) VALUES (?, ?, ?, ?, ?)";//define instrução SQL
        PreparedStatement ps;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);//prepara instrução SQL
            ps.setString(1, titulo);// primeiro parâmetro indica a ? correspondente, segundo parâmetro a variável que substituirá a ?
            ps.setTime(2, Time.valueOf(duracao)); //exemplo de hora
            ps.setDate(3, Date.valueOf(dataEstreia)); //exemplo de data
            ps.setString(4, genero); //Exemplo de String
            ps.setInt(5, Integer.parseInt(rating)); //exemplo de inteiro
            ps.execute(); //executa SQL preparada
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(FilmeDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void main(String[] args) {
        //crie um objeto da classe 
        FilmeDao dao = new FilmeDao();
        //chame o método inserir desse objeto
        boolean result = dao.inserir("Poeria em alto mar", "02:33:00", "1953-02-15", "drama", "4");
        if (result) {
            JOptionPane.showMessageDialog(null, "Inserção realizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Problemas com a inserção!");
        }
    }
}
