package com.pak.redplm.service;


import com.pak.redplm.entity.TaskForYoutrack;
import com.pak.redplm.repository.TaskForYoutrackRepository;

import java.util.List;
import java.util.Optional;

public class TaskForYouTrackService {

    private final TaskForYoutrackRepository taskForYoutrackRepository;

    public TaskForYouTrackService(TaskForYoutrackRepository taskForYoutrackRepository) {
        this.taskForYoutrackRepository = taskForYoutrackRepository;
    }

    // Create
    public TaskForYoutrack createTaskForYoutrack(TaskForYoutrack taskForYoutrack) {
        return taskForYoutrackRepository.save(taskForYoutrack);
    }

    // Read
    public List<TaskForYoutrack> getAllTaskForYoutrack(){
        return taskForYoutrackRepository.findAll();
    }
    public Optional<TaskForYoutrack> getTaskForYoutrackById(long id){
        return taskForYoutrackRepository.findById(id);
    }

    public List<TaskForYoutrack> getTaskForYoutrackByIdRange(Long startId, Long endId){
        return taskForYoutrackRepository.findByIdBetween(startId,endId);
    }

    // Update
    public TaskForYoutrack updateTaskForYoutrack (TaskForYoutrack taskForYoutrack){
        return taskForYoutrackRepository.save(taskForYoutrack);
    }

    // Delete
    public void deleteTaskForYoutrackById(Long id) {
        taskForYoutrackRepository.deleteById(id);
    }

    // Other
    // Получение количества деталей
    public long getCount(){
        return taskForYoutrackRepository.count();
    }

}
