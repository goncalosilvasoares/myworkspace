package org.urlShortster.persistence.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractModel implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    private String url_long;
    @Size(min = 4, message = "Need at least 4 characters long and can contain digits, upper case letters, and lowercase letters.")
    @Pattern(regexp = "([a-zA-Z0-9]+)")
    private String url_short;
    @CreationTimestamp
    private Date createDate;
    @UpdateTimestamp
    private Date updateDate;
    private Integer accessTimes = 0;

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
