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

import br.com.brunotonia.UTIL.DataUtil;
import br.com.brunotonia.VO.Versao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VersaoDAO {

    public Versao selecionar() throws Exception {
        Versao retorno = null;
        String sql = "SELECT * FROM versao WHERE id = 1";
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
            retorno.setUpdate(rs.getInt("updt"));
            retorno.setDataUpdate(rs.getString("data_updt"));
            retorno.setUpgrade(rs.getInt("upgrade"));
            retorno.setDataUpgrade(rs.getString("data_upgrade"));
            retorno.setDistUpgrade(rs.getInt("dist_upgrade"));
            retorno.setDataDistUpGrade(rs.getString("data_dist_upgrade"));
            retorno.setDataListaPacotes(rs.getString("data_pacotes"));
        }
        rs.close();
        ps.close();
        cnn.close();
        return retorno;
    }
    
    public void incrementarUpdate() throws Exception {
        String sql = "UPDATE versao SET "
                + " updt = updt + 1,"
                + " data_updt = ?"
                + " WHERE id = 1";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, new DataUtil().getDataAtual());
        ps.execute();
        ps.close();
        //cnn.commit();
        cnn.close();
    }
    
    public void incrementarUpgrade() throws Exception {
        String sql = "UPDATE versao SET "
                + " upgrade = upgrade + 1,"
                + " data_upgrade = ?"
                + " WHERE id = 1";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, new DataUtil().getDataAtual());
        ps.execute();
        ps.close();
        //cnn.commit();
        cnn.close();
    }
    
    public void incrementarDistUpgrade() throws Exception {
        String sql = "UPDATE versao SET "
                + " dist_upgrade = dist_upgrade + 1,"
                + " data_dist_upgrade = ?"
                + " WHERE id = 1";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, new DataUtil().getDataAtual());
        ps.execute();
        ps.close();
        cnn.commit();
        cnn.close();
    }
    
    public void atualizarDataListaPacotes() throws Exception {
        String sql = "UPDATE versao SET "
                + " data_pacotes = ?"
                + " WHERE id = 1";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, new DataUtil().getDataAtual());
        ps.execute();
        ps.close();
        //cnn.commit();
        cnn.close();
    }
    
}
