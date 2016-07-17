package br.com.brunotonia.UTIL;

import br.com.brunotonia.BO.RepositorioBO;
import br.com.brunotonia.VO.Repositorio;
import java.util.ArrayList;
import java.util.List;

public class RepositorioUtil {

    public List<String> listarURLsPacotes() {
        // Obtém lista de Repositorios do banco de dados
        List<Repositorio> repositorios = new RepositorioBO().listarAtivos();
        List<String> lista = new ArrayList<String>();
        String url = "";
        for (Repositorio r : repositorios) {
            // Url de exemplo
            // http://sft.if.usp.br/debian/dists/jessie/main/binary-all/Packages.xz
            String aux = r.getUrl() + "dists/" + r.getVersao() + "/";
            String[] rep = r.getRepositorios().split(" ");
            if (r.getId().equals(1)) {
                for (String rep1 : rep) {
                    lista.add(aux + rep1 + "/binary-all/Packages.xz");
                    lista.add(aux + rep1 + "/binary-i386/Packages.xz");
                }
            } else {
                for (String rep1 : rep) {
                    lista.add(aux + rep1 + "/source/Sources.xz");
                }
            }
        }
        return lista;
    }
}
