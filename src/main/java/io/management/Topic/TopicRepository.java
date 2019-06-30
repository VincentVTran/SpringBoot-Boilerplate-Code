package io.management.Topic;

import org.springframework.data.repository.CrudRepository; //CrudRepository provides all the Get,Post,Delete methods for connecting to a remote database

public interface TopicRepository extends CrudRepository<Topic, String> { //<Data Type, ID Data Type>

}
