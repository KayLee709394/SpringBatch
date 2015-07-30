package com.springbatch.service;

import org.springframework.batch.core.Job;

import java.util.List;

/**
 * Created by ksy on 2015/7/28.
 */
public interface JobService {

    public Job createJob(String jobName,List stepList);
}
