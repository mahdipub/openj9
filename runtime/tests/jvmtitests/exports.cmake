################################################################################
# Copyright IBM Corp. and others 2019
#
# This program and the accompanying materials are made available under
# the terms of the Eclipse Public License 2.0 which accompanies this
# distribution and is available at https://www.eclipse.org/legal/epl-2.0/
# or the Apache License, Version 2.0 which accompanies this distribution and
# is available at https://www.apache.org/licenses/LICENSE-2.0.
#
# This Source Code may also be made available under the following
# Secondary Licenses when the conditions for such availability set
# forth in the Eclipse Public License, v. 2.0 are satisfied: GNU
# General Public License, version 2 with the GNU Classpath
# Exception [1] and GNU General Public License, version 2 with the
# OpenJDK Assembly Exception [2].
#
# [1] https://www.gnu.org/software/classpath/license.html
# [2] https://openjdk.org/legal/assembly-exception.html
#
# SPDX-License-Identifier: EPL-2.0 OR Apache-2.0 OR GPL-2.0 WITH Classpath-exception-2.0 OR LicenseRef-GPL-2.0 WITH Assembly-exception
################################################################################

omr_add_exports(jvmtitest
	Agent_OnLoad
	Agent_OnUnload
	Agent_OnAttach
	Java_com_ibm_jvmti_tests_util_TestSuite_getTestCount
	Java_com_ibm_jvmti_tests_util_TestSuite_getTestClassName
	Java_com_ibm_jvmti_tests_util_TestSuite_getSelectedTestClassName
	Java_com_ibm_jvmti_tests_util_TestCase_getSelectedTestArguments
	Java_com_ibm_jvmti_tests_util_TestCase_getSpecificSubTestName
	Java_com_ibm_jvmti_tests_util_ErrorControl_hasErrors
	Java_com_ibm_jvmti_tests_util_ErrorControl_getErrorCount
	Java_com_ibm_jvmti_tests_util_Error_getErrorDetails
	Java_com_ibm_jvmti_tests_iterateOverInstancesOfClass_ioioc001_checkSubclasses
	Java_com_ibm_jvmti_tests_iterateThroughHeap_ith001Sub_testHeapIteration
	Java_com_ibm_jvmti_tests_iterateThroughHeap_ith001Sub_testArrayPrimitive
	Java_com_ibm_jvmti_tests_iterateThroughHeap_ith001Sub_testFieldPrimitive
	Java_com_ibm_jvmti_tests_iterateThroughHeap_ith001Sub_testStringPrimitive
	Java_com_ibm_jvmti_tests_iterateThroughHeap_ith001Sub_tagObject
	Java_com_ibm_jvmti_tests_iterateOverHeap_ioh001_iterate
	Java_com_ibm_jvmti_tests_getClassFields_gcf001_checkClassFields
	Java_com_ibm_jvmti_tests_getStackTrace_gst001_check
	Java_com_ibm_jvmti_tests_getStackTrace_gst002_check
	Java_com_ibm_jvmti_tests_getStackTraceExtended_gste001_anyJittedFrame
	Java_com_ibm_jvmti_tests_getAllStackTracesExtended_gaste001_anyJittedFrame
	Java_com_ibm_jvmti_tests_getThreadListStackTracesExtended_gtlste001_anyJittedFrame
	Java_com_ibm_jvmti_tests_addToBootstrapClassLoaderSearch_abcl002_addJar
	Java_com_ibm_jvmti_tests_addToBootstrapClassLoaderSearch_abcl003_addJar
	Java_com_ibm_jvmti_tests_addToSystemClassLoaderSearch_ascl002_addJar
	Java_com_ibm_jvmti_tests_addToSystemClassLoaderSearch_ascl003_addJar
	Java_com_ibm_jvmti_tests_fieldwatch_fw001_startTest
	Java_com_ibm_jvmti_tests_fieldwatch_fw001_endTest
	Java_com_ibm_jvmti_tests_fieldwatch_fw001_modifyWatches
	Java_com_ibm_jvmti_tests_followReferences_fr002_followRefs
	Java_com_ibm_jvmti_tests_followReferences_fr003_followFromObject
	Java_com_ibm_jvmti_tests_followReferences_fr003_followFromArrayObject
	Java_com_ibm_jvmti_tests_followReferences_fr003_followFromStringObject
	Java_com_ibm_jvmti_tests_followReferences_fr003_getStringData
	Java_com_ibm_jvmti_tests_followReferences_fr004_followObjectPrimitiveFields
	Java_com_ibm_jvmti_tests_followReferences_TagManager_setTag
	Java_com_ibm_jvmti_tests_followReferences_TagManager_checkTags
	Java_com_ibm_jvmti_tests_followReferences_TagManager_clearTags
	Java_com_ibm_jvmti_tests_followReferences_TagManager_isTagQueued
	Java_com_ibm_jvmti_tests_forceEarlyReturn_fer002_forceEarlyReturnInt
	Java_com_ibm_jvmti_tests_forceEarlyReturn_fer002_forceEarlyReturnBoolean
	Java_com_ibm_jvmti_tests_forceEarlyReturn_fer002_forceEarlyReturnShort
	Java_com_ibm_jvmti_tests_forceEarlyReturn_fer002_forceEarlyReturnLong
	Java_com_ibm_jvmti_tests_forceEarlyReturn_fer002_forceEarlyReturnDouble
	Java_com_ibm_jvmti_tests_forceEarlyReturn_fer002_forceEarlyReturnVoid
	Java_com_ibm_jvmti_tests_forceEarlyReturn_fer002_forceEarlyReturnObject
	Java_com_ibm_jvmti_tests_forceEarlyReturn_fer002_methodExitState
	Java_com_ibm_jvmti_tests_forceEarlyReturn_fer003_forceEarlyReturn
	Java_com_ibm_jvmti_tests_resourceExhausted_re001_hasBeenCalledBack
	Java_com_ibm_jvmti_tests_resourceExhausted_re002_hasBeenCalledBack
	Java_com_ibm_jvmti_tests_getClassVersionNumbers_gcvn001_checkVersionNumbers
	Java_com_ibm_jvmti_tests_eventClassFileLoadHook_ecflh001_checkReenableInLivePhase
	Java_com_ibm_jvmti_tests_eventThreadStart_ets001_check
	Java_com_ibm_jvmti_tests_eventVMObjectAllocation_evmoa001_didTestRun
	Java_com_ibm_jvmti_tests_eventMethodEntryGrow_emeng001_emeng001NativeMethod
	Java_com_ibm_jvmti_tests_eventMethodExit_emex001_sampleNativeMethod
	Java_com_ibm_jvmti_tests_eventMethodExit_emex001_checkJavaMethodExit
	Java_com_ibm_jvmti_tests_eventMethodExit_emex001_checkNativeMethodExit
	Java_com_ibm_jvmti_tests_getCurrentThreadCpuTimerInfo_gctcti001_verifyTimerInfo
	Java_com_ibm_jvmti_tests_BCIWithASM_ta001_redefineClass
	Java_com_ibm_jvmti_tests_redefineClasses_rc001_redefineClass
	Java_com_ibm_jvmti_tests_redefineClasses_rc002_redefineClass
	Java_com_ibm_jvmti_tests_redefineClasses_rc003_redefineClass
	Java_com_ibm_jvmti_tests_redefineClasses_rc004_redefineClass
	Java_com_ibm_jvmti_tests_redefineClasses_rc004_redefineClassAndTestFieldIDs
	Java_com_ibm_jvmti_tests_redefineClasses_rc004_accessStoredIDs
	Java_com_ibm_jvmti_tests_redefineClasses_rc005_redefineClass
	Java_com_ibm_jvmti_tests_redefineClasses_rc006_redefineClassAndTestMethodIDs
	Java_com_ibm_jvmti_tests_redefineClasses_rc006_accessStoredIDs
	Java_com_ibm_jvmti_tests_redefineClasses_rc007_redefineClasses
	Java_com_ibm_jvmti_tests_redefineClasses_rc008_redefineClass
	Java_com_ibm_jvmti_tests_redefineClasses_rc009_redefineClass
	Java_com_ibm_jvmti_tests_redefineClasses_rc010_redefineClass
	Java_com_ibm_jvmti_tests_redefineClasses_rc011_redefineClass1
	Java_com_ibm_jvmti_tests_redefineClasses_rc011_redefineClass3
	Java_com_ibm_jvmti_tests_redefineClasses_rc012_redefineClass
	Java_com_ibm_jvmti_tests_redefineClasses_rc012_1testRedefineRunningNativeMethod_1O1_meth1
	Java_com_ibm_jvmti_tests_redefineClasses_rc013_redefineClass
	Java_com_ibm_jvmti_tests_redefineClasses_rc014_redefineClass
	Java_com_ibm_jvmti_tests_redefineClasses_rc014_redefineClassExpectFailure
	Java_com_ibm_jvmti_tests_redefineClasses_rc015_redefineClass
	Java_com_ibm_jvmti_tests_redefineClasses_rc016_redefineClass
	Java_com_ibm_jvmti_tests_redefineClasses_rc017_redefineMultipleClass
	Java_com_ibm_jvmti_tests_redefineClasses_rc018_redefineClass
	Java_com_ibm_jvmti_tests_redefineClasses_rc019a_redefineClass
	Java_com_ibm_jvmti_tests_redefineClasses_rc019a_getValue
	Java_com_ibm_jvmti_tests_redefineClasses_rc019b_redefineClass
	Java_com_ibm_jvmti_tests_redefineClasses_rc019b_getValue
	Java_com_ibm_jvmti_tests_redefineClasses_rc020_redefineClass
	Java_com_ibm_jvmti_tests_redefineClasses_rc021_redefineClass
	Java_com_ibm_jvmti_tests_getPotentialCapabilities_gpc001_verifyOnLoadCapabilities
	Java_com_ibm_jvmti_tests_getPotentialCapabilities_gpc001_verifyLiveCapabilities
	Java_com_ibm_jvmti_tests_getPotentialCapabilities_gpc002_verifyCapabilityRetention
	Java_com_ibm_jvmti_tests_getThreadGroupChildren_gtgc001_checkAssignment
	Java_com_ibm_jvmti_tests_getThreadGroupChildren_gtgc002_checkGroupName
	Java_com_ibm_jvmti_tests_getOwnedMonitorStackDepthInfo_gomsdi001_nDepth
	Java_com_ibm_jvmti_tests_getOwnedMonitorStackDepthInfo_ThreadNDepth_verify
	Java_com_ibm_jvmti_tests_getOwnedMonitorStackDepthInfo_ThreadNDepth_verifyDeeper
	Java_com_ibm_jvmti_tests_getOwnedMonitorStackDepthInfo_gomsdi002_callGet
	Java_com_ibm_jvmti_tests_getThreadState_gts001_getThreadStates
	Java_com_ibm_jvmti_tests_getOwnedMonitorInfo_ThreadMonitorInfoTest_verifyMonitors
	Java_com_ibm_jvmti_tests_getOwnedMonitorInfo_gomi002_callGet
	Java_com_ibm_jvmti_tests_getHeapFreeTotalMemory_ghftm001_getHeapFreeMemory
	Java_com_ibm_jvmti_tests_getHeapFreeTotalMemory_ghftm001_getHeapTotalMemory
	Java_com_ibm_jvmti_tests_getHeapFreeTotalMemory_ghftm001_getCycleStartCount
	Java_com_ibm_jvmti_tests_getHeapFreeTotalMemory_ghftm001_getCycleEndCount
	Java_com_ibm_jvmti_tests_getMethodAndClassNames_gmcpn001_check
	Java_com_ibm_jvmti_tests_removeAllTags_rat001_tryRemoveAllTags
	Java_com_ibm_jvmti_tests_traceSubscription_ts001_tryRegisterTraceSubscriber
	Java_com_ibm_jvmti_tests_traceSubscription_ts001_tryFlushTraceData
	Java_com_ibm_jvmti_tests_traceSubscription_ts001_tryDeregisterTraceSubscriber
	Java_com_ibm_jvmti_tests_traceSubscription_ts001_getBufferCount
	Java_com_ibm_jvmti_tests_traceSubscription_ts001_getFinalBufferCount
	Java_com_ibm_jvmti_tests_traceSubscription_ts001_tryGetTraceMetadata
	Java_com_ibm_jvmti_tests_traceSubscription_ts002_tryRegisterTracePointSubscribers
	Java_com_ibm_jvmti_tests_traceSubscription_ts002_tryDeregisterTracePointSubscribers
	Java_com_ibm_jvmti_tests_traceSubscription_ts002_getTracePointCount1
	Java_com_ibm_jvmti_tests_traceSubscription_ts002_getTracePointCount2
	Java_com_ibm_jvmti_tests_traceSubscription_ts002_hasAlarmTriggered1
	Java_com_ibm_jvmti_tests_traceSubscription_ts002_hasAlarmTriggered2
	Java_com_ibm_jvmti_tests_decompResolveFrame_ResolveFrameClassloader_checkFrame
	Java_com_ibm_jvmti_tests_decompResolveFrame_decomp002_singleStep
	Java_com_ibm_jvmti_tests_decompResolveFrame_decomp003_startStepping
	Java_com_ibm_jvmti_tests_decompResolveFrame_decomp003_stopStepping
	Java_com_ibm_jvmti_tests_decompResolveFrame_decomp004_triggerDecompile
	Java_com_ibm_jvmti_tests_decompResolveFrame_decomp005_triggerDecompile
	Java_com_ibm_jvmti_tests_vmDump_vmd001_tryQueryDumpSmallBuffer
	Java_com_ibm_jvmti_tests_vmDump_vmd001_tryQueryDumpBigBuffer
	Java_com_ibm_jvmti_tests_vmDump_vmd001_tryQueryDumpInvalidBufferSize
	Java_com_ibm_jvmti_tests_vmDump_vmd001_tryQueryDumpInvalidBuffer
	Java_com_ibm_jvmti_tests_vmDump_vmd001_tryQueryDumpInvalidDataSize
	Java_com_ibm_jvmti_tests_vmDump_vmd001_trySetVmDump
	Java_com_ibm_jvmti_tests_vmDump_vmd001_tryResetVmDump
	Java_com_ibm_jvmti_tests_vmDump_vmd001_tryDisableVmDump
	Java_com_ibm_jvmti_tests_getLoadedClasses_glc001_check
	Java_com_ibm_jvmti_tests_retransformClasses_rtc001_retransformClass
	Java_com_ibm_jvmti_tests_retransformClasses_rtc002_retransformClass
	Java_com_ibm_jvmti_tests_retransformClasses_rtc003_retransformClass
	Java_com_ibm_jvmti_tests_log_log001_tryQueryLogOptions
	Java_com_ibm_jvmti_tests_log_log001_trySetLogOptions
	Java_com_ibm_jvmti_tests_javaLockMonitoring_jlm001_jvmtiJlmSet
	Java_com_ibm_jvmti_tests_javaLockMonitoring_jlm001_jvmtiJlmDump
	Java_com_ibm_jvmti_tests_javaLockMonitoring_jlm001_enableMonitoringEvent
	Java_com_ibm_jvmti_tests_javaLockMonitoring_jlm001_disableMonitoringEvent
	Java_tests_sharedclasses_options_TestSharedCacheJvmtiAPI_iterateSharedCache
	Java_tests_sharedclasses_options_TestSharedCacheJvmtiAPI_destroySharedCache
	Java_com_ibm_jvmti_tests_getMemoryCategories_gmc001_check
	Java_com_ibm_jvmti_tests_getOrSetLocal_gosl001_getInt
	Java_com_ibm_jvmti_tests_verboseGC_vgc001_tryRegisterVerboseGCSubscriber
	Java_com_ibm_jvmti_tests_verboseGC_vgc001_tryDeregisterVerboseGCSubscriber
	Java_com_ibm_jvmti_tests_verboseGC_vgc001_getBufferCount
	Java_com_ibm_jvmti_tests_verboseGC_vgc001_hasAlarmed
	Java_com_ibm_jvmti_tests_verboseGC_vgc001_tryRegisterVerboseGCSubscriber2
	Java_com_ibm_jvmti_tests_verboseGC_vgc001_tryDeregisterVerboseGCSubscriber2
	Java_com_ibm_jvmti_tests_verboseGC_vgc001_getBufferCount2
	Java_com_ibm_jvmti_tests_verboseGC_vgc001_hasAlarmed2
	Java_com_ibm_jvmti_tests_verboseGC_vgc001_tryRegisterVerboseGCSubscriber3
	Java_com_ibm_jvmti_tests_verboseGC_vgc001_tryDeregisterVerboseGCSubscriber3
	Java_com_ibm_jvmti_tests_verboseGC_vgc001_getBufferCount3
	Java_com_ibm_jvmti_tests_verboseGC_vgc001_hasAlarmed3
	Java_com_ibm_jvmti_tests_getJ9vmThread_gjvmt001_validateGJVMT001
	Java_com_ibm_jvmti_tests_getJ9method_gj9m001_validateGJ9M001
	Java_com_ibm_jvmti_tests_retransformRedefineCombo_rrc001_setTransformerData
	Java_com_ibm_jvmti_tests_retransformRedefineCombo_rrc001_retransformClass
	Java_com_ibm_jvmti_tests_retransformRedefineCombo_rrc001_redefineClass
	Java_com_ibm_jvmti_tests_redefineBreakpointCombo_rbc001_redefineClass
	Java_com_ibm_jvmti_tests_redefineBreakpointCombo_rbc001_setBreakpoint
	Java_com_ibm_jvmti_tests_redefineBreakpointCombo_rbc001_clearBreakpoint
	Java_com_ibm_jvmti_tests_redefineBreakpointCombo_rbc001_setBreakpointInMethodID
	Java_com_ibm_jvmti_tests_redefineBreakpointCombo_rbc001_getMethodID
	Java_com_ibm_jvmti_tests_redefineBreakpointCombo_rbc001_getMethodIDFromStack
	Java_com_ibm_jvmti_tests_classModificationAgent_cma001_retransformClass
	Java_com_ibm_jvmti_tests_classModificationAgent_cma001_redefineClass
	Java_com_ibm_jvmti_tests_registerNativesWithRetransformation_rnwr001_registerNative
	Java_com_ibm_jvmti_tests_registerNativesWithRetransformation_rnwr001_retransformClass
	Java_com_ibm_jvmti_tests_agentLibraryNatives_aln001_shortname
	Java_com_ibm_jvmti_tests_agentLibraryNatives_aln001_longname__I
	Java_com_ibm_jvmti_tests_nestMatesRedefinition_nmr001_redefineClass
	Java_com_ibm_jvmti_tests_setNativeMethodPrefix_snmp001_setPrefix
	Java_com_ibm_jvmti_tests_setNativeMethodPrefix_snmp001_nat
	Java_com_ibm_jvmti_tests_getSystemProperty_gsp001_getSystemProperty
	Java_com_ibm_jvmti_tests_getSystemProperty_gsp001_cleanup
	Java_com_ibm_jvmti_tests_eventException_ee001_invoke
	Java_com_ibm_jvmti_tests_eventException_ee001_check
	Java_com_ibm_jvmti_tests_eventVMStart_vmstart001_check
)

if(NOT JAVA_SPEC_VERSION LESS 9)
	omr_add_exports(jvmtitest
		Java_com_ibm_jvmti_tests_modularityTests_mt001_addModuleReads
		Java_com_ibm_jvmti_tests_modularityTests_mt001_addModuleExports
		Java_com_ibm_jvmti_tests_modularityTests_mt001_addModuleUses
		Java_com_ibm_jvmti_tests_modularityTests_mt001_addModuleOpens
		Java_com_ibm_jvmti_tests_modularityTests_mt001_addModuleProvides
	)
endif()

if(NOT JAVA_SPEC_VERSION LESS 11)
	omr_add_exports(jvmtitest
		Java_com_ibm_jvmti_tests_samplingObjectAllocation_soae001_reset
		Java_com_ibm_jvmti_tests_samplingObjectAllocation_soae001_enable
		Java_com_ibm_jvmti_tests_samplingObjectAllocation_soae001_disable
		Java_com_ibm_jvmti_tests_samplingObjectAllocation_soae001_check
	)
endif()
