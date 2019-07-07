import Sprockell

--	Int i = 0;


prog0 :: [Instruction]

prog0 = [
{-0-}		Load (ImmValue (-1)) regA,
{-1-}		WriteInstr regA (DirAddr 2),
{-2-}		WriteInstr regA (DirAddr 6),
{-3-}		Load (ImmValue 0) 2	{-  loaded integer 0  -},
{-4-}		Store 2 (DirAddr 1)	{-  declLine: varname: i stored at 1 types: [0] expr: 0  -},
{-5-}		
			Nop	{-  start of terminateAllNotStartedPrograms  -},
{-6-}		

			Load (ImmValue (1)) 2	{-  start writeImmToShared  -},
{-7-}		WriteInstr 2 (DirAddr 4),
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