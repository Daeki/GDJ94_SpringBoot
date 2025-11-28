package com.winter.app.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.winter.app.board.notice.NoticeDTO;
import com.winter.app.util.Pager;

@Mapper
public interface QnaDAO {
	
	public Long count(Pager pager)throws Exception;
	
	public List<NoticeDTO> list (Pager pager)throws Exception;
	
	public NoticeDTO detail(NoticeDTO noticeDTO)throws Exception;

	public int add(NoticeDTO noticeDTO)throws Exception;
	
	public int update(NoticeDTO noticeDTO)throws Exception;
	
	public int delete(NoticeDTO noticeDTO)throws Exception;

}
