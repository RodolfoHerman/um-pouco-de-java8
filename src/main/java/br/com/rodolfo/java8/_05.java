package br.com.rodolfo.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Os Streams possibilitam trabalhar com dados de uma maneira funcional. Normalmente, são dados e objetos que vêm de uma collection do Java.
 */
public class _05 {

    public static void main(String[] args) {
        
        List<Curso> cursos = new ArrayList<Curso>();

        System.out.println("Curso \t\t\t Qtd");

        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java", 113));
        cursos.add(new Curso("C", 55));


        // Optional<Curso> optionalCurso = cursos.stream()
        //     .filter(c -> c.getAlunos() >= 100)
        //     //encontra qualquer curso dos filtrados acima e o retorna
        //     .findAny()
        //     .ifPresent(System.out::println);

        //O orElse retorna o 'Curso' ou qauqluer o null que foi passado como paraêmtro
        //poderia passar um new Curso para voltar uma instancia em vez de null
        //Curso curso = optionalCurso.orElse(null);

        //Realizando toda a opração em apenas uma linha
        cursos.stream()
            .filter(c -> c.getAlunos() >= 100)
            //Pegar o primero elemento do filtro
            //.findFirst()
            //Pegar qualquer um elemento dentro do filtro
            .findAny()
            .ifPresent(System.out::println);

        //Transformando uma Stream para uma Colection

        //Transofmrando em um List
        List<Curso> lista = cursos.stream()
            .filter(c -> c.getAlunos() >= 100)
            //Coleta os dados filtrados e os insere em uma Lista e retorna a Lista
            //A interface Collectors é cheia de factory methods um deles é o toList()
            .collect(Collectors.toList());


        //Transformando em um Map
        Map<String, Integer> mapa = cursos.stream()
            .filter(c -> c.getAlunos() >= 100)
            .collect(Collectors.toMap(
                //A chave do mapa é o nome do curso e o valor é a qtd de alunos
                Curso::getCurso, 
                Curso::getAlunos));

        System.out.println(mapa);

        //O Map possui novos métodos também, por exemplo o forEach
        cursos.stream()
        .filter(c -> c.getAlunos() >= 100)
        .collect(Collectors.toMap(
            //A chave do mapa é o nome do curso e o valor é a qtd de alunos
            Curso::getCurso, 
            Curso::getAlunos))
        .forEach((nome, qtdAlunos) -> System.out.println(nome + " tem : " + qtdAlunos + " alunos"));         
       
        //Calculando a média de alunos por curso
        cursos.stream()
            .mapToInt(c -> c.getAlunos())
            .average()
            .ifPresent(System.out::println);
        
        //Realizando Joins
        List<String> nomes = new ArrayList<>(Arrays.asList("Rodolfo", "Herman", "Lara", "e", "Silva"));
        String nome = nomes.stream().collect(Collectors.joining(" "));
        System.out.println(nome);

        //Realizando Reduce
        List<Integer> numeros = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        //int soma = numeros.stream().reduce(0, (x, y) -> x + y);
        int soma = numeros.stream().reduce(0, Integer::sum);
        System.out.println(soma);

        //Pegando o max de uma collection
        numeros.stream().mapToInt(Integer::intValue).max().ifPresent(System.out::println);
        numeros.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);

        //Temos os tipos primitivos, como: integer, double... E temos a declaração dos optionals
        //Optional<Double> e OptionalDouble, a melhor opção é o OptionalDouble pois com o Optional<Double>
        //irá fazer o autoboxing dos doubles e isso utilizará mais recursos da JVM
    }
    
}