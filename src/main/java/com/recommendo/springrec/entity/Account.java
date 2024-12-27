package com.recommendo.springrec.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Account {
    @Id
    public String username;
    public String password;
    public String email;
    public String myAnimeListId;
    public String anilistId;
    public String steamId;
}
