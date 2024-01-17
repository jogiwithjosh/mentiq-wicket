package com.mentiq.service;


import com.mentiq.entity.Activity;

import java.util.List;

public interface IActivityService {

    public List<Activity> all(String user, String building) throws RuntimeException;

    public Activity create(Activity activity) throws RuntimeException;

    public void updateStatus(int activityID, String status) throws RuntimeException;
}
