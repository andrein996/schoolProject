package Repository;

import Entities.Post;
import Validator.PostValidator;

/**
 * Created by Andrei on 10/23/2016.
 */
public class PostRepo extends AbstractRepo<Post, String> {
    public PostRepo(){
        validator=new PostValidator();
    }
}