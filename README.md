# Chapter 1

Category

* objects
* morphism
* compose: if A is connected to B and B to C, there must be a morphism from A to C such that
    * associativity: (f . g) . h === f . (g . h)
    * for every object A, there is a morphism id (idA) such that
        * id . f === f and f . id === f

## 1, 2, 3

See class `Composition`.

## 4

WWW

* objects: URIs
* morphisms: links
* id: link to self?

NOT a category, it does not compose: if A is linked with B and B to C, A is not necessarily linked to C.
    
### 5

Facebook

* objects: People
* morphisms: Friendships
* id?

NOT a category, it does not compose: if A is friend with B and B with C, it doesn't mean A is friend with C.

### 6

A directed graph is a category IFF each node has an self-arrow and for every arrow A->B and B->C, A->C exists.

# Chapter 2

## 1

See class `Memoize`.

## 2

No.

    $ mvn com.github.johnpoth:jshell-maven-plugin:1.3:run -Djshell.options="--enable-preview"
    
    jshell> import cat.*

    jshell> var f = Memoize.memoize(Memoize::random)
    f ==> cat.Memoize$$Lambda$28/0x0000000800b7a040@5910e440
    
    ...
    
    jshell> f.apply(null)
    $11 ==> 2016009553

    jshell> f.apply(null)
    $12 ==> 2016009553

    jshell> f.apply(null)
    $13 ==> 2016009553

## 3

No.

    jshell> var f = Memoize.memoize(Memoize::randomSeed)
    f ==> cat.Memoize$$Lambda$28/0x0000000800b7a040@5910e440

    jshell> f.apply(42)
    $3 ==> -1170105035

    jshell> f.apply(42)
    $4 ==> -1170105035

    jshell> f.apply(42)
    $5 ==> -1170105035

    jshell> f.apply(42)
    $6 ==> -1170105035

    jshell> f.apply(43)
    $7 ==> -1170489784

    jshell> f.apply(43)
    $8 ==> -1170489784

    jshell> f.apply(43)
    $9 ==> -1170489784

## 4

Only 1 is pure.

## 5

There are 2^2 functions, 4. In general, given sets A and B
there are B^A pure functions between them.

The functions are
  * id
  * not - not True = False, not False = True
  * true - true _ = True
  * false - false _ = False

## 6

See `ch2_ex6.png`.
