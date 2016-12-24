package com.cloudspace.jindun.activity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudspace.jindun.R;
import com.cloudspace.jindun.activity.Woyao.CellActivitye;
import com.cloudspace.jindun.activity.Woyao.NameAlterActivitye;
import com.cloudspace.jindun.activity.Woyao.PassActivitye;
import com.cloudspace.jindun.activity.Woyao.SystemSettingsActivity;
import com.cloudspace.jindun.ui.RoundCornerImageView;
import com.cloudspace.jindun.window.SelectPicPopupWindow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WdActivity extends CustomTitleBaseActivity {
    @Bind(R.id.wd_image_head)
    RoundCornerImageView mWdImageHead;
    @Bind(R.id.wd_text_name)
    TextView mWdTextName;
    @Bind(R.id.main)
    RelativeLayout mMain;
    private SelectPicPopupWindow menuWindow;

    @Bind(R.id.back)
    ImageView mBack;
    @Bind(R.id.wd_collect_rl)
    RelativeLayout mWdCollectRl;
    @Bind(R.id.wd_image_phone)
    ImageView mWdImagePhone;
    @Bind(R.id.wd_text_phone)
    TextView mWdTextPhone;
    @Bind(R.id.wd_collect_r2)
    RelativeLayout mWdCollectR2;
    @Bind(R.id.wd_image_pass)
    ImageView mWdImagePass;
    @Bind(R.id.wd_text_pass)
    TextView mWdTextPass;
    @Bind(R.id.wd_collect_r3)
    RelativeLayout mWdCollectR3;
    @Bind(R.id.wd_text_sys)
    TextView mWdTextSys;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wd, false);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.back,R.id.wd_image_head, R.id.wd_text_name,R.id.wd_collect_rl, R.id.wd_collect_r2, R.id.wd_collect_r3, R.id.wd_text_sys})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                Intent intentBack = new Intent();
                intentBack.setClass(this, MainActivity.class);
                startActivity(intentBack);
                finish();
                break;
            case R.id.wd_image_head://头像
                //实例化SelectPicPopupWindow
                menuWindow = new SelectPicPopupWindow(WdActivity.this, itemsOnClick);
                //显示窗口
                menuWindow.showAtLocation(WdActivity.this.findViewById(R.id.main), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); //设置layout在PopupWindow中显示的位置
                break;
            case R.id.wd_text_name:
                Intent intentName = new Intent();
                intentName.setClass(this, NameAlterActivitye.class);
                startActivity(intentName);
                break;
            case R.id.wd_collect_r2://更改手机号
                Intent intentCall = new Intent();
                intentCall.setClass(this, CellActivitye.class);
                startActivity(intentCall);
                break;
            case R.id.wd_collect_r3://更改密码
                Intent intentPass = new Intent();
                intentPass.setClass(this, PassActivitye.class);
                startActivity(intentPass);
                break;
            case R.id.wd_text_sys://系统设置
                Intent intentSys = new Intent();
                intentSys.setClass(this, SystemSettingsActivity.class);
                startActivity(intentSys);
                break;
        }
    }

    private OnClickListener itemsOnClick = new OnClickListener() {

        public void onClick(View v) {
            menuWindow.dismiss();
            switch (v.getId()) {
                case R.id.btn_take_photo:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
                        Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                        startActivityForResult(intent2, 2);
                    } else {
                        Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                        startActivityForResult(intent2, 2);
                    }

                    break;
                case R.id.btn_pick_photo:
                    Intent intent = new Intent();
                    //intent = new Intent(Intent.ACTION_GET_CONTENT);
                /* 开启Pictures画面Type设定为image */
                    intent.setType("image/*");
                /* 使用Intent.ACTION_GET_CONTENT这个Action */
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                /* 取得相片后返回本画面 */
                    startActivityForResult(intent, 1);
                    break;
                default:
                    break;
            }
        }

    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // TODO Auto-generated method stub
        if (requestCode == 1) {
            Uri selectedImage = data.getData();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(this
                        .getContentResolver().openInputStream(Uri.parse(selectedImage.toString())));
                mWdImageHead.setImageBitmap(bitmap);
                Toast.makeText(getApplicationContext(), "上传成功",
                        Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (requestCode == 2) {

            String sdStatus = Environment.getExternalStorageState();
            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
                Log.i("TestFile",
                        "SD card is not avaiable/writeable right now.");
                return;
            }

            //.format("yyyyMMdd_hhmmss", Calendar.getInstance(Locale.CHINA)) + ".jpg";
            Toast.makeText(this, "111", Toast.LENGTH_LONG).show();
            if (data != null) {


                Bundle bundle = data.getExtras();
                Bitmap bitmap = (Bitmap) bundle.get("data");// 获取相机返回的数据，并转换为Bitmap图片格式

                FileOutputStream b = null;
                File file = new File("/sdcard/myImage/");
                file.mkdirs();// 创建文件夹
                String fileName = "/sdcard/myImage/" + "111";

                try {
                    b = new FileOutputStream(fileName);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        b.flush();
                        b.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                mWdImageHead.setImageBitmap(bitmap);
                ;// 将图片显示在ImageView里

            }
        }

    }

    protected void getImageFromCamera() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            startActivityForResult(intent, 2);
        } else {
            Toast.makeText(getApplicationContext(), "请确认已经插入SD卡", Toast.LENGTH_LONG).show();
        }
    }


}
