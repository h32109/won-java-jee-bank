package com.bank.daos;

import com.bank.domains.CustomerBean;
import com.bank.domains.EmployeeBean;

public interface MemberDAO {
	public void insertCustomer(CustomerBean param);
	public void insertEmployee(EmployeeBean param);
	public CustomerBean login(CustomerBean param);

}
