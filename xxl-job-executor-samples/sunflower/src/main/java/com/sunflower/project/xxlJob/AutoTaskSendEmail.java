package com.sunflower.project.xxlJob;

import com.sunflower.project.factory.AllDataSource;
import com.sunflower.project.factory.DataSourceFactory;
import com.sunflower.project.model.EmailInfo;
import com.sunflower.project.util.EmailUtil;
import com.sunflower.project.util.PublicVoid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


@Component
public class AutoTaskSendEmail {

    @Autowired
    private DataSourceFactory sourceFactory;

    @Autowired
    private PublicVoid pbVoid;

    @Autowired
    private EmailUtil emailUtil;

    private final String QUERY_TASK_SQL = "select tml_recAddress,tml_executeDate,tml_content,tml_title from task_email where tml_stt = '0' and tml_executeDate = ? ";

    /**
     * 获取当天待执行发送邮件的信息
     * @return info
     */
    private List<EmailInfo> getEmailInfo(){
        List<EmailInfo> infoList = new ArrayList<>();
        JdbcTemplate jdbcTemplate = sourceFactory.getJdbcTemplate(AllDataSource.sunflower);
        jdbcTemplate.query(QUERY_TASK_SQL, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                    EmailInfo info = new EmailInfo();
                    info.setRecAddress(resultSet.getString(1));
                    info.setExecuteDate(resultSet.getString(2));
                    info.setContent(resultSet.getString(3));
                    info.setTitle(resultSet.getString(4));
                    infoList.add(info);
            }
        },pbVoid.getCurrentDate("yyyyMMdd"));
        return infoList;
    }



    public void excute(){
        emailUtil.sendBatch(getEmailInfo());
    }
}
