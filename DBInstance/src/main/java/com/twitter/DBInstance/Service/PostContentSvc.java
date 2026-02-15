package com.twitter.DBInstance.Service;

@Service
public class PostContentSvc{

    @Autowired
    private IPostRepo repo;

    public ResponseBody<PostContentResBody> postContent (PostContentReqBody req){
        return null;
    }

}