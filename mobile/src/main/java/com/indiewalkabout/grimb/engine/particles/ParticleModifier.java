package com.indiewalkabout.grimb.engine.particles;

/**
 * Created by Raul Portales on 02/04/15.
 */
public interface ParticleModifier {
    void apply(Particle particle, long miliseconds);
}