package com.stackroute.trackservice.seeddata;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component

public class CommandLineRunnerImpl implements CommandLineRunner {

    private TrackRepository trackRepository;
    @Autowired
    public CommandLineRunnerImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        Track track1=new Track(1,"raj","good");
        trackRepository.save(track1);
    }
}
