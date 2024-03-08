package com.passweb.passweb.repository.pass;

import com.passweb.passweb.repository.BaseEntity;
import com.passweb.passweb.repository.packaze.PackageEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "pass")
public class PassEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성을 DB에 위임합니다. (AUTO_INCREMENT)
    private Integer passSeq;
    private Integer packageSeq;
    private String userId;

    @Enumerated(EnumType.STRING)
    private PassStatus status;
    private Integer remainingCount;

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private LocalDateTime expiredAt;

    /**
     * @ManyToOne: 이 어노테이션은 단일 엔티티 인스턴스가 다른 엔티티와 다대일 관계를 가질 수 있음을 나타냅니다. 즉, 엔티티 인스턴스는 다른 엔티티의 최대 한 개 인스턴스와 연결될 수 있습니다.
     * fetch = FetchType.LAZY: 이 부분은 JPA가 관련된 엔티티를 가져오는 방식을 지정합니다.
     * 여기서 FetchType.LAZY는 주 엔티티가 검색될 때 연결된 엔티티가 자동으로 데이터베이스에서 로드되지 않음을 의미합니다. 엔티티의 데이터가 코드에서 특별히 접근될 때만 로드됩니다.
     * 이 접근 방식은 불필요한 데이터베이스 쿼리를 방지하여 성능을 향상시킵니다.
     * @JoinColumn: 이 어노테이션은 현재 엔티티 테이블의 외래키 열을 정의하며, 이는 관련 엔티티 테이블의 주키를 참조합니다. 여기서 "packageSeq"는 현재 엔티티 테이블의 "packageSeq"라는 이름의 열이 외래키 값을 보유한다는 것을 지정합니다.
     * insertable = false: 이 속성은 새로운 현재 엔티티 인스턴스를 지속할 때 "packageSeq" 열이 INSERT 문에 포함되어서는 안 된다는 것을 나타냅니다. 이는 외래키 값이 데이터베이스 자체에 의해 할당되거나 코드의 다른 곳에서 설정될 수 있음을 의미합니다.
     * updatable = false: 이 속성은 마찬가지로 기존 현재 엔티티 인스턴스를 수정할 때 "packageSeq" 열이 UPDATE 문에 포함되어서는 안 된다는 것을 지정합니다. 이는 외래키 관계가 엔티티 생성 중에 설정되고 이후 변경되어서는 안 된다는 것을 의미합니다.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "packageSeq", insertable = false, updatable = false)
    private PackageEntity packageEntity;

}
