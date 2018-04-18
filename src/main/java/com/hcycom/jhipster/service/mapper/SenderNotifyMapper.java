package com.hcycom.jhipster.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.hcycom.jhipster.domain.SenderNotify;


@Mapper
public interface SenderNotifyMapper {

	/**
	 * 增加发件记录
	 * @param notify
	 * @return
	 */
	@Insert("INSERT INTO vll_sendernotify (uuid,title,time,content,addressee) "
			+ "VALUES(#{senderNotify.uuid},#{senderNotify.title},DATE_FORMAT(#{senderNotify.time},'%Y-%m-%d %T'),#{senderNotify.content},#{senderNotify.addressee})")
	public int addSenderNotify(@Param("senderNotify") SenderNotify senderNotify);
	
	/**
	 * 删除发件记录
	 * @param notify
	 * @return
	 */
	@Delete("DELETE from vll_sendernotify WHERE id=#{id}")
	public int deleteSenderNotify(@Param("id") int id);
	

	/**
	 * 根据用户ID获取发件记录
	 * @param notify
	 * @return
	 */
	@Select("SELECT id,uuid,title,DATE_FORMAT(time, '%Y-%m-%d %T')  time,content,addressee FROM vll_sendernotify WHERE uuid = #{uuid}")
	public List<SenderNotify> findSenderNotifyByUUID(@Param("uuid") String uuid);

}
