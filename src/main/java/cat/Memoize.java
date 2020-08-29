package cat;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Memoize {
    public static <A,B> Function<A,B> memoize(Function<A,B> f) {
        Map<A, B> values = new HashMap<>();
        return a -> {
            if (values.containsKey(a)) {
                return values.get(a);
            } else {
                B b = f.apply(a);
                values.put(a, b);
                return b;
            }
        };
    }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println(lengthy(42));
        System.out.println(lengthy(42));
        System.out.println(lengthy(42));
        System.out.println("Normal: " + (System.currentTimeMillis() - t1));
        Function<Integer, Integer> memoized = memoize(Memoize::lengthy);

        t1 = System.currentTimeMillis();
        System.out.println(memoized.apply(42));
        System.out.println(memoized.apply(42));
        System.out.println(memoized.apply(42));
        System.out.println("Memoized: " + (System.currentTimeMillis() - t1));
    }

    private static int lengthy(int x) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return x + 1;
    }

    public static Integer random(Void v) {
      return new java.util.Random().nextInt();
    }

    public static Integer randomSeed(Integer seed) {
      return new java.util.Random(seed).nextInt();
    }
}
