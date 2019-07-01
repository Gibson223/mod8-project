import Sprockell

--	Int b; Int c; if true {b = 10;} else {c = 20;}OutNumber b;
prog :: [Instruction]
prog = [
{-0-}		Load (ImmValue 1) 2	{-  loaded true  -},
{-1-}		Load (ImmValue 1) 3,
{-2-}		Compute Xor 3 2 2,
{-3-}		Branch 2 (Rel 4)	{- no if/elif conditional jump-},
{-4-}		Load (ImmValue 10) 2	{-  loaded integer 10  -},
{-5-}		Store 2 (DirAddr 0)	{-  asgnline: varname: b overwritten at heaploc 0 types: [0] expr: 10  -},
{-6-}		Jump (Rel 3)			{- Jump to after if, elif and else statements -},
{-7-}		Load (ImmValue 20) 2	{-  loaded integer 20  -},
{-8-}		Store 2 (DirAddr 1)	{-  asgnline: varname: c overwritten at heaploc 1 types: [0] expr: 20  -},
{-9-}		Nop,
{-10-}		Load (DirAddr 0) 2,
{-11-}		WriteInstr 2 numberIO	{-  end OutNumber  -}
			,EndProg
	]
main = run [prog]
