/*
 * Classe para obter e fechar conexão com o BD.
 */

package util;

import java.sql.*;

public class ConnectionFactory {
    // declaração de variáveis de classe
    private static String host = "localhost";
    private static String database = "sistema_controle_vendas";
    private static String usuario = "postgres";
    private static String senha = "lm";
    private static String url = "jdbc:postgresql://" +
            host + "/" + database;

    // método para obter a conexão
    public static Connection getConnection() throws Exception{
        try{
            // carrega a definição de classe para o driver
            // do BD
            Class.forName("org.postgresql.Driver");
            // obter e retorna a conexão
            return DriverManager.getConnection(url,
                    usuario, senha);
        }catch(Exception exception){
            throw new Exception(exception.getMessage());
        }
    }

    // método para fechar a conexão com 3 parâmetros
    public static void closeConnection(Connection conn,
            Statement stmt, ResultSet rs) throws Exception{
        close(conn, stmt, rs);
    }

    // método para fechar a conexão com 2 parâmetros
    public static void closeConnection(Connection conn,
            Statement stmt) throws Exception {
        close(conn, stmt, null);
    }

    // método para fechar a conexão com 1 parâmetro
    public static void closeConnection(Connection conn)
            throws Exception {
        close(conn, null, null);
    }

    // método privado para fechar a conexão
    private static void close(Connection conn, Statement stmt,
            ResultSet rs) throws Exception {
        try{
            if(rs != null){
                rs.close();
            }
            if(stmt != null){
                stmt.close();
            }
            if(conn != null){
                conn.close();
            }
        }catch(Exception exception){
            throw new Exception(exception.getMessage());
        }
    }

}
