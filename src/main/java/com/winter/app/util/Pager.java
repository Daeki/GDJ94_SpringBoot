package com.winter.app.util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Pager {
	
	private Long startNum;
	private Long countNum;
	
	private Long totalPage;
	
	private Long begin;
	private Long end;

}
