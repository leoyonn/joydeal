/**
 *
 * GoodService.java
 * @date 14-6-16 下午10:31
 * @author leo [liuy@xiaomi.com]
 * [CopyRight] All Rights Reserved.
 */

package com.joydeal.service;

import com.joydeal.dao.GoodDAO;
import com.joydeal.result.ErrorCode;
import com.joydeal.result.OperResult;
import com.joydeal.thrift.Good;
import com.joydeal.thrift.Need;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author leo
 */
@Service
public class GoodService extends BaseService {
    @Autowired
    private GoodDAO goodDao;

    public OperResult<Good> create(Good good) {
        try {
            if (!goodDao.add(good)) {
                return fail(ErrorCode.DbError, "添加宝贝失败");
            }
            good.setId(goodDao.lastAddedId());
        } catch (Exception ex) {
            LOGGER.warn("Add good " + good + " got exception", ex);
            return fail(ErrorCode.DbError, "添加宝贝失败", ex);
        }
        return success(good);
    }

    public OperResult<Good> get(long id) {
        try {
            Good good = goodDao.get(id);
            if (good == null) {
                return fail(ErrorCode.InvalidParam, "查无此宝贝");
            }
            return success(good);
        } catch (Exception ex) {
            LOGGER.warn("Load good info " + id + " got exception", ex);
            return fail(ErrorCode.DbError, "获取宝贝信息失败", ex);
        }
    }}
