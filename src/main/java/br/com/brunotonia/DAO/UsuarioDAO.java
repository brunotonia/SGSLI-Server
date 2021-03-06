/*
 * Copyright (C) 2016 Bruno Roberto Vasconcelos Tonia
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.brunotonia.DAO;

import br.com.brunotonia.VO.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    
    public void adicionar(Usuario usuario) throws Exception {
        String sql;
        sql = "INSERT INTO usuario "
                + "(\"tipo\", \"nome\", \"login\", \"senha\", \"ativo\")"
                + " values "
                + "(?, ?, ?, ?, ?)";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, usuario.getTipo().getId());
        ps.setString(2, usuario.getNome());
        ps.setString(3, usuario.getLogin());
        ps.setString(4, usuario.getSenha());
        ps.setBoolean(5, usuario.getAtivo());
        ps.execute();
        ps.close();
        cnn.commit();
        cnn.close();
    }
    
    public void editar(Usuario usuario) throws Exception {
        //"UPDATE Messages SET description = ?, author = ? WHERE id = ?"
        String sql = "UPDATE usuario SET "
                + " tipo = ?,"
                + " nome = ?,"
                + " login = ?,"
                + " senha = ?,"
                + " ativo = ?"
                + " WHERE id = ?";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, usuario.getTipo().getId());
        ps.setString(2, usuario.getNome());
        ps.setString(3, usuario.getLogin());
        ps.setString(4, usuario.getSenha());
        ps.setBoolean(5, usuario.getAtivo());
        ps.setInt(6, usuario.getId());
        ps.execute();
        ps.close();
        cnn.close();
    }
    
    public void ativarDesativar (Usuario u) throws Exception {
        String sql = "UPDATE usuario SET ativo = ?, WHERE id = ?";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setBoolean(1, !u.getAtivo());
        ps.setInt(2, u.getId());
        ps.execute();
        ps.close();
        cnn.close();
    }
    
    public void alterarSenha(Usuario usuario) throws Exception {
        String sql = "UPDATE usuario SET senha = ? WHERE id = ?";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, usuario.getSenha());
        ps.setInt(2, usuario.getTipo().getId());
        ps.execute();
        ps.close();
        cnn.commit();
        cnn.close();
    }
    
    public void excluir(Integer id) throws Exception {
        String sql = "DELETE FROM usuario WHERE id = ?";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
        ps.close();
        cnn.close();
    }
    
    public Usuario selecionar(Integer id) throws Exception {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE id = ?";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setTipo(new UsuarioTipoDAO().selecionar(rs.getInt("tipo")));
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setAtivo(rs.getBoolean("ativo"));
        }
        rs.close();
        ps.close();
        cnn.close();
        return usuario;
    }
    
    public Usuario login(String login, String senha) throws Exception {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ? AND ativo = ?";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, login);
        ps.setString(2, senha);
        ps.setBoolean(3, true);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {          
            usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setTipo(new UsuarioTipoDAO().selecionar(rs.getInt("tipo")));
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha("");
            usuario.setAtivo(rs.getBoolean("ativo"));
        }
        rs.close();
        ps.close();
        cnn.close();
        return usuario;
    }
    
    public List<Usuario> listar() throws Exception {
        String sql = "SELECT * FROM usuario ORDER BY id ";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Usuario> lista = new ArrayList<Usuario>();
        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setTipo(new UsuarioTipoDAO().selecionar(rs.getInt("tipo")));
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setAtivo(rs.getBoolean("ativo"));
            lista.add(usuario);
        }
        rs.close();
        ps.close();
        cnn.close();
        return lista;
    }
    
}
