package org.huifeng.execise.match;

public interface CharMatchLifeCycle {

     //发射
     String prepareLaunch(String in);

     //回收
     void recycle();
}
