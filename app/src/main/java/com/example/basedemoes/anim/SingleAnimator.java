package com.example.basedemoes.anim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

public class SingleAnimator {
    private static volatile ObjectAnimator animator;

    private SingleAnimator(){}

    public static ObjectAnimator getInstance(View v){
        if (animator == null){
            synchronized (SingleAnimator.class){
                if (animator==null){
                    animator= initAlertAnimator(v);
                }
            }
        }
        return animator;
    }

    private static ObjectAnimator initAlertAnimator(View target) {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(target, "translationX", 0f, 40f, -40f, 0f);
        animator1.setDuration(100);
//        animator1.setRepeatCount(ValueAnimator.INFINITE);
//        animator.setRepeatCount(1);
        animator1.setInterpolator(new DecelerateInterpolator(0.8f));
//        Runnable runnable=new Runnable() {
//            @Override
//            public void run() {
//                animator.start();
//            }
//        };
        animator1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                try {
                    Thread.sleep(2000);
                    animator.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        return animator1;
    }

}
