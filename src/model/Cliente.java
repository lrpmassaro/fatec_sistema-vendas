/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Professor
 */
public class Cliente {

    private int codigo;
    private String nome;
    private String cpf;
    private String telefone;

    public Cliente() {
    }

    public Cliente(int codigo, String nome, String cpf, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
