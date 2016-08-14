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

import br.com.brunotonia.VO.UsuarioTipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruno
 */
public class UsuarioTipoDAO {
    
    public UsuarioTipo selecionar(Integer id) throws Exception {
        UsuarioTipo usrTipo = null;
        String sql = "SELECT * FROM usuario_tipo WHERE id = ?";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            usrTipo = new UsuarioTipo();
            usrTipo.setId(rs.getInt("id"));
            usrTipo.setTipo(rs.getString("tipo"));
        }
        rs.close();
        ps.close();
        cnn.close();
        return usrTipo;
    }
    
    public List<UsuarioTipo> listar() throws Exception {
        String sql = "SELECT * FROM usuario_tipo ORDER BY id ";
        Connection cnn = PostgresqlConnect.getInstance().getConnection();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<UsuarioTipo> lista = new ArrayList<UsuarioTipo>();
        while (rs.next()) {
            
            UsuarioTipo usrTipo = new UsuarioTipo();
            usrTipo.setId(rs.getInt("id"));
            usrTipo.setTipo(rs.getString("tipo"));
            
            lista.add(usrTipo);
        }
        rs.close();
        ps.close();
        cnn.close();
        return lista;
    }
    
    
}
