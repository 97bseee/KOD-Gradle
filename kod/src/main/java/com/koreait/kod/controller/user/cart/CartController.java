package com.koreait.kod.controller.user.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.koreait.kod.biz.cart.CartDTO;
import com.koreait.kod.biz.cart.CartService;
import com.koreait.kod.biz.member.MemberDTO;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	ObjectMapper objectMapper;
	
	@PostMapping("/asyncUpdateProductCntToCart")
	public @ResponseBody String UpdateProductCntToCart(CartDTO cartDTO, Model model, HttpSession session) throws JsonProcessingException {
			
			cartDTO.setMemberID((String)session.getAttribute("memberID"));
			cartDTO.setSearchCondition("asyncUpdateProductCntToCart");
			model.addAttribute("UpdatedProductCnt", cartService.update(cartDTO));
			
			boolean flag = cartService.update(cartDTO);
			if(!flag) {
				System.out.println("[로그:정현진] 장바구니 상품추가 실패 ");
			}
			System.out.println("[로그:정현진] 장바구니 상품추가 성공 ");
			
			return objectMapper.writeValueAsString(cartService.selectOne(cartDTO).getCartProductCnt());
	}
	
	@PostMapping("/deleteAllProductsToCart")
	public String deleteAllProductToCart(CartDTO cartDTO,HttpSession session) {
		
		cartDTO.setMemberID((String)session.getAttribute("memberID"));
		cartDTO.setSearchCondition("deleteAllProductToCart");
		cartService.delete(cartDTO);
		
		return "user/cart";
	}
	
	@PostMapping("/deleteSelectProductsToCart")
	public String deleteSelectProductsToCart(CartDTO cartDTO,HttpSession session) {
		
		cartDTO.setMemberID((String)session.getAttribute("memberID"));
		cartDTO.setSearchCondition("deleteSelectProductsToCart");
		cartService.delete(cartDTO);
		
		return "user/cart";
	}
	
}
