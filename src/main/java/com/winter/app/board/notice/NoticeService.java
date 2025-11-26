package com.winter.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.util.Pager;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<NoticeDTO> list (Long page, Pager pager)throws Exception{
		
		if(page<1) {
			page=1L;
		}
		
		//1. 일정한 갯수만큼 조회
		
		pager.setCountNum(10L);
		Long s = (page-1)*pager.getCountNum();
		pager.setStartNum(s);
		
		

		
		//2. 페이징 계산
		/// 1. totalCount로 totalPage계산
		Long count = noticeDAO.count();
		Long totalPage = count / pager.getCountNum();
		if(count%pager.getCountNum() != 0) {
//			totalPage = totalPage+1;
//			totalPage+=1;
			totalPage++;
		} 
		
		if(page>totalPage) {
			page = totalPage;
		}
		
		///2. totalPage로 totalBlock 계산
		///// 한블럭당 보여줄 번호의 갯수
		Long perBlock = 5L;
		Long totalBlock = totalPage/perBlock;
		if(totalPage % perBlock != 0) {
			totalBlock++;
		}
		
		///3. page로 현재 block 구하기
		Long curBlock = page/perBlock;
		if(page%perBlock !=0) {
			curBlock++;
		}
		
		///4. 현재 block 번호로 시작번호와 끝번호 계산하기
		Long begin = (curBlock-1)*perBlock+1;
		Long end = curBlock*perBlock;
		
		pager.setBegin(begin);
		pager.setEnd(end);
		
		if(curBlock==totalBlock) {
			pager.setEnd(totalPage);
		}
		
		pager.setTotalPage(totalPage);
		
		// page*pager.getCountNum()-pager.getCountNum()
		// (page-1)*pager.getCountNum()


		
		return noticeDAO.list(pager);
	}
	
	public NoticeDTO detail(NoticeDTO noticeDTO)throws Exception{
		return noticeDAO.detail(noticeDTO);
	}
	
	public int add(NoticeDTO noticeDTO)throws Exception{
		return noticeDAO.add(noticeDTO);
	}
	
	public int update(NoticeDTO noticeDTO)throws Exception{
		return noticeDAO.update(noticeDTO);
	}
	
	public int delete(NoticeDTO noticeDTO)throws Exception{
		return noticeDAO.delete(noticeDTO);
	}
	
}
