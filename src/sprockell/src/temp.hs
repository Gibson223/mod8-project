import Sprockell

--	Int a = 5;parallel {sequential {   parallel {       sequential {Nop;}        sequential {Nop;}   }}sequential {Nop;}} a= 10; OutNumber a;


prog0 :: [Instruction]

prog0 = [
{-0-}		Load (ImmValue (-1)) regA,
{-1-}		WriteInstr regA (DirAddr 2),
{-2-}		WriteInstr regA (DirAddr 6),
{-3-}		Load (ImmValue 5) 2	{-  loaded integer 5  -},
{-4-}		Store 2 (DirAddr 1)	{-  declLine: varname: a stored at 1 types: [0] expr: 5  -},
{-5-}		

		Load (ImmValue 2) 2	{-  loaded amount of childs to be spawned into dedicated register

		start of managing child threads  -},
{-6-}		

		Load (ImmValue 2) 3	{-  amount of threads still needed to be terminated for parallel-handler to terminate  -},
{-7-}		Load (ImmValue 1) 4,
{-8-}		Push 4,
{-9-}		Load (ImmValue 4) 4,
{-10-}		Push 4,
{-11-}		

			TestAndSet (DirAddr 5)	{-  start of trylock  -},
{-12-}		Receive 4,
{-13-}		Branch 4 (Rel 2),
{-14-}		Jump  (Rel 10)	{- jump when trylock failed, going to check for terminated child threads-},
{-15-}		Branch 2 (Rel (4)),
{-16-}		

			Load (ImmValue (0)) 4	{-  start writeImmToShared  -},
{-17-}		WriteInstr 4 (DirAddr 5)	{-  to release proglock

			  -},
{-18-}		Jump  (Rel 6)	{- did obtain trylock but no more threads to activate-},
{-19-}		Load (ImmValue 1) 4,
{-20-}		WriteInstr 4 (DirAddr 7),
{-21-}		Pop 4,
{-22-}		WriteInstr 4 (DirAddr 6),
{-23-}		Compute Decr 2 2 2	{-  decremented dedicated register for amount of to be activated threads  -}	{-  

			end of activateSprockell  -},
{-24-}		

			ReadInstr (DirAddr 6)	{-  start readFromShared  -},
{-25-}		Receive 4	{-  read shmemory address as part of checkmatchsprockelid  -},
{-26-}		Compute Equal 4 1 4,
{-27-}		Branch 4 (Rel 2)	{-  read sprockell id equals expected sprockellid, so continue after jump  -},
{-28-}		Jump  (Rel 10)	{- no terminated child threads, start checkvar-},
{-29-}		Compute Decr 3 3 3	{-  decremented amount of child threads needed to be terminated still  -},
{-30-}		

			Load (ImmValue (0)) 4	{-  start writeImmToShared  -},
{-31-}		WriteInstr 4 (DirAddr 7)	{-  reset terminateorStart to 0  -},
{-32-}		

			Load (ImmValue (-1)) 4	{-  start writeImmToShared  -},
{-33-}		WriteInstr 4 (DirAddr 6)	{-  reset progID to -1  -},
{-34-}		

			Load (ImmValue (0)) 4	{-  start writeImmToShared  -},
{-35-}		WriteInstr 4 (DirAddr 5)	{-  release lock after read terminatedchild  -},
{-36-}		Branch 3(Rel 2)	{-  if all terminated jump over all in next jump  -},
{-37-}		Jump  (Rel 58)	{- all child progs terminated, finishing this threads tasks -},
{-38-}		Nop	{-  after checking for terminated child thread 

		and start of checking var Request  -},
{-39-}		

			ReadInstr (DirAddr 2)	{-  start readFromShared  -},
{-40-}		Receive 4	{-  read shmemory address as part of checkmatchsprockelid  -},
{-41-}		Compute Equal 4 1 4,
{-42-}		Branch 4 (Rel 2)	{-  read sprockell id equals expected sprockellid, so continue after jump  -},
{-43-}		Jump  (Rel (-32))	{- jump back to start of loop variable request and terminatethread -},
{-44-}		

			ReadInstr (DirAddr 3)	{-  start readFromShared  -},
{-45-}		Receive 4,
{-46-}		

			ReadInstr (DirAddr 1)	{-  start readFromShared  -},
{-47-}		Receive 5	{-  reg contains value type  -},
{-48-}		Compute Decr 4 4 4	{-  check location of lock for variable on heap  -},
{-49-}		Load (IndAddr 4) 6	{-  loading lock value  -}	{-  

			start of registerMatchExpectedImmVal  -},
{-50-}		Load (ImmValue (1)) 7,
{-51-}		Compute Equal 4 7 7,
{-52-}		Branch 7 (Rel (2))	{-  Jump when it is a match otherwise go to the jump under that should be replaced  -},
{-53-}		Jump  (Rel (19))	{- variable not locked, so jump to examine type request -},
{-54-}		Load (ImmValue (3)) 7,
{-55-}		Compute Equal 5 7 7,
{-56-}		Branch 7 (Rel (2))	{-  Jump when it is a match otherwise go to the jump under that should be replaced  -},
{-57-}		Jump  (Rel (12))	{- variable locked and no unlock request so jump to start of loop (should be after writing locked_var -2) -},
{-58-}		Compute Incr 4 4 4	{-  position in heap to store about to receive value for variable
			start of unlock var  -},
{-59-}		

			Load (ImmValue (-3)) 7	{-  start writeImmToShared  -},
{-60-}		WriteInstr 7 (DirAddr 2)	{-  

			start of polling changed value  -},
{-61-}		

			ReadInstr (DirAddr 3)	{-  start readFromShared  -},
{-62-}		Receive 7,
{-63-}		Compute Equal 4 7 7,
{-64-}		Branch 7 (Rel (-3))	{-  obtained value same as written so poll again  -},
{-65-}		

			ReadInstr (DirAddr 3)	{-  start readFromShared  -},
{-66-}		Receive 7	{-  pulled fresh since reg used in compute above  -},
{-67-}		Store 7 (IndAddr 4),
{-68-}		Jump (Rel (-57))	{-  check return to start loop  -},
{-69-}		

			Load (ImmValue (-2)) 7	{-  start writeImmToShared  -},
{-70-}		WriteInstr 7 (DirAddr 2),
{-71-}		Jump (Rel (-60))	{-  

			start of requests (first check for lock and then the rest)
			  -},
{-72-}		Compute Incr 4 4 4	{-  position in heap of var, so incr to negate decr for lock val  -}	{-  

			start of purerequest  -}	{-  

			start of registerMatchExpectedImmVal  -},
{-73-}		Load (ImmValue (0)) 7,
{-74-}		Compute Equal 5 7 7,
{-75-}		Branch 7 (Rel (2))	{-  Jump when it is a match otherwise go to the jump under that should be replaced  -},
{-76-}		Jump  (Rel (6))	{- should jump from failed purerequest to updatereq -},
{-77-}		Load (IndAddr 4) 6	{-  retrieving value  -},
{-78-}		WriteInstr 6 (DirAddr 3)	{-  end writeREgisterToShared  -}	{-  pushed value  -},
{-79-}		

			Load (ImmValue (-3)) 7	{-  start writeImmToShared  -},
{-80-}		WriteInstr 7 (DirAddr 2),
{-81-}		Jump (Rel (-70) )	{-  jump back to start of loop for Var Request and terminate/start Thread  -}	{-  
			end of purerequest  -}	{-  

			start of checking for lockrequest  -}	{-  

			start of registerMatchExpectedImmVal  -},
{-82-}		Load (ImmValue (0)) 7,
{-83-}		Compute Equal 5 7 7,
{-84-}		Branch 7 (Rel (2))	{-  Jump when it is a match otherwise go to the jump under that should be replaced  -},
{-85-}		Jump  (Rel (-74))	{- should jump from failed lockrequest to start of loop -},
{-86-}		Compute Decr 4 4 4	{-  to set lock  -},
{-87-}		Load (ImmValue (1)) 7,
{-88-}		Store 7 (IndAddr 4)	{-  set lock for variable  -},
{-89-}		Compute Incr 4 4 4	{-  to set lock  -},
{-90-}		Load (DirAddr 4) 6,
{-91-}		WriteInstr 6 (DirAddr 3)	{-  end writeREgisterToShared  -},
{-92-}		

			Load (ImmValue (-3)) 4	{-  start writeImmToShared  -},
{-93-}		WriteInstr 4 (DirAddr 2),
{-94-}		Jump (Rel (-83) )	{-  jump back to start of loop for Var Request and terminate/start Thread  -}	{-  


			end of parallelLine, continuing after join  -},
{-95-}		Load (ImmValue 10) 2	{-  loaded integer 10  -},
{-96-}		Store 2(DirAddr 1)	{-  asgnline: varname: a overwritten at heaploc 1 types: [0] expr: 10  -},
{-97-}		Load (DirAddr 1) 2,
{-98-}		WriteInstr 2 numberIO	{-  end OutNumber  -},
{-99-}		
			Nop	{-  start of terminateAllNotStartedPrograms  -},
{-100-}		

			Load (ImmValue (1)) 2	{-  start writeImmToShared  -},
{-101-}		WriteInstr 2 (DirAddr 4),
			EndProg
		]

