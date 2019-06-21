/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author gabi0
 *
 * Classe para guardar os dados dos alunos.
 */
public class Aluno {

    //identificação do aluno na banco de dados
    private int id;

    //identificação do instrutor responsável pelo aluno
    private int instrutorId;

    // atributos específicos de cada aluno
    private String nome;
    private String idade;
    private String altura;
    private String peso;
    private int sexo;
    private String objetivo;

    public Aluno(String nome, String idade, String altura, String peso, int sexo,
            String objetivo) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
        this.objetivo = objetivo;
    }

    public Aluno() {

    }

    //Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInstrutorId() {
        return instrutorId;
    }

    public void setInstrutorId(int instrutorId) {
        this.instrutorId = instrutorId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
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
}
