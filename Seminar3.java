import java.util.Random;

import linkedlist.LinkedList;

/**
 * Seminar3
 * Все задания реализованы в классе LinkedList.
 */
public class Seminar3 {

    public static void main(String[] args) {
        var linkedList = createRandomLinkedList(1, 100, 10);
        System.out.printf("%s\n %s\n", "Задан случайный односвязный список:", linkedListToString(linkedList));
        linkedList.reverse();
        System.out.printf("%s\n %s\n", "Результат после разворота списка:", linkedListToString(linkedList));
        int nvalue = linkedList.getEnd(2);
        System.out.printf("%s\n %s\n", "Элемент с индексом 2 с конца списка:", nvalue);
    }

    // Создать односвязный список размером size, заполненный случайными числами в
    // диапазоне от min до max.
    private static LinkedList<Integer> createRandomLinkedList(int min, int max, int size) {
        var randLinkedList = new LinkedList<Integer>();
        var rand = new Random();
        for (int i = 0; i < size; i++)
            randLinkedList.add(rand.nextInt(min, max));
        return randLinkedList;
    }

    // Создать строковое представление связного списка linkedList.
    private static String linkedListToString(LinkedList<Integer> linkedList) {
        var builder = new StringBuilder("[");
        for (int node : linkedList)
            builder.append(String.format("%d%s", node, ","));
        builder.setCharAt(builder.length() - 1, ']');
        return builder.toString();
    }
}
