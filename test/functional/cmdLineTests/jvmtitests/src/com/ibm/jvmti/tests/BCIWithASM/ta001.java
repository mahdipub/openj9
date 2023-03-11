/*******************************************************************************
 * Copyright IBM Corp. and others 2001
 *
 * This program and the accompanying materials are made available under
 * the terms of the Eclipse Public License 2.0 which accompanies this
 * distribution and is available at https://www.eclipse.org/legal/epl-2.0/
 * or the Apache License, Version 2.0 which accompanies this distribution and
 * is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * This Source Code may also be made available under the following
 * Secondary Licenses when the conditions for such availability set
 * forth in the Eclipse Public License, v. 2.0 are satisfied: GNU
 * General Public License, version 2 with the GNU Classpath
 * Exception [1] and GNU General Public License, version 2 with the
 * OpenJDK Assembly Exception [2].
 *
 * [1] https://www.gnu.org/software/classpath/license.html
 * [2] https://openjdk.org/legal/assembly-exception.html
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0 OR GPL-2.0 WITH Classpath-exception-2.0 OR LicenseRef-GPL-2.0 WITH Assembly-exception
 *******************************************************************************/
package com.ibm.jvmti.tests.BCIWithASM;

import java.util.ArrayList;

public class ta001 {
	public static native boolean redefineClass(Class name, int classBytesSize, byte[] classBytes);
	
	public boolean setup(String args) {
		return true;
	}

	public boolean testBCIUsingASM_InjectNPELogic() {
		int pre, post;

		Source preState = new Source();
		int preStateResult = preState.returnOne();

		byte[] trasnformedClassBytes = ASMTransformer.trasnform_injectNPELogic( Source.class );
		
		boolean transformed = redefineClass( Source.class, trasnformedClassBytes.length, trasnformedClassBytes );
		
		Source postState = new Source();
		
		boolean NPEThrown = false; 
		
		try { 
			int postStateResult = postState.returnOne();
		} catch ( NullPointerException e ) {
			NPEThrown = true;
		}
		
		System.out.println( "Pre  Replace: " + preStateResult );
		
		if ( preStateResult != 1 ) {
			return false;
		}
		
		if ( !NPEThrown ) {
			System.out.println( "Class instrumentation error, expceted NPE not received" );
			return false;
		} else {
			System.out.println( "Expected NullPointerException received" );
		}
		
		return true;
	}
	
	public String helpBCIUsingASM_InjectNPELogic() {
		return "Tests class redefinition where the redefined class is an ASM generated byte-code engineered version of the original class where new logic is injected to cause a NPE to be thrown";
	}
	
	public boolean testBCIUsingASM_InjectNewIFBlock() {
		int pre, post;

		Source2 preState = new Source2();
		int preStateResult = preState.process(2);

		byte[] trasnformedClassBytes = ASMTransformer.trasnform_injectNewIfBlock( Source2.class );
		
		boolean transformed = redefineClass( Source2.class, trasnformedClassBytes.length, trasnformedClassBytes );
		
		Source2 postState = new Source2();
		
		boolean NPEThrown = false; 
		
		int postStateResult = postState.process(2);
		
		System.out.println( "Pre Replace result  : " + preStateResult );
		System.out.println( "Post Replace result : " + postStateResult );
		
		if ( preStateResult != 5 ) {
			return false;
		}
		
		if ( postStateResult != 1 ) {
			return false;
		}
		
		return true;
	}
	
	public String helpBCIUsingASM_InjectNewIFBlock() {
		return "Tests class redefinition where the redefined class is an ASM generated byte-code engineered version of the original class where a new if block is injected";
	}

