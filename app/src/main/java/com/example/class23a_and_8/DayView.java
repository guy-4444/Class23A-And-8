package com.example.class23a_and_8;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;

import java.util.Random;

public class DayView extends FrameLayout {

    private final int DEFAULT_NUM_OF_SECTIONS = 24;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private int orientation = HORIZONTAL;
    private int sections = DEFAULT_NUM_OF_SECTIONS;

    public DayView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public DayView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs,R.styleable.DayView);
        orientation = typedArray.getInt(R.styleable.DayView_orientation, DayView.HORIZONTAL);
        sections = typedArray.getInt(R.styleable.DayView_sections, DEFAULT_NUM_OF_SECTIONS);
        typedArray.recycle();

        setBackgroundColor(Color.parseColor("#FF0000"));

        LinearLayoutCompat lay = new LinearLayoutCompat(context);
        lay.setBackgroundColor(Color.parseColor("#00FF00"));


        for (int i = 0; i < sections; i++) {
            View view = new View(context);
            LinearLayoutCompat.LayoutParams params = new LinearLayoutCompat.LayoutParams(
                    orientation == DayView.HORIZONTAL ? 0 : ViewGroup.LayoutParams.MATCH_PARENT,
                    orientation == DayView.HORIZONTAL ? ViewGroup.LayoutParams.MATCH_PARENT : 0
            );
            params.weight = 1;
            view.setLayoutParams(params);
            view.setBackgroundColor(Color.HSVToColor(new float[]{new Random().nextInt(360), 0.5f, 0.5f}));
            lay.addView(view);
        }



        addView(lay);

    }
}
