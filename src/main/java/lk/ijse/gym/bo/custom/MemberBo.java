package lk.ijse.gym.bo.custom;

import lk.ijse.gym.bo.SuperBo;
import lk.ijse.gym.dto.MemberDto;
import lk.ijse.gym.entity.tm.MemberTm;

import java.sql.SQLException;
import java.util.List;

public interface MemberBo extends SuperBo {
    boolean saveMember(MemberDto member) throws SQLException;
    List<MemberTm> getAllMember() throws SQLException;
    boolean deleteMember(String memberId) throws SQLException;
    boolean updateMember(MemberDto member) throws SQLException;
    MemberDto searchMember(String memberId) throws SQLException;
}
