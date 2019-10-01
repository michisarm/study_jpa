package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
//@Table( uniqueConstraints = )
public class Member1 {
    @Id
    private Long id;

//    @Column(name ="NM", updatable = false)
//    @Column(name ="NM", insertable = false)
//    @Column(name ="NM", nullable = false) // not null
//    @Column(name ="NM", unique = true) // 잘 안씀 이름이 uuid
//    @Column(name ="NM", columnDefinition = "varchar(100) default 'EMPTY'")
    @Column(name ="NM")
    private String name;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifieddDate;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;


    @Lob
    private String description;

    @Transient
    private int temp;

    public Member1() {
    }
}