prog1 :: [Instruction]

prog1 = [
{-0-}		

			ReadInstr (DirAddr 6)	{-  start readFromShared  -},
{-1-}		Receive 2,
{-2-}		Compute Equal 1 2 2,
{-3-}		Branch 2 (Rel (2)),
{-4-}		Jump (Rel (-4)),
{-5-}		

			Load (ImmValue (-1)) 2	{-  start writeImmToShared  -},
{-6-}		WriteInstr 2 (DirAddr 6),
{-7-}		

			Load (ImmValue (0)) 2	{-  start writeImmToShared  -},
{-8-}		WriteInstr 2 (DirAddr 7)	{-  reset terminatedOrStarted  -},
{-9-}		

			Load (ImmValue (0)) 2	{-  start writeImmToShared  -},
{-10-}		WriteInstr 2 (DirAddr 5)	{-  reset startProgLock, so other threads can signal termination or activation of thread

			Done with cleanup start thread  -},
{-11-}		

		Load (ImmValue 2) 2	{-  loaded amount of childs to be spawned into dedicated register

		start of managing child threads  -},
{-12-}		

		Load (ImmValue 2) 3	{-  amount of threads still needed to be terminated for parallel-handler to terminate  -},
{-13-}		Load (ImmValue 2) 4,
{-14-}		Push 4,
{-15-}		Load (ImmValue 3) 4,
{-16-}		Push 4,
{-17-}		

			TestAndSet (DirAddr 5)	{-  start of trylock  -},
{-18-}		Receive 4,
{-19-}		Branch 4 (Rel 2),
{-20-}		Jump  (Rel 10)	{- jump when trylock failed, going to check for terminated child threads-},
{-21-}		Branch 2 (Rel (4)),
{-22-}		

			Load (ImmValue (0)) 4	{-  start writeImmToShared  -},
{-23-}		WriteInstr 4 (DirAddr 5)	{-  to release proglock

			  -},
{-24-}		Jump  (Rel 6)	{- did obtain trylock but no more threads to activate-},
{-25-}		Load (ImmValue 1) 4,
{-26-}		WriteInstr 4 (DirAddr 7),
{-27-}		Pop 4,
{-28-}		WriteInstr 4 (DirAddr 6),
{-29-}		Compute Decr 2 2 2	{-  decremented dedicated register for amount of to be activated threads  -}	{-  

			end of activateSprockell  -},
{-30-}		

			ReadInstr (DirAddr 6)	{-  start readFromShared  -},
{-31-}		Receive 4	{-  read shmemory address as part of checkmatchsprockelid  -},
{-32-}		Compute Equal 4 1 4,
{-33-}		Branch 4 (Rel 2)	{-  read sprockell id equals expected sprockellid, so continue after jump  -},
{-34-}		Jump  (Rel 10)	{- no terminated child threads, start checkvar-},
{-35-}		Compute Decr 3 3 3	{-  decremented amount of child threads needed to be terminated still  -},
{-36-}		

			Load (ImmValue (0)) 4	{-  start writeImmToShared  -},
{-37-}		WriteInstr 4 (DirAddr 7)	{-  reset terminateorStart to 0  -},
{-38-}		

			Load (ImmValue (-1)) 4	{-  start writeImmToShared  -},
{-39-}		WriteInstr 4 (DirAddr 6)	{-  reset progID to -1  -},
{-40-}		

			Load (ImmValue (0)) 4	{-  start writeImmToShared  -},
{-41-}		WriteInstr 4 (DirAddr 5)	{-  release lock after read terminatedchild  -},
{-42-}		Branch 3(Rel 2)	{-  if all terminated jump over all in next jump  -},
{-43-}		Jump  (Rel 58)	{- all child progs terminated, finishing this threads tasks -},
{-44-}		Nop	{-  after checking for terminated child thread 

		and start of checking var Request  -},
{-45-}		

			ReadInstr (DirAddr 2)	{-  start readFromShared  -},
{-46-}		Receive 4	{-  read shmemory address as part of checkmatchsprockelid  -},
{-47-}		Compute Equal 4 1 4,
{-48-}		Branch 4 (Rel 2)	{-  read sprockell id equals expected sprockellid, so continue after jump  -},
{-49-}		Jump  (Rel (-32))	{- jump back to start of loop variable request and terminatethread -},
{-50-}		

			ReadInstr (DirAddr 3)	{-  start readFromShared  -},
{-51-}		Receive 4,
{-52-}		

			ReadInstr (DirAddr 1)	{-  start readFromShared  -},
{-53-}		Receive 5	{-  reg contains value type  -},
{-54-}		Compute Decr 4 4 4	{-  check location of lock for variable on heap  -},
{-55-}		Load (IndAddr 4) 6	{-  loading lock value  -}	{-  

			start of registerMatchExpectedImmVal  -},
{-56-}		Load (ImmValue (1)) 7,
{-57-}		Compute Equal 4 7 7,
{-58-}		Branch 7 (Rel (2))	{-  Jump when it is a match otherwise go to the jump under that should be replaced  -},
{-59-}		Jump  (Rel (19))	{- variable not locked, so jump to examine type request -},
{-60-}		Load (ImmValue (3)) 7,
{-61-}		Compute Equal 5 7 7,
{-62-}		Branch 7 (Rel (2))	{-  Jump when it is a match otherwise go to the jump under that should be replaced  -},
{-63-}		Jump  (Rel (12))	{- variable locked and no unlock request so jump to start of loop (should be after writing locked_var -2) -},
{-64-}		Compute Incr 4 4 4	{-  position in heap to store about to receive value for variable
			start of unlock var  -},
{-65-}		

			Load (ImmValue (-3)) 7	{-  start writeImmToShared  -},
{-66-}		WriteInstr 7 (DirAddr 2)	{-  

			start of polling changed value  -},
{-67-}		

			ReadInstr (DirAddr 3)	{-  start readFromShared  -},
{-68-}		Receive 7,
{-69-}		Compute Equal 4 7 7,
{-70-}		Branch 7 (Rel (-3))	{-  obtained value same as written so poll again  -},
{-71-}		

			ReadInstr (DirAddr 3)	{-  start readFromShared  -},
{-72-}		Receive 7	{-  pulled fresh since reg used in compute above  -},
{-73-}		Store 7 (IndAddr 4),
{-74-}		Jump (Rel (-57))	{-  check return to start loop  -},
{-75-}		

			Load (ImmValue (-2)) 7	{-  start writeImmToShared  -},
{-76-}		WriteInstr 7 (DirAddr 2),
{-77-}		Jump (Rel (-60))	{-  

			start of requests (first check for lock and then the rest)
			  -},
{-78-}		Compute Incr 4 4 4	{-  position in heap of var, so incr to negate decr for lock val  -}	{-  

			start of purerequest  -}	{-  

			start of registerMatchExpectedImmVal  -},
{-79-}		Load (ImmValue (0)) 7,
{-80-}		Compute Equal 5 7 7,
{-81-}		Branch 7 (Rel (2))	{-  Jump when it is a match otherwise go to the jump under that should be replaced  -},
{-82-}		Jump  (Rel (6))	{- should jump from failed purerequest to updatereq -},
{-83-}		Load (IndAddr 4) 6	{-  retrieving value  -},
{-84-}		WriteInstr 6 (DirAddr 3)	{-  end writeREgisterToShared  -}	{-  pushed value  -},
{-85-}		

			Load (ImmValue (-3)) 7	{-  start writeImmToShared  -},
{-86-}		WriteInstr 7 (DirAddr 2),
{-87-}		Jump (Rel (-70) )	{-  jump back to start of loop for Var Request and terminate/start Thread  -}	{-  
			end of purerequest  -}	{-  

			start of checking for lockrequest  -}	{-  

			start of registerMatchExpectedImmVal  -},
{-88-}		Load (ImmValue (0)) 7,
{-89-}		Compute Equal 5 7 7,
{-90-}		Branch 7 (Rel (2))	{-  Jump when it is a match otherwise go to the jump under that should be replaced  -},
{-91-}		Jump  (Rel (-74))	{- should jump from failed lockrequest to start of loop -},
{-92-}		Compute Decr 4 4 4	{-  to set lock  -},
{-93-}		Load (ImmValue (1)) 7,
{-94-}		Store 7 (IndAddr 4)	{-  set lock for variable  -},
{-95-}		Compute Incr 4 4 4	{-  to set lock  -},
{-96-}		Load (DirAddr 4) 6,
{-97-}		WriteInstr 6 (DirAddr 3)	{-  end writeREgisterToShared  -},
{-98-}		

			Load (ImmValue (-3)) 4	{-  start writeImmToShared  -},
{-99-}		WriteInstr 4 (DirAddr 2),
{-100-}		Jump (Rel (-83) )	{-  jump back to start of loop for Var Request and terminate/start Thread  -}	{-  

			sending termination signal to parent parallel-handler  -},
{-101-}		

			TestAndSet (DirAddr 5)	{-  start of looplock  -},
{-102-}		Receive 4,
{-103-}		Branch 4 (Rel 2),
{-104-}		Jump (Rel (-3))
	{-  end looplock  -},
{-105-}		

			Load (ImmValue (1)) 4	{-  start writeImmToShared  -},
{-106-}		WriteInstr 4 (DirAddr 7),
{-107-}		

			Load (ImmValue (1)) 4	{-  start writeImmToShared  -},
{-108-}		WriteInstr 4 (DirAddr 6)	{-  


			end of parallelLine, continuing after join  -}	{-  

			cleanup for thread below  -},
{-109-}		

			TestAndSet (DirAddr 5)	{-  start of looplock  -},
{-110-}		Receive 2,
{-111-}		Branch 2 (Rel 2),
{-112-}		Jump (Rel (-3))
	{-  end looplock  -},
{-113-}		

			Load (ImmValue (1)) 2	{-  start writeImmToShared  -},
{-114-}		WriteInstr 2 (DirAddr 7),
{-115-}		

			Load (ImmValue (0)) 2	{-  start writeImmToShared  -},
{-116-}		WriteInstr 2 (DirAddr 6),
			EndProg
		]

