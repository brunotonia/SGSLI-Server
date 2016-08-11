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

import br.com.brunotonia.VO.RepositorioSecurity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositorioSecurityDAO {
    
    public void adicionar(RepositorioSecurity repositorio) throws Exception {
        String sql = "INSERT INTO repositorio_security "
                + "(\"tipo\", \"url\", \"versao\", \"repositorios\", \"descricao\", \"ativo\")"
                + " VALUES "
                + "(?, ?, ?, ?, ?, ?)";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, repositorio.getTipo().getId());
        ps.setString(2, repositorio.getUrl());
        ps.setString(3, repositorio.getVersao());
        ps.setString(4, repositorio.getRepositorios());
        ps.setString(5, repositorio.getDescricao());
        ps.setBoolean(6, repositorio.getAtivo());
        ps.execute();
        ps.close();
        cnn.commit();
        cnn.close();
    }
    
    public void alterar(RepositorioSecurity repositorio) throws Exception {
        //"UPDATE Messages SET description = ?, author = ? WHERE id = ? AND seq_num = ?"
        String sql = "UPDATE repositorio_security SET "
                + " tipo = ?,"
                + " url = ?,"
                + " versao = ?,"
                + " repositorios = ?,"
                + " descricao = ?,"
                + " ativo = ?"
                + " WHERE id = ?";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, repositorio.getTipo().getId());
        ps.setString(2, repositorio.getUrl());
        ps.setString(3, repositorio.getVersao());
        ps.setString(4, repositorio.getRepositorios());
        ps.setString(5, repositorio.getDescricao());
        ps.setBoolean(6, repositorio.getAtivo());
        ps.setInt(7, repositorio.getId());
        ps.execute();
        ps.close();
        cnn.close();
    }
    
    public void excluir(Integer id) throws Exception {
        String sql = "DELETE FROM repositorio_security WHERE id = ?";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        
        ps.setInt(1, id);
        ps.execute();
        
        ps.close();
        cnn.close();
    }
    
    public RepositorioSecurity selecionar(Integer id) throws Exception {
        RepositorioSecurity repositorio = null;
        String sql = "SELECT * FROM repositorio_security WHERE id = ?";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            repositorio = new RepositorioSecurity();
            repositorio.setId(rs.getInt("id"));
            repositorio.setTipo(new RepositorioTipoDAO().selecionar(rs.getInt("tipo")));
            repositorio.setUrl(rs.getString("url"));
            repositorio.setVersao(rs.getString("versao"));
            repositorio.setRepositorios(rs.getString("repositorios"));
            repositorio.setDescricao(rs.getString("descricao"));
            repositorio.setAtivo(rs.getBoolean("ativo"));
            
        }
        rs.close();
        ps.close();
        cnn.close();
        return repositorio;
    }
    
    public List<RepositorioSecurity> listar() throws Exception {
        String sql = "SELECT * FROM repositorio_security ORDER BY id ";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<RepositorioSecurity> lista = new ArrayList<RepositorioSecurity>();
        while (rs.next()) {
            
            RepositorioSecurity repositorio = new RepositorioSecurity();
            repositorio.setId(rs.getInt("id"));
            repositorio.setTipo(new RepositorioTipoDAO().selecionar(rs.getInt("tipo")));
            repositorio.setUrl(rs.getString("url"));
            repositorio.setVersao(rs.getString("versao"));
            repositorio.setRepositorios(rs.getString("repositorios"));
            repositorio.setDescricao(rs.getString("descricao"));
            repositorio.setAtivo(rs.getBoolean("ativo"));
            
            lista.add(repositorio);
        }
        rs.close();
        ps.close();
        cnn.close();
        return lista;
    }
    
    public List<RepositorioSecurity> listarAtivos() throws Exception {
        String sql = "SELECT * FROM repositorio_security WHERE ativo = ? ORDER BY id ";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setBoolean(1, true);
        ResultSet rs = ps.executeQuery();
        List<RepositorioSecurity> lista = new ArrayList<RepositorioSecurity>();
        while (rs.next()) {
            
            RepositorioSecurity repositorio = new RepositorioSecurity();
            repositorio.setId(rs.getInt("id"));
            repositorio.setTipo(new RepositorioTipoDAO().selecionar(rs.getInt("tipo")));
            repositorio.setUrl(rs.getString("url"));
            repositorio.setVersao(rs.getString("versao"));
            repositorio.setRepositorios(rs.getString("repositorios"));
            repositorio.setDescricao(rs.getString("descricao"));
            repositorio.setAtivo(rs.getBoolean("ativo"));
            lista.add(repositorio);
            
        }
        rs.close();
        ps.close();
        return lista;
    }
    
    public List<RepositorioSecurity> listarInativos() throws Exception {
        String sql = "SELECT * FROM repositorio_security WHERE ativo = ? ORDER BY id ";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setBoolean(1, false);
        ResultSet rs = ps.executeQuery();
        List<RepositorioSecurity> lista = new ArrayList<RepositorioSecurity>();
        while (rs.next()) {
            
            RepositorioSecurity repositorio = new RepositorioSecurity();
            repositorio.setId(rs.getInt("id"));
            repositorio.setTipo(new RepositorioTipoDAO().selecionar(rs.getInt("tipo")));
            repositorio.setUrl(rs.getString("url"));
            repositorio.setVersao(rs.getString("versao"));
            repositorio.setRepositorios(rs.getString("repositorios"));
            repositorio.setDescricao(rs.getString("descricao"));
            repositorio.setAtivo(rs.getBoolean("ativo"));
            lista.add(repositorio);
            
        }
        rs.close();
        ps.close();
        return lista;
    }
    
}
