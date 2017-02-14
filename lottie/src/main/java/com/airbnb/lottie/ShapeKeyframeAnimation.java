package com.airbnb.lottie;

import android.graphics.Path;

import java.util.List;

class ShapeKeyframeAnimation extends BaseKeyframeAnimation<ShapeData, Path> {
  private final ShapeData tempShapeData = new ShapeData();
  private final Path tempPath = new Path();

  ShapeKeyframeAnimation(long startDelay, long duration, LottieComposition composition,
      List<Keyframe<ShapeData>> keyframes) {
    super(startDelay, duration, composition, keyframes);
  }

  @Override public Path getValue(Keyframe<ShapeData> keyframe, float keyframeProgress) {
    ShapeData startShapeData = keyframe.startValue;
    ShapeData endShapeData = keyframe.endValue;

    tempShapeData.interpolateBetween(startShapeData, endShapeData, keyframeProgress);
    MiscUtils.getPathFromData(tempShapeData, tempPath);
    return tempPath;
  }
}