	public boolean testBCIUsingASM_InjectTryCatch_Level1_injectCatchAndThrowNewAIOBE() {
		int pre, post;
		boolean NPEThrown = false; 
		boolean AIOBEThrown = false; 
		Source3 preState = new Source3();
		
		try {
			int preStateResult = preState.returnOne();
		} catch ( NullPointerException e ) {
			NPEThrown = true;
		}

		if ( !NPEThrown ) {
			System.out.println( "Expceted NPE not received" );
			return false;
		} else {
			System.out.println( "Expected NullPointerException received" );
		}

		byte[] trasnformedClassBytes = ASMTransformer.trasnform_injectCatchAndThrowNewAIOBE( Source3.class );
		
		boolean transformed = redefineClass( Source3.class, trasnformedClassBytes.length, trasnformedClassBytes );
		
		Source3 postState = new Source3();
		
		try { 
			int postStateResult = postState.returnOne();
		} catch ( ArrayIndexOutOfBoundsException e ) {
			AIOBEThrown = true;
		}
		
		if ( !AIOBEThrown ) {
			System.out.println( "Class instrumentation error, expceted ArrayIndexOutOfBoundsException not received" );
			return false;
		} else {
			System.out.println( "Expected ArrayIndexOutOfBoundsException received" );
		}
		
		return true;
	}
	
	public String helpBCIUsingASM_InjectTryCatch_Level1_injectCatchAndThrowNewAIOBE() {
		return "Tests class redefinition where the redefined class is an ASM generated byte-code engineered version of the original class where new try-catch block is inserted, the catch block throws a new ArrayIndexOutOfBoundsException";
	}
	
	public boolean testBCIUsingASM_InjectTryCatch_Level2_injectCatchAndThrowNewAIOBE_catchAIOBEAndThrowNewAE() {
		int pre, post;
		boolean NPEThrown = false; 
		boolean AEThrown = false; 
		Source4 preState = new Source4();
		
		try {
			int preStateResult = preState.returnOne();
		} catch ( NullPointerException e ) {
			NPEThrown = true;
		}

		if ( !NPEThrown ) {
			System.out.println( "Expceted NPE not received" );
			return false;
		} else {
			System.out.println( "Expected NullPointerException received" );
		}

		byte[] trasnformedClassBytes = ASMTransformer.trasnform_injectCatchAndThrowNewAIOBE_catchAIOBEAndThrowNewAE( Source4.class );
		
		boolean transformed = redefineClass( Source4.class, trasnformedClassBytes.length, trasnformedClassBytes );
		
		Source4 postState = new Source4();
		
		try { 
			int postStateResult = postState.returnOne();
		} catch ( ArithmeticException e ) {
			AEThrown = true;
		}
		
		if ( !AEThrown ) {
			System.out.println( "Class instrumentation error, expected ArithmeticException not received" );
			return false;
		} else {
			System.out.println( "Expected ArithmeticException received" );
		}
		
		return true;
	}
	
	public String helpBCIUsingASM_InjectTryCatch_Level2_injectCatchAndThrowNewAIOBE_catchAIOBEAndThrowNewAE() {
		return "Tests class redefinition where the redefined class is an ASM generated byte-code engineered version of the original class where new try-catch block is inserted, the catch block throws a new ArrayIndexOutOfBoundsException, which is caught by a second level nested catch block, which then throws an ArithmeticException";
	}
	
	public boolean testBCIUsingASM_inject_innerCatch2outerCatchJump() {
		int pre, post;

		Source5 preState = new Source5();
		
		int preStateResult = preState.returnOne();
		
		if ( preStateResult != 0 ) {
			System.out.println( "Expceted pre-transform result not received" );
			return false;
		} else {
			System.out.println( "Expected pre-transform result received" );
		}

		byte[] trasnformedClassBytes = ASMTransformer.trasnform_inject_Catch2CatchJump( Source5.class );
		
		boolean transformed = redefineClass( Source5.class, trasnformedClassBytes.length, trasnformedClassBytes );
		
		Source5 postState = new Source5();
		
		int postStateResult = postState.returnOne();
		
		if ( postStateResult != -1 ) {
			System.out.println( "Expected post-transform result not found" );
			return false;
		} else {
			System.out.println( "Expected post-transform result received" );
		}
		
		return true;
	}
	
	public String helpBCIUsingASM_inject_innerCatch2outerCatchJump() {
		return "Tests class redefinition where the redefined class is an ASM generated byte-code engineered version of the original class where a new outer try-catch block is inserted, and an unconditional jump is inserted in the inner catch block to go to the outer catch block";
	}
	
