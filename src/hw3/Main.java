package hw3;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.*;
import java.util.function.IntFunction;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList(
                 "огонь", "звезда", "дерево", "тигр", "тигр",
                "светофор", "санки", "огонь", "санки", "дерево",
                "звезда", "таз", "таз", "светофор", "санки",
                "тигр", "тигр", "звезда", "огонь", "тигр"
                ));

        System.out.println(list);
        Set<String> set = new HashSet<>(list);
        System.out.println(set);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Integer value = map.getOrDefault(list.get(i), 0);
            map.put(list.get(i), value + 1);
        }

        System.out.println(map);





        class telephoneDirectory{
            private String name;
            private Integer telephone;

            public telephoneDirectory(String name, Integer telephone) {
                this.name = name;
                this.telephone = telephone;
            }

            @Override
            public String toString() {
                return "Телефон из справочника на фамилию " + name + " - " + telephone;
            }

        }

        List<telephoneDirectory> telephone = new ArrayList<>(Arrays.asList(
                new telephoneDirectory("Petrov", 31220),
                new telephoneDirectory("Ivanov", 40020),
                new telephoneDirectory("Sidorov", 78002),
                new telephoneDirectory("Petrov", 31111),
                new telephoneDirectory("Kuznetsov", 22233),
                new telephoneDirectory("Ivanov", 88898)
        ));

        telephone.add(new telephoneDirectory("Andreev", 55869));
        System.out.println(telephone.get(6));






    }
}
