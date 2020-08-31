package cat;

import java.util.function.Function;

public abstract class Either<A, B> {
    public static class Left<A, B> extends Either<A, B> {
        public final A a;

        public Left(A a) {
            this.a = a;
        }

        @Override
        public <C> Either<A, C> map(Function<B, C> f) {
            return new Left<>(a);
        }

        @Override
        public <C> Either<A, C> flatMap(Function<B, Either<A, C>> f) {
            return new Left<>(a);
        }

        @Override
        public String toString() {
            return "Left{" +
                    "a=" + a +
                    "} " + super.toString();
        }
    }

    public static class Right<A, B> extends Either<A, B> {
        public final B b;

        public Right(B b) {
            this.b = b;
        }

        @Override
        public <C> Either<A, C> map(Function<B, C> f) {
            return new Right<>(f.apply(b));
        }

        @Override
        public <C> Either<A, C> flatMap(Function<B, Either<A, C>> f) {
            return f.apply(b);
        }

        @Override
        public String toString() {
            return "Right{" +
                    "b=" + b +
                    "} " + super.toString();
        }
    }

    public static <A, B> Either<A, B> right(B b) {
        return new Right<>(b);
    }

    public static <A, B> Either<A, B> left(A a) {
        return new Left<>(a);
    }

    public abstract <C> Either<A, C> map(Function<B, C> f);

    public abstract <C> Either<A, C> flatMap(Function<B, Either<A, C>> f);

    public static void main(String[] args) {
        var rootOfReciprocal = safeReciprocal(42)
        .flatMap((Function<Double, Either<String, Double>>) Either::safeSqrt);
        System.out.println(rootOfReciprocal);

        var wasZero = safeReciprocal(0)
                .flatMap((Function<Double, Either<String, Double>>) Either::safeSqrt);
        System.out.println(wasZero);

        var wasNegative = safeReciprocal(-1)
                .flatMap((Function<Double, Either<String, Double>>) Either::safeSqrt);
        System.out.println(wasNegative);
    }

    private static Either<String,Double> safeSqrt(Number n) {
        if (n.doubleValue() >= 0) return right(Math.sqrt(n.doubleValue()));
        else return left("Argument is negative");
    }

    private static Either<String,Double> safeReciprocal(Number n) {
        if (n.doubleValue() != 0) return right(1/n.doubleValue());
        else return left("Argument is zero");
    }
}
