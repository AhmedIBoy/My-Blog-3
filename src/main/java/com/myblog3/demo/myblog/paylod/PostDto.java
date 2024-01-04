package com.myblog3.demo.myblog.paylod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private long id;
    private String tittle;
    private String description;
    private String comments;

}
