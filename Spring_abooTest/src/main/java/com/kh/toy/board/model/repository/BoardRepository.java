package com.kh.toy.board.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.aboo.common.util.file.FileVO;
import com.kh.aboo.common.util.paging.Paging;
import com.kh.toy.board.model.vo.Board;

@Mapper
public interface BoardRepository {
	
	//게시글 업로드
	@Insert("insert into tb_board(bd_idx, user_id, title, content) "
			+ "values('b'||sc_board_idx.nextval, #{userId}, #{title}, #{content})")
	int insertBoard(Board board);
	int insertFile(FileVO file);
	List<Board> selectBoardList(Paging paging);
	
	@Select("select count(*) from tb_board")
	int selectContentCnt();
	
	@Select("select * from tb_board where bd_idx = #{bdIdx}")
	Board selectBoardDetail(String bdIdx);
	
	@Select("select * from tb_file where type_idx = #{bdIdx}")
	List<FileVO> selectFileWithBdIdx(String bdIdx);
	
}
