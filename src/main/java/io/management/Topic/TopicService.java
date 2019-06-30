package io.management.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//This is a business service
//Spring MVC creates one copy of this service and stores it in memory (Singleton)

//This is typically used to store data since only one instance of this copy is used

//If this was made in controller, a new List would be made each HTTP request
@Service
public class TopicService {

    private List<Topic> dataService = new ArrayList<>(
            Arrays.asList(
                new Topic("1", "Richard"),
                new Topic("2", "Vincent"),
                new Topic("3", "Bob")
            )
    );


    //return new Topic("192312", "Richard"); //Returns a JSON object {"id":"192312","name":"Richard"}
    public void addTopic(Topic topicBody){
        dataService.add(topicBody);
    }
    public Topic getTopic(String id){
        /*
            for(int i = 0;i<dataService.size();i++){
                if(dataService.get(i).getId().equals(id)){
                    return dataService.get(i);
                };
            }
        */

        //Turns dataService into a stream; grab an array of filter object; Grab first one
        return dataService.stream().filter(currentObject -> currentObject.getId().equals(id)).findFirst().get();
    }
    public List<Topic> getAllTopics(){
        return dataService;
    }

    public void updateTopic(Topic topic, String id){
        for(int i = 0;i<dataService.size();i++){
            if(dataService.get(i).getId().equals(id)){
                dataService.set(i,topic);
            }
        }
    }

    public void deleteTopic(String id){
        for(int i =0;i<dataService.size();i++){
            if(dataService.get(i).getId().equals(id)){
                dataService.remove(i);
            }
        }
    }
    //_____________________________________Connection to remote database_________________________

    @Autowired //Injects a singleton topic repository into the variable
    private TopicRepository topicRepository;

    public List<Topic> getAllRemoteDatabase(){
        List<Topic> list = new ArrayList<>();
        topicRepository.findAll().forEach(topic -> list.add(topic));
        return list;
    }

    public void addRemoteDatabase(Topic entity){
        topicRepository.save(entity);
    }

    public Topic getSpecificRemoteDatabase(String id){
        return topicRepository.findById(id).get();
    }

    public void updateRemoteDatabase(Topic entity){
        topicRepository.save(entity); //Adds entity if does not exist; Updates if it does
    }

    public void deleteRemoteDatabase(String id){
        topicRepository.deleteById(id);
    }

}
