package com.example.toolbardrawerlayout;

import android.content.Context;
import android.support.annotation.StyleRes;
import android.support.v7.internal.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TextView;

public class KToolBar extends Toolbar {

	private TextView mTitleTextView;
	private TextView mSubtitleTextView;

	private int mTitleTextColor;
	private int mSubtitleTextColor;

	private float mTitleSize = 20f;
	private int mUnit = TypedValue.COMPLEX_UNIT_SP;

	private CharSequence mTitleText;
	private CharSequence mSubtitleText;

	private int mTitleTextAppearance;
	private int mSubtitleTextAppearance;

	public KToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context, attrs, defStyleAttr);
	}

	public KToolBar(Context context, AttributeSet attrs) {
		this(context, attrs, R.attr.toolbarStyle);
	}

	public KToolBar(Context context) {
		this(context, null);
	}

	private void init(Context context, AttributeSet attrs, int defStyleAttr) {

		TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs, R.styleable.Toolbar, defStyleAttr, 0);

		this.mTitleTextAppearance = a.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
		if (this.mTitleTextAppearance != 0) {
			setTitleTextAppearance(context, mTitleTextAppearance);
		}
		this.mSubtitleTextAppearance = a.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
		if (this.mSubtitleTextAppearance != 0) {
			setSubtitleTextAppearance(context, mSubtitleTextAppearance);
		}
		if (a.hasValue(R.styleable.Toolbar_titleTextColor)) {
			setTitleTextColor(a.getColor(R.styleable.Toolbar_titleTextColor, -1));
		}
		if (a.hasValue(R.styleable.Toolbar_subtitleTextColor)) {
			setSubtitleTextColor(a.getColor(R.styleable.Toolbar_subtitleTextColor, -1));
		}
		a.recycle();

	}

	public void setTitleSize(float size) {
		setTitleSize(TypedValue.COMPLEX_UNIT_SP, size);
	}

	public void setTitleSize(int unit, float size) {
		this.mUnit = unit;
		this.mTitleSize = size;
		if (mTitleTextView != null) {
			mTitleTextView.setTextSize(mUnit, mTitleSize);
		}
	}

	@Override
	public CharSequence getTitle() {
		return mTitleText;
	}

	@Override
	public CharSequence getSubtitle() {
		return mSubtitleText;
	}

	@Override
	public void setSubtitle(CharSequence subtitle) {
		// super.setSubtitle(subtitle);
		if (!TextUtils.isEmpty(subtitle)) {
			if (this.mSubtitleTextView == null) {
				Context context = getContext();
				this.mSubtitleTextView = new TextView(context);
				this.mSubtitleTextView.setSingleLine();
				this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
				if (this.mSubtitleTextAppearance != 0) {
					this.mSubtitleTextView.setTextAppearance(context, this.mSubtitleTextAppearance);
				}
				if (this.mSubtitleTextColor != 0) {
					this.mSubtitleTextView.setTextColor(this.mSubtitleTextColor);
				}
			}
		}
		if (this.mSubtitleTextView != null) {
			this.mSubtitleTextView.setText(subtitle);
		}
		this.mSubtitleText = subtitle;
	}

	@Override
	public void setTitle(CharSequence title) {
		// super.setTitle(title);
		if (!TextUtils.isEmpty(title)) {
			if (this.mTitleTextView == null) {
				Context context = getContext();
				this.mTitleTextView = new TextView(context);
				this.mTitleTextView.setSingleLine();
				this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
				if (this.mTitleTextAppearance != 0) {
					this.mTitleTextView.setTextAppearance(context, this.mTitleTextAppearance);
				}
				if (this.mTitleTextColor != 0) {
					this.mTitleTextView.setTextColor(this.mTitleTextColor);
				}
			}
			Toolbar.LayoutParams lp = new Toolbar.LayoutParams(android.view.ViewGroup.LayoutParams.WRAP_CONTENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
			addView(mTitleTextView, lp);
		}
		if (this.mTitleTextView != null) {
			this.mTitleTextView.setText(title);
		}
		this.mTitleText = title;

	}

	@Override
	public void setTitleTextColor(int color) {
		super.setTitleTextColor(color);
		this.mTitleTextColor = color;
		if (this.mTitleTextView != null) {
			this.mTitleTextView.setTextColor(color);
		}
	}

	@Override
	public void setSubtitleTextAppearance(Context context, @StyleRes int resId) {
		super.setSubtitleTextAppearance(context, resId);
		if (this.mSubtitleTextView != null)
			this.mSubtitleTextView.setTextAppearance(context, resId);
	}

	@Override
	public void setTitleTextAppearance(Context context, @StyleRes int resId) {
		super.setTitleTextAppearance(context, resId);
		if (this.mTitleTextView != null)
			this.mTitleTextView.setTextAppearance(context, resId);
	}
}
