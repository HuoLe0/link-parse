package com.huole.learn.entity;

import java.util.Date;

public class WxUserDO {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wx_user.id
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wx_user.name
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wx_user.video_number
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    private Integer videoNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wx_user.sign_in_sum
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    private Integer signInSum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wx_user.end_sign_in_time
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    private Date endSignInTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wx_user.open_id
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    private String openId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wx_user.create_time
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wx_user.last_parsing_time
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    private Date lastParsingTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_user.id
     *
     * @return the value of wx_user.id
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_user.id
     *
     * @param id the value for wx_user.id
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_user.name
     *
     * @return the value of wx_user.name
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_user.name
     *
     * @param name the value for wx_user.name
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_user.video_number
     *
     * @return the value of wx_user.video_number
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public Integer getVideoNumber() {
        return videoNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_user.video_number
     *
     * @param videoNumber the value for wx_user.video_number
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public void setVideoNumber(Integer videoNumber) {
        this.videoNumber = videoNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_user.sign_in_sum
     *
     * @return the value of wx_user.sign_in_sum
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public Integer getSignInSum() {
        return signInSum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_user.sign_in_sum
     *
     * @param signInSum the value for wx_user.sign_in_sum
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public void setSignInSum(Integer signInSum) {
        this.signInSum = signInSum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_user.end_sign_in_time
     *
     * @return the value of wx_user.end_sign_in_time
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public Date getEndSignInTime() {
        return endSignInTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_user.end_sign_in_time
     *
     * @param endSignInTime the value for wx_user.end_sign_in_time
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public void setEndSignInTime(Date endSignInTime) {
        this.endSignInTime = endSignInTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_user.open_id
     *
     * @return the value of wx_user.open_id
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_user.open_id
     *
     * @param openId the value for wx_user.open_id
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_user.create_time
     *
     * @return the value of wx_user.create_time
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_user.create_time
     *
     * @param createTime the value for wx_user.create_time
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_user.last_parsing_time
     *
     * @return the value of wx_user.last_parsing_time
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public Date getLastParsingTime() {
        return lastParsingTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_user.last_parsing_time
     *
     * @param lastParsingTime the value for wx_user.last_parsing_time
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    public void setLastParsingTime(Date lastParsingTime) {
        this.lastParsingTime = lastParsingTime;
    }
}