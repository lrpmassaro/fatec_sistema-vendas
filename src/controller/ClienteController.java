package controller;

import dao.ClienteDAO;
import java.util.List;
import model.Cliente;

public class ClienteController {

    private ClienteDAO dao;
    
    // método para cadastrar os Clientes
    public boolean cadastrar(Cliente cliente) throws Exception{
        dao = new ClienteDAO();
        if(cliente != null){
            dao.salvar(cliente);
            return true;
        }else{
            return false;
        }
    }

    // método para pesquisar cliente pelo nome
    public List pesquisar(String nome) throws Exception{
        dao = new ClienteDAO();
        List<Cliente> lista = dao.listaNome(nome);
        if(!lista.isEmpty()){
            return lista;
        }else{
            return null;
        }
    }

    // método para pesquisar cliente pelo codigo
    public List pesquisar(int codigo) throws Exception{
        dao = new ClienteDAO();
        List<Cliente> lista = dao.listaCodigo(codigo);
        if(!lista.isEmpty()){
            return lista;
        }else{
            return null;
        }
    }

    // método para obter o último código de Cliente
    public int getUltimoCodigo() throws Exception{
        dao = new ClienteDAO();
        return dao.getUltimoCodigo();
    }

    // método para retornar a lista de Clientes cadastrados
    public List<Cliente> getTodosClientes() throws Exception{
        dao = new ClienteDAO();
        return dao.todosClientes();
    }

    public boolean alterar(Cliente cliente) throws Exception{
        dao = new ClienteDAO();
        if(cliente != null){
            dao.atualizar(cliente);
            return true;
        }else{
            return false;
        }
    }

    public boolean excluir(Cliente cliente) throws Exception{
        dao = new ClienteDAO();
        if(cliente != null){
            dao.excluir(cliente);
            return true;
        }else{
            return false;
        }
    }
}

