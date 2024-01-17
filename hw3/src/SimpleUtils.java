import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class SimpleUtils {
    public static <T extends Comparable<T>> T least(Collection<T> items, boolean from_start){

        return items.stream()
                .reduce((a, b) -> (from_start && a.compareTo(b) <= 0) || (!from_start && a.compareTo(b) < 0) ? a : b)
                .orElse(null);
    }
    public static <K, V> List<String> flatten(Map<K, V> aMap){

        return aMap.entrySet().stream()
                .map(entry -> entry.getKey() + " -> " + entry.getValue())
                .collect(Collectors.toList());
    };

    public static void main(String...args){
        List<Integer> numbers = Arrays.asList(5, 10, 9, 3, 7, 3);
        List<String> strings = Arrays.asList("ae", "ba", "o", "ba", "at");

        /*List<Person> person_list = Arrays.asList(
                new Person("Naxy_1", 19),
                new Person("Maxwell_1", 20),
                new Person("Naxy_2", 19),
                new Person("Howard", 21)
        );
        Person p = least(person_list,true);
        System.out.println(p);
        Person p2 = least(person_list,false);
        System.out.println(p2);*/

        System.out.println(least(numbers,true));
        System.out.println(least(strings,false));


        HashMap<Integer, String> h = new HashMap<>();
        h.put(1, "a");
        h.put(2, "aa");
        h.put(3, "aaa");
        System.out.println((flatten(h)));
    }
}
/*
class Person implements Comparable<Person> {
    String name;
    int age;

    Person(String s, int i) {
        name = s;
        age = i;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}*/
