package br.com.hbsis.eventmanager.init;


import br.com.hbsis.eventmanager.common.AppProperties;
import br.com.hbsis.eventmanager.event.Event;
import br.com.hbsis.eventmanager.event.EventRepository;
import br.com.hbsis.eventmanager.person.Person;
import br.com.hbsis.eventmanager.person.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;

@Configuration
@Slf4j
@Profile("dev")
public class LoadDatabase {

    private final AppProperties appProperties;

    public LoadDatabase(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    @Bean
    CommandLineRunner initDatabase(PersonRepository personRepository, EventRepository eventRepository){
        return args -> {

            //application params
            if(args != null)
                for(String a : args)
                     log.info(a);

            log.info("Persistindo pessoas.");
            personRepository.save(new Person("André","Santos", dateFormat.parse("28/11/1985 17:30"),"M"));
            personRepository.save(new Person("João","Batista", dateFormat.parse("15/03/1980 09:00"),"M"));
            personRepository.save(new Person("Maria","Aparecida", dateFormat.parse("06/03/1970 09:00"),"F"));

            log.info("Persistindo eventos.");
            eventRepository.save(new Event("Meia Maratona Blumenau",
                    "Esportivo", "21k", "Largada no parque Vila Germanica",false, dateFormat.parse("15/06/2020 06:00"), 60.00));

            eventRepository.save(new Event("Meia Maratona Pomerode",
                    "Esportivo", "21k", "Largada no portal",false, dateFormat.parse("20/08/2020 06:00"), 75.00));

            eventRepository.save(new Event("Blumenau 5K",
                    "Esportivo", "5k", "Largada na prefitura",false, dateFormat.parse("01/10/2020 08:00"), 80.00));

        };
    }
}
