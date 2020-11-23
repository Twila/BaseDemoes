package com.example.basedemoes

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.content.Context
import android.view.View
import android.view.View.VISIBLE

open class Utils {
    companion object{
        /**
         * 获取两点间距离
         * @param x1
         * @param y1
         * @param x2
         * @param y2
         * @return
         */
        fun getDistance(x1: Float, y1: Float, x2: Float, y2: Float): Float {
            return Math.sqrt(Math.pow(x1 - x2.toDouble(), 2.0) + Math.pow(y1 - y2.toDouble(), 2.0)).toFloat()
        }

        /**
         * 关闭动画
         */
        fun closeAnimate(view: View) {
            val height = view.height
            val animator = createDropAnimator(view, height, 0)
            animator.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    view.visibility = View.GONE
                }
            })
            animator.start()
        }

        private fun createDropAnimator(v: View, start: Int, end: Int): ValueAnimator {
            val animator = ValueAnimator.ofInt(start, end)
            animator.addUpdateListener { arg0 ->
                val value = arg0.animatedValue as Int
                val layoutParams = v.layoutParams
                layoutParams.height = value
                v.layoutParams = layoutParams
                v.invalidate()
            }
            return animator
        }

        /**
         * 展开动画
         */
        public fun openAnim(view: View, height: Int) {
            view.visibility = VISIBLE
            val animator = createDropAnimator(view, 0, height)
            animator.start()
        }

    }
}
