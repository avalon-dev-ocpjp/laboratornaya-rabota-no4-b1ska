package ru.avalon.java.dev.ocpjp.labs;

import ru.avalon.java.dev.ocpjp.labs.models.Commodity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        final Collection<Commodity> commodities = Commodity.random(100);

        /*
         * TODO(Студент): С использованием Java Stream API выполнить задачи из списка:
         * 1. Выполнить поиск самого дорого товара
         * 2. Найти товары с минимальным остатком
         * 3. Найти товары с остатком меньшим 5 и вывести в консоль их названия
         * 4. Подсчитать общую стоимость товаров с учётом их остатка
         * 5. Найти товар, с самым длинным названием и вывести его на экран
         * 6. Выполнить сортировку коллекции commodities
         * 7. Найти среднюю стоимость товаров
         * 8. Найти моду (медиану) стоимости товаров
         */
        //1
        double max1 = commodities.stream()
                .map((x) -> x.getPrice())
                .max(Double::compare).get();

        System.out.println("Задание 1. Стоимость самого дорого товара: " + max1);

        //2
        System.out.println("");
        int min2 = commodities.stream()
                .map((x) -> x.getResidue())
                .min(Integer::compare).get();
        System.out.println("Задание 2. Минимальный остаток: " + min2);

        //3
        System.out.println("");
        List<Commodity> ProductsLessFiveResidue = commodities.stream()
                .filter(x -> (x.getResidue() < 5))
                .collect(Collectors.toList());

        System.out.println("Задание 3. Товары с остатком менее 5");
        ProductsLessFiveResidue.forEach((x) -> System.out.println(x.getName() + "остаток: " + x.getResidue()));

        //4
        System.out.println("");
        double totalPrice = commodities.stream()
                .mapToDouble((x) -> (x.getResidue() * x.getPrice()))
                .sum();
        System.out.println("Задание 4. Общая стоимость оставшегося товара: " + totalPrice);

        //5
        System.out.println("");
        String longetsName = commodities.stream()
                .map(Commodity::getName)
                .max(Comparator.comparingInt(String::length))
                .get();

        System.out.println("Задание 5. Товар с самым длинным названием: " + longetsName);

        //6
        System.out.println("");
        List<Commodity> sortProduts = commodities.stream()
                .sorted((x1, x2) -> String.valueOf(x1.getName()).compareTo(String.valueOf(x2.getName())))
                .collect(Collectors.toList());

        System.out.println("Задание 6. Отсортированный сипоск товаров:");
        sortProduts.forEach((x) -> System.out.println(x.getName()));

        //7 
        System.out.println("");
        double avPrice = commodities.stream()
                .mapToDouble(Commodity::getPrice)
                .average()
                .getAsDouble();
        System.out.println("Задание 7. Средня стоимость товара: " + avPrice);

        //8
        System.out.println("");

        double[] moda = commodities.stream()
                .mapToDouble(Commodity::getPrice)
                .sorted()
                .toArray();

        double mediana;
        if (moda.length % 2 == 0) {
            mediana = ((moda[(moda.length/2) - 1] + moda[moda.length/2])/2);
        } else {
            mediana = moda.length/2;
        }

        System.out.println("Задание 8. Медиана стоимости равна: " + mediana);

    }

}
