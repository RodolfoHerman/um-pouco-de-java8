package br.com.rodolfo.java8;

/**
 * Curso
 */
public class Curso {

    private String curso;
    private int alunos;

    public Curso(String curso, int alunos) {

        this.curso = curso;
        this.alunos = alunos;

    }

    /**
     * @return String return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @return int return the alunos
     */
    public int getAlunos() {
        return alunos;
    }

    @Override
    public String toString() {
        return curso + " \t\t\t " + alunos;
    }
    
}