package com.myblog3.demo.myblog.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="New-posts")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String tittle;
    private String description;

    private String comments;
}
