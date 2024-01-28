package com.myblog3.demo.myblog.util;

import com.myblog3.demo.myblog.paylod.PostDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

    private boolean FirstPage;
    private List<PostDto> content;
    private int PageNumber;
    private int PageSize;
    private long TotalElement;
    private int TotalPages;
    private boolean LastPage;
}
