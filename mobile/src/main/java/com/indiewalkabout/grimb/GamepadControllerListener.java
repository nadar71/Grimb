package com.indiewalkabout.grimb;

import android.view.KeyEvent;
import android.view.MotionEvent;

/**
 *
 */
public interface GamepadControllerListener {

    boolean dispatchGenericMotionEvent(MotionEvent event);

    boolean dispatchKeyEvent(KeyEvent event);
}
