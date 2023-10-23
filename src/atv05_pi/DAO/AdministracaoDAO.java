package atv05_pi.DAO;

import connect.ConnectFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Administracaos;

public class AdministracaoDAO {

    private Connection con;

    public AdministracaoDAO() {
        this.con = new ConnectFactory().getConnection();
    }

    //CADASTRAR
    public void cadastrarCondominio(Administracaos admn) {
        try {
            String sql = "INSERT INTO administracao (notificacao) "
                    + "VALUES (?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, admn.getNotificacao());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {

        }
    }

    public List<Administracaos> listarAdministracaos() {
        List<Administracaos> listaAdministracaos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM administracao";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Administracaos condominio = new Administracaos();
                condominio.setId(rs.getInt("id"));
                condominio.setNotificacao(rs.getString("notificacao"));

                listaAdministracaos.add(condominio);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {

        }
        return listaAdministracaos;
    }

    public Administracaos buscarCondominioPorId(int id) {
        Administracaos condominio = null;
        try {
            String sql = "SELECT * FROM administracao WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                condominio = new Administracaos();
                condominio.setId(rs.getInt("id"));
                condominio.setNotificacao(rs.getString("notificacao"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
        }
        return condominio;
    }

    public void alterarAdministracaos(Administracaos condominio) {
        try {
            String sql = "UPDATE administracao SET notificacao=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, condominio.getNotificacao());
            ps.setInt(2, condominio.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {

        }
    }

    public void excluirCondominioPorId(int id) {
        try {
            String sql = "DELETE FROM administracao WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {

        }
    }
}
