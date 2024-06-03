package guestbook.controller;

import java.util.List;

import guestbook.bean.GuestbookDTO;

public interface GuestbookService {
	public int guestbookWrite(GuestbookDTO guestbookDTO);
	public List<GuestbookDTO> guestbookList(int startNum, int endNum);
	public int getTotalA();
}
