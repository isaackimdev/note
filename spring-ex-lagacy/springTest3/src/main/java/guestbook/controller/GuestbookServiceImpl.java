package guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;
@Service
public class GuestbookServiceImpl implements GuestbookService {
	@Autowired
	private GuestbookDAO guestbookDAO; 
	
	@Override
	public int guestbookWrite(GuestbookDTO guestbookDTO) {
		return guestbookDAO.guestbookWrite(guestbookDTO);
	}

	@Override
	public List<GuestbookDTO> guestbookList(int startNum, int endNum) {
		return guestbookDAO.guestbookList(startNum, endNum);
	}

	@Override
	public int getTotalA() {
		return guestbookDAO.getTotalA();
	}

}