	public boolean testBCIUsingASM_inject_CatchWithSelfGOTO() {
		int pre, post;

		Source6 preState = new Source6();
		
		int preStateResult = preState.returnOne();
		
		if ( preStateResult != 0 ) {
			System.out.println( "Expceted pre-transform result not received" );
			return false;
		} else {
			System.out.println( "Expected pre-transform result received" );
		}

		byte[] trasnformedClassBytes = ASMTransformer.trasnform_inject_CatchWithSelfGOTO( Source6.class );
		
		boolean transformed = redefineClass( Source6.class, trasnformedClassBytes.length, trasnformedClassBytes );
		
		Source6 postState = new Source6();
		
		int postStateResult = postState.returnOne();
		
		if ( postStateResult != -1 ) {
			System.out.println( "Expected post-transform result not found" );
			return false;
		} else {
			System.out.println( "Expected post-transform result received" );
		}
		
		return true;
	}
	
	public String helpBCIUsingASM_inject_CatchWithSelfGOTO() {
		return "Tests class redefinition where the redefined class is an ASM generated byte-code engineered version of the original class where we add a jump in the catch block to go to the beginning of the catch block 5 times before returning";
	}
	
	public boolean testBCIUsingASM_inject_ParallelCatchJump() {
		int pre, post;

		Source9 preState = new Source9();
		
		int preStateResult = preState.returnOne();
		
		if ( preStateResult != 10 ) {
			System.out.println( "Expceted pre-transform result not received" );
			return false;
		} else {
			System.out.println( "Expected pre-transform result received" );
		}

		byte[] trasnformedClassBytes = ASMTransformer.trasnform_inject_ParallelCatchJump( Source9.class );
		
		boolean transformed = redefineClass( Source9.class, trasnformedClassBytes.length, trasnformedClassBytes );
		
		Source9 postState = new Source9();
		
		int postStateResult = postState.returnOne();
		
		if ( postStateResult != -2 ) {
			System.out.println( "Expected post-transform result not found" );
			return false;
		} else {
			System.out.println( "Expected post-transform result received" );
		}
		
		return true;
	}
	
	public String helpBCIUsingASM_inject_ParallelCatchJump() {
		return "Tests class redefinition where the redefined class is an ASM generated byte-code engineered version of the original class where a try-catch block is inserted, and an unconditional jump is inserted in the first catch block to go to the second catch block";
	}
	
	public boolean testBCIUsingASM_inject_Loop2Loop_Jump() {
		int pre, post;

		Source10 preState = new Source10();
		
		int preStateResult = preState.returnOne();
		
		if ( preStateResult != 5 ) {
			System.out.println( "Expceted pre-transform result not received" );
			return false;
		} else {
			System.out.println( "Expected pre-transform result received" );
		}

		byte[] trasnformedClassBytes = ASMTransformer.trasnform_inject_Loop2Loop_Jump( Source10.class );
		
		boolean transformed = redefineClass( Source10.class, trasnformedClassBytes.length, trasnformedClassBytes );
		
		Source10 postState = new Source10();
		
		int postStateResult = postState.returnOne();
		
		if ( postStateResult != 1 ) {
			System.out.println( "Expected post-transform result not found" );
			return false;
		} else {
			System.out.println( "Expected post-transform result received" );
		}
		
		return true;
	}
	
	public String helpBCIUsingASM_inject_Loop2Loop_Jump() {
		return "Tests class redefinition where the redefined class is an ASM generated byte-code engineered version of the original class where a we add a jump from one for loop to another";
	}
	
