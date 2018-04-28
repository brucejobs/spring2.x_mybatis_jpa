package com.bbgame.authority.repository;

import com.bbgame.authority.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Author bruce
 * @Date 2018/4/24 10:58
 * @Company bbgame
 */

@Repository
public interface UserRepository extends BaseRepository<User, Long>{
//
//    @Query("select * from bbgame_usr limit :ccount")
//    List<User> getUserListLimit(@Param("count") int count);

}
