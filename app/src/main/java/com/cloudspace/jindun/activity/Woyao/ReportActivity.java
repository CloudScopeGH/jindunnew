package com.cloudspace.jindun.activity.Woyao;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.cloudspace.jindun.R;
import com.cloudspace.jindun.activity.CustomTitleBaseActivity;
import com.cloudspace.jindun.adapter.ReportListAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

//汇报记录
public class ReportActivity extends CustomTitleBaseActivity {

    @Bind(R.id.back)
    ImageView mBack;
    @Bind(R.id.report_listView_data)
    ListView mReportListViewData;

    private ReportListAdapter mReportListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report, false);
        ButterKnife.bind(this);
        initData();
        setData();
        setListener();

    }

    private void setData() {
        mReportListViewData.setAdapter(mReportListAdapter);
    }
    private void initData() {
        mReportListAdapter=new ReportListAdapter(this);

        loadDataIng();
    }

    private void loadDataIng() {

    }

    private void setListener() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mReportListViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }
}