prog2 :: [Instruction]

prog2 = [
{-0-}		

			ReadInstr (DirAddr 6)	{-  start readFromShared  -},
{-1-}		Receive 2,
{-2-}		Compute Equal 1 2 2,
{-3-}		Branch 2 (Rel (2)),
{-4-}		Jump (Rel (-4)),
{-5-}		

			Load (ImmValue (-1)) 2	{-  start writeImmToShared  -},
{-6-}		WriteInstr 2 (DirAddr 6),
{-7-}		

			Load (ImmValue (0)) 2	{-  start writeImmToShared  -},
{-8-}		WriteInstr 2 (DirAddr 7)	{-  reset terminatedOrStarted  -},
{-9-}		

			Load (ImmValue (0)) 2	{-  start writeImmToShared  -},
{-10-}		WriteInstr 2 (DirAddr 5)	{-  reset startProgLock, so other threads can signal termination or activation of thread

			Done with cleanup start thread  -},
{-11-}		Nop	{-  end explicit Nop  -}	{-  

			cleanup for thread below  -},
{-12-}		

			TestAndSet (DirAddr 5)	{-  start of looplock  -},
{-13-}		Receive 2,
{-14-}		Branch 2 (Rel 2),
{-15-}		Jump (Rel (-3))
	{-  end looplock  -},
{-16-}		

			Load (ImmValue (1)) 2	{-  start writeImmToShared  -},
{-17-}		WriteInstr 2 (DirAddr 7),
{-18-}		

			Load (ImmValue (1)) 2	{-  start writeImmToShared  -},
{-19-}		WriteInstr 2 (DirAddr 6),
			EndProg
		]

