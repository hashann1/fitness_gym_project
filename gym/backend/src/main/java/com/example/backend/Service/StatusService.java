package com.example.backend.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.backend.Model.Status;
import com.example.backend.Model.User;
import com.example.backend.Repository.StatusRepository;
import com.jayway.jsonpath.Criteria;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;
    private MongoTemplate mongoTemplate;

    public List<Status> allStatuses() {
        return statusRepository.findAll();
    }

    public Optional<Status> singleStatus(String id) {
        return statusRepository.findById(id);
    }

    public Status createStatus(Status status) {
        return statusRepository.save(status);

    }

    public Status updateStatus(Status status) {
        return statusRepository.save(status);
    }

        // Method to delete a status by its Object ID
    public void deleteStatus(String id){
        Optional<Status> statusToDelete = statusRepository.findById(id);

        if(statusToDelete.isPresent()){
            statusRepository.deleteById(id);
        }
    }

       // New method to get all statuses by user
       public List<Status> getAllStatusesByUser(String user) {
        return statusRepository.findByUser(user);
        
    }


    // // Scheduled task to delete old statuses
    // @Scheduled(cron = "0 0 */24 * * *") // Runs every 24 hours
    // public void deleteOldStatuses() {
    //     LocalDateTime dateTime = LocalDateTime.now().minusDays(1); // 24 hours ago
    //     statusRepository.deleteOldStatuses(dateTime);



}
