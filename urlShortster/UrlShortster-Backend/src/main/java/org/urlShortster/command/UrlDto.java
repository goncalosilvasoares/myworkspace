package org.urlShortster.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class UrlDto {

    private Integer id;

    @NotNull(message = "Long URL is mandatory")
    @NotBlank(message = "Long URL is mandatory")
    @Size(min = 10)
    private String url_long;

    @Pattern(regexp = "/[^A-Za-z0-9]+/g", message = "Short Url contains invalid characters")
    @Size(min = 4, message = "Need at least 4 characters long and can contain digits, upper case letters, and lowercase letters.")
    private String url_short;
    private Date createDate;
    private Date updateDate;
    private Integer accessTimes;

    public Integer getId() {
        return id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public Integer getAccessTimes() {
        return accessTimes;
    }

    public String getUrl_long() {
        return url_long;
    }

    public String getUrl_short() {
        return url_short;
    }

    public void setAccessTimes(Integer accessTimes) {
        this.accessTimes = accessTimes;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUrl_short(String url_short) {
        this.url_short = url_short;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setUrl_long(String url_long) {
        this.url_long = url_long;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
