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
public class Exercicio {
    
    private int id;
    private String nome;
    private String series;
    private String repeticoes;

    public Exercicio(String nome, String series, String repeticoes) {
        this.nome = nome;
        this.series = series;
        this.repeticoes = repeticoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(String repeticoes) {
        this.repeticoes = repeticoes;
    }
    
    @Override
    public String toString() {
        return "Exercicio {" + "nome = " + nome + ", series = " + series + 
                ", repeticoes = " + repeticoes + '}';
    }   
}
