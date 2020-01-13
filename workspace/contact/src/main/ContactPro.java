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
						+"���� �޴� �� �ϳ��� �����ϼ���"
						+ "\n =============== \n");
			System.out.println("1. ȸ�� �߰�");
			System.out.println("2. ȸ�� ��� ����");
			System.out.println("3. ȸ�� ��� �����ϱ�");
			System.out.println("4. ȸ�� ����");
			System.out.println("5. ����");
			
			System.out.print(">>  ");
			String text = scanner.next();
			
			if(text.equals("1")) {
				
				PrivateInfo = new HashMap<String, String>();
				System.out.print("�̸�: ");
				String name = scanner.next();
				PrivateInfo.put("�̸�", name);
				
				System.out.print("��ȭ��ȣ(ex:01012345678):  ");
				String phonenm = scanner.next();
				PrivateInfo.put("��ȭ��ȣ", phonenm);
				
				System.out.print("����(ex: ����, ģ��, ȸ��, ��Ÿ): ");
				String classification = scanner.next();
				PrivateInfo.put("����", classification);
				
				TotalInfo.put(phonenm, PrivateInfo);
				
			}else if(text.equals("2")) {
				int n = TotalInfo.size();
				Set<String> keys = TotalInfo.keySet();
				Iterator<String> it = keys.iterator();
				System.out.println("��"
								+ n
								+ "���� ȸ���� ����Ǿ� �ֽ��ϴ�.");
				while(it.hasNext()) {
					String key = it.next();
					System.out.println("ȸ������ : "+"�̸� = "+TotalInfo.get(key).get("�̸�") 
									+ " ���� = "+TotalInfo.get(key).get("��ȭ��ȣ") 
									+ " ���� = "+TotalInfo.get(key).get("����"));
				}
				
			}else if(text.equals("3")) {
				System.out.println("������ ȸ���� �̸��� ��������.");
				
				String rename = scanner.next();
				Iterator<String> it = TotalInfo.keySet().iterator();
				ArrayList<String> contactnm = new ArrayList<String>();
				
				while(it.hasNext()) {
					String key = it.next();
					if(rename.equals(TotalInfo.get(key).get("�̸�"))) {
						contactnm.add(key);
						int n2 = contactnm.size();
						

					}
					
				}
				System.out.println("��" + contactnm.size() + "ȸ���� �˻��Ǿ����ϴ�.");
//				��ġ�ϴ� ȸ���� ���ٸ�, ArrayList�� ��Ұ� 0����.
				if(contactnm.isEmpty()) {
					System.out.println("��ġ�ϴ� ȸ���� �����ϴ�.");
				}else {
					
					System.out.println("�Ʒ� ��� �� ������ ȸ���� ��ȣ�� �Է��ϼ���.");
					for(int i =0; i<contactnm.size(); i++) {
						String key = contactnm.get(i);
						
						System.out.println(i+1 +"�̸�: "+TotalInfo.get(key).get("�̸�") 
						+"��ȭ��ȣ: "+TotalInfo.get(key).get("��ȭ��ȣ")
						+"����: "+TotalInfo.get(key).get("����"));

					}

					int rename1 = scanner.nextInt();
					
					for(int i =1; i< contactnm.size(); i++) {
						if(rename1 == i) {
							String ss = contactnm.get(i-1);
							contactnm.remove(i-1);
							TotalInfo.remove(ss);
							
							System.out.print("�̸�: ");
							String name = scanner.next();
							PrivateInfo.put("�̸�", name);
							
							System.out.println("��ȭ��ȣ: ");
							String phonenum = scanner.next();
							PrivateInfo.put("��ȭ��ȣ", phonenum);
							
							System.out.println("����:  ");
							String classify = scanner.next();
							PrivateInfo.put("����", classify);
							
							TotalInfo.put(phonenum,PrivateInfo);
						}
					}
				}
			}
			
					else if(text.equals("4")) {
				System.out.println("������ ȸ���� �̸��� �Է��ϼ���.");
				System.out.print("�̸�: ");
				String delname = scanner.next();
				Iterator<String> it1 = TotalInfo.keySet().iterator();
				ArrayList<String> contactnm1 = new ArrayList<String>();
				
//				for(String key:TotalInfo.keySet()) {
//					System.out.println(key1);
//					if(delname.equals(TotalInfo.get(key).get("�̸�"))) {
//						contactnm1.add(key);
//						int n2 = contactnm1.size();
//						System.out.println(n2+"�̸�: "+TotalInfo.get(key).get("�̸�") 
//								+"��ȭ��ȣ: "+TotalInfo.get(key).get("��ȭ��ȣ")
//								+"����: "+TotalInfo.get(key).get("����"));
//							
//					}
//				}
				
				while(it1.hasNext()) {
					String key = it1.next();
					
					if(delname.equals(TotalInfo.get(key).get("�̸�"))) {
						contactnm1.add(key);
						int n2 = contactnm1.size();

							
					}
				}
				
				System.out.println("��" + contactnm1.size() + "���� ȸ���� �˻��Ǿ����ϴ�.");
				
				if(contactnm1.isEmpty()) {
					System.out.println("��ġ�ϴ� ȸ���� �����ϴ�.");
				}else {
					System.out.println("�Ʒ� ��� �� ������ ȸ���� ��ȣ�� �Է��ϼ���.");
					for(int i = 0; i< contactnm1.size(); i++) {
						String key = contactnm1.get(i);
						System.out.println(i+1+"�̸�: "+TotalInfo.get(key).get("�̸�") 
						+"��ȭ��ȣ: "+TotalInfo.get(key).get("��ȭ��ȣ")
						+"����: "+TotalInfo.get(key).get("����"));
						
					}
				}
				
				int delnm = scanner.nextInt();
				for(int i=1; i<contactnm1.size(); i++) {
					if(delnm == i) {
						String s = contactnm1.get(i-1);
						contactnm1.remove(i-1);
						TotalInfo.remove(s);
						System.out.println("�����Ǿ����ϴ�.");
						
					}else if(delnm != i) {
						System.out.println("��������");
					}
				}
				
			}else if(text.equals("5")) {
				
				System.out.println("����Ǿ����ϴ�.");
				break;
			}else {
				System.out.println("�ش��ϴ� ��ȣ�� �����ϴ�.");
				break;
			}
			
			
		}
		
	}

}


