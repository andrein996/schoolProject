package Validator;

import Entities.Post;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.*;

/**
 * Created by Andrei on 11/7/2016.
 */
public class PostValidatorTest {

    Post p1;
    Post p2;
    Post p3;

    @Before
    public void setUp() throws Exception {
        p1 = new Post("1","Descriere post id 1", "parttime");
        p2 = new Post("2","Descriere post id 2", "fulltime");
        p3 = new Post("3","Descriere post id 3", "partdstime");
    }

    @After
    public void tearDown() throws Exception {
        p1 = null;
        p2 = null;
        p3 = null;
    }

    @Test
    public void validate() throws Exception {
        PostValidator validator = new PostValidator();

        try {
            validator.validate(p1);
            assert (true);
        }
        catch (ValidatorException msg) {
            msg.printStackTrace();
            assert (false);
        }

        try {
            validator.validate(p2);
            assert (true);
        }
        catch (ValidatorException msg) {
            msg.printStackTrace();
            assert (false);
        }

        try {
            validator.validate(p3);
            assert(false);
        }
        catch (ValidatorException msg) {
            assert (true);
        }
    }

}