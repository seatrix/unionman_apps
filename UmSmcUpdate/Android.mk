LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_SRC_FILES := $(call all-subdir-java-files)
LOCAL_MODULE_PATH := $(TARGET_OUT)/vendor/dvb/install_packages/default_city

LOCAL_JAVA_LIBRARIES :=
LOCAL_STATIC_JAVA_LIBRARIES := jazzlib

LOCAL_PACKAGE_NAME := UmSmcUpdate

LOCAL_JNI_SHARED_LIBRARIES := libsmcjni

LOCAL_CERTIFICATE := shared
LOCAL_REQUIRED_MODULES := libsmcjni

LOCAL_PROGUARD_ENABLED := full
LOCAL_PROGUARD_FLAG_FILES := proguard.flags

include $(BUILD_PACKAGE)


include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_SRC_FILES := $(call all-subdir-java-files)
LOCAL_MODULE_PATH := $(TARGET_OUT_VENDOR_APPS)

LOCAL_JAVA_LIBRARIES :=
LOCAL_STATIC_JAVA_LIBRARIES := jazzlib

LOCAL_PACKAGE_NAME := UmSmcUpdatePreInstall

LOCAL_JNI_SHARED_LIBRARIES := libsmcjni

LOCAL_CERTIFICATE := shared
LOCAL_REQUIRED_MODULES := libsmcjni

LOCAL_PROGUARD_ENABLED := full
LOCAL_PROGUARD_FLAG_FILES := proguard.flags

include $(BUILD_PACKAGE)

include $(LOCAL_PATH)/jni/Android.mk
# Use the folloing include to make our test apk.    
include $(call all-makefiles-under,$(LOCAL_PATH))  
 