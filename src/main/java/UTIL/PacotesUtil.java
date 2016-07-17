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

            Pacotes pacote = new Pacotes();
            PacotesCategoria categoria;

            // Povoa Pacotes
            //PacotesBO pacotesBO = PacotesBO.getInstance();
            //PacotesCategoriaBO pacotesCategoriaBO = PacotesCategoriaBO.getInstance();
            while (linha != null) {
                String aux;

                if (linha.startsWith("Package: ")) {
                    aux = linha.substring(9).replace(" ", "");
                    pacote.setPacote(aux);
                    // procura pacote do banco de dados 
                    Pacotes p_aux = new PacotesBO().selecionar(aux);
                    if (p_aux != null) {
                        pacote.setId(p_aux.getId());
                    }
                } else if (linha.startsWith("Version: ")) {
                    pacote.setVersao(linha.substring(9).replace(" ", ""));
                } else if (linha.startsWith("Depends: ")) {
                    pacote.setDependencias(linha.substring(9));
                } else if (linha.startsWith("Description: ")) {
                    pacote.setDescricao(linha.substring(13));
                } else if (linha.startsWith("Section: ")) {
                    aux = linha.substring(9).replace(" ", "");
                    pacote.setAtivo(true);
                    // Verifica e Adiciona Categoria
                    PacotesCategoriaBO pacotesCategoriaBO = new PacotesCategoriaBO();
                    categoria = pacotesCategoriaBO.selecionar(aux);
                    if (categoria == null) {
                        categoria = new PacotesCategoria(aux);
                        pacotesCategoriaBO.adicionar(categoria);
                        categoria = pacotesCategoriaBO.selecionar(aux);
                    }
                    pacote.setCategoria(categoria);
                    pacote.setAtivo(true);
                    // Armazena pacote
                    if (pacote.getId() == null) {
                        // Pacote não existe - Cria
                        new PacotesBO().adicionar(pacote);
                    } else {
                        try {
                            //new PacotesBO().atualizar(pacote);
                        } catch (Exception ex) {
                            Logger.getLogger(ArquivoUtil.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    pacote = new Pacotes();
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
        PacotesBO pacotesBO = new PacotesBO();
        //pacotesBO.prepararAtualizacaoPacotes();
        for (String url : lista_url) {
            ArquivoUtil au = new ArquivoUtil();
            lerPacotes(au.descompactarArquivoXZ(au.downloadArquivo(url)));
        }
    }

}