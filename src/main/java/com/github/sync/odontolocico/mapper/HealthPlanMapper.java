package com.github.sync.odontolocico.mapper;

import com.github.sync.odontolocico.dto.HealthPlanDto;
import com.github.sync.odontolocico.entity.HealthPlanEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HealthPlanMapper {

    @Mapping(source = "id", target = "idPlan")
    @Mapping(source = "plan", target = "planHealthInsurance")
    @Mapping(source = "planNumber", target = "numberPlan")
    @Mapping(source = "planExpiration", target = "expirationDatePlan")
    HealthPlanEntity toEntity(HealthPlanDto dto);

    @Mapping(source = "idPlan", target = "id")
    @Mapping(source = "planHealthInsurance", target = "plan")
    @Mapping(source = "numberPlan", target = "planNumber")
    @Mapping(source = "expirationDatePlan", target = "planExpiration")
    HealthPlanDto toDto(HealthPlanEntity entity);
}
