/*
 * Copyright (C) 2016 bruno
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

/**
 *
 * @author bruno
 */
public class UsuarioDAO {
    
    public void adicionar(Usuario usuario) throws Exception {
        String sql;
        sql = "insert into usuario "
                + "(\"tipo\", \"nome\", \"login\", \"senha\", \"ativo\")"
                + " values "
                + "(?, ?, ?, ?, ?)";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
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
    
    public Usuario selecionar(Integer id) throws Exception {
        Usuario usuario = null;
        String sql = "select * from usuario where id = ?";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            
            usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setTipo(new UsuarioTipoDAO().selecionar(rs.getInt("tipo")));
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("usuario"));
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
        String sql = "select * from usuario where login = ? and senha = ?";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, login);
        ps.setString(2, senha);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            
            usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setTipo(new UsuarioTipoDAO().selecionar(rs.getInt("tipo")));
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("usuario"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setAtivo(rs.getBoolean("ativo"));
            
        }
        rs.close();
        ps.close();
        cnn.close();
        return usuario;
    }
    
    public List<Usuario> listar() throws Exception {
        String sql = "select * from usuario order by id ";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Usuario> lista = new ArrayList<Usuario>();
        while (rs.next()) {
            
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setTipo(new UsuarioTipoDAO().selecionar(rs.getInt("tipo")));
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("usuario"));
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
