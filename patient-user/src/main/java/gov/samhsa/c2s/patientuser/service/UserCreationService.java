package gov.samhsa.c2s.patientuser.service;

import gov.samhsa.c2s.patientuser.service.dto.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

public interface UserCreationService {
    @Transactional
    UserCreationResponseDto initiateUserCreation(UserCreationRequestDto userCreationRequest, String xForwardedProto, String xForwardedHost, int xForwardedPort);

    @Transactional(readOnly = true)
    UserCreationResponseDto findUserCreationInfoByPatientId(Long patientId);

    @Transactional
    UserActivationResponseDto activateUser(UserActivationRequestDto userActivationRequest, String xForwardedProto, String xForwardedHost, int xForwardedPort);

    @Transactional(readOnly = true)
    VerificationResponseDto verify(String emailToken, Optional<String> verificationCode, Optional<LocalDate> birthDate);

    ScopeAssignmentResponseDto assignScopeToUser(ScopeAssignmentRequestDto scopeAssignmentRequestDto);
}