prog3 :: [Instruction]

prog3 = [
{-0-}		

			ReadInstr (DirAddr 6)	{-  start readFromShared  -},
{-1-}		Receive 2,
{-2-}		Compute Equal 1 2 2,
{-3-}		Branch 2 (Rel (2)),
{-4-}		Jump (Rel (-4)),
{-5-}		

			Load (ImmValue (-1)) 2	{-  start writeImmToShared  -},
{-6-}		WriteInstr 2 (DirAddr 6),
{-7-}		

			Load (ImmValue (0)) 2	{-  start writeImmToShared  -},
{-8-}		WriteInstr 2 (DirAddr 7)	{-  reset terminatedOrStarted  -},
{-9-}		

			Load (ImmValue (0)) 2	{-  start writeImmToShared  -},
{-10-}		WriteInstr 2 (DirAddr 5)	{-  reset startProgLock, so other threads can signal termination or activation of thread

			Done with cleanup start thread  -},
{-11-}		Nop	{-  end explicit Nop  -}	{-  

			cleanup for thread below  -},
{-12-}		

			TestAndSet (DirAddr 5)	{-  start of looplock  -},
{-13-}		Receive 2,
{-14-}		Branch 2 (Rel 2),
{-15-}		Jump (Rel (-3))
	{-  end looplock  -},
{-16-}		

			Load (ImmValue (1)) 2	{-  start writeImmToShared  -},
{-17-}		WriteInstr 2 (DirAddr 7),
{-18-}		

			Load (ImmValue (1)) 2	{-  start writeImmToShared  -},
{-19-}		WriteInstr 2 (DirAddr 6),
			EndProg
		]

