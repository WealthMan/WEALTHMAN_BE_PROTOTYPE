package io.wealthman.db.dao;

import io.wealthman.db.entity.ManagerEntity;
import io.wealthman.enums.UserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("PMD.AvoidDuplicateLiterals")
@Component
@Mapper
public interface ManagersMapper {
    @Delete("DELETE FROM users WHERE id = #{id}")
    Boolean delete(final Long id);

    @Select("SELECT * FROM users WHERE email = #{email} LIMIT 1")
    ManagerEntity getByEmail(final String email);

    @Select("SELECT * FROM users WHERE id = #{id} LIMIT 1")
    ManagerEntity getById(final Long id);

    @Select("SELECT * FROM users WHERE email = #{email} AND passwordHash = #{passwordHash} LIMIT 1")
    ManagerEntity get(@Param("email") final String email,
                   @Param("passwordHash") final String passwordHash);

    @Select("SELECT * FROM users WHERE role = #{role}")
    List<ManagerEntity> getByRole(final UserRole role);
    default boolean isExists(final String email) {
        return getByEmail(email) != null;
    }

    @Select("SELECT portfolioID FROM portfolio  WHERE portfolioID = #{portfolioID}")
    List<ManagerEntity> getListOfPortfolio( @Param("portfolioID") final Long portfolioID);

    @Insert("INSERT INTO users (role, email, passwordHash, firstName, lastName, status, verified)"
            + "VALUES (#{role}, #{email}, #{passwordHash}, #{firstName}, #{lastName}, #{status}, #{verified})")
    @Options(useGeneratedKeys = true, keyColumn = "ID", keyProperty = "id")
    Long create(final ManagerEntity entity);

    @Select("SELECT * FROM users")
    List<ManagerEntity> getAll();
}
