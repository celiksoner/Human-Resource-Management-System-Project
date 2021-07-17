package com.hrms.hrmsproject.core.utilities.business;

import com.hrms.hrmsproject.core.utilities.results.Result;

public class BusinessRules {

	public static Result run(Result... logics) {
		for (Result logic : logics) {
			if (logic != null && !logic.isSuccess()) {
				return logic;
			}
		}
		return null;
	}
}
