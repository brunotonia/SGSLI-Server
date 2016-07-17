package UTIL;

import BO.PacotesBO;
import BO.PacotesCategoriaBO;
import VO.Pacotes;
import VO.PacotesCategoria;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PacotesUtil {

    private void lerPacotes(File arquivo_txt) {

        FileInputStream stream;
        InputStreamReader reader;
        BufferedReader br;

        try {
            stream = new FileInputStream(arquivo_txt);
            reader = new InputStreamReader(stream);
            br = new BufferedReader(reader);
            String linha = br.readLine();

            // Povoa Pacotes
            PacotesBO pacotesBO = new PacotesBO();
            PacotesCategoriaBO pacotesCategoriaBO = new PacotesCategoriaBO();

            Pacotes pacote = null;
            Pacotes pct_aux = null;
            PacotesCategoria categoria = null;

            while (linha != null) {
                String valor = "";
                // Lendo o nome do Pacote!
                if (linha.startsWith("Package: ")) {
                    // Inicializo o pacote
                    pacote = new Pacotes();
                    // Leio o nome do pacote da lista de pacotes e seto o valor
                    valor = linha.substring(9).replace(" ", "").toLowerCase();
                    pacote.setPacote(valor);
                    // procura pacote do banco de dados 
                    pct_aux = pacotesBO.selecionar(valor);
                    if (pct_aux != null) {
                        pacote.setId(pct_aux.getId());
                    }
                }
                // Lendo a versao do Pacote!
                if (linha.startsWith("Version: ")) {
                    pacote.setVersao(linha.substring(9).replace(" ", "").toLowerCase());
                }
                // Lendo as dependencias do Pacote!
                if (linha.startsWith("Depends: ")) {
                    pacote.setDependencias(linha.substring(9));
                }
                // Lendo as dependencias do Pacote!
                if (linha.startsWith("Description: ")) {
                    pacote.setDescricao(linha.substring(13).toLowerCase());
                }
                // Lendo as dependencias do Pacote!
                if (linha.startsWith("Section: ")) {
                    valor = linha.substring(9).replace(" ", "").toLowerCase();
                    // Verifica e Adiciona Categoria
                    categoria = pacotesCategoriaBO.selecionar(valor);
                    if (categoria == null) {
                        categoria = new PacotesCategoria(valor);
                        pacotesCategoriaBO.adicionar(categoria);
                        categoria = pacotesCategoriaBO.selecionar(valor);
                    }
                    pacote.setCategoria(categoria);
                    // Deixa pacote ativo!
                    pacote.setAtivo(true);
                    // Armazena pacote
                    if (pacote.getId() == null) {
                        // Pacote não existe - Cria
                        pacotesBO.adicionar(pacote);
                    } else {
                        try {
                            //pacotesBO.atualizar(pacote);
                        } catch (Exception ex) {
                            Logger.getLogger(ArquivoUtil.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                linha = br.readLine();
            }
            arquivo_txt.delete();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void processarListaDePacotes() {
        List<String> lista_url = new RepositorioUtil().listarURLsPacotes();
        //PacotesBO pacotesBO = new PacotesBO();
        //pacotesBO.prepararAtualizacaoPacotes();
        for (String url : lista_url) {
            ArquivoUtil au = new ArquivoUtil();
            lerPacotes(au.descompactarArquivoXZ(au.downloadArquivo(url)));
        }
    }

}
