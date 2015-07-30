package com.springbatch.service.impl;

import com.springbatch.datasource.DataSourceConfiguration;
import com.springbatch.model.User;
import com.springbatch.service.JobService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ksy on 2015/7/28.
 */
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Override
    public Job createJob(String jobName, List stepList) {
        JobBuilder jobBuilder = jobs.get(jobName);
//        jobBuilder.start()
        return null;
    }

    /**
     *
     * @param stepName
     * @param type
     *              0:Simple Step
     *              1:Multi-threaded Step (single process)
                    2:Parallel Steps (single process)
                    3:Remote Chunking of Step (multi process)
                    4:Partitioning a Step (single or multi process)
     */
    public void addStep(String stepName, int type){
        Step step = null;
        StepBuilder builder = steps.get(stepName);
        step = builder.chunk(10).build();
        switch(type){
//            case 0:builder.tasklet();
//            case 1:builder.chunk();
//            case 2:builder.chunk();
//            case 3:builder.chunk();
//            default:builder.
        }
    }


}
