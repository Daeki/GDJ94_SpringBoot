package com.winter.app.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class NoticeDAOTest {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	void testDetail() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setBoardNum(1L);
		
		noticeDTO = noticeDAO.detail(noticeDTO);
		
		assertNotNull(noticeDTO);
		
	}

}
