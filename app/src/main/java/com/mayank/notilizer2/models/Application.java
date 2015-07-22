package com.mayank.notilizer2.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Applications", daoClass = ApplicationDaoImpl.class)
public class Application {
    public static final String FIELD_TABLE_NAME = "Applications";
    public static final String FIELD_PACKAGE_NAME = "PackageName";
    public static final String FIELD_IGNORE = "Ignore";

    @DatabaseField(columnName = FIELD_PACKAGE_NAME, id = true, generatedId = false)
    private String PackageName;
    @DatabaseField(columnName = FIELD_IGNORE, canBeNull = false)
    private Boolean Ignore;

    public Application() {
        //ORMLite needs a no-arg constructor.
    }

    public Application(String packageName, Boolean ignore) {
        this.PackageName = packageName;
        this.Ignore = ignore;
    }

    public String getPackageName() {
        return PackageName;
    }

    public void setPackageName(String packageName) {
        PackageName = packageName;
    }

    public Boolean getIgnore() {
        return Ignore;
    }

    public void setIgnore(Boolean ignore) {
        Ignore = ignore;
    }
}
