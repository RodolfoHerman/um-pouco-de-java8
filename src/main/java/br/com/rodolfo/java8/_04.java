package br.com.rodolfo.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Stream, trabalhando com as collections (Toda collection possui a interface Stream)
 */
public class _04 {

    public static void main(String[] args) {
     
        List<Curso> cursos = new ArrayList<Curso>();

        System.out.println("Curso \t\t\t Qtd");

        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java", 113));
        cursos.add(new Curso("C", 55));

        //Ordernar os cursos adotando um critério
        cursos.sort(Comparator.comparing(Curso::getAlunos));
        //cursos.forEach(System.out::println);

        //Imprimir todos os cursos que possue mais de 100 alunos
        //cursos.stream().filter(c -> c.getAlunos() >= 100)
        //    .forEach(System.out::println);

        //Quantos alunos possue em cada curso. dado um stream curso quero mapea-lo para integers e imprimir
        cursos.stream().filter(c -> c.getAlunos() >= 100)
            //.map(curso -> curso.getAlunos())
            .map(Curso::getAlunos)
            .forEach(System.out::println);

        //Trabalhando de forma mais interessante com o mapToInt
        int sum = cursos.stream().filter(c -> c.getAlunos() >= 100)
            //mapToItn para trabalhor com os tipos primitivos e evitar o boxing e unboxing desses tipos (aumento de performance)
            //Além disso há novos método para se trabalhar com os inteiros -> min(), max(), average()....
            .mapToInt(Curso::getAlunos)
            //.min();
            //.max();
            //.average().getAsDouble();
            .sum();

        System.out.println(sum);
        
    }
}
