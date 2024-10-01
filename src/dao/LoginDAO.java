package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {


    // M�todo para validar o login
    public boolean validarLogin(String nome, String senha) {
        String sql = "SELECT * FROM usuarios WHERE nome = ? AND senha = ?"; // supondo que a tabela seja 'usuarios'

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            // Se houver resultados, as credenciais est�o corretas
            return rs.next();

        } catch (SQLException e) {
            System.out.println("Erro ao validar login: " + e.getMessage());
            return false;
        }
    }

    // M�todo para inserir um novo usu�rio no banco de dados
    public boolean inserirUsuario(Login login) {
        String sql = "INSERT INTO usuarios (nome, senha) VALUES (?, ?)";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login.getNome());
            stmt.setString(2, login.getSenha());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir usu�rio: " + e.getMessage());
            return false;
        }
    }

    // M�todo para buscar um usu�rio por nome
    public Login buscarUsuarioPorNome(String nome) {
        String sql = "SELECT * FROM usuarios WHERE nome = ?";
        Login login = null;

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                login = new Login();
                login.setId(rs.getInt("id"));
                login.setNome(rs.getString("nome"));
                login.setSenha(rs.getString("senha"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar usu�rio: " + e.getMessage());
        }

        return login;
    }

    // M�todo para deletar um usu�rio pelo ID
    public boolean deletarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar usu�rio: " + e.getMessage());
            return false;
        }
    }

    // M�todo para atualizar um usu�rio
    public boolean atualizarUsuario(Login login) {
        String sql = "UPDATE usuarios SET nome = ?, senha = ? WHERE id = ?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login.getNome());
            stmt.setString(2, login.getSenha());
            stmt.setInt(3, login.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar usu�rio: " + e.getMessage());
            return false;
        }
    }
}

