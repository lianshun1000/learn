package com.learn.cpp;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * @author lianshun
 * @date 2021/9/26 4:26 下午
 * @description
 */
public interface Clibrary extends Library {
    Clibrary INATANCE = (Clibrary) Native.synchronizedLibrary((Clibrary)Native.loadLibrary("/Users/lianshun/learn/learn/algorithm/src/main/resources/libfunc.so", Clibrary.class));

    String sayHello(String input);

}
