package com.stackroute.trackservice.seeddata;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component

public class ApplicationListenerImpl implements ApplicationListener {

    private TrackRepository trackRepository;
    @Autowired
    public ApplicationListenerImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

        Track track1=new Track(1,"raj","good");
        trackRepository.save(track1);
    }
}
