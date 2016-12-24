package com.cloudspace.jindun.activity.Woyao;

import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cloudspace.jindun.R;
import com.cloudspace.jindun.activity.CustomTitleBaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SystemSettingsActivity extends CustomTitleBaseActivity {

    @Bind(R.id.back2)
    ImageView mBack2;
    @Bind(R.id.rl)
    RelativeLayout mRl;
    @Bind(R.id.p1_t1)
    TextView mP1T1;
    @Bind(R.id.p1_sc1)
    SwitchCompat mP1Sc1;
    @Bind(R.id.p1_t2)
    TextView mP1T2;
    @Bind(R.id.part1)
    RelativeLayout mPart1;
    @Bind(R.id.p2_title)
    TextView mP2Title;
    @Bind(R.id.p2_line)
    TextView mP2Line;
    @Bind(R.id.p2_t1)
    TextView mP2T1;
    @Bind(R.id.p2_t2)
    TextView mP2T2;
    @Bind(R.id.p2_t3)
    TextView mP2T3;
    @Bind(R.id.part2)
    RelativeLayout mPart2;
    @Bind(R.id.p3_title)
    TextView mP3Title;
    @Bind(R.id.p3_line)
    TextView mP3Line;
    @Bind(R.id.p3_t1)
    TextView mP3T1;
    @Bind(R.id.p3_t2)
    TextView mP3T2;
    @Bind(R.id.p3_t3)
    TextView mP3T3;
    @Bind(R.id.part3)
    RelativeLayout mPart3;
    @Bind(R.id.p4_t1)
    TextView mP4T1;
    @Bind(R.id.p4_img1)
    ImageView mP4Img1;
    @Bind(R.id.p4_t2)
    TextView mP4T2;
    @Bind(R.id.p4_img2)
    ImageView mP4Img2;
    @Bind(R.id.part4)
    RelativeLayout mPart4;
    @Bind(R.id.sys_btn_logbut)
    Button mSysBtnLogbut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_settings, false);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.sys_btn_logbut)
    public void onClick() {

    }
}
