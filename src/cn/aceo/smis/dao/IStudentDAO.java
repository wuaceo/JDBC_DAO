package cn.aceo.smis.dao;

import java.util.List;
import cn.aceo.smis.domain.Student;

public interface IStudentDAO {
	/**
	 * 保存操作
	 * @param stu 要保存的学生对象信息
	 */
	void save(Student stu);
	/**
	 * 删除操作
	 * @param id 要删除的学生信息的主键值
	 */
	void delete(Long id);
	/**
	 * 更新操作
	 * @param id 要更新的学生信息的主键值
	 * @param newStu 新的学生信息
	 */
	void update(Long id,Student newStu);
	/**
	 * 根据ID查询一个学生信息
	 * @param id 要查询的学生信息的主键值
	 * @return 如果id存在就返回该学生的信息，如果不存在就返回为null
	 */
	Student get(Long id);
	/**
	 * 查询所有的学生信息
	 * @return 如果结果集为空就返回一个空的list对象
	 */
	List<Student> listAll();
}
