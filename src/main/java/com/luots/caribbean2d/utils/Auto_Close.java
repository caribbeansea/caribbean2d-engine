package com.luots.caribbean2d.utils;

/*
 * Creates on 2020/5/14.
 */

import com.luots.caribbean2d.Log;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author kevin
 */
public class Auto_Close
{

  public static void close(Closeable... closeables) {
    try {
      if (closeables == null) return;
      for (Closeable closeable : closeables) {
        if (closeable == null) continue;
        closeable.close();
      }
    }catch (IOException e){
      Log.error("close failure.", e);
    }
  }

}