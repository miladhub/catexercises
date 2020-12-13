module Chap6 where

data Shape = Circle Float
           | Rect Float Float
           | Square Float

area :: Shape -> Float
area (Circle r) = pi * r * r
area (Rect d h) = d * h
area (Square e) = e * e

circ :: Shape -> Float
circ (Circle r) = 2.0 * pi * r
circ (Rect d h) = 2.0 * (d + h)
circ (Square e) = 4 * e

-- Had to add the circ function only to add the circ function
-- Had to touch both functions to add a new shape