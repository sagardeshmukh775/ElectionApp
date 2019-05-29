package com.smartloan.smtrick.jagrutiapp;

import java.util.Map;

public interface LeedRepository {


    void deleteLeed(final String leedId, final CallBack callback);

    void updateLeed(final String leedId, final Map leedsMap, final CallBack callBack);


}
