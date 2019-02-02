package cn.aceo.smis.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.aceo.smis.dao.IStudentDAO;
import cn.aceo.smis.domain.Student;
import cn.aceo.smis.util.JdbcUtil;

public class StudentDAOImpl implements IStudentDAO{

	@Override
	public void save(Student stu) {
		// TODO 保存信息(增)
		Connection conn = null;
		Statement st = null;
		// INSERT INTO t_student (name,age) VALUES ('WB',12)
		StringBuilder sb = new StringBuilder(40);
		sb.append("INSERT INTO t_student (name,age) VALUES ('")
				.append(stu.getName()).append("',").append(stu.getAge())
				.append(")");
		System.out.println(sb.toString());
		try {
			// 1.加载驱动		
			// 2.获取连接对象
			conn=JdbcUtil.getConn();
			// 3.创建执行语句
			st = conn.createStatement();
			// 4.执行SQL语句
			st.executeUpdate(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.释放资源
			JdbcUtil.close(st, conn, null);
		}
	}

	@Override
	public void delete(Long id) {
		// TODO 删除信息
		Connection conn = null;
		Statement st = null;
		// DELETE FORM t_student WHERE id=4
		//DELETE FROM 表名称 WHERE 列名称 = 值
		String sql="DELETE FROM t_student WHERE id="+id;
		System.out.println(sql);
		try {
			// 1.加载驱动		
			// 2.获取连接对象
			conn=JdbcUtil.getConn();
			// 3.创建执行语句
			st = conn.createStatement();
			// 4.执行SQL语句
			st.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.释放资源
			JdbcUtil.close(st, conn, null);
		}
	}

	@Override
	public void update(Long id, Student newStu) {
		// TODO 更新信息
		Connection conn = null;
		Statement st = null;
		// UPDATE t_student SET name='WYF',age='16' WHERE id='7'
		StringBuilder sb = new StringBuilder(40);
		sb.append("UPDATE t_student SET name='").append(newStu.getName())
				.append("',age='").append(newStu.getAge())
				.append("' WHERE id='").append(id).append("'");
		System.out.println(sb.toString());
		try {
			// 1.加载驱动		
			// 2.获取连接对象
			conn=JdbcUtil.getConn();
			// 3.创建执行语句
			st = conn.createStatement();
			// 4.执行SQL语句
			st.executeUpdate(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.释放资源
			JdbcUtil.close(st, conn, null);
		}
	}

	@Override
	public Student get(Long id) {
		// TODO 根据ID查询一个信息
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		String sql="SELECT * FROM t_student WHERE id="+id;
		try {
			// 1.加载驱动		
			// 2.获取连接对象
			conn=JdbcUtil.getConn();
			//3.创建执行语句
			st=conn.createStatement();
			//4.执行SQL语句
			rs=st.executeQuery(sql);
			//*****************************
				if(rs.next()){
					Student stu=new Student();
						stu.setId(rs.getLong("id"));
						stu.setName(rs.getString("name"));
						stu.setAge(rs.getInt("age"));
					return stu;
				}
			//****************************
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5.释放资源
			JdbcUtil.close(st, conn, rs);
		}
		return null;
	}

	@Override
	public List<Student> listAll() {
		// TODO 查询所有信息
		List<Student> list=new ArrayList<Student>();
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		String sql="SELECT * FROM t_student";
		try {
			// 1.加载驱动		
			// 2.获取连接对象
			conn=JdbcUtil.getConn();
			//3.创建执行语句
			st=conn.createStatement();
			//4.执行SQL语句
			rs=st.executeQuery(sql);
			//*****************************
				while(rs.next()){
					Student stu=new Student();
						stu.setId(rs.getLong("id"));
						stu.setName(rs.getString("name"));
						stu.setAge(rs.getInt("age"));
						list.add(stu);
				}
			//****************************
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5.释放资源
			JdbcUtil.close(st, conn, rs);
		}
		return list;
	}

}
