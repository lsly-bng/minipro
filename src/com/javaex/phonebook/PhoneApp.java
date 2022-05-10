package com.javaex.phonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {

		// Scanner
		Scanner sc = new Scanner(System.in);

		// Input
		InputStream in = new FileInputStream(
				"C:\\javaStudy\\workspace\\minipro\\src\\com\\javaex\\phonebook\\PhoneDB.txt");
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		// Create List
		List<Person> pList = new ArrayList<Person>();

		// Read File
		while (true) {
			String data = br.readLine();

			if (data == null) {
				break;
			}
			String[] info = data.split(",");
			pList.add(new Person(info[0], info[1], info[2]));
		}

		// 시작화면
		System.out.println("*********************************");
		System.out.println("*	전화번호 관리 프로그램		*");
		System.out.println("*********************************");
		System.out.println();

		// Create Option
		while (true) {
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.println("---------------------------------");
			System.out.print(">메뉴번호: ");

			int option = sc.nextInt();

			// 1. 리스트
			if (option == 1) {
				System.out.println("<1.리스트>");

				for (int i = 0; i < pList.size(); i++) {
					System.out.print(i + 1);
					pList.get(i).showInfo();
				}
				System.out.println();

				// 2. 등록
			} else if (option == 2) {
				System.out.println("<2.등록>");

				Person p = new Person();

				System.out.print(">이름: ");
				p.setName(sc.next());
				System.out.print(">휴대전화: ");
				p.setHp(sc.next());
				System.out.print(">회사전화: ");
				p.setCompany(sc.next());

				pList.add(p);

				System.out.println("[등록되었습니다.]");
				System.out.println();

				// 3. 삭제
			} else if (option == 3) {
				System.out.println("<3.삭제>");
				System.out.print(">번호: ");

				pList.remove((sc.nextInt() - 1));

				System.out.println("[삭제되었습니다.]");

				// 4. 검색
			} else if (option == 4) {
				System.out.println("<4.검색>");
				System.out.print(">이름: ");
				String search = sc.next();

				for (int i = 0; i < pList.size(); i++) {

					if (pList.get(i).getName().contains(search)) {
						System.out.print(i + 1);
						pList.get(i).showInfo();
					}
				}
				System.out.println();

				// 5. 프로그램 종료
			} else if (option == 5) {
				System.out.println();
				System.out.println("*********************************");
				System.out.println("*	   감사합니다	  	*");
				System.out.println("*********************************");
				break;
			} else if (option > 1 || option < 5) {
				System.out.println("[다시 입력해 주세요.]");
				System.out.println();
			}
		}

		// Output
		OutputStream out = new FileOutputStream(
				"C:\\javaStudy\\workspace\\minipro\\src\\com\\javaex\\phonebook\\PhoneDB.txt");
		OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		// Output method
		for (int i = 0; i < pList.size(); i++) {
			String output = pList.get(i).getName() + "," + pList.get(i).getHp() + "," + pList.get(i).getCompany();

			bw.write(output);
			bw.newLine();
			bw.flush();
		}
		sc.close();
		br.close();
		bw.close();
	}
}
