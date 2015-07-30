package com.springbatch.reader;

import com.springbatch.datasource.DataSourceConfiguration;
import com.springbatch.model.User;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by ksy on 2015/7/29.
 */
@Component
public class ReaderConfigure {

    @Autowired
    private DataSourceConfiguration dataSourceConfiguration;

    public ItemReader reader(String resource, int type) {
        ItemReader itemReader = null;
        switch(type){
            case 0:itemReader = new FlatFileItemReader();
            case 1:itemReader = new JdbcCursorItemReader();
            case 2:itemReader = new JdbcPagingItemReader();
            case 3:itemReader = new MongoItemReader();
        }
        FlatFileItemReader<User> reader = new FlatFileItemReader<User>();

        return reader;
    }

    private ItemReader createFlatFileItemReader(String resource){
        FlatFileItemReader itemReader = new FlatFileItemReader();
        itemReader.setResource(new ClassPathResource("sample-data.csv"));
        itemReader.setLineMapper(new DefaultLineMapper() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] { "name", "mark" });
            }});
        }});
        return itemReader;
    }

    private ItemReader createJDBCItemReader(String dbPath, String userName, String password){

    }

    private ItemReader createJdbcCursorItemReader(DataSource dataSource, String sql) throws Exception {
        JdbcCursorItemReader cursorItemReader = new JdbcCursorItemReader();
        cursorItemReader.setDataSource(dataSource);
        int counter = 0;
        ExecutionContext executionContext = new ExecutionContext();
        cursorItemReader.open(executionContext);
        Object result = new Object();
        while(result != null){
            result = cursorItemReader.read();
            counter++;
        }
        cursorItemReader.close();
        return cursorItemReader;
    }

    private ItemReader createJdbcPagingItemReader(DataSource dataSource, String sql){
        JdbcPagingItemReader pagingItemReader = new JdbcPagingItemReader();
        pagingItemReader.setDataSource(dataSource);
        return pagingItemReader;
    }
}
