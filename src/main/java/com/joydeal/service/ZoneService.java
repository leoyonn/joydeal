/**
 *
 * ZoneService.java
 * @date 14-6-17 上午12:10
 * @author leo [liuy@xiaomi.com]
 * [CopyRight] All Rights Reserved.
 */

package com.joydeal.service;

import com.joydeal.dao.UserDAO;
import com.joydeal.dao.ZoneDAO;
import com.joydeal.result.ErrorCode;
import com.joydeal.result.OperResult;
import com.joydeal.thrift.User;
import com.joydeal.thrift.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author leo
 */
@Service
public class ZoneService extends BaseService {
    private static ZoneService instance;

    @Autowired
    private ZoneDAO zoneDao;

    public ZoneService() {
        synchronized (ZoneService.class) {
            instance = this;
        }
    }

    public static ZoneService instance() {
        return instance;
    }

    public OperResult<Zone> create(Zone zone) {
        return null;
    }

    public OperResult<Zone> get(long id) {
        try {
            Zone zone = zoneDao.get(id);
            if (zone == null) {
                return fail(ErrorCode.InvalidParam, "查无此区");
            }
            return success(zone);
        } catch (Exception ex) {
            LOGGER.warn("Load zone info " + id + " got exception", ex);
            return fail(ErrorCode.DbError, "获取区信息失败", ex);
        }
    }
}
