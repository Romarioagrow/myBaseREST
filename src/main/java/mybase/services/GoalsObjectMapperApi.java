package mybase.services;

import mybase.domain.jpa.GoalEntity;
import mybase.domain.dto.GoalDto;
import org.springframework.stereotype.Service;

@Service
public interface GoalsObjectMapperApi {

    GoalDto mapGoalEntityToDto(GoalEntity goalEntity);

}
