package com.stackroute.trackservice.controller;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exception.TrackAlreadyExistsException;
import com.stackroute.trackservice.exception.TrackNotFoundException;
import com.stackroute.trackservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TrackController {

    private TrackService trackService;

    public TrackController() {
    }


    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> setTrack(@RequestBody Track track) throws TrackAlreadyExistsException {
        ResponseEntity responseEntity;
        Track saveTrack = trackService.saveTrack(track);
        return new ResponseEntity(saveTrack, HttpStatus.OK);
    }

    @GetMapping("tracks/{name}")
    public ResponseEntity<?> getTrackByName(@PathVariable String name) throws TrackNotFoundException {
        List<Track> trackDetails = trackService.getTrackByName(name);
        return new ResponseEntity(trackDetails, HttpStatus.OK);
    }

    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) throws TrackNotFoundException {
        Track trackDetails = trackService.getById(id);
        return new ResponseEntity(trackDetails, HttpStatus.OK);
    }

    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks() throws Exception {
        ResponseEntity responseEntity;

        List<Track> trackDetails = trackService.getAllTracks();
        return new ResponseEntity(trackDetails, HttpStatus.OK);


    }

    @DeleteMapping("tracks/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id) throws TrackNotFoundException {


        Track trackDetails = trackService.getById(id);
        return new ResponseEntity<Track>(trackDetails, HttpStatus.OK);


    }

    @PutMapping("tracks/{id}")
    public ResponseEntity<?> trackUpdateById(@PathVariable int id, @RequestBody Track track) throws TrackNotFoundException {
        Track trackDetails = trackService.updateTrackById(id, track);
        return new ResponseEntity<Track>(trackDetails, HttpStatus.OK);
    }

}
