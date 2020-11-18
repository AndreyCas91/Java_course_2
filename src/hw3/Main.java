package hw3;

import java.util.*;

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


        System.out.println();


        class TelephoneDirectory {
            private ArrayList telephoneDirectories;
            private String name;
            private Integer telephone;

            public TelephoneDirectory() {
            }

            public TelephoneDirectory(String name, Integer telephone) {
                this.name = name;
                this.telephone = telephone;
            }

            @Override
            public String toString() {
                return name;
            }

            public void addArr(){
                telephoneDirectories = new ArrayList<>();
            }

            public void add(String s, int i){
//
                telephoneDirectories.add(new TelephoneDirectory(s, i));
            }

//          Пробовал переопределить get. Пытолся через for пройтись по Листу и сравнить значения через переопределенный
//            toString. не вышло

//            public void get(String s){
//                Object[] n = new Object[telephoneDirectories.size()];
//                telephoneDirectories.toArray(n);
//                Object t = (Object) s;
//                System.out.println(n[1].equals(s));
//                for (int i = 0; i < telephoneDirectories.size(); i++) {
//                    if(s.equals(n[i])){
//                        System.out.println("ghbdtn");
//                    }
//                }
//            }
        }


        TelephoneDirectory te = new TelephoneDirectory();
        te.addArr();
        te.add("Petrov", 31220);
        te.add("Ivanov", 40020);
        te.add("Sidorov", 78002);
        te.add("Petrov", 31111);
        te.add("Kuznetsov", 22233);
        te.add("Ivanov", 88898);



    }

    void add(){

    }


}
