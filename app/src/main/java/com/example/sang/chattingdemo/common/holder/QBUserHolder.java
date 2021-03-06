package com.example.sang.chattingdemo.common.holder;

import android.util.SparseArray;

import com.quickblox.content.model.QBFile;
import com.quickblox.users.model.QBUser;

import java.util.ArrayList;
import java.util.List;

public class QBUserHolder {
    private static QBUserHolder instance;
    public SparseArray<QBUser> qbUserSparseArray;
    public List<QBUser> qbUsersList;


    public static synchronized QBUserHolder getInstance() {
        if (instance == null)
            instance = new QBUserHolder();
        return instance;

    }

    private QBUserHolder() {
        qbUserSparseArray = new SparseArray<>();
        qbUsersList = new ArrayList<>();

    }

    public void putUsers(List<QBUser> qbUsers) {
        for (QBUser qbUser : qbUsers)
            putUser(qbUser);

    }
    public void putListUsers(List<QBUser> qbUsers)
    {
        qbUsersList=qbUsers;
    }

    public void putUser(QBUser qbUser) {
        qbUserSparseArray.put(qbUser.getId(), qbUser);

    }


    public QBUser getUserById(int i) {
        return qbUserSparseArray.get(i);

    }

    public List<QBUser> getUsersById(List<Integer> ids) {
        List<QBUser> qbUserList = new ArrayList<>();
        for (Integer i : ids) {
            QBUser user = getUserById(i);
            if (user != null) {
                qbUserList.add(user);
            }

        }
        return qbUserList;
    }

    public List<QBUser> getUsers()
    {
        return qbUsersList;
    }

}
