package com.sunflower.project.factory;

public enum AllDataSource {
    xxlJob("MysqlJdbcTemplate"),
    sunflower("SunflowerJdbcTemplate")
    ;
    private final String sourceName;

    AllDataSource(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceName() {
        return sourceName;
    }
}
