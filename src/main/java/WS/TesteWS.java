package WS;

import BO.VersaoBO;
import VO.Versao;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/testes")
public class TesteWS {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String testes() {
        System.err.print("Testes/\n"
                + "\t- sf - testa o sessionFactory\n"
                + "\t- session - testa a session\n"
                + "\n");
        return "Testes/\n"
                + "\t- sf - testa o sessionFactory\n"
                + "\t- session - testa a session\n"
                + "\n";
    }
    
    @Path("/versao")
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String versao() {
        VersaoBO versaoBO = new VersaoBO();
        Versao v = versaoBO.selecionar();
        if (v == null) {
            return "não deu certo";
        } else {
            return v.toString();
        }
    }
    
}
