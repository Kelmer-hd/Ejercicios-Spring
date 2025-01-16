package com.kelmerdev.steps;

import com.kelmerdev.entities.Persona;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ItemProcessorStep implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        log.info("------------- Inicio del paso de PROCESAMIENTO --------------");

        List<Persona> personaList = (List<Persona>) chunkContext.getStepContext()
                                                                .getStepExecution()
                                                                .getJobExecution()
                                                                .getExecutionContext()
                                                                .get("personaList");

        List<Persona> personFinalList = personaList.stream().map(person -> {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            person.setInsertionDate(format.format(LocalDateTime.now()));
            return person;
        }).collect(Collectors.toList());


        chunkContext.getStepContext()
                        .getStepExecution()
                        .getJobExecution()
                        .getExecutionContext()
                        .put("personList", personFinalList);

        log.info("------------- Fin del paso de PROCESAMIENTO --------------");
        return RepeatStatus.FINISHED;
    }
}
