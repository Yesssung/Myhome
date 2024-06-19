package himedia.myhome.dao;

import java.util.List;

import himedia.myhome.vo.GuestVo;

public interface GuestBookDao {
	public List<GuestVo> getList();
	public GuestVo get(Long no);
	public boolean insert(GuestVo vo);
	public boolean delete(GuestVo vo);

}
