package com.app.api.activities.controller;

import com.app.api.activities.model.Activity;
import com.app.api.activities.model.User;
import com.app.api.activities.repository.ActivityRepository;
import com.app.api.activities.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appActivities")
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Activity> createActivity(@Validated @RequestBody Activity activity) {
        if (activity.getMaxCapacity() <= 0) {
            return ResponseEntity.badRequest().body(null); // Return bad request if capacity is invalid
        }
        return ResponseEntity.ok(activityRepository.save(activity));
    }

    @GetMapping
    public ResponseEntity<List<Activity>> getAllActivities() {
        List<Activity> activities = activityRepository.findAll();
        return ResponseEntity.ok(activities);
    }

    @PostMapping("/import")
    public ResponseEntity<Void> importActivities(@Validated @RequestBody List<Activity> activities) {
        for (Activity activity : activities) {
            if (activity.getMaxCapacity() <= 0) {
                return ResponseEntity.badRequest().build(); // Return bad request if any activity has invalid capacity
            }
        }
        activityRepository.saveAll(activities);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{activityId}/signup")
    public ResponseEntity<String> signupForActivity(@PathVariable Long activityId, @Validated @RequestBody User user) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not found"));

        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (activity.getUsers().size() >= activity.getMaxCapacity()) {
            return ResponseEntity.status(400).body("Activity is at full capacity.");
        }

        activity.addUser(existingUser);
        activityRepository.save(activity);

        return ResponseEntity.ok("User signed up successfully.");
    }

}
