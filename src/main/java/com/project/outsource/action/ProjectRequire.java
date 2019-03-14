package com.project.outsource.action;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.project.outsource.commons.ResData;
import com.project.outsource.commons.STATUS;
import com.project.outsource.utils.DINGDINGROBOT;

/**
* 名称: ProjectRequire.java
* 类说明:
*
*/
@Controller
@RequestMapping("ProjectRequire")
public class ProjectRequire {
	private static final Logger logger = LoggerFactory.getLogger(ProjectRequire.class);
	private static final Gson GSON = new Gson();
	/**
	 * 
	 * @Title: submitRequire
	 * @Description: 提交需求
	 * @param userName
	 * @param phone
	 * @param context
	 * @return string
	 *
	 */
	@RequestMapping("submitRequire")
	@ResponseBody
	public String submitRequire(String userName, String phone, String content) {
		logger.debug(userName);
		logger.debug(phone);
		logger.debug(content);
		System.out.println(1/0);
		if (StringUtils.isBlank(userName)) {
			return GSON.toJson(new ResData(STATUS.PARAM_ERROR));
		}
		if (StringUtils.isBlank(phone)) {
			return GSON.toJson(new ResData(STATUS.PARAM_ERROR));
		}
		if (!phone.matches("1\\d{10}")) {
			return GSON.toJson(new ResData(STATUS.PARAM_ERROR));
		}
		if (StringUtils.isBlank(content)) {
			return GSON.toJson(new ResData(STATUS.PARAM_ERROR));
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("用户名:" + userName + ", ");
		stringBuilder.append("电话:" + phone + ", ");
		stringBuilder.append("需求内容:" + content);
		try {
			DINGDINGROBOT.dingdingNotify(stringBuilder.toString());
		} catch (Exception e) {
			// TODO: handle exception
			return GSON.toJson(new ResData(STATUS.ERROR));
		}
		ResData resData = new ResData(STATUS.SUCCESS);
		return GSON.toJson(resData);
	}
}
