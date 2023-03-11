/*******************************************************************************
 * Copyright IBM Corp. and others 2010
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

/**
 * @brief  This file contains the memory categories for the SDK.
 * The only other categories are "Unknown" and "Port library" that
 * are maintained inside the port library itself.
 */

#include "j9.h"
#include "j9memcategories.h"

/*
 * To add a new category:
 * - Add a new category macro to runtime/include/j9memcategories.h
 * - Declare the category below
 * - Add the category to the category table.
 * - The first category is the root, all categories in the tree must be reachable from that.
 */

/* Note: OMRMEM_CATEGORY_UNKNOWN and OMRMEM_CATEGORY_PORT_LIBRARY are stored inside the port library */
OMRMEM_CATEGORY_4_CHILDREN("JRE", J9MEM_CATEGORY_JRE, OMRMEM_CATEGORY_VM, OMRMEM_CATEGORY_JIT, J9MEM_CATEGORY_CLASS_LIBRARIES, OMRMEM_CATEGORY_UNKNOWN);
#if JAVA_SPEC_VERSION >= 16
#if defined(OMR_OPT_CUDA)
OMRMEM_CATEGORY_10_CHILDREN("VM", OMRMEM_CATEGORY_VM, J9MEM_CATEGORY_CLASSES, J9MEM_CATEGORY_MODULES, OMRMEM_CATEGORY_MM, OMRMEM_CATEGORY_THREADS, OMRMEM_CATEGORY_TRACE, J9MEM_CATEGORY_JVMTI, J9MEM_CATEGORY_JNI, OMRMEM_CATEGORY_CUDA, OMRMEM_CATEGORY_PORT_LIBRARY, J9MEM_CATEGORY_VM_FFI);
#else /* OMR_OPT_CUDA */
OMRMEM_CATEGORY_9_CHILDREN("VM", OMRMEM_CATEGORY_VM, J9MEM_CATEGORY_CLASSES, J9MEM_CATEGORY_MODULES, OMRMEM_CATEGORY_MM, OMRMEM_CATEGORY_THREADS, OMRMEM_CATEGORY_TRACE, J9MEM_CATEGORY_JVMTI, J9MEM_CATEGORY_JNI, OMRMEM_CATEGORY_PORT_LIBRARY, J9MEM_CATEGORY_VM_FFI);
#endif /* OMR_OPT_CUDA */
#else /* JAVA_SPEC_VERSION >= 16 */
#if defined(OMR_OPT_CUDA)
OMRMEM_CATEGORY_9_CHILDREN("VM", OMRMEM_CATEGORY_VM, J9MEM_CATEGORY_CLASSES, J9MEM_CATEGORY_MODULES, OMRMEM_CATEGORY_MM, OMRMEM_CATEGORY_THREADS, OMRMEM_CATEGORY_TRACE, J9MEM_CATEGORY_JVMTI, J9MEM_CATEGORY_JNI, OMRMEM_CATEGORY_CUDA, OMRMEM_CATEGORY_PORT_LIBRARY);
#else /* OMR_OPT_CUDA */
OMRMEM_CATEGORY_8_CHILDREN("VM", OMRMEM_CATEGORY_VM, J9MEM_CATEGORY_CLASSES, J9MEM_CATEGORY_MODULES, OMRMEM_CATEGORY_MM, OMRMEM_CATEGORY_THREADS, OMRMEM_CATEGORY_TRACE, J9MEM_CATEGORY_JVMTI, J9MEM_CATEGORY_JNI, OMRMEM_CATEGORY_PORT_LIBRARY);
#endif /* OMR_OPT_CUDA */
#endif /* JAVA_SPEC_VERSION >= 16 */
OMRMEM_CATEGORY_1_CHILD("Classes", J9MEM_CATEGORY_CLASSES, J9MEM_CATEGORY_CLASSES_SHC_CACHE);
OMRMEM_CATEGORY_NO_CHILDREN("Shared Class Cache", J9MEM_CATEGORY_CLASSES_SHC_CACHE);
OMRMEM_CATEGORY_1_CHILD("Memory Manager (GC)", OMRMEM_CATEGORY_MM, OMRMEM_CATEGORY_MM_RUNTIME_HEAP);
OMRMEM_CATEGORY_NO_CHILDREN("Java Heap", OMRMEM_CATEGORY_MM_RUNTIME_HEAP);
OMRMEM_CATEGORY_NO_CHILDREN("Java Stack", OMRMEM_CATEGORY_THREADS_RUNTIME_STACK);
OMRMEM_CATEGORY_NO_CHILDREN("Trace", OMRMEM_CATEGORY_TRACE);
OMRMEM_CATEGORY_2_CHILDREN("JIT", OMRMEM_CATEGORY_JIT, OMRMEM_CATEGORY_JIT_CODE_CACHE, OMRMEM_CATEGORY_JIT_DATA_CACHE);
OMRMEM_CATEGORY_NO_CHILDREN("JIT Code Cache", OMRMEM_CATEGORY_JIT_CODE_CACHE);
OMRMEM_CATEGORY_NO_CHILDREN("JIT Data Cache", OMRMEM_CATEGORY_JIT_DATA_CACHE);
OMRMEM_CATEGORY_1_CHILD("sun.misc.Unsafe", J9MEM_CATEGORY_SUN_MISC_UNSAFE_ALLOCATE, J9MEM_CATEGORY_SUN_MISC_UNSAFE_ALLOCATEDBB);
OMRMEM_CATEGORY_NO_CHILDREN("Direct Byte Buffers", J9MEM_CATEGORY_SUN_MISC_UNSAFE_ALLOCATEDBB);
OMRMEM_CATEGORY_2_CHILDREN("VM Class Libraries", J9MEM_CATEGORY_VM_JCL, J9MEM_CATEGORY_CUDA4J, J9MEM_CATEGORY_SUN_MISC_UNSAFE_ALLOCATE);
OMRMEM_CATEGORY_NO_CHILDREN("CUDA4J", J9MEM_CATEGORY_CUDA4J);
OMRMEM_CATEGORY_2_CHILDREN("Class Libraries", J9MEM_CATEGORY_CLASS_LIBRARIES, J9MEM_CATEGORY_SUN_JCL, J9MEM_CATEGORY_VM_JCL);
OMRMEM_CATEGORY_1_CHILD("JVMTI", J9MEM_CATEGORY_JVMTI, J9MEM_CATEGORY_JVMTI_ALLOCATE);
OMRMEM_CATEGORY_NO_CHILDREN("JVMTI Allocate()", J9MEM_CATEGORY_JVMTI_ALLOCATE);
OMRMEM_CATEGORY_NO_CHILDREN("JNI", J9MEM_CATEGORY_JNI);
OMRMEM_CATEGORY_7_CHILDREN("Standard Class Libraries", J9MEM_CATEGORY_SUN_JCL, J9MEM_CATEGORY_CLASSLIB_IO_MATH_LANG,
		J9MEM_CATEGORY_CLASSLIB_ZIP, J9MEM_CATEGORY_CLASSLIB_WRAPPERS, J9MEM_CATEGORY_CLASSLIB_NETWORKING, J9MEM_CATEGORY_CLASSLIB_GUI,
		J9MEM_CATEGORY_CLASSLIB_FONT, J9MEM_CATEGORY_CLASSLIB_SOUND);
