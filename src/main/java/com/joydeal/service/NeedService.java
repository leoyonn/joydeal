/**
 *
 * NeedService.java
 * @date 14-6-17 上午12:08
 * @author leo [liuy@xiaomi.com]
 * [CopyRight] All Rights Reserved.
 */

package com.joydeal.service;

import com.joydeal.dao.NeedDAO;
import com.joydeal.result.ErrorCode;
import com.joydeal.result.OperResult;
import com.joydeal.thrift.Need;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author leo
 */
@Service
public class NeedService extends BaseService {
    private static NeedService instance;

    @Autowired
    private NeedDAO needDao;

    public NeedService() {
        synchronized (NeedService.class) {
            instance = this;
        }
    }

    public static NeedService instance() {
        return instance;
    }

    public OperResult<Need> create(Need need) {
        try {
            if (!needDao.add(need)) {
                return fail(ErrorCode.DbError, "添加需求失败");
            }
            need.setId(needDao.lastAddedId());
        } catch (Exception ex) {
            LOGGER.warn("Add need " + need + " got exception", ex);
            return fail(ErrorCode.DbError, "添加需求失败", ex);
        }
        return success(need);
    }

    public OperResult<Need> get(long id) {
        try {
            Need need = needDao.get(id);
            if (need == null) {
                return fail(ErrorCode.InvalidParam, "查无此需求");
            }
            return success(need);
        } catch (Exception ex) {
            LOGGER.warn("Load need info " + id + " got exception", ex);
            return fail(ErrorCode.DbError, "获取需求信息失败", ex);
        }
    }
}
