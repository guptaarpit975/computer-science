package edx.georgiatech;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");

        list.stream().forEach(System.out::println);

        list.remove(1);
        list.stream().forEach(System.out::println);
    }
}
