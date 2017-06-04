package net.kerba.demo.redis.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @user: kerb
 * @created: 04/06/2017.
 */
@Controller
public class EntryPointController {

    private RedisTemplate<String,Object> template;

    @Autowired
    public EntryPointController(RedisTemplate<String,Object> template) {
        this.template = template;
    }

    @RequestMapping("/")
    @ResponseBody
    public String home() {

        final HashOperations<String, Object, Object> ops = template.opsForHash();

        final Person vasya = new Person();
        vasya.setFirstName("Vasya");
        vasya.setLastName("Pupkin");
        ops.put("user", "1", vasya);

        return "Hello " + ops.get("user", "1");
    }


}
