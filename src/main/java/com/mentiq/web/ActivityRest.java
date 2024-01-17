package com.mentiq.web;

import com.mentiq.dto.UpdateStatus;
import com.mentiq.entity.Activity;
import com.mentiq.repository.ActivityRepository;
import com.mentiq.service.ActivityService;
import com.mentiq.service.IActivityService;
import org.wicketstuff.rest.annotations.MethodMapping;
import org.wicketstuff.rest.annotations.parameters.RequestBody;
import org.wicketstuff.rest.annotations.parameters.RequestParam;
import org.wicketstuff.rest.contenthandling.json.objserialdeserial.GsonObjectSerialDeserial;
import org.wicketstuff.rest.contenthandling.json.webserialdeserial.JsonWebSerialDeserial;
import org.wicketstuff.rest.resource.AbstractRestResource;
import org.wicketstuff.restutils.http.HttpMethod;
import java.util.List;

public class ActivityRest extends AbstractRestResource<JsonWebSerialDeserial> {

    private final IActivityService activityService;

    public ActivityRest() {
        super(new JsonWebSerialDeserial(new GsonObjectSerialDeserial()));

        this.activityService = new ActivityService(new ActivityRepository());
    }

    @MethodMapping(value = "/all", httpMethod = HttpMethod.GET)
    public List<Activity> all(@RequestParam(value = "user", required = false, defaultValue = "") String user, @RequestParam(value = "building", required = false, defaultValue = "") String building) {
        return this.activityService.all(user, building);
    }

    @MethodMapping(value = "/save", httpMethod = HttpMethod.POST)
    public Activity create(@RequestBody Activity activity) {
        return  this.activityService.create(activity);
    }

    @MethodMapping(value = "/update-status", httpMethod = HttpMethod.PUT)
    public void updateStatus(@RequestBody UpdateStatus updateStatus) {
        this.activityService.updateStatus(updateStatus.getId(), updateStatus.getStatus());
    }
}
