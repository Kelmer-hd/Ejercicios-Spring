package com.kelmerdev.config;

import com.kelmerdev.steps.ItemDescompressStep;
import com.kelmerdev.steps.ItemProcessorStep;
import com.kelmerdev.steps.ItemReaderStep;
import com.kelmerdev.steps.ItemWriterStep;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilder jobBuilderFactory;

    @Autowired
    public StepBuilder stepBuilderFactory;

    @Bean
    public ItemDescompressStep itemDescompressStep(){
        return new ItemDescompressStep();
    }

    @Bean
    public ItemReaderStep itemReaderStep(){
        return new ItemReaderStep();
    }

    @Bean
    public ItemProcessorStep itemProcessorStep(){
        return new ItemProcessorStep();
    }

    @Bean
    public ItemWriterStep itemWriterStep(){
        return new ItemWriterStep();
    }
}
