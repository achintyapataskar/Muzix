package com.stackroute.muzix.controller;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.services.TrackServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("muzix/v1/")
public class MuzixController {
    @Autowired
    private TrackServices trackServices;
//    public void setTrackServices(TrackServices trackServices) {
//        this.trackServices = trackServices;
//    }

    public MuzixController(TrackServices trackServices) {
        this.trackServices = trackServices;
    }

    @RequestMapping(value = "/newtrack", method = RequestMethod.PUT)
    public ResponseEntity<Track> newTrack(@RequestBody Track track) {
        Track track1 = trackServices.addTrack(track);
        return new ResponseEntity<Track>(track, HttpStatus.OK);
    }
    @RequestMapping(value = "/deltrack", method = RequestMethod.DELETE)
    public ResponseEntity<Track> delTrack(@RequestBody Track track) {
        Track track1 = trackServices.delTrack(track);
        return new ResponseEntity<Track>(track1, HttpStatus.OK);
    }
    @RequestMapping(value = "/modifycomments", method = RequestMethod.PUT)
    public ResponseEntity<Track> modifyTrackComments(@RequestBody Track track) {
        Track track1 = trackServices.modifyTrack(track);
        return new ResponseEntity<Track>(track1, HttpStatus.OK);
    }
    @RequestMapping(value = "/displaytrack", method = RequestMethod.GET)
    public ResponseEntity<Optional<Track>> searchTrack(@RequestBody Track track) {
        Optional<Track> track1 = trackServices.displayTrack(track);
        return new ResponseEntity<Optional<Track>>(track1, HttpStatus.OK);
    }
    @RequestMapping(value = "/displayalltracks", method = RequestMethod.GET)
    public ResponseEntity<List<Track>> displayAlltracks() {
        List<Track> track1 = trackServices.displayTracks();
        return new ResponseEntity<List<Track>>(track1, HttpStatus.OK);
    }
}
