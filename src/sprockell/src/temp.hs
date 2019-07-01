import Sprockell

--	Bool a = true; while a {OutNumber 10;a = false;} OutNumber 5;
prog :: [Instruction]
prog = [
{-0-}		Load (ImmValue 1) 2	{-  loaded true  -},
{-1-}		Store 2 (DirAddr 0)	{-  declLine: varname: a stored at 0 types: [1] expr: true  -},
{-2-}		Load (DirAddr 0) 2,
{-3-}		Load (ImmValue 1) 3,
{-4-}		Compute Xor 3 2 2,
{-5-}		Branch 2 (Rel 6)	{- start while loop -},
{-6-}		Load (ImmValue 10) 2	{-  loaded integer 10  -},
{-7-}		WriteInstr 2 numberIO	{-  end OutNumber  -},
{-8-}		Load (ImmValue 0) 2	{-  loaded false  -},
{-9-}		Store 2 (DirAddr 0)	{-  asgnline: varname: a overwritten at heaploc 0 types: [1] expr: false  -},
{-10-}		Jump (Rel (-8) )	{-  jump back to start of while loop  -},
{-11-}		Nop	{-  after while  -},
{-12-}		Load (ImmValue 5) 2	{-  loaded integer 5  -},
{-13-}		WriteInstr 2 numberIO	{-  end OutNumber  -}
			,EndProg
	]
main = run [prog]
