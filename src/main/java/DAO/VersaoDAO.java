package DAO;

import VO.Versao;
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
