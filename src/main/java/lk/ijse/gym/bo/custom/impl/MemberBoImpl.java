package lk.ijse.gym.bo.custom.impl;

import lk.ijse.gym.dao.Custom.MemberDao;
import lk.ijse.gym.dao.DAOFactory;
import lk.ijse.gym.bo.custom.MemberBo;
import lk.ijse.gym.dto.MemberDto;
import lk.ijse.gym.entity.Member;
import lk.ijse.gym.entity.tm.MemberTm;

import java.sql.SQLException;
import java.util.List;

public class MemberBoImpl implements MemberBo {
    MemberDao memberDao= (MemberDao) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.MEMBER);

    @Override
    public boolean saveMember(MemberDto memberDto) throws SQLException {
        Member member=new Member(memberDto.getMemberId(),memberDto.getName(),memberDto.getGender(),memberDto.getCont(),memberDto.getAddress(),memberDto.getDateJoin(),memberDto.getPlan(),memberDto.getPlanPrice());
        return memberDao.save(member);
    }

    @Override
    public List<MemberTm> getAllMember() throws SQLException {
        return memberDao.getAll();
    }

    @Override
    public boolean deleteMember(String memberId) throws SQLException {
        return memberDao.delete(memberId);
    }

    @Override
    public boolean updateMember(MemberDto memberDto) throws SQLException {
        Member member=new Member(memberDto.getMemberId(),memberDto.getName(), memberDto.getGender(),memberDto.getCont(),memberDto.getAddress(),memberDto.getDateJoin(),memberDto.getPlan(),memberDto.getPlanPrice());
        return memberDao.update(member);
    }

    @Override
    public MemberDto searchMember(String memberId) throws SQLException {
        Member member= memberDao.search(memberId);
        return new MemberDto(member.getMemberId(),member.getName(),member.getGender(),member.getCont(),member.getAddress(),member.getDateJoin(),member.getPlan(),member.getPlanPrice());

    }
}
