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
 * Classe que relaciona um aluno com um exercicio. É utilizada para representar
 * quais exercicios pertecem a um determinado aluno.
 */
public class AlunoExercicio {

    //identificação do aluno
    private int alunoId;

    //identificação do exercicio pertencente ao aluno
    private int exercicioId;

    public AlunoExercicio() {

    }

    //Getters e Setters
    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public int getExercicioId() {
        return exercicioId;
    }

    public void setExercicioId(int exercicioId) {
        this.exercicioId = exercicioId;
    }
}
