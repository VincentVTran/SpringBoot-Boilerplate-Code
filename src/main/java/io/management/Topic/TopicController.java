package io.management.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.management.Topic.Topic; //Custom object

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    //Injects the TopicService data into TopicService when Spring scans over this controller; Do not need to instantiate the variable
    @Autowired
    private TopicService topicService;

    @RequestMapping("/topic")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics(); //Uses TopicService method to retrieve the entire list
    }

    @RequestMapping("/topic/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    @RequestMapping(method= RequestMethod.POST,value = "/topic")
    public void createTopic(@RequestBody Topic topicBody){
        topicService.addTopic(topicBody);
    }

    @RequestMapping(method= RequestMethod.DELETE,value = "/topic/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }

    @RequestMapping(method= RequestMethod.PUT,value = "/topic/{id}")
    public void updateTopic(@RequestBody Topic topicBody, @PathVariable String id){
        topicService.updateTopic(topicBody,id);
    }
}
