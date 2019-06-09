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
public class Aluno {
    
    private int id;
    private String nome;
    private int idade;
    private int altura;
    private int peso;
    private int sexo;
    private String objetivo;

    public Aluno(String nome, int idade, int altura, int peso, int sexo, 
            String objetivo) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
        this.objetivo = objetivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    @Override
    public String toString() {
        return "Aluno{" + "nome = " + nome + ", idade = " + idade + 
                ", altura = " + altura + ", peso = " + peso + 
                ", sexo = " + sexo + ", objetivo = " + objetivo + '}';
    }
    
    
    
}
