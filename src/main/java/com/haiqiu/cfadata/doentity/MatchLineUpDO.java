package com.haiqiu.cfadata.doentity;

import java.util.List;

/**
 * Created by peanut on 2019/7/17 下午3:57
 */

public class MatchLineUpDO {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<LineUpNameDO> lineupName;

        private List<PlayListDO> playList;

        public List<LineUpNameDO> getLineupName() {
            return lineupName;
        }

        public void setLineupName(List<LineUpNameDO> lineupName) {
            this.lineupName = lineupName;
        }

        public List<PlayListDO> getPlayList() {
            return playList;
        }

        public void setPlayList(List<PlayListDO> playList) {
            this.playList = playList;
        }

    }
}
