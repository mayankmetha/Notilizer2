package com.mayank.notilizer2.models;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;


public interface ApplicationDao extends Dao<Application, String> {
    public List<Application> getIgnoredApps() throws SQLException;

}
