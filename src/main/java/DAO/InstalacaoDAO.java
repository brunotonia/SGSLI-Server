package DAO;

import VO.Instalacao;
import VO.Pacotes;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InstalacaoDAO {

    public void adicionar(Instalacao p) throws Exception {
        String sql;
        sql = "insert into instalacao "
                + "(\"pacote\", \"ativo\")"
                + " values "
                + "(?, ?)";
        Conexoes cnx = new Conexoes();
        Connection cnn = cnx.getConexao();
        PreparedStatement ps = cnn.prepareStatement(sql);

        ps.setInt(1, p.getPacote().getId());
        ps.setBoolean(2, p.getAtivo());

        ps.execute();
        ps.close();
        cnn.close();
    }

}