OMRMEM_CATEGORY_NO_CHILDREN("IO/Math/Language", J9MEM_CATEGORY_CLASSLIB_IO_MATH_LANG);
OMRMEM_CATEGORY_NO_CHILDREN("Zip", J9MEM_CATEGORY_CLASSLIB_ZIP);
OMRMEM_CATEGORY_2_CHILDREN("Wrappers",J9MEM_CATEGORY_CLASSLIB_WRAPPERS, J9MEM_CATEGORY_CLASSLIB_WRAPPERS_MALLOC, J9MEM_CATEGORY_CLASSLIB_WRAPPERS_EBCDIC);
OMRMEM_CATEGORY_NO_CHILDREN("Malloc", J9MEM_CATEGORY_CLASSLIB_WRAPPERS_MALLOC);
OMRMEM_CATEGORY_NO_CHILDREN("z/OS EBCDIC Conversion", J9MEM_CATEGORY_CLASSLIB_WRAPPERS_EBCDIC);
OMRMEM_CATEGORY_3_CHILDREN("Networking", J9MEM_CATEGORY_CLASSLIB_NETWORKING, J9MEM_CATEGORY_CLASSLIB_NETWORKING_NET, J9MEM_CATEGORY_CLASSLIB_NETWORKING_NIO, J9MEM_CATEGORY_CLASSLIB_NETWORKING_RMI);
OMRMEM_CATEGORY_NO_CHILDREN("NET", J9MEM_CATEGORY_CLASSLIB_NETWORKING_NET);
OMRMEM_CATEGORY_NO_CHILDREN("NIO and NIO.2", J9MEM_CATEGORY_CLASSLIB_NETWORKING_NIO);
OMRMEM_CATEGORY_NO_CHILDREN("RMI", J9MEM_CATEGORY_CLASSLIB_NETWORKING_RMI);
OMRMEM_CATEGORY_4_CHILDREN("GUI", J9MEM_CATEGORY_CLASSLIB_GUI, J9MEM_CATEGORY_CLASSLIB_GUI_AWT, J9MEM_CATEGORY_CLASSLIB_GUI_MAWT, J9MEM_CATEGORY_CLASSLIB_GUI_JAWT, J9MEM_CATEGORY_CLASSLIB_GUI_MEDIALIB);
OMRMEM_CATEGORY_NO_CHILDREN("AWT", J9MEM_CATEGORY_CLASSLIB_GUI_AWT);
OMRMEM_CATEGORY_NO_CHILDREN("MAWT", J9MEM_CATEGORY_CLASSLIB_GUI_MAWT);
OMRMEM_CATEGORY_NO_CHILDREN("JAWT", J9MEM_CATEGORY_CLASSLIB_GUI_JAWT);
OMRMEM_CATEGORY_NO_CHILDREN("Medialib Image", J9MEM_CATEGORY_CLASSLIB_GUI_MEDIALIB);
OMRMEM_CATEGORY_NO_CHILDREN("Font", J9MEM_CATEGORY_CLASSLIB_FONT);
OMRMEM_CATEGORY_NO_CHILDREN("Sound", J9MEM_CATEGORY_CLASSLIB_SOUND);
OMRMEM_CATEGORY_NO_CHILDREN("Modules", J9MEM_CATEGORY_MODULES);
#if defined(OMR_OPT_CUDA)
OMRMEM_CATEGORY_NO_CHILDREN("CUDA", OMRMEM_CATEGORY_CUDA);
#endif /* OMR_OPT_CUDA */
#if JAVA_SPEC_VERSION >= 16
OMRMEM_CATEGORY_NO_CHILDREN("Foreign Linker API", J9MEM_CATEGORY_VM_FFI);
#endif /* JAVA_SPEC_VERSION >= 16 */

