package com.shujuniu.cache.admin;

import com.shujuniu.cache.redis.RedisService;
import com.shujuniu.common.rest.AdminUserProfile;
import com.shujuniu.common.utils.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminCacheService {

    @Autowired
    private RedisService redisService;

    private static final String KEY_USER_PROFILE = "shujuniu:admin:user:profile:%d";

    public void setUserProfile(AdminUserProfile userProfile){
        String key = String.format(KEY_USER_PROFILE,userProfile.getId());
        redisService.setString(key, JsonUtils.toJson(userProfile),((int)(Math.random()*4)+28)*24*60*60);
    }
    public void delUserProfile(Integer userId){
        String key = String.format(KEY_USER_PROFILE,userId);
        redisService.del(key);
    }
    public AdminUserProfile getUserProfile(Integer userId){

        String key = String.format(KEY_USER_PROFILE,userId);

        String json = redisService.getString(key);
        if(StringUtils.isEmpty(json)){
            return null;
        }

        return JsonUtils.toObject(json,AdminUserProfile.class);
    }
}
