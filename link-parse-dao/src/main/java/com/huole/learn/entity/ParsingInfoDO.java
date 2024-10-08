package com.huole.learn.entity;

import java.util.Date;

public class ParsingInfoDO {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column parsing_info.id
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column parsing_info.user_open_id
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    private String userOpenId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column parsing_info.download_url
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    private String downloadUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column parsing_info.title
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column parsing_info.author
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    private String author;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column parsing_info.cover
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    private String cover;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column parsing_info.create_time
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column parsing_info.id
     *
     * @return the value of parsing_info.id
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column parsing_info.id
     *
     * @param id the value for parsing_info.id
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column parsing_info.user_open_id
     *
     * @return the value of parsing_info.user_open_id
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public String getUserOpenId() {
        return userOpenId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column parsing_info.user_open_id
     *
     * @param userOpenId the value for parsing_info.user_open_id
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public void setUserOpenId(String userOpenId) {
        this.userOpenId = userOpenId == null ? null : userOpenId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column parsing_info.download_url
     *
     * @return the value of parsing_info.download_url
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public String getDownloadUrl() {
        return downloadUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column parsing_info.download_url
     *
     * @param downloadUrl the value for parsing_info.download_url
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl == null ? null : downloadUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column parsing_info.title
     *
     * @return the value of parsing_info.title
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column parsing_info.title
     *
     * @param title the value for parsing_info.title
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column parsing_info.author
     *
     * @return the value of parsing_info.author
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column parsing_info.author
     *
     * @param author the value for parsing_info.author
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column parsing_info.cover
     *
     * @return the value of parsing_info.cover
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public String getCover() {
        return cover;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column parsing_info.cover
     *
     * @param cover the value for parsing_info.cover
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column parsing_info.create_time
     *
     * @return the value of parsing_info.create_time
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column parsing_info.create_time
     *
     * @param createTime the value for parsing_info.create_time
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}