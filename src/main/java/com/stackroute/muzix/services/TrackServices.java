package com.stackroute.muzix.services;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TrackServices {
//    @Autowired
//    TrackRepository trackRepository;
//    public void setTrackRepository(TrackRepository trackRepository) {
//    }
    //Comment this out to make the class into an interface
    public Track addTrack(Track track);
    public Track delTrack(Track track);
    public Track modifyTrack(Track track);
    public Optional<Track> displayTrack(Track track);
    public List<Track> displayTracks();
}
