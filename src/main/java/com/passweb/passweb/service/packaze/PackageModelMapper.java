package com.passweb.passweb.service.packaze;

import com.passweb.passweb.repository.packaze.PackageEntity;
import com.passweb.passweb.repository.pass.BulkPassEntity;
import com.passweb.passweb.service.pass.BulkPass;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Mapper 어노테이션:
 * 이 인터페이스가 ModelMapper를 사용하여 객체 간 매핑을 수행하도록 지정합니다.
 * unmappedTargetPolicy 속성은 매핑되지 않은 대상 속성에 대한 처리 정책을 지정합니다. 여기서는 ReportingPolicy.IGNORE를 사용하여 매핑되지 않은 대상 속성을 무시하도록 설정합니다.
 * INSTANCE 필드:
 * PackageModelMapper 인스턴스를 싱글톤으로 제공합니다.
 * map 메서드:
 * 주어진 PackageEntity 목록을 Package 모델 목록으로 변환합니다.
 * packageEntities: 변환할 PackageEntity 목록
 * return: 변환된 Package 모델 목록
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PackageModelMapper {
    PackageModelMapper INSTANCE = Mappers.getMapper(PackageModelMapper.class);

    List<Package> map(List<PackageEntity> packageEntities);

}
