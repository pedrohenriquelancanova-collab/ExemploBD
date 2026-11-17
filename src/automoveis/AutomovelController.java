/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automoveis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author 2025007300
 */
public class AutomovelController {

    private Connection conexao;

    public AutomovelController() {
        this.conexao = Conexao.getConexao();
    }

    public void adicionar(Automovel auto) {
        String sql = "insert into automovel (marca, modelo, placa, cor) values (?,?,?,?)";

        try {
            // Criação do Prepared Statement para inserção de um novo Funcion�rio
            PreparedStatement ps = this.conexao.prepareStatement(sql);

            // Setando os valores de acordo com o funcion�rio recebido por par�metro
            ps.setString(1, auto.getMarca());
            ps.setString(2, auto.getModelo());
            ps.setString(3, auto.getPlaca());
            ps.setString(4, auto.getCor());
            

            // Executa e ap�s fecha
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<Automovel> listar() {
        String sql = "select * from automovel";

        try {
            LinkedList<Automovel> automoveis = new LinkedList<Automovel>();
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // Criando o objeto Funcionario
                Automovel auto = new Automovel(rs.getString("marca"), rs.getString("modelo"), rs.getString("placa"), rs.getString("cor"));
                auto.setId(rs.getInt("id"));

                // Adicionando o objeto à lista
                automoveis.add(auto);
            }
            rs.close();
            ps.close();
            return automoveis;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    

    public LinkedList<Automovel> procurar(String placa) {
        String sql = "select * from automovel where placa like ?";

        try {
            LinkedList<Automovel> automoveis = new LinkedList<Automovel>();
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setString(1, '%' + placa + '%');
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Automovel auto = new Automovel(rs.getString("marca"), rs.getString("modelo"), rs.getString("placa"), rs.getString("cor"));
                auto.setId(rs.getInt("id"));
                automoveis.add(auto);
            }
            rs.close();
            ps.close();
            return automoveis;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Automovel procurar(int id) {
        String sql = "select * from automovel where id = ?";

        try {
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                rs.next();
                Automovel auto = new Automovel(rs.getString("marca"), rs.getString("modelo"), rs.getString("placa"), rs.getString("cor"));
                auto.setId(rs.getInt("id"));
                rs.close();
                ps.close();
                return auto;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterar(Automovel auto) {
        String sql = "update automovel set marca=?, modelo=?, placa=?, cor=? where id=?";

        try {
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setString(1, auto.getMarca());
            ps.setString(2, auto.getModelo());
            ps.setString(3, auto.getPlaca());
            ps.setString(4, auto.getCor());
            ps.setLong(5, auto.getId());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(Automovel auto) {
        String sql = "delete from automovel where id = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, auto.getId());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
