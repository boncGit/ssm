package com.watchme.wm.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by huangpeng on 2016/1/6.
 */
public class DataSources extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
         return DataSourceHolder.getDataSource();
    }
}