static OMRMemCategory * categories[] = {
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_JRE),
CATEGORY_TABLE_ENTRY(OMRMEM_CATEGORY_VM),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_CLASSES),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_MODULES),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_CLASSES_SHC_CACHE),
CATEGORY_TABLE_ENTRY(OMRMEM_CATEGORY_MM),
CATEGORY_TABLE_ENTRY(OMRMEM_CATEGORY_MM_RUNTIME_HEAP),
CATEGORY_TABLE_ENTRY(OMRMEM_CATEGORY_THREADS_RUNTIME_STACK),
CATEGORY_TABLE_ENTRY(OMRMEM_CATEGORY_TRACE),
CATEGORY_TABLE_ENTRY(OMRMEM_CATEGORY_JIT),
CATEGORY_TABLE_ENTRY(OMRMEM_CATEGORY_JIT_CODE_CACHE),
CATEGORY_TABLE_ENTRY(OMRMEM_CATEGORY_JIT_DATA_CACHE),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_CUDA4J),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_SUN_MISC_UNSAFE_ALLOCATE),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_VM_JCL),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_CLASS_LIBRARIES),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_JVMTI),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_JVMTI_ALLOCATE),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_JNI),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_SUN_JCL),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_CLASSLIB_IO_MATH_LANG),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_CLASSLIB_ZIP),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_CLASSLIB_WRAPPERS),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_CLASSLIB_WRAPPERS_MALLOC),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_CLASSLIB_WRAPPERS_EBCDIC),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_CLASSLIB_NETWORKING),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_CLASSLIB_NETWORKING_NET),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_CLASSLIB_NETWORKING_NIO),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_CLASSLIB_NETWORKING_RMI),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_CLASSLIB_GUI),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_CLASSLIB_GUI_AWT),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_CLASSLIB_GUI_MAWT),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_CLASSLIB_GUI_JAWT),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_CLASSLIB_GUI_MEDIALIB),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_CLASSLIB_FONT),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_CLASSLIB_SOUND),
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_SUN_MISC_UNSAFE_ALLOCATEDBB),
#if defined(OMR_OPT_CUDA)
CATEGORY_TABLE_ENTRY(OMRMEM_CATEGORY_CUDA),
#endif /* OMR_OPT_CUDA */
NULL, /* OMRMEM_CATEGORY_THREADS populated by thread library */
NULL, /* OMRMEM_CATEGORY_THREADS_NATIVE_STACK populated by thread library */
#if JAVA_SPEC_VERSION >= 16
CATEGORY_TABLE_ENTRY(J9MEM_CATEGORY_VM_FFI),
#endif /* JAVA_SPEC_VERSION >= 16 */
};

OMRMemCategorySet j9MainMemCategorySet = { sizeof(categories) / sizeof(OMRMemCategory *), categories };
