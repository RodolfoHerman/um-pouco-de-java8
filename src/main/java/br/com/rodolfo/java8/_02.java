package br.com.rodolfo.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Utilizando expressão LAMBDA em vez de criar classes anônimas
 */
public class _02 {

    
    public static void main(String[] args) {
     
        List<String> lista = new ArrayList<String>();
        lista.add("Rodolfo");
        lista.add("Rafael");
        lista.add("Ana");

        //Classes anônimas
        Consumer<String> consumer = new Consumer<String>() {

            @Override
            public void accept(String t) {
                System.out.println(t);
            }
        
        };

        //utilizando a expressão lambda para contruir um Consumer.
        //Obs é necessário que a classe tenha uma interface funcional para utilizar o lambda.
        Consumer<String> consumer2 = s -> System.out.println(s);

        lista.forEach(consumer);
        lista.forEach(consumer2);

        //Classes anônimas passando por parâmetros
        lista.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
        });

        //Expressão lambda Java 8 (reduzindo códigos)
        lista.forEach((String t) -> {
            System.out.println(t);
        });

        //Reduzindo ainda mais o código da expressão lambda (conceito arrow function javascript)
        lista.forEach(t -> System.out.println(t));

        //####################################################################################
        //####################################################################################

        //Classes anônimas passando por parâmetros
        lista.sort(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if(s1.length() < s2.length())
                    return -1;

                if(s1.length() > s2.length())
                    return 1;

                return 0;
            }
        });

        //Expressão lambda Java 8 (reduzindo códigos). 
        //Labmda só funciona em interfaces com 1 método abstrato (Interface funcional, apenas um método abstrato)
        lista.sort((s1, s2) -> {
            if(s1.length() < s2.length())
                return -1;

            if(s1.length() > s2.length())
                return 1;

            return 0;
        });

        //Melhorando o sort do lambda
        lista.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

    }


}