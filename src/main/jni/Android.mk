LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_SRC_FILES := \
	examples.cpp

LOCAL_LDLIBS:= -llog

LOCAL_MODULE:= examples

include $(BUILD_SHARED_LIBRARY)
