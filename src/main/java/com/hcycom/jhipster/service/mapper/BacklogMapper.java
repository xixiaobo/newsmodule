package com.hcycom.jhipster.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hcycom.jhipster.domain.Backlog;


@Mapper
public interface BacklogMapper {

	/**
	 * 增加待办事宜
	 * @param backlog
	 * @return
	 */
	@Insert("INSERT INTO vll_backlog (uuid,title,checkbox) "
			+ "VALUES(#{backlog.uuid},#{backlog.title},#{backlog.checkbox})")
	public int addBacklog(@Param("backlog") Backlog backlog);
	
	/**
	 * 删除待办事宜
	 * @param backlog
	 * @return
	 */
	@Delete("DELETE from vll_backlog WHERE id=#{id}")
	public int deleteBacklog(@Param("id") int id);
	
	/**
	 * 修改待办事宜
	 * @param backlog
	 * @return
	 */
	@Update("update vll_backlog set title=#{backlog.title} and checkbox=0 where id=#{backlog.id}")
	public int updateBacklog(@Param("backlog") Backlog backlog);
	/**
	 * 修改待办事宜状态
	 * @param backlog
	 * @return
	 */
	@Update("update vll_backlog set checkbox=#{backlog.checkbox} where id=#{backlog.id}")
	public int updateBacklogCheckbox(@Param("backlog") Backlog backlog);

	/**
	 * 根据用户ID获取待办事宜
	 * @param backlog
	 * @return
	 */
	@Select("SELECT id,uuid,title,checkbox FROM vll_backlog	WHERE uuid = #{uuid}")
	public List<Backlog> findBacklogByUUID(@Param("uuid") String uuid);

}
