package org.urlShortster.persistence.model;

import java.util.Date;

public interface Model {


    Integer getId();

    Date getCreateDate();

    Date getUpdateDate();

    Integer getAccessTimes();

    String getUrl_long();

    String getUrl_short();

    void setAccessTimes(Integer accessTimes);

    void setId(Integer id);

    void setUrl_short(String url_short);

    void setUpdateDate(Date updateDate);

    void setUrl_long(String url_long);
}
