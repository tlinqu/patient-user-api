package gov.samhsa.mhc.patientuser.service;

import gov.samhsa.mhc.patientuser.service.dto.UserActivationRequestDto;
import gov.samhsa.mhc.patientuser.service.dto.UserActivationResponseDto;
import gov.samhsa.mhc.patientuser.service.dto.UserCreationRequestDto;
import gov.samhsa.mhc.patientuser.service.dto.UserCreationResponseDto;
import org.springframework.transaction.annotation.Transactional;

public interface UserCreationService {
    @Transactional
    UserCreationResponseDto initiateUserCreation(UserCreationRequestDto userCreationRequest);

    @Transactional(readOnly = true)
    UserCreationResponseDto findUserCreationInfoByPatientId(Long patientId);

    @Transactional
    UserActivationResponseDto activateUser(UserActivationRequestDto userActivationRequest);
}
