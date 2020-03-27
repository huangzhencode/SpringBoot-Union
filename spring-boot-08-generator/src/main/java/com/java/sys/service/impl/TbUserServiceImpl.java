package com.java.sys.service.impl;

import com.java.sys.entity.TbUser;
import com.java.sys.mapper.TbUserMapper;
import com.java.sys.service.ITbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hz
 * @since 2020-03-25
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements ITbUserService {

}
