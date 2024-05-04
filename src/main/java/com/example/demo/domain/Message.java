package com.example.demo.domain;
import jakarta.persistence.*;

@Entity //это сущность для сохранения в БД
public class Message {
    public Message(){}
    public Message(String text, String tag, User user) {
        this.author = user;
        this.text = text;
        this.tag = tag;
    }
    public String getAuthorName(){
        return author != null ? author.getUsername() : "<none>";
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String text;
    private String tag;
    @ManyToOne(fetch = FetchType.EAGER)//Указываем базе, что одному пользователю соответсвует множество сообщений
    @JoinColumn(name = "user_id") //Указание как называть это поле
    private User author;

    public Integer getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
