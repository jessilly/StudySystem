package com.hbnu.study.dao;

import com.hbnu.study.bean.Subject;
import com.hbnu.study.dao.common.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao {

    /**
	 * 搜索所有院系信息
	 * @param subject
	 * @return
	 */
	public List<Subject> getSubject()
	{
            //controller--service--dao通过三层调用写在此数据库操作类
                //创建数据库连接对象
		Connection conn = DBUtils.getConn();
		ResultSet rs=null;
                //集合类来保存student这种类型
		List<Subject> sub=new ArrayList<Subject>();
		String sql = "select * from SUBJECT ";
		try {
                       
			PreparedStatement pStatement = conn.prepareStatement(sql);//预处理			
			rs = pStatement.executeQuery();	//执行	
			while(rs.next())//将查询的结果放在集合类中，只要有下一条数据就不断的执行
			{
				Subject s=new Subject();//创建院系对象
				s.setId(rs.getInt(1));
				s.setSubjectNo(rs.getString(2));
                                s.setSubjectName(rs.getString(3));
				sub.add(s);//每创建一个就放在对象中
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeConn(conn);//数据库关闭
		}
		return sub ;
	}

    public int saveSubject(Subject sub) {
        Connection conn = DBUtils.getConn();
		int result = 0;
		String sql = "insert into SUBJECT(SUBJECT_NO,SUBJECT_NAME) VALUES(?,?)";
		try {
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, sub.getSubjectNo());
			pStatement.setString(2, sub.getSubjectName());			
			result = pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeConn(conn);
		}

		return result ;
    }

    public Subject getStuById(int id) {
        Connection conn = DBUtils.getConn();
		ResultSet rs=null;
		Subject s=null;
		String sql = "select * from SUBJECT where ID=?";
		try {
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, id);
			rs = pStatement.executeQuery();
			while(rs.next())
			{
				s=new Subject();
				s.setId(rs.getInt(1));
				s.setSubjectNo(rs.getString(2));
				s.setSubjectName(rs.getString(3));			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeConn(conn);
		}

		return s ;
    }
    
    public List<Subject> findSubject(Subject sub) {
		StringBuffer sql=new StringBuffer("select * from SUBJECT ");
		boolean ifand=false;
		if(!("".equals(sub.getSubjectName())))
		{
			sql.append("where ");
		}
		
		if(!("".equals(sub.getSubjectName())))
		{
			ifand=true;
			sql.append("SUBJECT_NAME ='"+sub.getSubjectName()+"'");
		}		
		Connection conn = DBUtils.getConn();
		ResultSet rs=null;
		List<Subject> subs=new ArrayList<Subject>();		
		try {
			PreparedStatement pStatement = conn.prepareStatement(sql.toString());					
			rs = pStatement.executeQuery();		
			while(rs.next())
			{
				Subject s=new Subject();
				s.setId(rs.getInt(1));
				s.setSubjectNo(rs.getString(2));				
				s.setSubjectName(rs.getString(3));				
				subs.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeConn(conn);
		}
		return subs ;
	}

    public int updateSub(Subject sub) {
        Connection conn = DBUtils.getConn();
		int result = 0;
		String sql = "update SUBJECT set SUBJECT_NO=?,SUBJECT_NAME=? where id=?";
		try {
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, sub.getSubjectNo());		
			pStatement.setString(2, sub.getSubjectName());			
			pStatement.setInt(3, sub.getId());
			result = pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeConn(conn);
		}

		return result ;
    }

    public int deleteSub(Subject sub) {
        Connection conn = DBUtils.getConn();
		int result = 0;
		String sql = "delete from SUBJECT where id=?";
		try {
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, sub.getId());
			result = pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeConn(conn);
		}

		return result ;
    }

    public List<Subject> getSubjectForAdd() {
//       Connection conn = DBUtils.getConn();
//		int result = 0;
//		String sql = "SELECT * FROM SUBJECT";
        List<Subject> subs=new ArrayList<Subject>();
//		PreparedStatement pStatement = conn.prepareStatement(sql);
//		ResultSet rs = pStatement.executeQuery();
//		while(rs.next())
//		{
//            //duplicateCode_GetFaculty(rs,facultyList);
//		}
               return subs;
  }
    
}
