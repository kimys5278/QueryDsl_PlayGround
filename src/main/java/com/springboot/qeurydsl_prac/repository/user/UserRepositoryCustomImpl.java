package com.springboot.qeurydsl_prac.repository.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.qeurydsl_prac.dto.user.UserRequestDto;
import com.springboot.qeurydsl_prac.entity.QUser;
import com.springboot.qeurydsl_prac.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<User> getUserList(String name) {
        QUser qUser = QUser.user;
        return jpaQueryFactory.select(qUser)
                .from(qUser)
                .where(qUser.name.eq(name))
                .fetch();
    }

    @Override
    public List<User> getUserListWithPage(Long offset, int size) {
        QUser qUser = QUser.user;
        return jpaQueryFactory.select(qUser)
                .from(qUser)
                .offset(offset)
                .limit(size)
                .fetch();
    }


}
