package kosta.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kosta.domain.EmpDTO;

public interface EmpMapper {
	
	/**
	 * 전체검색
	 * */
	@Select("select empno, ename, job, sal, hiredate from emp")
	@Results(value = {
		@Result(column = "empno", property = "empno"),
		@Result(column = "ename", property = "ename")
	})
	List<EmpDTO> selectAll();
	
	/**
	 * 사원번호 검색
	 * */
	@Select("select empno, ename, job, sal, hiredate from emp where empno=#{empno}")
	EmpDTO selectByEmpno(int empno);
	
	/**
	 * 등록
	 * */
	@Insert("insert into emp(empno, ename, job, sal, hiredate) values(#{empno},#{ename},#{job},#{sal},sysdate)")
	int insert(EmpDTO empDTO);
	
	/**
	 * 삭제
	 * */
	@Delete("delete from emp where empno=#{_parameter}")
	int delete(int empno);
	
	/**
	 * 수정
	 * */
	@Update("update emp set job=#{job}, ename=#{ename} where empno=#{empno}")
	int update(EmpDTO empDTO);
	
	/**
	 *  동적쿼리 검색하기
	 *  
	 *  <select id="ifTest" parameterType="empDTO" resultType="empDTO">
	   	<include refid="empSelectSql"/>
	   	<trim prefix="where" prefixOverrides="and | or">
	   		<if test="ename!=null">
		   		ename=#{ename}
		   	</if>
		   	<if test="job!=null">
		   		and job=#{job}
		   	</if>
	   	</trim>
	   </select>
	 * */
	@Select("<script>select empno, ename, job, sal, hiredate from emp "
			+ "	<trim prefix=\"where\" prefixOverrides=\"and | or\">\r\n" + 
			"	   		<if test=\"ename!=null\">\r\n" + 
			"		   		ename=#{ename}\r\n" + 
			"		   	</if>\r\n" + 
			"		   	<if test=\"job!=null\">\r\n" + 
			"		   		and job=#{job}\r\n" + 
			"		   	</if>\r\n" + 
			"	</trim></script>")
	List<EmpDTO> ifTest(EmpDTO empDTO);
}
