package com.springbatch.process;

import com.springbatch.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<User, User> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public User process(final User user) throws Exception {
        final String id = user.getId();
        final String lastName = user.getName().toUpperCase();

        final User transformedUser = new User(id, lastName);

        log.info("Converting (" + user + ") into (" + transformedUser + ")");

        return transformedUser;
    }

}