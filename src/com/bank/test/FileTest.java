package com.bank.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FileTest {
	public static final String FILE_PATH = String.format("C:%sUsers%suser%seclipse-jee%sjee-bitcamp%sWebContent%sresources%stxt%s",
			File.separator,File.separator,File.separator,File.separator,File.separator,File.separator,File.separator,File.separator);
	
	public static void main(String[] args) {
		
		System.out.println(""+FILE_PATH);
		
		try {
			File file = new File(FILE_PATH+"list.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
			BufferedReader reader = new BufferedReader(new FileReader(file));
			List<String> list = new ArrayList<>();
			
			while(true) {
				switch (JOptionPane.showInputDialog("0.����   1.����  2. �б�")) {
				case "0": 
					JOptionPane.showMessageDialog(null, "����");
					return;
				case "1":
					String msg = JOptionPane.showInputDialog("�޼����� �Է��� �ּ���. ������ ���̿� , �Է��� �ּ���.");
					writer.write(msg);
					writer.newLine();
					writer.flush();
					break;
				case "2":
					while ((msg = reader.readLine()) != null) {
						list.add(msg+"/");
					}
					JOptionPane.showMessageDialog(null, list);
					reader.close();
					break;
				default:
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}


	}

}
