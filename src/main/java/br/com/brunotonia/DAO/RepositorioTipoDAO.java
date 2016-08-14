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

import br.com.brunotonia.VO.RepositorioTipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RepositorioTipoDAO {
    
    public RepositorioTipo selecionar(Integer id) throws Exception {
        RepositorioTipo repTipo = null;
        String sql = "SELECT * FROM repositorio_tipo WHERE id = ?";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            repTipo = new RepositorioTipo();
            repTipo.setId(rs.getInt("id"));
            repTipo.setTipo(rs.getString("tipo"));
        }
        rs.close();
        ps.close();
        cnn.close();
        return repTipo;
    }
    
    public RepositorioTipo selecionar(String tipo) throws Exception {
        RepositorioTipo repTipo = null;
        String sql = "SELECT * FROM repositorio_tipo WHERE tipo = ?";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, tipo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            repTipo = new RepositorioTipo();
            repTipo.setId(rs.getInt("id"));
            repTipo.setTipo(rs.getString("tipo"));
        }
        rs.close();
        ps.close();
        cnn.close();
        return repTipo;
    }
    
    public List<RepositorioTipo> listar() throws Exception {
        String sql = "SELECT * FROM repositorio_tipo ORDER BY id ";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<RepositorioTipo> lista = new ArrayList<RepositorioTipo>();
        while (rs.next()) {
            
            RepositorioTipo repTipo = new RepositorioTipo();
            repTipo.setId(rs.getInt("id"));
            repTipo.setTipo(rs.getString("tipo"));
            
            lista.add(repTipo);
        }
        rs.close();
        ps.close();
        cnn.close();
        return lista;
    }
    
}
