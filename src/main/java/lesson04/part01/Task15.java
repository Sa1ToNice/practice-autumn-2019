package lesson04.part01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

/**
 * Ввести с клавиатуры 10 чисел и заполнить ими список.
 * Вывести их в обратном порядке. Каждый элемент - с новой строки.
 * Использовать только цикл for.
 *
 * Подсказка:
 * Не забудь импортировать класс: java.util.ArrayList;
 *
 * Требования:
 * 1.	Объяви переменную типа список целых чисел и сразу проинициализируй ee.
 * 2.	Считай 10 целых чисел с клавиатуры и добавь их в список.
 * 3.	Выведи числа в обратном порядке.
 * 4.	Используй цикл for.
 */

public class Task15 {
  public static void main(String[] args) throws IOException {
    ArrayList<Integer> list = new ArrayList<>();
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 0; i < 10; i++) {
      list.add(parseInt(r.readLine()));
    }
    for (int i = list.size()-1; i >= 0; i--){
      System.out.println(list.get(i));
    }
    //напишите тут ваш код
  }
}