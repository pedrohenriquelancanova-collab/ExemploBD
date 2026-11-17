/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automoveis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 2025007300
 */
public class Conexao {

    // Deixa o construtor privado para n�o instanciar essa classe.
    private Conexao() {
    }

    public static Connection getConexao() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/automoveis", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
