import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BijectionGroup<T> implements Group<Function<T,T>>{
    private final Set<T> domain;
    public BijectionGroup(Set<T> domain) {
        this.domain = domain;
    }
    @Override
    public Function<T, T> binaryOperation(Function<T, T> one, Function<T, T> other) {
        return one.compose(other);
    }

    @Override
    public Function<T, T> identity() {
        return t -> t;
    }

    @Override
    public Function<T, T> inverseOf(Function<T, T> t) {
        Map<T, T> inverseMap = new HashMap<>();
        for (T elem : domain) {
            inverseMap.put(t.apply(elem), elem);
        }
        return (key -> inverseMap.get(key) );
    }

    public static <T> BijectionGroup<T> bijectionGroup(Set<T> domain) {
        return new BijectionGroup<>(domain);
    }

    public static <T> Set<Function<T, T>> bijectionsOf(Set<T> domain) {
        List<T> domainList = new ArrayList<>(domain);
        List<List<T>> permutations = generatePermutations(domainList,0);
        Set<Function<T, T>> bijections = new HashSet<>();

        for (List<T> permutation : permutations) {
            Map<T, T> mapping = new HashMap<>();
            for (int i = 0; i < domainList.size(); i++) {
                mapping.put(domainList.get(i), permutation.get(i));
            }
            bijections.add(mapping::get);
        }
        return bijections;
    }

    private static <T> List<List<T>> generatePermutations(List<T> list, int index ) {
        if (index == list.size() - 1) {
            return Collections.singletonList(new ArrayList<>(list));
        }
        List<List<T>> result = new ArrayList<>();

        for (int i = index; i < list.size(); i++) {
            Collections.swap(list, index, i);
            result.addAll(generatePermutations(list, index + 1));
            Collections.swap(list, index, i);
        }
        return result;
    }



    public static <T> void main(String... args) {

        Set<Integer> a_few = Stream.of(1, 2, 3).collect(Collectors.toSet());
// you have to figure out the data type in the line below
        Set<Function<Integer,Integer>> bijections = bijectionsOf(a_few);
        bijections.forEach(aBijection -> {
            a_few.forEach(n -> System.out.printf("%d --> %d; ", n, aBijection.apply(n)));
            System.out.println();
        });

        System.out.println("----------------------");
        BijectionGroup<Integer> g = bijectionGroup(a_few);
        Function<Integer, Integer> f1 = bijections.stream().skip(1).findFirst().get();
        Function<Integer, Integer> f2 = g.inverseOf(f1);
        Function<Integer, Integer> id = g.identity();


        a_few.forEach(n -> System.out.printf("%d --> %d; ", n, f1.apply(n)));
        System.out.println();


        a_few.forEach(n -> System.out.printf("%d --> %d; ", n, f2.apply(n)));
        System.out.println();

        a_few.forEach(n -> System.out.printf("%d --> %d; ", n, id.apply(n)));
        System.out.println();


    }



}

