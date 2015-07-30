package com.springbatch.controller;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ksy on 2015/7/27.
 */
@Controller
@RequestMapping("/batch")
public class BatchController {

    Logger logger = Logger.getLogger(BatchController.class);

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job testJob;

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Object test() throws Exception {
        logger.info("BatchController ------------");
        Map<String, JobParameter> params = new HashMap<String, JobParameter>();
        params.put("testJob",new JobParameter("testJob"));
        return jobLauncher.run(testJob, new JobParameters(params));
    }

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}
