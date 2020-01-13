package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ContactPro {

	public static void main(String[] args) {

		HashMap<String, String> PrivateInfo = new HashMap<String, String>();
		HashMap<String, HashMap> TotalInfo = new HashMap<String, HashMap>();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n =============== \n"
						+"다음 메뉴 중 하나를 선택하세요"
						+ "\n =============== \n");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 목록 보기");
			System.out.println("3. 회원 목록 수정하기");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 종료");
			
			System.out.print(">>  ");
			String text = scanner.next();
			
			if(text.equals("1")) {
				
				PrivateInfo = new HashMap<String, String>();
				System.out.print("이름: ");
				String name = scanner.next();
				PrivateInfo.put("이름", name);
				
				System.out.print("전화번호(ex:01012345678):  ");
				String phonenm = scanner.next();
				PrivateInfo.put("전화번호", phonenm);
				
				System.out.print("구분(ex: 가족, 친구, 회사, 기타): ");
				String classification = scanner.next();
				PrivateInfo.put("구분", classification);
				
				TotalInfo.put(phonenm, PrivateInfo);
				
			}else if(text.equals("2")) {
				int n = TotalInfo.size();
				Set<String> keys = TotalInfo.keySet();
				Iterator<String> it = keys.iterator();
				System.out.println("총"
								+ n
								+ "명의 회원이 저장되어 있습니다.");
				while(it.hasNext()) {
					String key = it.next();
					System.out.println("회원정보 : "+"이름 = "+TotalInfo.get(key).get("이름") 
									+ " 전번 = "+TotalInfo.get(key).get("전화번호") 
									+ " 구별 = "+TotalInfo.get(key).get("구분"));
				}
				
			}else if(text.equals("3")) {
				System.out.println("수정할 회원의 이름을 적으세요.");
				
				String rename = scanner.next();
				Iterator<String> it = TotalInfo.keySet().iterator();
				ArrayList<String> contactnm = new ArrayList<String>();
				
				while(it.hasNext()) {
					String key = it.next();
					if(rename.equals(TotalInfo.get(key).get("이름"))) {
						contactnm.add(key);
						int n2 = contactnm.size();
						

					}
					
				}
				System.out.println("총" + contactnm.size() + "회원이 검색되었습니다.");
//				일치하는 회원이 없다면, ArrayList에 요소가 0개다.
				if(contactnm.isEmpty()) {
					System.out.println("일치하는 회원이 없습니다.");
				}else {
					
					System.out.println("아래 목록 중 수정할 회원의 번호를 입력하세요.");
					for(int i =0; i<contactnm.size(); i++) {
						String key = contactnm.get(i);
						
						System.out.println(i+1 +"이름: "+TotalInfo.get(key).get("이름") 
						+"전화번호: "+TotalInfo.get(key).get("전화번호")
						+"구분: "+TotalInfo.get(key).get("구분"));

					}

					int rename1 = scanner.nextInt();
					
					for(int i =1; i< contactnm.size(); i++) {
						if(rename1 == i) {
							String ss = contactnm.get(i-1);
							contactnm.remove(i-1);
							TotalInfo.remove(ss);
							
							System.out.print("이름: ");
							String name = scanner.next();
							PrivateInfo.put("이름", name);
							
							System.out.println("전화번호: ");
							String phonenum = scanner.next();
							PrivateInfo.put("전화번호", phonenum);
							
							System.out.println("구분:  ");
							String classify = scanner.next();
							PrivateInfo.put("구분", classify);
							
							TotalInfo.put(phonenum,PrivateInfo);
						}
					}
				}
			}
			
					else if(text.equals("4")) {
				System.out.println("삭제할 회원의 이름을 입력하세요.");
				System.out.print("이름: ");
				String delname = scanner.next();
				Iterator<String> it1 = TotalInfo.keySet().iterator();
				ArrayList<String> contactnm1 = new ArrayList<String>();
				
//				for(String key:TotalInfo.keySet()) {
//					System.out.println(key1);
//					if(delname.equals(TotalInfo.get(key).get("이름"))) {
//						contactnm1.add(key);
//						int n2 = contactnm1.size();
//						System.out.println(n2+"이름: "+TotalInfo.get(key).get("이름") 
//								+"전화번호: "+TotalInfo.get(key).get("전화번호")
//								+"구분: "+TotalInfo.get(key).get("구분"));
//							
//					}
//				}
				
				while(it1.hasNext()) {
					String key = it1.next();
					
					if(delname.equals(TotalInfo.get(key).get("이름"))) {
						contactnm1.add(key);
						int n2 = contactnm1.size();

							
					}
				}
				
				System.out.println("총" + contactnm1.size() + "명의 회원이 검색되었습니다.");
				
				if(contactnm1.isEmpty()) {
					System.out.println("일치하는 회원이 없습니다.");
				}else {
					System.out.println("아래 목록 중 삭제할 회원의 번호를 입력하세요.");
					for(int i = 0; i< contactnm1.size(); i++) {
						String key = contactnm1.get(i);
						System.out.println(i+1+"이름: "+TotalInfo.get(key).get("이름") 
						+"전화번호: "+TotalInfo.get(key).get("전화번호")
						+"구분: "+TotalInfo.get(key).get("구분"));
						
					}
				}
				
				int delnm = scanner.nextInt();
				for(int i=1; i<contactnm1.size(); i++) {
					if(delnm == i) {
						String s = contactnm1.get(i-1);
						contactnm1.remove(i-1);
						TotalInfo.remove(s);
						System.out.println("삭제되었습니다.");
						
					}else if(delnm != i) {
						System.out.println("삭제못해");
					}
				}
				
			}else if(text.equals("5")) {
				
				System.out.println("종료되었습니다.");
				break;
			}else {
				System.out.println("해당하는 번호가 없습니다.");
				break;
			}
			
			
		}
		
	}

}


