package experiments;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Andrey Klyuev on 29/09/2020.
 */
public class Main {

  public static void main(String[] args) {
//    final List<String> collect = IntStream.rangeClosed(1, 10).mapToObj(i -> i + "").collect(Collectors.toList());
//    System.out.println(collect);
//    collect.forEach(s -> System.out.print(s + " "));

//    final List<Integer> collect = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
//    collect.removeIf(i -> i > 5);
//    collect.forEach(System.out::println);

    Map <String, String> books = new HashMap<>();
    books.put("Война и мир", "Лев Толстой");
    books.put("Преступление и наказание", "Федор Достоевский");
    books.put("Философия Java", "Брюс Эккель");
    books.put("Братья Карамазовы", "Федор Достоевский");
    books.put("Властелин Колец", "Джон Толкин");

    System.out.println(books.compute("Философия Java", (key, value) -> key + " " + value));;
    System.out.println(books);

    System.out.println(books.computeIfAbsent("Гарри Поттер и узник Азкабан", value -> "Джоан Роулинг"));;
    System.out.println(books);
    books.computeIfPresent("Философия Java", (key, value) -> "");
    System.out.println(books.getOrDefault("Гарри Поттер и узник Азкабан", "default"));
    System.out.println(books.getOrDefault("Гарри Поттер и узник Аз", "default"));
    books.merge("Гарри Поттер и узник Азкабан", "Джоан Роулинг", (key, value) -> "   ");
    books.get("Гарри Поттер и узник Азкабан");

    books.replaceAll((key, value) -> "");
    System.out.println(books);
  }
}
