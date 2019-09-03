package com.indiewalkabout.grimb.engine.particles;

import java.util.Random;

/**
 *
 */
public class RotationSpeedInitializer implements ParticleInitializer {

    private double mMinRotationSpeed;
    private double mMaxRotationSpeed;

    public RotationSpeedInitializer(double minRotationSpeed,	double maxRotationSpeed) {
        mMinRotationSpeed = minRotationSpeed;
        mMaxRotationSpeed = maxRotationSpeed;
    }

    @Override
    public void initParticle(Particle p, Random r) {
        double rotationSpeed = r.nextDouble()*(mMaxRotationSpeed-mMinRotationSpeed) + mMinRotationSpeed;
        p.mRotationSpeed = rotationSpeed;
    }

}
