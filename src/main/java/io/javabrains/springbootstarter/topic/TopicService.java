package io.javabrains.springbootstarter.topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

        //HardCoded DataBase

//    private final List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("spring", "Spring Framework", "Spring Framework Description"),
//            new Topic("java", "Core Java", "Core Java Description"),
//            new Topic("javascript", "JavaScript", "JavaScript Description")
//    ));

    public List<Topic> getAllTopics(){
        //return topics;

        //utilizing the crud repo in Topic Repository to do the same task.
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id){
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

        //topicRepository.findOne() is not an available method. Used findById() instead and wrap method in Optional;
        return topicRepository.findById(id).get();
    }

    public void addTopic(Topic topic) {
        //topics.add(topic);

        //utilizing the crud repo in Topic Repository to do the same task.
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id) {
//        for(int i = 0; i < topics.size(); i++){
//            Topic t = topics.get(i);
//            if(t.getId().equals(id)){
//                topics.set(i, topic);
//                return;
//            }
//        }
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
//        topics.removeIf(t -> t.getId().equals(id));

        topicRepository.deleteById(id);
    }
}
