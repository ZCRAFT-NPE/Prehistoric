package com.wiyuka.prehistoric.raytracesound.rtmaterial;

import org.joml.Vector3f;

public class RayTraceMaterial {

    public float spread = 0.5f;
    public float maxAngle = 0.1f;
    public int samplingTimes = 10;

    public float absorption = 0.0f;
    public float scattering = 0.0f;
    public float reflectivity = 0.5f;
    public float roughness = 0.1f;

    public static float angularWeight(Vector3f idealReflectionVec, Vector3f reflectedVec) {
        float dot = idealReflectionVec.dot(reflectedVec);
        dot = Math.max(-1.0f, Math.min(1.0f, dot));
        float angle = (float) Math.acos(Math.max(0.0f, dot));
        float sigma = 0.1f;
        return (float) Math.exp(-(angle * angle) / (2.0f * sigma * sigma));
    }

    public static void a() {

    }
}

//行我先退了 咱们换个项目吧
//我还以为你找到了