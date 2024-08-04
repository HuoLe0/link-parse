package com.huole.learn.mapper;

import com.huole.learn.entity.WxUserDO;
import com.huole.learn.entity.WxUserParam;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WxUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_user
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    int countByExample(WxUserParam example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_user
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    int deleteByExample(WxUserParam example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_user
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_user
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    int insert(WxUserDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_user
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    int insertSelective(WxUserDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_user
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    List<WxUserDO> selectByExample(WxUserParam example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_user
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    WxUserDO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_user
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    int updateByExampleSelective(@Param("record") WxUserDO record, @Param("example") WxUserParam example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_user
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    int updateByExample(@Param("record") WxUserDO record, @Param("example") WxUserParam example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_user
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    int updateByPrimaryKeySelective(WxUserDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_user
     *
     * @mbggenerated Sat Aug 03 18:38:16 CST 2024
     */
    int updateByPrimaryKey(WxUserDO record);
}