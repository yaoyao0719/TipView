package com.android.tipview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.tooltipview.Tooltip;

public class MainActivity extends AppCompatActivity {

    public Button mButton;
    public Button mButton1;
    private TextView mTextView;
    private Context mContext;
    private Tooltip.TooltipView mTooltipView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext=this;
        mButton=(Button)findViewById(R.id.button);
        mButton1=(Button)findViewById(R.id.button11);
        mTextView=(TextView)findViewById(R.id.text);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                            mTooltipView= Tooltip.make(
                                    mContext,
                    new Tooltip.Builder()
                            .anchor(mButton, Tooltip.Gravity.BOTTOM)
                            .fitToScreen(true)
                            .text("提示！！！")
                            .withArrow(true)
                            .closePolicy(new Tooltip.ClosePolicy().insidePolicy(false,false).outsidePolicy(false,false), 0)
                            .maxWidth(getScreenWidth()/2)
                            .setDismiss(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    mTooltipView.remove();
                                }
                            })
                            .withOverlay(false)
                            .build()
            );
            mTooltipView.show();
            }
        });

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"ssssss",Toast.LENGTH_SHORT).show();
            }
        });

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"点击按钮",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public  int getScreenWidth(){
        return this.getResources().getDisplayMetrics().widthPixels;
    }
}
