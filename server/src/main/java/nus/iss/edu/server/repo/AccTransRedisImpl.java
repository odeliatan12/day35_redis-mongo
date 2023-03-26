package nus.iss.edu.server.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import nus.iss.edu.server.Utils;
import nus.iss.edu.server.models.AccountTransfer;

import static nus.iss.edu.server.Constants.*;

@Repository
public class AccTransRedisImpl {

    // @Autowired
    // @Qualifier(DATABASE_REDIS)
    // RedisTemplate<String, Object> redisTemplate;

    // public int saveTransferAccount(AccountTransfer at){

    //     redisTemplate.opsForValue().set(at.getId(), Utils.toJSON(at));
    //     String result = (String) redisTemplate.opsForValue().get(at.getId());
    //     if(result != null){
    //         return 1;
    //     } else {
    //         return 0;
    //     }
    // }
    
}
