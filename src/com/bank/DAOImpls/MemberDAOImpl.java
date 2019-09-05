package com.bank.DAOImpls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.bank.daos.MemberDAO;
import com.bank.domains.CustomerBean;
import com.bank.domains.EmployeeBean;
import com.bank.pool.Constants;

public class MemberDAOImpl implements MemberDAO{	
	File file = new File(Constants.FILE_PATH+"customer0905.txt");
	List<String> list = new ArrayList<>();
	@Override
	public void insertCustomer(CustomerBean param) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(param.toString());
			writer.newLine();
			writer.flush();
			writer.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertEmployee(EmployeeBean param) {
		
	}

	@Override
	public CustomerBean login(CustomerBean param) {
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String user = reader.readLine();
			reader.close();
			String[] val = user.split(",");
			param.setId(val[0]);
			param.setPw(val[1]);
			param.setName(val[2]);
			param.setSsn(val[3]);
			param.setCredit(val[4]);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return param;
	}

}
