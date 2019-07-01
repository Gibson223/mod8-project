import Sprockell

--	Int a = true; if a {OutNumber 5} else {OutNumber 10}
prog :: [Instruction]
prog = [
{-0-}		Load (ImmValue 1) 2	{-  loaded true  -},
{-1-}		Store 2 (DirAddr 0)	{-  declLine: varname: a stored at 0 types: [0] expr: true  -},
{-2-}		Load (DirAddr 0) 2,
{-3-}		Load (ImmValue 1) 3,
{-4-}		Compute Xor 3 2 2,
{-5-}		Branch 2 (Abs 9)	{- if/elif -},
{-6-}		Load (ImmValue 5) 3	{-  loaded integer 5  -},
{-7-}		WriteInstr 3 numberIO	{-  end OutNumber  -},
{-8-}		Jump (Abs 11)			{- Jump to after if, elif and else statements -},
{-9-}		Load (ImmValue 10) 2	{-  loaded integer 10  -},
{-10-}		WriteInstr 2 numberIO	{-  end OutNumber  -},
{-11-}		Nop
			,EndProg
	]
main = run [prog]
