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
package br.com.brunotonia.BEAN;

import br.com.brunotonia.BO.VersaoBO;
import br.com.brunotonia.UTIL.PacotesUtil;
import br.com.brunotonia.VO.Versao;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "versaoBean")
@ViewScoped
public class VersaoBean implements Serializable {
    
    public Versao versao;

    public VersaoBean() {
        this.versao = new VersaoBO().selecionar();
    }

    public Versao getVersao() {
        return versao;
    }

    public void setVersao(Versao versao) {
        this.versao = versao;
    }
    
    public void atualizar(ActionEvent actionEvent) {
        this.versao = new VersaoBO().selecionar();
    }
    
    public void incrementarUpdate(ActionEvent actionEvent) {
        new VersaoBO().incrementarUpdate();
        atualizar(actionEvent);
    }
    
    public void incrementarUpgrade(ActionEvent actionEvent) {
        new VersaoBO().incrementarUpgrade();
        atualizar(actionEvent);
    }
    
    public void incrementarDistUpgrade(ActionEvent actionEvent) {
        new VersaoBO().incrementarDistUpgrade();
        atualizar(actionEvent);
    }
    
    public void atualizarListaDePacotes(ActionEvent actionEvent) {
        new PacotesUtil().processarListaDePacotes();
        atualizar(actionEvent);
    }
    
}
