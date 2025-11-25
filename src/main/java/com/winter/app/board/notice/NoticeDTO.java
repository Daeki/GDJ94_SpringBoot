package com.winter.app.board.notice;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeDTO {
	
	private Long boardNum;
	private String boardTitle;
	private String boardWriter;
	private String boardContets;
	private LocalDate boardDate;
	private Long boardHit;

}
