package com.cloudspace.jindun.activity.Woyao;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudspace.jindun.R;
import com.cloudspace.jindun.activity.CustomTitleBaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PassActivitye extends CustomTitleBaseActivity {

    private String type="2";

    @Bind(R.id.back)
    ImageView mBack;
    @Bind(R.id.call_text_title)
    TextView mCallTextTitle;
    @Bind(R.id.call_et)
    EditText mCallEt;
    @Bind(R.id.call_bt)
    Button mCallBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cell_activitye, false);
        ButterKnife.bind(this);
        setView();
    }

    private void setView() {
        mCallTextTitle.setText("更改密码");
        mCallBt.setText("下一步");
        mCallEt.setHint("请在在此输入旧密码");
    }


    @OnClick({R.id.back, R.id.call_bt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.call_bt:
                showDialogText(this,"提示","对不起,您输入的密码有误","联系客服","重新输入");
                break;
        }
    }
    public static Dialog showDialogText(final Context context, String title, String Hint,String buttonLeft,String buttonRight) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
        builder.setTitle(title)    //标题
                .setCancelable(false)    //不响应back按钮
                .setMessage(Hint)
                //对话框显示内容
                //设置按钮
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "确定", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "取消", Toast.LENGTH_SHORT).show();
            }
        });


        //创建Dialog对象
        AlertDialog dlg = builder.create();
        dlg.show();
        return dlg;
    }
}
