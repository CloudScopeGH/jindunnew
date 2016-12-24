package com.cloudspace.jindun.activity.Woyao;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudspace.jindun.R;
import com.cloudspace.jindun.activity.CustomTitleBaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

//隐患汇报
public class HiddendangerActivity extends CustomTitleBaseActivity {

    @Bind(R.id.back)
    ImageView mBack;
    @Bind(R.id.hiddenactivity_edit_title)
    EditText mHiddenactivityEditTitle;
    @Bind(R.id.hiddenactivity_checkbox_cBox1)
    CheckBox mHiddenactivityCheckboxCBox1;
    @Bind(R.id.hiddenactivity_checkbox_cBox2)
    CheckBox mHiddenactivityCheckboxCBox2;
    @Bind(R.id.activity_particulars)
    TextView mActivityParticulars;
    @Bind(R.id.hiddenactivity_particulars_edit)
    EditText mHiddenactivityParticularsEdit;
    @Bind(R.id.hidden_iv_01)
    ImageView mHiddenIv01;
    @Bind(R.id.hidden_iv_02)
    ImageView mHiddenIv02;
    @Bind(R.id.hidden_iv_03)
    ImageView mHiddenIv03;
    @Bind(R.id.bt02)
    Button mBt02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiddendanger, false);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.back, R.id.hidden_iv_01, R.id.hidden_iv_02, R.id.hidden_iv_03, R.id.bt02})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.hidden_iv_01:
                break;
            case R.id.hidden_iv_02:
                break;
            case R.id.hidden_iv_03:
                break;
            case R.id.bt02:
                break;
        }
    }
}
