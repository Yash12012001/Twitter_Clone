package com.twitter.CommonLibrary.FetchMyPostDTO;

import com.twitter.CommonLibrary.CommonUseObjects.*;

import lombok.Data;

@Data
public class FetchMyPostResBody {
    private String Status;
    private List<Content> myPosts;

}
