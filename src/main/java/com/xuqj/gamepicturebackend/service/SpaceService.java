package com.xuqj.gamepicturebackend.service;

import com.xuqj.gamepicturebackend.model.dto.space.SpaceAddRequest;
import com.xuqj.gamepicturebackend.model.entity.Space;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xuqj.gamepicturebackend.model.entity.User;

/**
* @author 11394
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2025-08-21 09:57:03
*/
public interface SpaceService extends IService<Space> {

    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);

    void validSpace(Space space, boolean add);

    void fillSpaceBySpaceLevel(Space space);
}
