package common.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class defaultAction  extends ActionSupport{
	@Override
	public String execute() throws Exception {
		return Action.ERROR;
	}
}
