module Ch7 where

data Optional a = Nope | Really a deriving Show

instance Functor Optional where
  fmap _ _ = Nope

{-

Optional:

law #1: fmap id = id

fmap _  = \_ -> Nope
fmap id = \_ -> Nope
-> id /= \_ -> Nope -> does not obey law #1

Reader:

instance Functor (->) r where
  fmap = (.)
  fmap f fra = f . fra :: ((->) r b)

law #1: fmap id = id

fmap id ((->) r a) = (.) id ((->) r a)
                   = id . ((->) r a)
                   = ((->) r a)
=> fmap id x = x => fmap id = \x -> x = id

law #2: fmap (f . g) = (fmap f) . (fmap g)

f :: c -> b
g :: a -> c
(f . g) :: a -> b

x :: r -> a

fmap (f . g) x = (f . g) . x = f . g . x
(fmap f) . (fmap g) $ x = (fmap f) . (g . x) = f . g . x

List:

fmap id = id

fmap id [] = []
fmap id [h:t] = [(id h):fmap t] = [h: fmap t] = [h:t]

fmap (f.g) = (fmap f) . (fmap g)

fmap (f.g) [] = (fmap f) . (fmap g) $ [] = (fmap f) $ (fmap g) [] = (fmap f) [] = []
fmap (f.g) [h:t] = (fmap f) $ (fmap g) [h:t] = (fmap f) $ [g h: fmap g t] =
  [f.g h: (fmap f) (fmap g) t]

-}


