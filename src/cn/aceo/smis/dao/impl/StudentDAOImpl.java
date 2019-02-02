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
		// TODO ������Ϣ(��)
		Connection conn = null;
		Statement st = null;
		// INSERT INTO t_student (name,age) VALUES ('WB',12)
		StringBuilder sb = new StringBuilder(40);
		sb.append("INSERT INTO t_student (name,age) VALUES ('")
				.append(stu.getName()).append("',").append(stu.getAge())
				.append(")");
		System.out.println(sb.toString());
		try {
			// 1.��������		
			// 2.��ȡ���Ӷ���
			conn=JdbcUtil.getConn();
			// 3.����ִ�����
			st = conn.createStatement();
			// 4.ִ��SQL���
			st.executeUpdate(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.�ͷ���Դ
			JdbcUtil.close(st, conn, null);
		}
	}

	@Override
	public void delete(Long id) {
		// TODO ɾ����Ϣ
		Connection conn = null;
		Statement st = null;
		// DELETE FORM t_student WHERE id=4
		//DELETE FROM ������ WHERE ������ = ֵ
		String sql="DELETE FROM t_student WHERE id="+id;
		System.out.println(sql);
		try {
			// 1.��������		
			// 2.��ȡ���Ӷ���
			conn=JdbcUtil.getConn();
			// 3.����ִ�����
			st = conn.createStatement();
			// 4.ִ��SQL���
			st.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.�ͷ���Դ
			JdbcUtil.close(st, conn, null);
		}
	}

	@Override
	public void update(Long id, Student newStu) {
		// TODO ������Ϣ
		Connection conn = null;
		Statement st = null;
		// UPDATE t_student SET name='WYF',age='16' WHERE id='7'
		StringBuilder sb = new StringBuilder(40);
		sb.append("UPDATE t_student SET name='").append(newStu.getName())
				.append("',age='").append(newStu.getAge())
				.append("' WHERE id='").append(id).append("'");
		System.out.println(sb.toString());
		try {
			// 1.��������		
			// 2.��ȡ���Ӷ���
			conn=JdbcUtil.getConn();
			// 3.����ִ�����
			st = conn.createStatement();
			// 4.ִ��SQL���
			st.executeUpdate(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.�ͷ���Դ
			JdbcUtil.close(st, conn, null);
		}
	}

	@Override
	public Student get(Long id) {
		// TODO ����ID��ѯһ����Ϣ
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		String sql="SELECT * FROM t_student WHERE id="+id;
		try {
			// 1.��������		
			// 2.��ȡ���Ӷ���
			conn=JdbcUtil.getConn();
			//3.����ִ�����
			st=conn.createStatement();
			//4.ִ��SQL���
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
			//5.�ͷ���Դ
			JdbcUtil.close(st, conn, rs);
		}
		return null;
	}

	@Override
	public List<Student> listAll() {
		// TODO ��ѯ������Ϣ
		List<Student> list=new ArrayList<Student>();
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		String sql="SELECT * FROM t_student";
		try {
			// 1.��������		
			// 2.��ȡ���Ӷ���
			conn=JdbcUtil.getConn();
			//3.����ִ�����
			st=conn.createStatement();
			//4.ִ��SQL���
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
			//5.�ͷ���Դ
			JdbcUtil.close(st, conn, rs);
		}
		return list;
	}

}
