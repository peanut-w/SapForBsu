package com.haiqiu.cfadata.service;

import com.haiqiu.cfadata.doentity.MatchDO;
import com.haiqiu.cfadata.doentity.MatchLineUpDO;
import com.haiqiu.cfadata.doentity.MatchesBySeasonsDO;

/**
 * Created by peanut on 2019/6/14 下午1:30
 */

public interface MatchService {
    MatchDO match(Integer maId);

    MatchesBySeasonsDO matchesBySeasons(Integer seId, String lm);

    MatchLineUpDO MatchLineUp(Integer maId);
}
