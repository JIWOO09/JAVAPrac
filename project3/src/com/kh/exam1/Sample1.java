package com.kh.exam1;

import java.util.*;

public class Sample1 {

	public static void main(String[] args) {
		/* Set 컬렉션
		 * 	- 순서가 없는 컬랙션
		 * 	- 중복 데이터 저장을 허용하지 않음
		 */
		Set<Integer> s = new HashSet<Integer>();
		
		// 추가
		s.add(10);	s.add(20);	s.add(30);
		System.out.println(s);
		
		// 중복안됨
		s.add(10);	s.add(20);	s.add(30);
		System.out.println(s);
		
		for(int i: s) {
			System.out.print(i + "\t");
		}
		System.out.println();
		
		// 삭제
		s.remove(new Integer(10));
		System.out.println(s);
		
		// 빈 컬렉션 유무 확인
		boolean resBool = s.isEmpty();
		System.out.println("빈 컬렉션? -> " + resBool);
		
		// 컬렉션에 저장된 데이터 수
		int resInt = s.size();
		System.out.println("저장된 데이터 수? -> " + resInt);
		
		// 저장된 데이터 확인
		resBool = s.contains(new Integer(20));
		System.out.println("정수 20이 존재? -> " + resBool);
		
		resBool = s.contains(new Integer(10));
		System.out.println("정수 10이 존재? -> " + resBool);
		
		// Set 컬렉션을 배열로 변환
		Integer[] iArr = s.toArray(new Integer[s.size()]);
		iArr[0] += 2;
		System.out.println(iArr[0]);
		
		// Set 컬렉션을 List 컬렉션으로 변환
		List<Integer> lst = new ArrayList<Integer>(s);
		lst.set(0, lst.get(0) + 5);
		System.out.println(lst.get(0));
		
		// 배열을 Set 컬렉션으로 변환
		s = new HashSet<Integer>(Arrays.asList(iArr));
		System.out.println(s);
		
		// List 컬렉션을 Set 컬렉션으로 변환
		s = new HashSet<Integer>(lst);
		System.out.println(s);
		
		// 데이터 저장 순서의 유지가 가능하게 한다.
		Set<Integer> linkedSet = new LinkedHashSet<Integer>(s);
		linkedSet.add(60);	linkedSet.add(50);	linkedSet.add(40);
		System.out.println(linkedSet);
		
		// 데이터 저장시 정렬이 이루어 지도록 한다.
		Set<Integer> treeSet = new TreeSet<Integer>(s);
		treeSet.add(60);	treeSet.add(50);	treeSet.add(40);
		System.out.println(treeSet);
	}

}

