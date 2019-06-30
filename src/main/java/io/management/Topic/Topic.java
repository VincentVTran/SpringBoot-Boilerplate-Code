package io.management.Topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //Configures database table to where ID and name are columns; Instances will be rows
public class Topic {

    @Id //Marks id as 'ID' (Primary search key)
    String id;
    String name;

    public Topic(){ //JPA Requires default constructor

    }

    public Topic(String id,String name){
        this.id = id;
        this.name = name;
    }
    //Getters
    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    //Setters
    public void setId(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

}
