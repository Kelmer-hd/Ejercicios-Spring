package com.kelmerdev.steps;

import com.kelmerdev.entities.Persona;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ItemReaderStep implements Tasklet {

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        log.info("------------- Inicio del paso de lectura --------------");
        Reader reader = new FileReader(resourceLoader.getResource("classpath:files/destination/persons.csv").getFile());

        CSVParser parser = new CSVParserBuilder()
                .withSeparator(',')
                .build();

        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withCSVParser(parser)
                .withSkipLines(1)
                .build();


        List<Persona> personaList = new ArrayList<>();
        String[] actualLine;

        while((actualLine = csvReader.readNext()) != null){
            Persona persona = new Persona();
            persona.setName(actualLine[0]);
            persona.setLastName(actualLine[1]);
            persona.setAge(Integer.parseInt(actualLine[2]));

            personaList.add(persona);
        }

        csvReader.close();
        reader.close();

        log.info("------------- Fin del paso de lectura --------------");

        chunkContext.getStepContext()
                .getStepExecution()
                .getJobExecution()
                .getExecutionContext()
                .put("personaList", personaList);

        return RepeatStatus.FINISHED;
    }
}