prog4 :: [Instruction]

prog4 = [
{-0-}		

			ReadInstr (DirAddr 6)	{-  start readFromShared  -},
{-1-}		Receive 2,
{-2-}		Compute Equal 1 2 2,
{-3-}		Branch 2 (Rel (2)),
{-4-}		Jump (Rel (-4)),
{-5-}		

			Load (ImmValue (-1)) 2	{-  start writeImmToShared  -},
{-6-}		WriteInstr 2 (DirAddr 6),
{-7-}		

			Load (ImmValue (0)) 2	{-  start writeImmToShared  -},
{-8-}		WriteInstr 2 (DirAddr 7)	{-  reset terminatedOrStarted  -},
{-9-}		

			Load (ImmValue (0)) 2	{-  start writeImmToShared  -},
{-10-}		WriteInstr 2 (DirAddr 5)	{-  reset startProgLock, so other threads can signal termination or activation of thread

			Done with cleanup start thread  -},
{-11-}		Nop	{-  end explicit Nop  -}	{-  

			cleanup for thread below  -},
{-12-}		

			TestAndSet (DirAddr 5)	{-  start of looplock  -},
{-13-}		Receive 2,
{-14-}		Branch 2 (Rel 2),
{-15-}		Jump (Rel (-3))
	{-  end looplock  -},
{-16-}		

			Load (ImmValue (1)) 2	{-  start writeImmToShared  -},
{-17-}		WriteInstr 2 (DirAddr 7),
{-18-}		

			Load (ImmValue (0)) 2	{-  start writeImmToShared  -},
{-19-}		WriteInstr 2 (DirAddr 6),
			EndProg
		]
main = run [prog0,prog1,prog2,prog3,prog4]


main2 = runWithDebugger (debuggerSimplePrintAndWait myShow) [prog0,prog1,prog2,prog3,prog4]

main3 = runWithDebugger (debuggerPrintCondWaitCond showLocalMem doesLocalMemWrite never) [prog0,prog1,prog2,prog3,prog4]

showLocalMem :: DbgInput -> String
showLocalMem ( _ , systemState ) = show $ localMem $ head $ sprStates systemState

doesLocalMemWrite :: DbgInput -> Bool
doesLocalMemWrite (instrs,st) = any isStoreInstr instrs
    where
        isStoreInstr (Store _ _) = True
        isStoreInstr _ = False