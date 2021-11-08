package com.kh.exam1;

import java.util.*;
import java.util.Map.Entry;

public class Sample3 {

	public static void main(String[] args) {
		/*
		 * Map
		 * 	- 키와 값의 쌍인 Entry 객체로 관리
		 * 	- 동일한 키를 가지는 Entry 는 저장되지 않음
		 * 	- 동일한 값을 가지는 Entry 는 저장됨.
		 */
		Map<String, String> m = new HashMap<String, String>();
		
		// 추가
		m.put("키1", "값1");	m.put("키2", "값2");	m.put("키3", "값3");
		System.out.println(m);
		
		// 중복값
		m.put("키4", "값2");
		System.out.println(m);
		
		// 수정
		m.put("키1", "값수정1");
		System.out.println(m);
		
		m.replace("키3", "값수정3");
		System.out.println(m);
		
		// 새로운 값이 추가된 경우 null
		String resStr = m.put("키5", "값5");
		System.out.println(resStr);
		
		// 기존 키의 값을 수정한 경우 이전 값을 반환
		resStr = m.put("키5", "값수정5");
		System.out.println(resStr);
		
		// 값의 수정이 완료되면 이전 값 반환, 값의 수정이 안되면 null
		resStr = m.replace("키5", "값수정5");
		System.out.println(resStr + " 값에 대한 수정이 완료되었습니다.");
		System.out.println(m);
		
		// 키의 존재 확인
		boolean resBool = m.containsKey("키1");
		System.out.println("키1 이 있습니까? -> " + resBool);
		
		// 값의 존재 확인
		resBool = m.containsValue("값1");
		System.out.println("값1 이 있습니까? -> " + resBool);
		
		// 값 추출
		resStr = m.get("키1");
		System.out.println("키1 의 값 -> " + resStr);
		
		// 빈 컬렉션 유무 확인
		resBool = m.isEmpty();
		System.out.println("빈 컬렉션? -> " + resBool);
		
		// 컬렉션에 저장된 데이터의 수
		int resInt = m.size();
		System.out.println("데이터의 수 -> " + resInt);
		
		// 모든 키를 추출 -> Set 컬렉션에 담긴다.
		Set<String> keys = m.keySet();
		System.out.println(keys);
		
		// 모든 값을 추출 -> Collection 객체로 반환 -> new ArrayList<>(Collection)
		List<String> values = new ArrayList<String>(m.values());
		System.out.println(values);
		
		// 키/값의 쌍(Entry 객체)을 추출 -> Set 컬렉션에 담긴다.
		Set<Entry<String, String>> entrys = m.entrySet();
		
		for(Entry<String, String> e: entrys) {
			System.out.println("키 -> " + e.getKey());
			System.out.println("값 -> " + e.getValue());
		}
		
		// 삭제
		resStr = m.remove("키1");
		System.out.println(resStr + " 이 삭제되었습니다.");
		
		resStr = m.remove("키1");
		System.out.println("이미 삭제된 데이터를 또 삭제 시도하는 경우 -> " + resStr);
		
		// 멀티쓰레드에 대한 쓰레드 safe 기능 제공
		Map<String, String> hashtable = new Hashtable<String, String>(m);
		
		// 정렬과 검색 기능을 강화시킨 기능 제공
		Map<String, String> treeMap = new TreeMap<String, String>(m);
		
	}

}