package com.socoolby.scroll_table.lib;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.socoolby.scroll_table.unit.Func;
import com.socoolby.scroll_table.widget.CustomScrollView;

/**
 * Created by socoolby on 3/24/14.
 */
public class ScrollTableView  extends LinearLayout{
    private final static String TAG="ScrollTableView";
    CustomScrollView cv_scrolltable_header_vertical,cv_crolltable_header_horizontion,cv_crolltable_content;
    LinearLayout ll_crolltable_header_horicontion,ll_crolltable_header_veritcal;
    TableLayout content_crolltable_table;

    private RelativeLayout root_layout;
    public ScrollTableView(Context context) {
        super(context);
        initView();
    }

    public ScrollTableView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

//    public ScrollTableView(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//    }
    private void initView()
    {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        root_layout=(RelativeLayout)layoutInflater.inflate(R.layout.layout_scrolltable, null);
        this.addView(root_layout);
        cv_crolltable_content=(CustomScrollView)root_layout.findViewById(R.id.cv_crolltable_content);
        cv_crolltable_header_horizontion=(CustomScrollView)root_layout.findViewById(R.id.cv_crolltable_header_horizontion);
        cv_scrolltable_header_vertical = (CustomScrollView)root_layout.findViewById(R.id.cv_scrolltable_header_vertical);

        ll_crolltable_header_horicontion=(LinearLayout)root_layout.findViewById(R.id.ll_crolltable_header_horicontion);
        ll_crolltable_header_veritcal=(LinearLayout)root_layout.findViewById(R.id.ll_crolltable_header_veritcal);
        content_crolltable_table=(TableLayout)root_layout.findViewById(R.id.content_crolltable_table);


        cv_crolltable_content.setAbortAnimationListner(new CustomScrollView.AbortAnimationListener() {
            @Override
            public void abortAnimation() {
                cv_crolltable_header_horizontion.setAbortAnimateStop();
                cv_scrolltable_header_vertical.setAbortAnimateStop();
            }
        });
        cv_crolltable_content.setScrollListener(new CustomScrollView.ScrollListener() {
            @Override
            public void scrollTo(int x, int y) {
                cv_crolltable_header_horizontion.scrollTo(x,0);
                cv_scrolltable_header_vertical.scrollTo(0,y);
            }
        });
        cv_crolltable_content.setFlingListener(new CustomScrollView.FlingListener() {
            @Override
            public void flingListener(int velocityX, int velocityY) {
                cv_crolltable_header_horizontion.fling(velocityX,velocityY);
                cv_scrolltable_header_vertical.fling(velocityX,velocityY);

            }
        });

    }
    public void setData(String title_horizontal[],String []title_vertical,String [][]content)
       {

        int count_horizontal=title_horizontal.length;
        int count_vertical=title_vertical.length;
            Func.Log(TAG,"setData count_horizontal:"+count_horizontal+" count_vertical:"+count_vertical);
        for (int i = 0; i <count_horizontal ; i++) {
            LinearLayout view=getView(title_horizontal[i]);

            if(ll_crolltable_header_horicontion==null)
                Func.Log(TAG,"view is null");
            ll_crolltable_header_horicontion.addView(view);
        }
        for (int i = 0; i < count_vertical; i++) {
            LinearLayout view=getView(title_vertical[i]);
            ll_crolltable_header_veritcal.addView(view);
        }

        for(int i=0;i<count_vertical;i++)
        {
            TableRow row = new TableRow(getContext());
            for (int j = 0; j < count_horizontal; j++) {
                LinearLayout view=getView(content[i][j]);
                row.addView(view);
            }

            content_crolltable_table.addView(row);
        }

    }
    private LinearLayout getView(String contnet)
    {
                LinearLayout lay=(LinearLayout)LayoutInflater.from(getContext()).inflate(R.layout.scrolltable_item, null);
        TextView view = (TextView) lay.findViewById(R.id.tv_scrolltable_item_tv);
        view.setText(contnet);
        return lay;
    }

}
