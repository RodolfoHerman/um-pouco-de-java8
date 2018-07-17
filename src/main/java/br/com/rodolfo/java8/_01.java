package br.com.rodolfo.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Defaults métodos em Interfaces (Java 8)
 */
public class _01 {

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        
        List<String> lista = new ArrayList<String>();
        lista.add("Rodolfo");
        lista.add("Rafael");
        lista.add("Ana");

        Comparator<String> c = new ComparadorDeStringPorTamanho();

        //Consumer vem do Java 8
        Consumer<String> consumer = new ConsumidorDeStringsd();

        //Versões anteriores ao java 8
        //Collections.sort(lista, c);

        //Utilizando o sort do java 8
        lista.sort(c);

        // Iterar os elementos com versões anteriores 
        // for (String var : lista) {
        //     System.out.println(var);
        // }

        //Utilizando o forEach do java 8
        lista.forEach(consumer);
    }
}

class ComparadorDeStringPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
        
        if(s1.length() < s2.length())
            return -1;

        if(s1.length() > s2.length())
            return 1;

        return 0;
	}
    
}

class ConsumidorDeStringsd implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(t);
	}

}


