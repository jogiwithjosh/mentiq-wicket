package com.mentiq.service;

import com.mentiq.entity.Activity;
import com.mentiq.repository.ActivityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ActivityService implements IActivityService {

    public final Logger logger = LoggerFactory.getLogger(ActivityService.class);

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public List<Activity> all(String user, String building) throws RuntimeException {
        try {
            return activityRepository.all(user, building);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public Activity create(Activity activity) throws RuntimeException {
        try {
            return activityRepository.save(activity);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateStatus(int activityID, String status) throws RuntimeException {
        try {
            activityRepository.updateStatus(activityID, status);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }
}
