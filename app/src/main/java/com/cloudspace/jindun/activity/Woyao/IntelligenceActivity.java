package com.cloudspace.jindun.activity.Woyao;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cloudspace.jindun.R;
import com.cloudspace.jindun.activity.CustomTitleBaseActivity;

//情报上报
public class IntelligenceActivity extends CustomTitleBaseActivity {
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intelligence, false);
        initView();
    }

    private void initView() {
        back= (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
