package com.stackroute.muzix.services;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackDBServices implements TrackServices {


    @Autowired
    private TrackRepository trackRepository;
    public TrackDBServices(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }


    public Track addTrack(Track track) {
        return trackRepository.save(track);
    }

    public Track delTrack(Track track) {
        trackRepository.deleteById(track.getTrackId());
        return track;
    }

    public Track modifyTrack(Track track) {
        Track track1 = trackRepository.findByName(track.getName());
        track1.setComment(track.getComment());
        track1 = trackRepository.save(track);
        return track1;
    }

    public Optional<Track> displayTrack(Track track) {
        return trackRepository.findById(track.getTrackId());
    }
    public List<Track> displayTracks() {
        return (List<Track>) trackRepository.findAll();
    }
}
