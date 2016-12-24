package com.cloudspace.jindun.manager;

import com.cloudspace.jindun.UCAPIApp;
import com.cloudspace.jindun.dao.PhoneRecord;
import com.cloudspace.jindun.dao.PhoneRecordDao;

/**
 * Created by zengxianhua on 16/12/22.
 */

public class PhoneRecordManager {
    private static PhoneRecordManager instance;

    public synchronized static PhoneRecordManager getInstance(){
        if (instance == null){
            instance = new PhoneRecordManager();
        }

        return instance;
    }

    public  void addPhoneRecord(PhoneRecord record){
        if (UCAPIApp.getInstance().getDaoSession() == null) {
            return;
        }

        UCAPIApp.getInstance().getDaoSession().getPhoneRecordDao().insert(record);
    }

    public  void deletePhoneRecord(String userId){
        if (UCAPIApp.getInstance().getDaoSession() == null) {
            return;
        }

        PhoneRecord key = UCAPIApp.getInstance().getDaoSession().getPhoneRecordDao().queryBuilder().where(PhoneRecordDao.Properties.Userid.eq(userId)).unique();

        if (key == null){
            return;
        }

        UCAPIApp.getInstance().getDaoSession().getPhoneRecordDao().delete(key);
    }
}
