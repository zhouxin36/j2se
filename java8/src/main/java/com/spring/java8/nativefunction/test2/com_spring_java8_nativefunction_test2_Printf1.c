#include "com_spring_java8_nativefunction_test2_Printf1.h"
#include <stdio.h>

JNIEXPORT jint JNICALL Java_com_spring_java8_nativefunction_test2_Printf1_print
  (JNIEnv * env, jclass cl, jint width, jint precision, jdouble x)
  {
    char fmt[30];
    jint ret;
    sprintf(fmt, "%%%d.%df", width, precision);
    ret = printf(fmt, x);
    fflush(stdout);
    return ret;
  }