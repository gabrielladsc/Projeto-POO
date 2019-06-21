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
 * Classe para guardar os dados dos exercicios.
 */
public class Exercicio {

    //Identificaçãoo do exercício no banco de dados
    private int id;

    //Atributos específicos do exercício
    private String nome;
    private String serie;
    private String repeticoes;

    public Exercicio(String nome, String series, String repeticoes) {
        this.nome = nome;
        this.serie = series;
        this.repeticoes = repeticoes;
    }

    public Exercicio() {

    }

    //Getters e setters
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

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(String repeticoes) {
        this.repeticoes = repeticoes;
    }
}
