package lk.ijse.gym.dao.Custom.Impl;

import lk.ijse.gym.dao.Custom.MemberDao;
import lk.ijse.gym.dao.SqlUtil;
import lk.ijse.gym.entity.Member;
import lk.ijse.gym.entity.tm.MemberTm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MemberDaoImpl implements MemberDao {

    public Member search(String memberId) throws SQLException {
        String sql = "SELECT * FROM member WHERE memberId =? ";
        ResultSet resultSet = SqlUtil.execute(sql,memberId);
        Member dto = null;

        if (resultSet.next()) {
            String mem_Id = resultSet.getString(1);
            String mem_name = resultSet.getString(2);
            String mem_gender = resultSet.getString(3);
            int mem_con = Integer.parseInt(resultSet.getString(4));
            String mem_add=resultSet.getString(5);
            String mem_dateJoin=resultSet.getString(6);
            String mem_plan=resultSet.getString(7);
            double plan_price = resultSet.getDouble(8);

            dto=new Member(mem_Id,mem_name,mem_gender,mem_con,mem_add,mem_dateJoin,mem_plan,plan_price);
        }
        return dto;
    }


    public boolean save(Member member) throws SQLException {
        String sql = "INSERT INTO member VALUES (?,?,?,?,?,?,?,?)";
        return SqlUtil.execute(sql,member.getMemberId(),member.getName(),member.getGender(),member.getCont(),member.getAddress(),member.getDateJoin(),member.getPlan(),member.getPlanPrice());
    }

    public List<MemberTm> getAll() throws SQLException {
        String sql="SELECT * FROM member";
        ResultSet resultSet=SqlUtil.execute(sql);

        ArrayList<MemberTm>dtoList=new ArrayList<>();

        while (resultSet.next()) {
            dtoList.add(
                    new MemberTm(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getDouble(8)


                    )
            );
        }
        return dtoList;
    }
    public boolean delete(String memberId) throws SQLException {
        String sql = "DELETE FROM member WHERE memberId= ?";
        return SqlUtil.execute(sql,memberId);
    }


    public boolean update(Member member) throws SQLException {
        String sql="UPDATE member SET name = ?, gender = ?, contact = ?,address = ?,dateJoin=?,plan=?,planPrice=? WHERE memberId = ?";
        return SqlUtil.execute(sql,member.getName(),member.getGender(),member.getCont(),member.getAddress(),member.getDateJoin(),member.getPlan(),member.getPlanPrice(),member.getMemberId());
    }
}



