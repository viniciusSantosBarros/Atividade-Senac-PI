package atv05_pi.DAO;

import connect.ConnectFactory;
import model.CadastroCondominios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CadastroCondominioDAO {

    private Connection con;

    public CadastroCondominioDAO() {
        this.con = new ConnectFactory().getConnection();
    }

    //CADASTRAR
    public void cadastrarCondominio(CadastroCondominios condominio) {
        try {
            String sql = "INSERT INTO condominio (nome, endereco, numero, sindico, numeroAp, ultimaAssembleia, proximaAssembleia, contaPagar, contaReceber, multa) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, condominio.getNome());
            ps.setString(2, condominio.getEndereco());
            ps.setString(3, condominio.getNumero());
            ps.setString(4, condominio.getSindico());
            ps.setString(5, condominio.getNumeroAp());

            // Converter LocalDate para java.sql.Date
            ps.setDate(6, java.sql.Date.valueOf(condominio.getUltimaAssembleia()));
            ps.setDate(7, java.sql.Date.valueOf(condominio.getProximaAssembleia()));

            ps.setDouble(8, condominio.getContaPagar());
            ps.setDouble(9, condominio.getContaReceber());
            ps.setDouble(10, condominio.getMulta());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {

        }
    }

    public List<CadastroCondominios> listarTodosCondominios() {
        List<CadastroCondominios> listaCondominios = new ArrayList<>();

        try {
            String sql = "SELECT * FROM condominio";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CadastroCondominios condominio = new CadastroCondominios();
                condominio.setId(rs.getInt("id"));
                condominio.setNome(rs.getString("nome"));
                condominio.setEndereco(rs.getString("endereco"));
                condominio.setNumero(rs.getString("numero"));
                condominio.setSindico(rs.getString("sindico"));
                condominio.setNumeroAp(rs.getString("numeroAp"));
                condominio.setUltimaAssembleia(rs.getDate("ultimaAssembleia").toLocalDate());
                condominio.setProximaAssembleia(rs.getDate("proximaAssembleia").toLocalDate());
                condominio.setContaPagar(rs.getDouble("contaPagar"));
                condominio.setContaReceber(rs.getDouble("contaReceber"));
                condominio.setMulta(rs.getDouble("multa"));

                listaCondominios.add(condominio);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {

        }

        return listaCondominios;
    }

    public CadastroCondominios buscarCondominioPorId(int id) {
        CadastroCondominios condominio = null;

        try {
            String sql = "SELECT * FROM condominio WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                condominio = new CadastroCondominios();
                condominio.setId(rs.getInt("id"));
                condominio.setNome(rs.getString("nome"));
                condominio.setEndereco(rs.getString("endereco"));
                condominio.setNumero(rs.getString("numero"));
                condominio.setSindico(rs.getString("sindico"));
                condominio.setNumeroAp(rs.getString("numeroAp"));
                condominio.setUltimaAssembleia(rs.getDate("ultimaAssembleia").toLocalDate());
                condominio.setProximaAssembleia(rs.getDate("proximaAssembleia").toLocalDate());
                condominio.setContaPagar(rs.getDouble("contaPagar"));
                condominio.setContaReceber(rs.getDouble("contaReceber"));
                condominio.setMulta(rs.getDouble("multa"));
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
        }

        return condominio;
    }

    public void alterarCondominio(CadastroCondominios condominio) {
        try {
            String sql = "UPDATE condominio SET nome=?, endereco=?, numero=?, sindico=?, numeroAp=?, ultimaAssembleia=?, proximaAssembleia=?, contaPagar=?, contaReceber=?, multa=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, condominio.getNome());
            ps.setString(2, condominio.getEndereco());
            ps.setString(3, condominio.getNumero());
            ps.setString(4, condominio.getSindico());
            ps.setString(5, condominio.getNumeroAp());
            ps.setDate(6, java.sql.Date.valueOf(condominio.getUltimaAssembleia()));
            ps.setDate(7, java.sql.Date.valueOf(condominio.getProximaAssembleia()));
            ps.setDouble(8, condominio.getContaPagar());
            ps.setDouble(9, condominio.getContaReceber());
            ps.setDouble(10, condominio.getMulta());
            ps.setInt(11, condominio.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {

        }
    }

    public void excluirCondominioPorId(int id) {
        try {
            String sql = "DELETE FROM condominio WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            
        }
    }

}
