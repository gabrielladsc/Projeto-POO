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
    private String serie;
    private String repeticoes;

    public Exercicio(String nome, String series, String repeticoes) {
        this.nome = nome;
        this.serie = series;
        this.repeticoes = repeticoes;
    }
    
    public Exercicio() {
        
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
    
    @Override
    public String toString() {
        return "Exercicio {" + "nome = " + nome + ", series = " + serie + 
                ", repeticoes = " + repeticoes + '}';
    }   
}
