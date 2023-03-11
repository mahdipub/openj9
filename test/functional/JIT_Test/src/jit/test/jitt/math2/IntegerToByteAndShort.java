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
// Test file: IntegerToByteAndShort.java
// Testing the conversion from integer to byte and from integer to short.

package jit.test.jitt.math2;

import org.testng.annotations.Test;
import org.testng.Assert;

@Test(groups = { "level.sanity","component.jit" })
public class IntegerToByteAndShort extends jit.test.jitt.Test {

   @Test
   public void testIntegerToByteAndShort() {

        byte  A;
        short B;
        int   C;

        C = -4;
        B = doInt2Short(C);
        if (B != -4)
                Assert.fail("IntegerToByteAndShort->run: Incorrect conversion for test #1!");


	C = 4;
        A = doInt2Byte(C);
        if (A != 10)
                Assert.fail("IntegerToByteAndShort->run: Incorrect conversion for test #2!");


   }


   static short doInt2Short(int C){
      return ((short)C);
   }

   static byte doInt2Byte(int C){
      return ((byte)(C+6));
   }

}



