package cat.ch5;

import java.util.function.Function;

public class Composition {
    public static <T> T id(T t) {
        return t;
    }

    public static <A, B, C> Function<A, C> comp(Function<A, B> g, Function<B, C> f) {
        return a -> f.apply(g.apply(a));
    }

    public static void main(String[] args) {
        Function<Integer, Integer> g = (Integer x) -> x + 1;
        Function<Integer, Integer> h = comp(Composition::id, g);
        System.out.println(h.apply(42));
        Function<Integer, Integer> h2 = comp(g, Composition::id);
        System.out.println(h2.apply(42));
    }
}