package com.airbnb.lottie;

import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Log;

import java.util.List;

class PathKeyframeAnimation extends KeyframeAnimation<PointF> {
  private final PointF point = new PointF();
  private final float[] pos = new float[2];
  private PathKeyframe pathMeasureKeyframe;
  private PathMeasure pathMeasure;

  PathKeyframeAnimation(long startDelay, long duration, LottieComposition composition,
      List<? extends Keyframe<PointF>> keyframes) {
    super(startDelay, duration, composition, keyframes);
  }

  @Override public PointF getValue(Keyframe<PointF> keyframe, float keyframeProgress) {
    PathKeyframe pathKeyframe = (PathKeyframe) keyframe;
    Log.d("Gabe", "PathKeyframeAnimation#getValue\t" + keyframes.indexOf(keyframe) + " " + keyframeProgress);
    if (pathMeasureKeyframe != pathKeyframe) {
      pathMeasure = new PathMeasure(pathKeyframe.getPath(), false);
      pathMeasureKeyframe = pathKeyframe;
    }

    pathMeasure.getPosTan(keyframeProgress * pathMeasure.getLength(), pos, null);
    point.set(pos[0], pos[1]);
    return point;
  }
}
