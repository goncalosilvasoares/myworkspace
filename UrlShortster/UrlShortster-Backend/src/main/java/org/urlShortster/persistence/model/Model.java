package org.urlShortster.persistence.model;

import java.util.Date;

public interface Model {


    public Integer getId();

    public Date getCreateDate();

    public Date getUpdateDate();

    public Integer getAccessTimes();

    public String getUrl_long();

    public String getUrl_short();

    public void setAccessTimes(Integer accessTimes);

    public void setId(Integer id);

    public void setUrl_short(String url_short);

    public void setUpdateDate(Date updateDate);

    public void setUrl_long(String url_long);

}
