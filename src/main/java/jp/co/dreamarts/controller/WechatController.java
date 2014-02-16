package jp.co.dreamarts.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WechatController {

	@RequestMapping("/token.do")
	public String testToken(HttpServletRequest request,
			HttpServletResponse response) {

		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");

		String content = request.getParameter("Content");
		String fromUserName = request.getParameter("FromUserName");

		String username;
		if (request.getAttribute("FromUserName") != null) {
			username = (String) request.getAttribute("FromUserName");
			System.out.println("username is " + username);
		}

		request.setAttribute("echostr", echostr);
		System.out.println("signature is " + signature);
		System.out.println("timestamp is " + timestamp);

		System.out.println("echostr is " + echostr);
		System.out.println("content is " + content);
		System.out.println("fromUserName is " + fromUserName);

		return "index";
	}
}
