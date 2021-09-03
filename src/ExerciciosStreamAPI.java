import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//obs.: .stream() nao altera lista

public class ExerciciosStreamAPI {
    public static void main(String[] args) {
        List<String> numerosAleatorios =
                Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("Imprima todos os elementos dessa lista de String: ");
        numerosAleatorios.stream()
                .forEach(System.out::println);
//        numerosAleatorios.forEach(System.out::println); mesma coisa, ocultando o .stream


        System.out.println("Pegue os 5 últimos primeiros e coloque dentro de um Set: "); //o numero repetido nao entrara no Set
        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("Transforme esta lista de String em uma lista de números inteiros: ");
        List<Integer> numerosAleatorios1 = numerosAleatorios.stream()
                .map(Integer::parseInt).collect(Collectors.toList());
        numerosAleatorios1.stream()
                .forEach(System.out::println);

        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista: ");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> i % 2 == 0 && i > 2)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("Mostre a lista na ordem numérica:");
        numerosAleatorios1.stream()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);

        System.out.println("Mostre a media dos números:");
//        numerosAleatorios.stream()
//                .average()
//                .ifPresent(System.out::println);

        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt) //converte valor por valor de string para int
                .average()                   //tenta criar uma media
                .ifPresent(System.out::println);  //se existir a media, realiza a ação, caso contraio, ignora, sem erro

        System.out.println("Remova os valores ímpares:");
        numerosAleatorios1.removeIf(integer -> integer % 2 != 0); //numerosAleatorios1 ja e uma lista de inteiros
        System.out.println(numerosAleatorios1);

//        para voce
        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante");
        numerosAleatorios.stream()
                .skip(3)
                .forEach(System.out::println);

        System.out.println("Retirando os números repetidos da lista, quantos números ficam?");
        long noRepeat = numerosAleatorios.stream()
                .distinct()
                .count();
        System.out.println(noRepeat);

        System.out.println("Mostre o menor valor da lista");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .min()
                .ifPresent(System.out::println);

        System.out.println("Mostre o maior valor da lista");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);

        System.out.println("Pegue apenas os números ímpares e some:");
        Integer soma = numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 != 0)
                .sum();
        System.out.println(soma);

        System.out.println("Agrupe os valores ímpares múltiplos de 3 e de 5:");
        Map<Boolean, List<Integer>> multiplos = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.groupingBy(n -> n % 5 == 0 || n % 3 == 0));
        System.out.println(multiplos);
//        dica: collect(Collectors.groupingBy(new Function());
    }
}