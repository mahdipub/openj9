/*[INCLUDE-IF Sidecar18-SE]*/
/*******************************************************************************
 * Copyright IBM Corp. and others 2004
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
package com.ibm.jvm.j9.dump.indexsupport;

import org.xml.sax.Attributes;

import com.ibm.dtfj.java.j9.JavaRuntime;
import com.ibm.dtfj.java.j9.TraceBuffer;

/**
 * @author jmdisher
 *
 */
public class NodeTrace extends NodeAbstract
{
	private TraceBuffer _traceBuffer;
	
	public NodeTrace(JavaRuntime runtime, Attributes attributes)
	{
		//trace objects are special in that DTFJ says that they are implementation dependent.  As a result, it is hard to know how to implement them, at this time
		_traceBuffer = new TraceBuffer();
		runtime.setTraceBufferForName(_traceBuffer, "trace");
	}

	/* (non-Javadoc)
	 * @see com.ibm.jvm.j9.dump.indexsupport.IParserNode#nodeToPushAfterStarting(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	public IParserNode nodeToPushAfterStarting(String uri, String localName, String qName, Attributes attributes)
	{
		IParserNode child = null;
		
		if (qName.equals("header")) {
			child = new NodeHeader(_traceBuffer, attributes);
		} else if (qName.equals("buffers")) {
			child = new NodeBuffers(_traceBuffer, attributes);
		} else {
			child = super.nodeToPushAfterStarting(uri, localName, qName, attributes);
		}
		return child;
	}
}
