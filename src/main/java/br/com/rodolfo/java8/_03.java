package br.com.rodolfo.java8;

import java.util.ArrayList;
//Import static (assim n precisamos chamar a classe do obejto, somente sua classe)
//import static java.util.Comparator.*;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Methods references serve para escrever expressões LAMBDAS de forma mais enxuta e clara
 */
public class _03 {

    public static void main(String[] args) {
        
        List<String> lista = new ArrayList<String>();
        lista.add("Rodolfo");
        lista.add("Rafael");
        lista.add("Ana");

        lista.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        lista.sort((s1, s2) -> s1.length() - s2.length());

        //Method References
        
        //Em lista ordernar dado uma string 's' queremos comparar o seu 'length'
        lista.sort(Comparator.comparing(s -> s.length()));
        //utilizando o import static
        //lista.sort(comparing(s -> s.length()));
        
        //Extraindo a 'Funcion' que é recebida como parâmetro no comparator.
        //Dado um string quero avaliar o seu tamanho
        Function<String, Integer> function = s -> s.length();
        lista.sort(Comparator.comparing(function));

        //Criando com uma classe anonima
        Function<String, Integer> function2 = new Function<String,Integer>() {
			@Override
			public Integer apply(String t) {
				return t.length();
			}
        };

        Comparator<String> comparator2 = Comparator.comparing(function2);
        lista.sort(comparator2);


        //Extraindo o comparator para passar como parâmetro
        Comparator<String> comparator = Comparator.comparing(s -> s.length());
        lista.sort(comparator);

        //########################################
        //########################################

        //Forma usual no dia a dia
        lista.sort(Comparator.comparing(s -> s.length()));

        //Obs: Lambda pode ser traduzido como -> dado um objeto invocar o método do objeto

        //Como existe apenas um método a ser executado no método pode-se reduzir o código.
        //Realizar a chamada 'quero que me retorne o tamanho da string'
        lista.sort(Comparator.comparing(String::length));

        lista.sort(String.CASE_INSENSITIVE_ORDER);

        //Outra forma de visualizar. Dado uma String quero o seu tamanho
        Function<String, Integer> function3 = String::length;

        //ForEach lambda tradicional. Dada uma String, invoque o System.out.println passando-a como argumento.
        lista.forEach(s -> System.out.println(s));
        
        //Utilizando o Method Reference para o println. O método reference vira um lambda
        lista.forEach(System.out::println);

        //Passando para o Consumer
        Consumer<String> consumer = System.out::println;
        lista.forEach(consumer);

        //Quando usar lambda e quando usar method reference? Algumas vezes não é possível usar method references. 
        //Se você tiver, por exemplo, um lambda que dada uma String, 
        //pega os 5 primeiros caracteres,faríamos s -> s.substring(0, 5). 
        //Esse lambda não pode ser escrito como method reference! 
        //Pois não é uma simples invocação de métodos onde os parâmetros são os mesmos que os do lambda.

    }


}