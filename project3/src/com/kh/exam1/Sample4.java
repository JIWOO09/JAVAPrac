package com.kh.exam1;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.db.conn.OracleCloudConnect;

class Salary {
	private int salary;
	private int salaryYear;
	
	public Salary(int salary, int salaryYear) {
		this.salary = salary;
		this.salaryYear = salaryYear;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getSalaryYear() {
		return salaryYear;
	}

	public void setSalaryYear(int salaryYear) {
		this.salaryYear = salaryYear;
	}

	@Override
	public String toString() {
		return "Salary [salary=" + salary + ", salaryYear=" + salaryYear + "]";
	}
	
}

public class Sample4 {

	public static void main(String[] args) {
		OracleCloudConnect occ;
		try {
			occ = new OracleCloudConnect();
			occ.connection();
			
			// EMPLOYEES 테이블을 사용하여 부서별 인원수를 구하여 본다.
			String query = ""
					+ "SELECT B.DEPARTMENT_NAME"
					+ "     , COUNT(A.EMPLOYEE_ID)"
					+ "  FROM EMPLOYEES A JOIN DEPARTMENTS B"
					+ "    ON A.DEPARTMENT_ID = B.DEPARTMENT_ID"
					+ " WHERE A.DEPARTMENT_ID IS NOT NULL"
					+ " GROUP BY B.DEPARTMENT_NAME"
					+ " ORDER BY B.DEPARTMENT_NAME";
			ResultSet res = occ.sendQuery(query);
			
			// Map 컬렉션에 조회 데이터를 담아본다.(키:부서명, 값:인원수)
			Map<String, Integer> m = new HashMap<String, Integer>();
			while(res.next()) {
				m.put(res.getString(1), res.getInt(2));
			}
			System.out.println(m);
			
			// EMPLOYEES 테이블을 사용하여 급여기 8000 이상인 사원을 조회 후
			// Map 컬렉션에 조회 데이터를 담아본다. (키:사원명, 값:Salary(급여액, 연봉))
			query = ""
					+ "SELECT FIRST_NAME || ' ' || LAST_NAME"
					+ "     , SALARY"
					+ "     , SALARY * 12"
					+ "  FROM EMPLOYEES A"
					+ " WHERE A.SALARY >= 8000";
			res = occ.sendQuery(query);
			
			Map<String, Salary> m2 = new HashMap<String, Salary>();
			while(res.next()) {
				m2.put(res.getString(1),
						new Salary(res.getInt(2), res.getInt(3)));
			}
			System.out.println(m2);
			
			res.close();
			occ.close();
			occ.connectionClose();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}