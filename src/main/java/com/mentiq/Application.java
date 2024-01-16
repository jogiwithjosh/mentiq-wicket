package com.mentiq;

import com.mentiq.repository.ActivityRepository;
import com.mentiq.service.ActivityService;
import com.mentiq.service.IActivityService;
import com.mentiq.web.ActivityRest;
import org.apache.wicket.Page;
import org.apache.wicket.core.request.mapper.MountedMapper;
import org.apache.wicket.core.util.file.WebApplicationPath;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;

public class Application extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return com.mentiq.Index.class;
    }

    @Override
    public void init() {
        super.init();
        getResourceSettings().getResourceFinders().add(new WebApplicationPath(getServletContext(), "/"));
        mountResource("/activity", new ResourceReference("activity") {

            ActivityRest activityRest = new ActivityRest();
            @Override
            public IResource getResource() {
                return activityRest;
            }
        });
    }

}