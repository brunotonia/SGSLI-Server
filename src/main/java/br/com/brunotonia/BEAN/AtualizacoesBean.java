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
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "atualizacoesBean")
public class AtualizacoesBean {

    public AtualizacoesBean() {
    }

    public void atualizaListaPacotes() {
        new PacotesUtil().processarListaDePacotes();
    }

    public void atualizaUpdate() {
        new VersaoBO().incrementarUpdate();
    }

    public void atualizaUpgrade() {
        new VersaoBO().incrementarUpgrade();
    }

    public void atualizaDistUpgrade() {
        new VersaoBO().incrementarDistUpgrade();
    }

}