package com.indiewalkabout.grimb.input;

import android.view.View;

import com.indiewalkabout.grimb.GrimbActivity;

/**
 *
 */
public class CompositeInputController extends InputController {
    private GamepadInputController mGamepadInputController;
    private VirtualJoystickInputController mVJoystickInputController;


    public CompositeInputController(View view, GrimbActivity activity) {
        mGamepadInputController = new GamepadInputController(activity);
        mVJoystickInputController = new VirtualJoystickInputController(view);
    }

    public void onPreUpdate() {
        mIsFiring = mGamepadInputController.mIsFiring || mVJoystickInputController.mIsFiring;
        mHorizontalFactor = mGamepadInputController.mHorizontalFactor + mVJoystickInputController.mHorizontalFactor;
        mVerticalFactor = mGamepadInputController.mVerticalFactor + mVJoystickInputController.mVerticalFactor;
    }

    @Override
    public void onStart() {
        mGamepadInputController.onStart();
        mVJoystickInputController.onStart();
    }

    @Override
    public void onStop() {
        mGamepadInputController.onStop();
        mVJoystickInputController.onStop();
    }

    @Override
    public void onPause() {
        mGamepadInputController.onPause();
        mVJoystickInputController.onPause();
    }

    @Override
    public void onResume() {
        mGamepadInputController.onResume();
        mVJoystickInputController.onResume();
    }
}
