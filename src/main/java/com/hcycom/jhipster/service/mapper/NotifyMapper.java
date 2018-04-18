package com.hcycom.jhipster.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hcycom.jhipster.domain.Notify;


@Mapper
public interface NotifyMapper {

	/**
	 * 增加消息通知
	 * @param notify
	 * @return
	 */
	@Insert("INSERT INTO vll_notify (uuid,title,time,content,status,sender) "
			+ "VALUES(#{notify.uuid},#{notify.title},DATE_FORMAT(#{notify.time},'%Y-%m-%d %T'),#{notify.content},#{notify.status},#{notify.sender})")
	public int addNotify(@Param("notify") Notify notify);
	
	/**
	 * 删除消息通知
	 * @param notify
	 * @return
	 */
	@Delete("DELETE from vll_notify WHERE id=#{id}")
	public int deleteNotify(@Param("id") int id);
	
	/**
	 * 修改消息通知状态
	 * @param notify
	 * @return
	 */
	@Update("update vll_notify set status=#{notify.status} where id=#{notify.id}")
	public int updateNotify(@Param("notify") Notify notify);

	/**
	 * 根据用户ID获取消息通知
	 * @param notify
	 * @return
	 */
	@Select("SELECT id,uuid,title,DATE_FORMAT(time, '%Y-%m-%d %T')  time,content,status,sender FROM vll_notify WHERE uuid = #{uuid}")
	public List<Notify> findNotifyByUUID(@Param("uuid") String uuid);
	
	/**
	 * 根据用户ID获取消息通知
	 * @param notify
	 * @return
	 */
	@Select("SELECT count(id) FROM vll_notify WHERE uuid = #{uuid} and status=0")
	public int findNotifyCountByUUID(@Param("uuid") String uuid);

}
