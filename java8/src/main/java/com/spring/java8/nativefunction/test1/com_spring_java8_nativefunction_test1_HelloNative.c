#include "com_spring_java8_nativefunction_test1_HelloNative.h"
#include <stdio.h>

JNIEXPORT void JNICALL Java_com_spring_java8_nativefunction_test1_HelloNative_greeting
(JNIEnv* env, jclass cl) {
	printf("Hello native World!\n");
}