/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.VendaDAO;
import java.util.Date;
import java.util.List;
import model.Venda;

/**
 *
 * @author Professor
 */
public class VendaController {
    
    private VendaDAO dao;
    
    // método para cadastrar os Vendas
    public boolean cadastrar(Venda venda) throws Exception{
        dao = new VendaDAO();
        if(venda != null){
            dao.salvar(venda);
            return true;
        }else{
            return false;
        }
    }

    // método para pesquisar Venda pelo numero
    public List pesquisar(int numero) throws Exception{
        dao = new VendaDAO();
        List<Venda> lista = dao.listaNumero(numero);
        if(!lista.isEmpty()){
            return lista;
        }else{
            return null;
        }
    }
    
    // método para pesquisar Venda pelo numero
    public List pesquisar(Date data) throws Exception{
        dao = new VendaDAO();
        List<Venda> lista = dao.listaData(data);
        if(!lista.isEmpty()){
            return lista;
        }else{
            return null;
        }
    }

    // método para obter o último numero de Venda
    public int getUltimoNumero() throws Exception{
        dao = new VendaDAO();
        return dao.getUltimoNumero();
    }

    // método para retornar a lista de Vendas cadastrados
    public List<Venda> getTodosVendas() throws Exception{
        dao = new VendaDAO();
        return dao.todosVendas();
    }

    public boolean alterar(Venda venda) throws Exception{
        dao = new VendaDAO();
        if(venda != null){
            dao.atualizar(venda);
            return true;
        }else{
            return false;
        }
    }

    public boolean excluir(Venda venda) throws Exception{
        dao = new VendaDAO();
        if(venda != null){
            dao.excluir(venda);
            return true;
        }else{
            return false;
        }
    }
}
