package com.xuqj.gamepicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuqj.gamepicturebackend.model.dto.space.SpaceAddRequest;
import com.xuqj.gamepicturebackend.model.dto.space.SpaceQueryRequest;
import com.xuqj.gamepicturebackend.model.entity.Space;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xuqj.gamepicturebackend.model.entity.User;
import com.xuqj.gamepicturebackend.model.vo.SpaceVO;
import jakarta.servlet.http.HttpServletRequest;

/**
* @author 11394
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2025-08-21 09:57:03
*/
public interface SpaceService extends IService<Space> {

    /**
     * 创建空间
     * @param spaceAddRequest
     * @param loginUser
     * @return
     */
    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);

    /**
     * 校验空间
     * @param space
     * @param add
     */
    void validSpace(Space space, boolean add);

    /**
     * 获取空间包装类（分页）
     *
     * @param spacePage
     * @param request
     * @return
     */
    Page<SpaceVO> getSpaceVOPage(Page<Space> spacePage, HttpServletRequest request);

    /**
     * 获取查询对象
     *
     * @param spaceQueryRequest
     * @return
     */
    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);

    /**
     * 获取单个空间包装类
     * @param space
     * @param request
     * @return
     */
    SpaceVO getSpaceVO(Space space, HttpServletRequest request);

    /**
     * 根据空间级别填充对象
     * @param space
     */
    void fillSpaceBySpaceLevel(Space space);

    /**
     * 校验空间权限
     * @param loginUser
     * @param space
     */
    void checkSpaceAuth(User loginUser, Space space);
}
