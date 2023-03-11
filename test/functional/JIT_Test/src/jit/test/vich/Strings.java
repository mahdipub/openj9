/*******************************************************************************
 * Copyright IBM Corp. and others 2006
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

package jit.test.vich;


import java.util.StringTokenizer;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import jit.test.vich.utils.Timer; 


public class Strings {

private static Logger logger = Logger.getLogger(Strings.class);
Timer timer;

public Strings() {
	timer = new Timer ();
}

String [] strings = {
  		"a.b.c.e.f.g.h.i.j.k.l.m" ,
		"aaaaaa.bbbbbb.cccccc.eeeeee.ffffff.gggggg.hhhhhh.iiiiii.jjjjjj.kkkkkk.llllll.mmmmmm",
		"aaaaaa.bbbbbb.cccccc.eeeeee.ffffff.gggggg.hhhhhh.iiiiii.jjjjjj.kkkkkk.llllll.mmmmmm"
}; 
@Test(groups = { "level.sanity","component.jit" })
public void testStrings() {   
	StringTokenizer tokenizer;

	try {	 
		timer.reset();
		for (int i = 0; i < strings.length; i++) {
			String s = strings[i];
			for (i = 0; i < 10000; i++) {
				tokenizer =  new StringTokenizer(s,".");
				while (tokenizer.hasMoreTokens()) tokenizer.nextToken(); 
			}
		}
		timer.mark();
		logger.info("StringTokenizer = "+ Long.toString(timer.delta()));
	} catch (NoClassDefFoundError err) {
		Assert.fail("StringTokenizer -- unsupported");
		err.printStackTrace();
	}
}


}
