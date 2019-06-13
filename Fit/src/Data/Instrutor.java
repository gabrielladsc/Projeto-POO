/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Guilherme
 */
public class Instrutor {

    private int id;
    private String nome;
    private String senha;
    private boolean logado = false;

    public Instrutor(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Instrutor() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }
    
    

    @Override
    public String toString() {
        return "Instrutor{" + "nome = " + nome + ", senha = " + senha + '}';
    }
}
