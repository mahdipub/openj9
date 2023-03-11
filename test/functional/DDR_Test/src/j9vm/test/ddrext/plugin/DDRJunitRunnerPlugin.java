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
package j9vm.test.ddrext.plugin;

import j9vm.test.ddrext.AutoRun;
import java.io.PrintStream;
import com.ibm.j9ddr.tools.ddrinteractive.Command;
import com.ibm.j9ddr.tools.ddrinteractive.Context;
import com.ibm.j9ddr.tools.ddrinteractive.DDRInteractiveCommandException;
import com.ibm.j9ddr.tools.ddrinteractive.annotations.DebugExtension;

@DebugExtension(VMVersion = "*")
public class DDRJunitRunnerPlugin extends Command {
	public DDRJunitRunnerPlugin() {
		addCommand("ddrjunit", "", "DDR Junit test runner plugin");

	}

	public void run(String command, String[] arguments, Context context,
			PrintStream out) throws DDRInteractiveCommandException {
		String testCaseList = "";
		if (arguments.length == 0) {
			testCaseList = "ALL";
		} else {
			testCaseList = arguments[0];
		}
		AutoRun.runTest(context, out, testCaseList);
	}
}
