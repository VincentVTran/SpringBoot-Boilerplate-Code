package io.management.Topic;

public class Topic {
    String id;
    String name;

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
