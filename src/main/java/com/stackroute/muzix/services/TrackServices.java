package com.stackroute.muzix.services;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServices {
    @Autowired
    private TrackRepository trackRepository;
    public void setTrackRepository(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public Track addTrack(Track track) {
        Track track1 = trackRepository.save(track);
        return track1;
    }

    public Track delTrack(Track track) {
        trackRepository.deleteById(track.getTrackId());
        return track;
    }

    public Track modifyTrack(Track track) {
        Track track1 = (Track) trackRepository.findByName(track.getName());
        track1.setComment(track.getComment());
        track1 = trackRepository.save(track);
        return track1;
    }

    public Optional<Track> displayTrack(Track track) {
        Optional<Track> track1 = (Optional<Track>) trackRepository.findById(track.getTrackId());
        return track1;
    }
    public List<Track> displayTracks() {
        List<Track> trackList = (List<Track>) trackRepository.findAll();
        return trackList;
    }
}
