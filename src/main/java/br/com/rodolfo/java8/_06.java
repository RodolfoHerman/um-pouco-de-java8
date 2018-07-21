package br.com.rodolfo.java8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utilização da nova API de datas do Java 8
 */
public class _06 {

    public static void main(String[] args) {
        
        //Na API LocalDate existem vários método estáticos para se trabalhar com datas,
        //um exemploe é o método now() que busca a data de hoje.
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        //Especificando uma data
        LocalDate daqui2Anos = LocalDate.of(2020, Month.JUNE, 1);

        //Para saber a diferença entre duas data podemos utilizar a classe Period, que calcula a quantidade de anos, meses e dias
        //para alcançar a data requerida
        System.out.println("###### CALCULANDO O PERIODO ENTRE DUAS DATAS ########");
        Period periodo = Period.between(hoje, daqui2Anos);
        System.out.println(periodo);
        System.out.println(periodo.getYears());
        System.out.println(periodo.getMonths());
        System.out.println(periodo.getDays());
        
        //Para realizar operações com horas, minutos e segundos podemos utilizar o Duration
        System.out.println("###### CALCULANDO O PERÍODO DE TEMPO ########");
        Instant t1 = Instant.now();
        Duration t2 = Duration.ofSeconds(60);
        System.out.println(t1.plus(t2));


        //Incrementar e decremetar uma data qualquer
        System.out.println("###### INCREMENTAR E DECREMENTAR ########");
        System.out.println(hoje.minusYears(1));
        System.out.println(hoje.minusMonths(1));
        System.out.println(hoje.minusDays(1));
        System.out.println(hoje.minusWeeks(1));
        
        System.out.println(hoje.plusYears(1));
        System.out.println(hoje.plusMonths(1));
        System.out.println(hoje.plusDays(1));
        System.out.println(hoje.plusWeeks(1));
        
        //Obtendo o primeiro e o ultimo dia do mês
        System.out.println("####### PRIMEIRO DIA E O ULTIMO DIA DO MES #######");
        System.out.println(hoje.withDayOfMonth(1));
        System.out.println(hoje.withDayOfMonth(hoje.lengthOfMonth()));


        //A API LocalDate é imutável, ou seja, podemos realizar a operação no objeto mas ele não será alterado
        System.out.println("####### API IMUTAVEL #######");
        LocalDate hojeModificado = hoje.plusYears(2);
        System.out.println(hoje);
        System.out.println(hojeModificado);

        //Podemos realizar a formatação das datas com o DateTimeFormatter. 
        //Existem diversas formatações já prontas, mas pode-se construir a nossas próprias
        System.out.println("###### FORMATACAO DAS DATAS ########");
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(hoje.format(formatador));


        //Também podemos trabalhar com horas, minutos e segundos utilizando o LocalDateTime
        System.out.println("####### TRABALHANDO COM HORAS, MINUTOS e SEGUNDOS #######");
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora);
        
        //Criando um formatador para ver melhor o resultdao
        DateTimeFormatter formatador2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(agora.format(formatador2));
        
        //Existe os formatters padrao
        DateTimeFormatter padrao = DateTimeFormatter.ISO_TIME;
        System.out.println(agora.format(padrao));
        
        //O mais comum é querer trabalhar com ano e mês, para isso tem a YearMounth. Existem várias classes
        //no java 8 para tratar datas e tempo, em vez de criar as nossas pesquisar para adequar a necessidade é a melhor opção
        System.out.println("###### TRABALHANDO APENAS COM MES E ANO ########");
        YearMonth anoMes = YearMonth.now();
        System.out.println(anoMes);
        
        //Para trabalhar apenas com tempo podemos utilizar o LocalTime
        System.out.println("####### TRABALHANDO APENAS COM O TEMPO #######");
        LocalTime local = LocalTime.now();
        LocalTime local2 = LocalTime.of(15, 20);
        System.out.println(local);
        System.out.println(local2);
        
        //Trabalhando com Time Zone
        System.out.println("####### TRABALHANDO TIME ZONE #######");
        ZonedDateTime zoned = ZonedDateTime.now();
        System.out.println(zoned);

    }
    
}