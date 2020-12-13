factorizer :: (c -> a) -> (c -> b) -> (c -> (a, b))
factorizer p q = \x -> (p x, q x)


m :: Int -> (Int, Bool)
m x = (x, True)

p :: Int -> Int
p x = x

q :: Int -> Bool
q _ = True

Int -> (Int, Bool)
\x -> (x, True)


p :: (Int, Int, Bool) -> Int
p (x, _, _) = x

q :: (Int, Int, Bool) -> Bool
q (_, _, b) = b

m :: (Int, Int, Bool) -> (Int, Bool)
m (x, _, b) = (x, b)