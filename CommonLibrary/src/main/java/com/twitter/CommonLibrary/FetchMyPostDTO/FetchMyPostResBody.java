package com.twitter.CommonLibrary.FetchMyPostDTO;

import java.util.List;

import com.twitter.CommonLibrary.CommonUseObjects.*;

import lombok.Data;

@Data
public class FetchMyPostResBody {
    private String Status;
    private List<String> myPosts;

}
