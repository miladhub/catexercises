module Chap4 where

data Optional a = None | Some a deriving (Eq, Show)

compose :: (a -> Optional b) -> (b -> Optional c) -> (a -> Optional c)
compose fa fb = \a ->
  case fa a of
    None -> None
    Some b -> fb b

safeRoot a =
  if (a > 0) then Some (sqrt a)
  else None

safeReciprocal a =
  if (a == 0) then None
  else Some (1/a)

safeRootReciprocal = compose safeReciprocal safeRoot

