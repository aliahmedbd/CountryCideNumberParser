package com.bracbank.voxmartnumberparser.util

import android.content.Context
import android.graphics.Rect
import android.view.accessibility.AccessibilityEvent

import android.view.MotionEvent

import android.view.accessibility.AccessibilityNodeInfo

import android.os.Bundle
import android.util.AttributeSet
import android.view.View

import android.view.accessibility.AccessibilityManager
import android.widget.FrameLayout


class DialKeyButton : FrameLayout {
    /** Accessibility manager instance used to check touch exploration state.  */
    private var mAccessibilityManager: AccessibilityManager? = null

    /** Bounds used to filter HOVER_EXIT events.  */
    private val mHoverBounds: Rect = Rect()

    interface OnPressedListener {
        fun onPressed(view: View?, pressed: Boolean)
    }

    private var mOnPressedListener: OnPressedListener? = null
    fun setOnPressedListener(onPressedListener: OnPressedListener?) {
        mOnPressedListener = onPressedListener
    }


    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initForAccessibility(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        initForAccessibility(context)
    }

    private fun initForAccessibility(context: Context) {
        mAccessibilityManager = context.getSystemService(
            Context.ACCESSIBILITY_SERVICE
        ) as AccessibilityManager?
    }

    override fun setPressed(pressed: Boolean) {
        super.setPressed(pressed)
        if (mOnPressedListener != null) {
            mOnPressedListener!!.onPressed(this, pressed)
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mHoverBounds.left = paddingLeft
        mHoverBounds.right = w - paddingRight
        mHoverBounds.top = paddingTop
        mHoverBounds.bottom = h - paddingBottom
    }

    override fun performAccessibilityAction(action: Int, arguments: Bundle?): Boolean {
        if (action == AccessibilityNodeInfo.ACTION_CLICK) {
            simulateClickForAccessibility()
            return true
        }
        return super.performAccessibilityAction(action, arguments)
    }

    override fun onHoverEvent(event: MotionEvent): Boolean {
        // When touch exploration is turned on, lifting a finger while inside
        // the button's hover target bounds should perform a click action.
        if (mAccessibilityManager!!.isEnabled
            && mAccessibilityManager!!.isTouchExplorationEnabled
        ) {
            when (event.actionMasked) {
                MotionEvent.ACTION_HOVER_ENTER ->                     // Lift-to-type temporarily disables double-tap activation.
                    isClickable = false
                MotionEvent.ACTION_HOVER_EXIT -> {
                    if (mHoverBounds.contains(event.x.toInt(), event.y.toInt())) {
                        simulateClickForAccessibility()
                    }
                    isClickable = true
                }
            }
        }
        return super.onHoverEvent(event)
    }

    /**
     * When accessibility is on, simulate press and release to preserve the
     * semantic meaning of performClick(). Required for Braille support.
     */
    private fun simulateClickForAccessibility() {
        // Checking the press state prevents double activation.
        if (isPressed) {
            return
        }
        isPressed = true
        // Stay consistent with performClick() by sending the event after
        // setting the pressed state but before performing the action.
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_CLICKED)
        isPressed = false
    }
}