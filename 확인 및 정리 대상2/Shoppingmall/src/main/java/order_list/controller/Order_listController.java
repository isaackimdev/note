package order_list.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import item.bean.ItemDTO;
import item.controller.ItemServiceImpl;

@Controller
public class Order_listController {

	@Autowired
	private Order_listServiceImpl order_listService;
	@Autowired
	private ItemServiceImpl item_service;
	// 카트...
	@Transactional	// 이상현상을 막아 줌 : sql두개 이상 사용할 경우
	@RequestMapping(value="/order_list/cartList")
	public ModelAndView cartList(HttpServletRequest request, ModelAndView modelAndView) {
		System.out.println("cartList");
		
		// 장바구니 담을 정보 가져오기
		String item_code = request.getParameter("item_code");
		String item_color = request.getParameter("item_color");
		String item_size = request.getParameter("item_size");
		int item_qty = Integer.parseInt(request.getParameter("item_qty"));
		int item_index = order_listService.getItemByCodeSizeColor(item_code, item_color, item_size);
		System.out.println(item_index);
		ItemDTO itemDTO = item_service.getItemByIndex(item_index);
		System.out.println(itemDTO);
		itemDTO.setItem_quantity(item_qty);
		
		HttpSession httpSession = request.getSession(false);
		List<ItemDTO> cart_list = null;
		if(httpSession.getAttribute("cart_list") == null) {
			cart_list = new ArrayList<>();
		} else {
			cart_list = (List<ItemDTO>) httpSession.getAttribute("cart_list");
		}
		cart_list.add(itemDTO);
		if(cart_list != null) {
			for(ItemDTO itemDTO2 : cart_list) {
				System.out.println(itemDTO2.toString());
			}
		}
				
		httpSession.setAttribute("cart_list", cart_list);
		modelAndView.setViewName("redirect:/main/index.jsp?req=cartList");
		return modelAndView;
	}
	// 메인 투 카트리스트
	@RequestMapping(value="/order_list/mainToCartList")
	public ModelAndView mainToCartList (HttpServletRequest request, ModelAndView modelAndView) {
		modelAndView.setViewName("redirect:/main/index.jsp?req=cartList");
		return modelAndView;
	}
	// 주문 리스트 
	@RequestMapping(value="/order_list/order_list")
	public ModelAndView orderList(HttpServletRequest request, ModelAndView modelAndView) {
		
		modelAndView.setViewName("/main/index.jsp?req=order_list");
		return modelAndView;
	}
}
