package com.kelmerdev.steps;

import com.kelmerdev.entities.Persona;
import com.kelmerdev.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Slf4j
public class ItemWriterStep implements Tasklet {

    @Autowired
    private IPersonService personService;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        log.info("------------- Inicio del paso de escritura --------------");

        List<Persona> personList = (List<Persona>) chunkContext.getStepContext()
                    .getStepExecution()
                    .getJobExecution()
                    .getExecutionContext()
                    .get("personList");

        personList.forEach(persona -> {
            if (persona != null) {
                log.info(persona.toString());
            }
        });

        personService.saveAll(personList);

        log.info("------------- Fin del paso de escritura --------------");

        return RepeatStatus.FINISHED;
    }
}