	public boolean testBCIUsingASM_inject_call_to_timer_method() {
		
		class ProfilerThread extends Thread {
			boolean testPassed = true;
			
			public boolean getResult() {
				return testPassed;
			}
			
			public void run () {
				
				//Initialize monitor.
				Timer.init();
				
				/*Test with first source*/

				byte[] trasnformedClassBytes = ASMTransformer.inject_call_to_timerMethod ( Source12.class );
				boolean transformed = redefineClass( Source12.class, trasnformedClassBytes.length, trasnformedClassBytes );
				
				Source12 postState12 = new Source12();
				postState12.method1();
				
				if ( !Timer.isMethodAccountedFor( Source12.class.getCanonicalName() + "#method1") ) {
					System.out.println( Thread.currentThread().getName() + " : Expceted post-transform result not received after Source12.method1()" );
					testPassed = false;
				} else {
					System.out.println( Thread.currentThread().getName() + " : Expected post-transform result received after Source12.method1()" );
				}

				postState12.method2();
				
				if ( !Timer.isMethodAccountedFor( Source12.class.getCanonicalName() + "#method2") ) {
					System.out.println( Thread.currentThread().getName() + " : Expceted post-transform result not received after Source12.method2()" );
					testPassed = false;
				} else {
					System.out.println( Thread.currentThread().getName() + " : Expected post-transform result received after Source12.method2()" );
				}

				/*Test with second source*/
		
				trasnformedClassBytes = ASMTransformer.inject_call_to_timerMethod( Source13.class );
				transformed = redefineClass( Source13.class, trasnformedClassBytes.length, trasnformedClassBytes );
				
				Source13 postState13 = new Source13();
				
				postState13.method1();
				
				if ( !Timer.isMethodAccountedFor( Source13.class.getCanonicalName() + "#method1") ) {
					System.out.println( Thread.currentThread().getName() + " : Expceted post-transform result not received after Source13.method1()" );
					testPassed = false;
				} else {
					System.out.println( Thread.currentThread().getName() + " : Expected post-transform result received after Source13.method1()" );
				}

				postState13.method2();
				
				if ( !Timer.isMethodAccountedFor( Source13.class.getCanonicalName() + "#method2") ) {
					System.out.println( Thread.currentThread().getName() + " : Expceted post-transform result not received after Source13.method2()" );
					testPassed = false;
				} else {
					System.out.println( Thread.currentThread().getName() + " : Expected post-transform result received after Source13.method2()" );
				}

				postState13.method3();
				
				if ( !Timer.isMethodAccountedFor( Source13.class.getCanonicalName() + "#method3") ) {
					System.out.println( Thread.currentThread().getName() + " : Expceted post-transform result not received after Source13.method3()" );
					testPassed = false;
				} else {
					System.out.println( Thread.currentThread().getName() + " : Expected post-transform result received after Source13.method3()" );
				}
				
				Timer.printStats();
			}
		}

		
		//Create a list of Profiler threads
		ArrayList<ProfilerThread> profilerThreadList = new ArrayList<ProfilerThread>();
		
		profilerThreadList.add(new ProfilerThread());
		profilerThreadList.add(new ProfilerThread());
		profilerThreadList.add(new ProfilerThread());
		
		//Start the profiler threads
		for ( int i = 0 ; i < profilerThreadList.size() ; i++ ) {
			profilerThreadList.get(i).start();
		}
		
		//Wait for all profiler threads to exit
		for ( int i = 0 ; i < profilerThreadList.size() ; i++ ) {
			try {
				profilerThreadList.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		//Accumulate results of each thread
		for ( int i = 0 ; i < profilerThreadList.size() ; i++ ) {
			if ( !profilerThreadList.get(i).getResult() ) {
				return false;
			}
		}
		
		return true;
	}
	
	public String helpBCIUsingASM_inject_call_to_timer_method() {
		return "Tests class redefinition where the redefined class is an ASM generated byte-code engineered version of the original class where a inject calls to timer methods at methodEnter and methoExit points";
	}
	
	public boolean testBCIUsingASM_inject_stackValueUsage_After_Branch_Using_MethodCall() {
		int pre, post;

		Source14 preState = new Source14();
		
		double preStateResult = preState.method1();
		
		System.out.println("pre : " + preStateResult );
		
		if ( preStateResult != 10.0 ) {
			System.out.println( "Expceted pre-transform result not received" );
			return false;
		} else {
			System.out.println( "Expected pre-transform result received" );
		}

		byte[] trasnformedClassBytes = ASMTransformer.trasnform_inject_stackValueUsage_After_Branch_Using_MethodCall( Source14.class );
		
		boolean transformed = redefineClass( Source14.class, trasnformedClassBytes.length, trasnformedClassBytes );
		
		Source14 postState = new Source14();
		
		double postStateResult = postState.method1();
		
		System.out.println("post : " + postStateResult );
		
		if ( postStateResult != 0.1 ) {
			System.out.println( "Expceted post-transform result not received" );
			return false;
		} else {
			System.out.println( "Expected post-transform result received" );
		}
		
		return true;
	}
	
	public String helpBCIUsingASM_inject_stackValueUsage_After_Branch_Using_MethodCall() {
		return "Instruments bytecode by leaving local values on stack before calling a method and using it after the method returns.";
	}
	
	public boolean testBCIUsingASM_inject_stackValueUsage_After_Branch_Using_IfCompare() {
		int pre, post;

		Source16 preState = new Source16();
		
		int preStateResult = preState.method1();
		
		System.out.println("pre : " + preStateResult );
		
		if ( preStateResult != 2 ) {
			System.out.println( "Expceted pre-transform result not received" );
			return false;
		} else {
			System.out.println( "Expected pre-transform result received" );
		}

		byte[] trasnformedClassBytes = ASMTransformer.trasnform_inject_stackValueUsage_After_Branch_Using_IfCompare( Source16.class );
		
		boolean transformed = redefineClass( Source16.class, trasnformedClassBytes.length, trasnformedClassBytes );
		
		Source16 postState = new Source16();
		
		int postStateResult = postState.method1();
		
		System.out.println("post : " + postStateResult );
		
		if ( postStateResult != 5 ) {
			System.out.println( "Expceted post-transform result not received" );
			return false;
		} else {
			System.out.println( "Expected post-transform result received" );
		}
		
		return true;
	}
	
	public String helpBCIUsingASM_inject_stackValueUsage_After_Branch_Using_IfCompare() {
		return "Instruments bytecode by leaving local values on stack before an if-compare branch and using it after";
	}
	
	public boolean testBCIUsingASM_Inject_Dead_Code() {
		int pre, post;

		Source17 preState = new Source17();
		
		int preStateResult = preState.method1();
		
		System.out.println("pre : " + preStateResult );
		
		if ( preStateResult != 4 ) {
			System.out.println( "Expceted pre-transform result not received" );
			return false;
		} else {
			System.out.println( "Expected pre-transform result received" );
		}

		byte[] trasnformedClassBytes = ASMTransformer.trasnform_inject_unverifiable_dead_code( Source17.class );
		
		boolean transformed = redefineClass( Source17.class, trasnformedClassBytes.length, trasnformedClassBytes );
		
		Source17 postState = new Source17();
		
		int postStateResult = postState.method1();
		
		System.out.println("post : " + postStateResult );
		
		if ( postStateResult != 2 ) {
			System.out.println( "Expceted post-transform result not received" );
			return false;
		} else {
			System.out.println( "Expected post-transform result received" );
		}
		
		return true;
	}
	
	public String helpBCIUsingASM_Inject_Dead_Code() {
		return "Instruments bytecode by injecting dead code";
	}
	
	public boolean testBCIUsingASM_inject_Unclean_Return() {
		int pre, post;

		Source18 preState = new Source18();
		
		int preStateResult = preState.method1();
		
		System.out.println("pre : " + preStateResult );
		
		if ( preStateResult != 3 ) {
			System.out.println( "Expceted pre-transform result not received" );
			return false;
		} else {
			System.out.println( "Expected pre-transform result received" );
		}

		byte[] trasnformedClassBytes = ASMTransformer.trasnform_inject_unclean_return( Source18.class );
		
		boolean transformed = redefineClass( Source18.class, trasnformedClassBytes.length, trasnformedClassBytes );
		
		Source18 postState = new Source18();
		
		int postStateResult = postState.method1();
		
		System.out.println("post : " + postStateResult );
		
		if ( postStateResult != 5 ) {
			System.out.println( "Expceted post-transform result not received" );
			return false;
		} else {
			System.out.println( "Expected post-transform result received" );
		}
		
		return true;
	}
	
	public String helpBCIUsingASM_inject_Unclean_Return() {
		return "Instruments bytecode by injecting unclean return";
	}
}
