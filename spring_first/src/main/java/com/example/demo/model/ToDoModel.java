package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class ToDoModel {

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Id
    @GeneratedValue
    public int id;
    public String user;

    public String desc;
    public Date date;
    public boolean done;

    public ToDoModel(
    ){super();}

    public ToDoModel(int id, String user, String desc, Date date, boolean done) {
        super();
        this.id = id;
        this.user = user;
        this.desc = desc;
        this.date = date;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getDesc() {
        return desc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isDone() {
        return done;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ToDoModel other = (ToDoModel) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return String.format(
                "Todo [id=%s, user=%s, desc=%s, targetDate=%s, isDone=%s]", id,
                user, desc, date, done);
    }
}
