package com.example.basedemoes.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.basedemoes.R;

/**
 * 带动画的开关按钮
 *
 * @author allen
 * @date 2016/9/23
 * update by yuwei 修改为MixPad上使用的开关按钮
 */

public class SwitchButton extends FrameLayout implements View.OnClickListener {
    private static final String TAG = "SwitchButton";
    private FrameLayout switchBtnBg;
    private ImageView offImageView;
    private ImageView onImageView;
    //开关动画
    private AnimationSet offDismissAnim, offShowAnim, onDismissAnim, onShowAnim;
    private boolean isOn = true;
    private boolean clickChangeState = true;
    private OnSwitchButtonOnOffListener onOffListener;
    //private static String fontColor = AppSettingUtil.getFontColor();

    public SwitchButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SwitchButton(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View view = View.inflate(context, R.layout.switch_button, this);
        switchBtnBg = view.findViewById(R.id.switch_btn_bg);
        offImageView = view.findViewById(R.id.offImageView);
        onImageView = findViewById(R.id.onImageView);
        setOnClickListener(this);
    }


    /**
     * 设置开或关
     * 没有动画效果
     *
     * @param isOn true开、false关
     */
    public void setIsOn(boolean isOn) {
        setIsOn(isOn, false);
    }

    /**
     * 设置开或关
     *
     * @param isOn     true开、false关
     * @param playAnim true播放动画、false不播放动画
     */
    public void setIsOn(boolean isOn, boolean playAnim) {
        if (this.isOn != isOn) {
            this.isOn = isOn;
            if (isOn) {
                onImageView.setVisibility(VISIBLE);
                offImageView.setVisibility(GONE);
                if (playAnim) {
                    if (onShowAnim == null) {
                        onShowAnim = (AnimationSet) AnimationUtils.loadAnimation(getContext(), R.anim.switch_button_on_show);
//                        onShowAnim = AnimManager.getInstance().getSwitchButtonOnShowAnim();
                    }
                    if (offDismissAnim == null) {
                        offDismissAnim = (AnimationSet) AnimationUtils.loadAnimation(getContext(), R.anim.switch_button_off_dismiss);
//                        offDismissAnim = AnimManager.getInstance().getSwitchButtonOffDismissAnim();
                    }
                    onImageView.startAnimation(onShowAnim);
                    offImageView.startAnimation(offDismissAnim);
                }
            } else {
                onImageView.setVisibility(GONE);
                offImageView.setVisibility(VISIBLE);
                if (playAnim) {
                    if (onDismissAnim == null) {
                        onDismissAnim = (AnimationSet) AnimationUtils.loadAnimation(getContext(), R.anim.switch_button_on_dismiss);
//                        onDismissAnim = AnimManager.getInstance().getSwitchButtonOnDismissAnim();
                    }
                    if (offShowAnim == null) {
                        offShowAnim = (AnimationSet) AnimationUtils.loadAnimation(getContext(), R.anim.switch_button_off_show);
//                        offShowAnim = AnimManager.getInstance().getSwitchButtonOffShowAnim();
                    }
                    onImageView.startAnimation(onDismissAnim);
                    offImageView.startAnimation(offShowAnim);
                }
            }
        }
//        if (isOn) {
//            switchBtnBg.setBackgroundResource(R.drawable.shape_switch_button);
//        } else {
//            switchBtnBg.setBackgroundResource(R.drawable.shape_switch_button);
//        }
    }

    /**
     * 设置是否可点击
     *
     * @param enable true可点击、false不可点击
     */
    public void setButtonEnabled(boolean enable) {
        onImageView.setEnabled(enable);
        onImageView.setClickable(enable);
        offImageView.setEnabled(enable);
        onImageView.setClickable(enable);
    }

    /**
     * 设置点击是否立刻改变开关状态
     *
     * @param clickChangeState true立刻改变状态、false不立刻改变状态
     */
    public void setClickChangeState(boolean clickChangeState) {
        this.clickChangeState = clickChangeState;
    }

    /**
     * 判断开关状态
     *
     * @return 开关状态
     */
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void onClick(View v) {
        if (clickChangeState) {
            setIsOn(!isOn, true);
        }
        if (onOffListener != null) {
            onOffListener.onSwitchButtonOnOff(this, v, isOn);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            if (onImageView != null) {
                onImageView.clearAnimation();
                onImageView.setAnimation(null);
            }

            if (offImageView != null) {
                offImageView.clearAnimation();
                offImageView.setAnimation(null);
            }
        } catch (Exception e) {
            Log.d(TAG, e.toString());;
        }
        onOffListener = null;
    }

    public void setOnSwitchButtonOnOffListener(OnSwitchButtonOnOffListener onSwitchButtonOnOffListener) {
        onOffListener = onSwitchButtonOnOffListener;
    }

    /**
     * 开关监听器
     */
    public interface OnSwitchButtonOnOffListener {
        /**
         * 开关回调
         *
         * @param parent 点击的父视图
         * @param v      点击的视图
         * @param isOn   true开、false关
         */
        void onSwitchButtonOnOff(SwitchButton parent, View v, boolean isOn);
    }
}
