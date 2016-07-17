package WS;

import BO.RepositorioBO;
import BO.RepositorioSecurityBO;
import BO.VersaoBO;
import UTIL.RepositorioUtil;
import VO.Repositorio;
import VO.RepositorioSecurity;
import VO.Versao;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/etc/apt/sources.list")
public class SourcesListWS {

    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String gerarSourcesList() {
        RepositorioBO repositorioBO = new RepositorioBO();
        List<Repositorio> lista = repositorioBO.listarAtivos();
        VersaoBO versaoBO = new VersaoBO();
        Versao versao = versaoBO.selecionar();
        if (lista.isEmpty() || versao == null) {
            return "ERRO";
        } else {
            String resultado = "#SGSLI - Gerado automaticamente.\n#Versão " + versao.getSources().toString() + "\n\n";
            for (Repositorio repositorio : lista) {
                resultado += repositorio.toString() + " \n";
            }
            resultado += "\n";
            RepositorioSecurityBO repositorioSecurityBO = new RepositorioSecurityBO();
            List<RepositorioSecurity> listaSecurity = repositorioSecurityBO.listarAtivos();
            for (RepositorioSecurity repositorio : listaSecurity) {
                resultado += repositorio.toString() + " \n";
            }
            return resultado;
        }
    }

    @Path("/versao")
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String versaoSourcesList() {
        VersaoBO versaoBO = new VersaoBO();
        Versao versao = versaoBO.selecionar();
        return versao.getSources().toString();
    }

    @Path("/urls")
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String urlSourcesList() {
        String s = "";
        RepositorioUtil p = new RepositorioUtil();
        for (String aux : p.listarURLsPacotes()) {
            s += aux + "\n";
        }
        return s;
    }
    
}
