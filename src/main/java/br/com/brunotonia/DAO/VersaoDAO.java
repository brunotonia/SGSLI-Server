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

import br.com.brunotonia.VO.Versao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VersaoDAO {

    public Versao selecionar() throws Exception {
        Versao retorno = null;
        String sql = "select * from versao where id = 1";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            retorno = new Versao();
            retorno.setId(rs.getInt("id"));
            retorno.setSources(rs.getInt("sources"));
            retorno.setInstalacao(rs.getInt("instalacao"));
            retorno.setRemocao(rs.getInt("remocao"));
            retorno.setUpgrade(rs.getInt("upgrade"));
            retorno.setDistUpdate(rs.getInt("dist_update"));
        }
        rs.close();
        ps.close();
        cnn.close();
        return retorno;
    }
    
}
