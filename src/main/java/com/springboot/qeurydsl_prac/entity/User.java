package com.springboot.qeurydsl_prac.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "email")
    private String email;

    /*
    *unique를 사용해야할때, 굳이 여기에 안붙혀도된다.
    * 데이터베이스 단에서 unique 속성을 설정하면 데이터베이스 안에서 관리. 데이터를 넣는 시점에서 관리.
    * jpa 엔티티에 unique 설정은 -> 영속성 컨텍스트 안에서 설정하는것.
    * 동일한 시점에 여러개 서비스에 동일한 데이터를 저장해야할때, 데이터베이스 자체에서 unique가 안되는 현상에서
    * 데이터베이스 컬럼에 unique를 안걸어놔서그럼 jpa 엔티티에서만 걸어 놓았음.
    *
    *
    * */
    @Column(name = "address" , unique = true)
    private String address;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Order> orderList;
}
