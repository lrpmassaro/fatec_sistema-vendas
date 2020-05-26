/*
 * Classe para fazer o armazenamento, manipulação e recuperação dos
 * dados dos objetos Cliente.
 */

package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import model.Cliente;
import util.ConnectionFactory;

/**
 *
 * @author Professor
 */
public class ClienteDAO {

    // declaração de variável de instância
    private Connection conn;

    // construtor
    public ClienteDAO() throws Exception {
        try{
            this.conn = ConnectionFactory.getConnection();
        }catch(Exception exception){
            throw new Exception(exception.getMessage());
        }
    }

    // método para salvar os dados do objeto Cliente
    public void salvar(Cliente cliente) throws Exception{
        // variável para armazenar referência do PreparedStatement
        PreparedStatement ps = null;
        // verifica se cliente é null
        if(cliente == null){
            throw new Exception("Erro: cliente não pode ser nulo.");
        }
        try{
            String SQL = "INSERT INTO clientes(nome, cpf, telefone) " +
                    "values(?,?,?)";
            // obtém instância de um objeto PreparedStatement
            ps = this.conn.prepareStatement(SQL);
            // configura a conexão
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getTelefone());
            // executa a instrução
            ps.executeUpdate();
        }catch(SQLException sqlException){
            throw new Exception("Erro ao inserir dados: " +
                    sqlException.getMessage());
        }finally{
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

    // método para atualizar dados do Cliente
    public void atualizar(Cliente cliente) throws Exception{
        // variável para armazenar a referência de PreparedStatement
        PreparedStatement ps = null;
        // verifica se cliente é nulo
        if(cliente == null){
            throw new Exception("Erro: cliente não pode ser nulo.");
        }
        try{
            String SQL = "UPDATE clientes SET nome=?," +
                    "cpf=?," +
                    "telefone=?" +
                    " WHERE codigo=?";
            // obtém instância de PreparedStatement
            ps = this.conn.prepareStatement(SQL);
            // configura a instrução
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getTelefone());
            ps.setInt(4, cliente.getCodigo());
            // executa a instrução
            ps.executeUpdate();
        }catch(SQLException sqlException){
            throw new Exception("Erro ao atualizar dados: " +
                    sqlException.getMessage());
        }finally{
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

    // método para excluir dados de Cliente
    public void excluir(Cliente cliente) throws Exception{
        // variável para armazenar a referência de PreparedStatement
        PreparedStatement ps = null;
        // verifica se cliente é nulo
        if(cliente == null){
            throw new Exception("Erro: cliente não pode ser nulo.");
        }
        try{
            // obtém instância de PreparedStatement
            ps = this.conn.prepareStatement("DELETE FROM clientes " +
                    "WHERE codigo=?");
            // configura a instrução
            ps.setInt(1, cliente.getCodigo());
            // executa a instrução
            ps.executeUpdate();
        }catch(SQLException sqlException){
            throw new Exception("Erro ao excluir dados: " +
                    sqlException.getMessage());
        }finally{
            ConnectionFactory.closeConnection(conn, ps);
        }
    }

    // método para listar os dados de todos Clientes
    public List todosClientes() throws Exception{
        // variável para armazenar a referência de PreparedStatement
        PreparedStatement ps = null;
        // variável para armazenar a referência de ResultSet
        ResultSet rs = null;
        try{
            // obtém instância e configura o PreparedStatement
            ps = this.conn.prepareStatement("SELECT * FROM clientes");
            // executa a instrução e armazena o resultado em ResultSet
            rs = ps.executeQuery();
            List<Cliente> lista = new ArrayList<Cliente>();
            while(rs.next()){
                Integer codigo = rs.getInt(1);
                String nome = rs.getString(2);
                String cpf = rs.getString(3);
                String telefone = rs.getString(4);
                // instancia um novo cliente e insere na lista
                lista.add(new Cliente(codigo,nome,cpf,telefone));
            }
            return lista;
        }catch(SQLException sqlException){
            throw new Exception("Erro ao consultar dados: " +
                    sqlException.getMessage());
        }finally{
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }

    // método para consultar clientes através do código
    public List listaCodigo(int codigo) throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = this.conn.prepareStatement("SELECT * FROM clientes WHERE codigo=?");
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            List<Cliente> lista = new ArrayList<Cliente>();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setCpf(rs.getString(3));
                cliente.setTelefone(rs.getString(4));
                lista.add(cliente);
            }
            return lista;
        }catch(SQLException sqlException){
            throw new Exception("Erro ao consultar dados: " +
                    sqlException);
        }finally{
            ConnectionFactory.closeConnection(conn, ps, rs);
        }

    }

    // método para consultar clientes através do código
    public List listaNome(String nomeConsulta) throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String SQL = "SELECT * FROM clientes WHERE lower(nome) like lower('" + nomeConsulta + "%')";
            ps = this.conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<Cliente> lista = new ArrayList<Cliente>();
            while(rs.next()){
                Integer codigo = rs.getInt(1);
                String nome = rs.getString(2);
                String cpf = rs.getString(3);
                String telefone = rs.getString(4);

                lista.add(new Cliente(codigo,nome,cpf,telefone));
            }
            return lista;
        }catch(SQLException sqlException){
            throw new Exception("Erro ao consultar dados: " +
                    sqlException);
        }finally{
            ConnectionFactory.closeConnection(conn, ps, rs);
        }

    }

    public int getUltimoCodigo() throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String SQL = "SELECT last_value FROM clientes_codigo_seq";
            ps = this.conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            int codigo = 0;
            if(rs.next()){
                codigo = rs.getInt(1);
            }
            return codigo;
        }catch(SQLException sqlException){
            throw new Exception("Erro ao consultar dados: " +
                    sqlException);
        }finally{
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
    }

}
