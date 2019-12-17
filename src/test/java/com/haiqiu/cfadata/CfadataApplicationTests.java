package com.haiqiu.cfadata;


import com.haiqiu.cfadata.dao.MatchPOMapper;
import com.haiqiu.cfadata.poentity.MatchPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CfadataApplicationTests {
    @Autowired
    MatchPOMapper matchPOMapper;

    @Test
    public void contextLoads() {
        MatchPO matchPO = matchPOMapper.selectByPrimaryKey(16652);
        Date date = matchPO.getMatchDate();

        SimpleDateFormat sdfprase = new SimpleDateFormat("dd.MM.yyyy");

        SimpleDateFormat sdfprasetime = new SimpleDateFormat("HH:mm");

        System.out.println(matchPO);

        System.out.println("原始时间" + date);

        System.out.println("年月日" + sdfprase.format(date));

        System.out.println("时分秒" + sdfprasetime.format(date));


    }
}
