package cat.ch7;

import java.util.function.Function;

public class Reader {
    static <A,B,R> Function<R, B> fmap(Function<A, B> f, Function<R, A> ra) {
        return r -> f.apply(ra.apply(r));
    }

    public static void main(String[] args) {
        Function<Integer,String> f = Object::toString;
        Function<String,Integer> g = String::length;
        System.out.println(fmap(g, f).apply(42));
        System.out.println(fmap(f, g).apply("foo"));
    }
}
