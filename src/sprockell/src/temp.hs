import Sprockell

--	Int b = 3;while b > 0 {   OutNumber b;    b = b-1;} 


prog0 :: [Instruction]

prog0 = [
{-0-}		Load (ImmValue (-1)) regA,
{-1-}		WriteInstr regA (DirAddr 2),
{-2-}		WriteInstr regA (DirAddr 6),
{-3-}		Load (ImmValue 3) 2	{-  loaded integer 3  -},
{-4-}		Store 2 (DirAddr 1)	{-  declLine: varname: b stored at 1 types: [0] expr: 3  -},
{-5-}		Load (DirAddr 1) 2,
{-6-}		Load (ImmValue 0) 3	{-  loaded integer 0  -},
{-7-}		Compute Gt  2 3 2,
{-8-}		Load (ImmValue 1) 3,
{-9-}		Compute Xor 3 2 2,
{-10-}		Branch 2 (Rel 8)	{- start while loop -},
{-11-}		Load (DirAddr 1) 2,
{-12-}		WriteInstr 2 numberIO	{-  end OutNumber  -},
{-13-}		Load (DirAddr 1) 2,
{-14-}		Load (ImmValue 1) 3	{-  loaded integer 1  -},
{-15-}		Compute Sub 2 3 2,
{-16-}		Store 2(DirAddr 1)	{-  asgnline: varname: b overwritten at heaploc 1 types: [0] expr: b-1  -},
{-17-}		Jump (Rel (-12) )	{-  jump back to start of while loop  -},
{-18-}		Nop	{-  after while  -},
{-19-}		
			Nop	{-  start of terminateAllNotStartedPrograms  -},
{-20-}		

			Load (ImmValue (1)) 2	{-  start writeImmToShared  -},
{-21-}		WriteInstr 2 (DirAddr 4),
			EndProg
		]
main = run [prog0]


main2 = runWithDebugger (debuggerSimplePrintAndWait myShow) [prog0]

main3 = runWithDebugger (debuggerPrintCondWaitCond showLocalMem doesLocalMemWrite never) [prog0]

showLocalMem :: DbgInput -> String
showLocalMem ( _ , systemState ) = show $ localMem $ head $ sprStates systemState

doesLocalMemWrite :: DbgInput -> Bool
doesLocalMemWrite (instrs,st) = any isStoreInstr instrs
    where
        isStoreInstr (Store _ _) = True
        isStoreInstr _ = False