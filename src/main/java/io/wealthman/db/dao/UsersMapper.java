package io.wealthman.db.dao;

import io.wealthman.db.entity.UserEntity;
import io.wealthman.enums.UserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@SuppressWarnings("PMD.AvoidDuplicateLiterals")
@Component
@Mapper
public interface UsersMapper {

    @Delete("DELETE FROM users WHERE id = #{id}")
    Boolean delete(final Long id);

    @Select("SELECT * FROM users WHERE email = #{email} LIMIT 1")
    UserEntity getByEmail(final String email);

    @Select("SELECT * FROM users WHERE id = #{id} LIMIT 1")
    UserEntity getById(final Long id);

    @Select("SELECT * FROM users WHERE email = #{email} AND passwordHash = #{passwordHash} LIMIT 1")
    UserEntity get(@Param("email") final String email,
                   @Param("passwordHash") final String passwordHash);

    @Select("SELECT * FROM users WHERE role = #{role}")
    List<UserEntity> getByRole(final UserRole role);

    default boolean isExists(final String email) {
        return getByEmail(email) != null;
    }

    @Update("UPDATE users SET passwordHash = #{passwordHash}, verified=1, status='Enabled' WHERE email = #{email}")
    void changePassword(@Param("email") final String email,
                        @Param("passwordHash") final String passwordHash);

    @Insert("INSERT INTO users (role, email, passwordHash, firstName, lastName, status, verified)"
            + "VALUES (#{role}, #{email}, #{passwordHash}, #{firstName}, #{lastName}, #{status}, #{verified})")
    @Options(useGeneratedKeys = true, keyColumn = "ID", keyProperty = "id")
    Long create(final UserEntity entity);

    @Update("UPDATE users SET firstName = #{firstName}, lastName = #{lastName},"
            + "passwordHash = #{passwordHash}, status = #{status}, role = #{role} WHERE id = #{id}")
    Boolean save(final UserEntity entity);


    @Select("SELECT * FROM users")
    List<UserEntity> getAll();

    @Delete("DELETE FROM users WHERE verified = 0 AND DATEDIFF(NOW(), registrationDate) > 7")
    void deleteUnverifiedUsers();

    @Update("UPDATE users SET verified = 1, status='Enabled' WHERE email = #{email}")
    void verifySignUp(final String email);
}
