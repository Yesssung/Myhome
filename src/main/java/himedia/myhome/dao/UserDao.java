package himedia.myhome.dao;

import java.util.List;

import himedia.myhome.vo.UserVo;

public interface UserDao {
	public List<UserVo> getList();			  // 목록
	public boolean insert(UserVo userVo);	  // 입력
	public boolean update(UserVo userVo);	  // 수정
	public boolean delete(Long no);			  // 삭제
	public UserVo getUserByIdAndPassword
			(String email, String password);  // Login용
	
}
